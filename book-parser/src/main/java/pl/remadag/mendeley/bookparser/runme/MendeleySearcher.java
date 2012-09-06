package pl.remadag.mendeley.bookparser.runme;

import com.mendeley.oapi.common.PagedArrayList;
import com.mendeley.oapi.common.PagedList;
import com.mendeley.oapi.schema.Author;
import com.mendeley.oapi.schema.Document;
import com.mendeley.oapi.services.MendeleyException;
import com.mendeley.oapi.services.MendeleyServiceFactory;
import com.mendeley.oapi.services.SearchService;

import java.util.*;

public class MendeleySearcher {

    private Map<String, DocumentCounter> documentMap = new HashMap<String, DocumentCounter>();
    private Map<String, AuthorCounter> authorMap = new HashMap<String, AuthorCounter>();

    private Set<Document> documentToSearch = new HashSet<Document>();

    private int loopCounter = 1;
    private int rateCounter = 0;

    private static final int STOP_LIMIT = 5;
    private static final int RATE_LIMIT = 10;
    private static final long MILLIS = 2000L;

    public void searchService(MendeleyServiceFactory factory, String... searchedTerms) {
        try {

            Thread.sleep(MILLIS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SearchService searchService = factory.createSearchService();
        List<Document> documents = new ArrayList<Document>();
        rateCounter++;
        if (rateCounter <= RATE_LIMIT) {
            try {
                documents = searchService.search(searchedTerms);
            } catch (MendeleyException e) {
                System.out.println("EXCEPTION: " + e.getMessage());
            }
        }
        System.out.println("!START! Dla szukanego/szukanych terminów: " + Arrays.toString(searchedTerms)
                + " mam wszystkich dokumentów " + documents.size() + " sztuk.");
        documentToSearch.addAll(documents);
        recurrentSearch(searchService);
        printLastResults();
    }


    private void recurrentSearch(SearchService searchService) {
        if (loopCounter <= STOP_LIMIT) {
            List<Document> documentsList = new ArrayList<Document>(documentToSearch);
            try {
                Thread.sleep(MILLIS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Obecnie mam: " + documentsList.size() + " sztuk.");
            documentToSearch = new HashSet<Document>();
            for (Document document : documentsList) {
                if (document.getAuthors() != null && document.getAuthors().size() > 0 && document.getTitle() != null) {
                    addDocumentToMap(document);
                    for (Author author : document.getAuthors()) {
                        if (author.getSurname() != null) {
                            addAuthorToMap(author, document);
                            try {
                                Thread.sleep(MILLIS);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            PagedList<Document> authorDocs = new PagedArrayList<Document>();
                            rateCounter++;
                            if (rateCounter <= RATE_LIMIT) {
                                try {
                                    authorDocs = searchService.getDocumentsByAuthor(constructUrlValidString(author));
                                } catch (MendeleyException e) {
                                    System.out.println("EXCEPTION: " + e.getMessage());
                                }
                            }
                            System.out.println("   dodaje nowych " + authorDocs.size() + " dokumentow");
                            for (Document doc : authorDocs) {
                                documentToSearch.add(doc);
                            }
                        }
                    }
                    System.out.println("Koniec rekurencji " + loopCounter);
                    loopCounter = loopCounter + 1;
                    recurrentSearch(searchService);
                }
            }
        } else {
            printSearcherResult();
        }
    }

    private void printSearcherResult() {
        System.out.println("\n\nSTATYSTYKI");
        System.out.println(" Liczba wszystkich ksiazek: " + documentMap.size());
        System.out.println(" Liczba wszystkich autorow: " + authorMap.size());

    }

    private void addDocumentToMap(Document document) {
        if (documentMap.containsKey(document.getUuid())) {
            DocumentCounter existedDocCounter = documentMap.remove(document.getUuid());
            int counter = existedDocCounter.getCounter();
            documentMap.put(document.getUuid(), new DocumentCounter(document, counter + 1));
        } else {
            DocumentCounter documentCounter = new DocumentCounter(document, 1);
            documentMap.put(document.getUuid(), documentCounter);
        }
    }

    private void addAuthorToMap(Author author, Document document) {
        if (authorMap.containsKey(getAuthorsMapKey(author))) {
            AuthorCounter existedAuthor = authorMap.remove(getAuthorsMapKey(author));
            existedAuthor.setCounter(existedAuthor.getCounter() + 1);
            existedAuthor.addDocToAuthor(document);
            authorMap.put(getAuthorsMapKey(author), existedAuthor);
        } else {
            AuthorCounter authorCounter = new AuthorCounter(author, 1);
            authorCounter.addDocToAuthor(document);
            authorMap.put(getAuthorsMapKey(author), authorCounter);
        }
    }

    private String getAuthorsMapKey(Author author) {
        return author.getSurname() + " " + author.getForename();
    }


    private static String constructUrlValidString(Author author) {
        String str = author.getForename() + " " + author.getSurname();
        str = str.replaceAll(" ", "%20");
        return str;
    }

    private void printLastResults() {
        System.out.println("\n\nKONIEC\n\n");
        System.out.println(" Liczba wszystkich ksiazek: " + documentMap.size());
        System.out.println(" Liczba wszystkich autorow: " + authorMap.size());

        System.out.println("\n\n\n Dla szukanego hasła znaleziono takie książki:");
        for (String key : documentMap.keySet()) {
            DocumentCounter documentCounter = documentMap.get(key);
            Document doc = documentCounter.getDocument();
            System.out.println(doc.getTitle() + " | " + getAuthors(doc.getAuthors()));
            System.out.println("\t o czestotliwosci" + documentCounter.getCounter());
        }

        System.out.println("\n\n\n Dla szukanego hasła znaleziono takich autorow i powiazane ksiażki:");
        for (String key : authorMap.keySet()) {
            AuthorCounter authorCounter = authorMap.get(key);
            Author auth = authorCounter.getAuthor();
            System.out.println(auth.getSurname() + " " + auth.getForename());
            System.out.println("\t o czestotliwosci " + authorCounter.getCounter());
            System.out.println("\t powiazane ksiażki z danym autorem: ");
            for (Document doc : authorCounter.getAuthorsDoc()) {
                System.out.println("\t\t " + doc.getTitle());
            }
        }

    }

    private String getAuthors(final List<Author> authors) {
        StringBuilder builder = new StringBuilder();
        for (Author author : authors) {
            builder.append("Autor: ").append(author.getSurname()).append(" ").append(author.getForename()).append(", ");
        }
        return builder.toString();
    }
}

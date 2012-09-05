package pl.remadag.mendeley.bookparser.runme;

import com.mendeley.oapi.common.PagedList;
import com.mendeley.oapi.schema.Author;
import com.mendeley.oapi.schema.Document;
import com.mendeley.oapi.services.MendeleyServiceFactory;
import com.mendeley.oapi.services.SearchService;

import java.util.*;

public class MendeleySearcher {

    private Map<String, DocumentCounter> documentMap = new HashMap<String, DocumentCounter>();
    private Map<String, AuthorCounter> authorsMap = new HashMap<String, AuthorCounter>();

    private Set<Document> documentToSearch = new HashSet<Document>();

    private int loopCounter = 1;

    public void searchService(MendeleyServiceFactory factory, String... searchedTerms) {
        SearchService searchService = factory.createSearchService();
        List<Document> documents = searchService.search(searchedTerms);
        System.out.println("!START! Dla szukanego/szukanych terminów: " + Arrays.toString(searchedTerms)
                + " mam wszystkich dokumentów " + documents.size() + " sztuk.");
        documentToSearch.addAll(documents);
        recurrentSearch(searchService);
    }

    private void recurrentSearch(SearchService searchService) {
        List<Document> documentsList = new ArrayList<Document>(documentToSearch);

        System.out.println("Obecnie mam: " + documentsList.size() + " sztuk.");
        documentToSearch = new HashSet<Document>();
        for (Document document : documentsList) {
/*
            if (document.getTitle() != null) {
                System.out.println("document (" + document.getUuid() + ") = " + document.getTitle());
            }
*/
            if (document.getAuthors() != null && document.getAuthors().size() > 0 && document.getTitle() != null) {
                addDocumentToMap(document);
                for (Author author : document.getAuthors()) {
                    if (author.getSurname() != null) {
//                        System.out.println("   > author = " + author.getForename() + " " + author.getSurname());
                        addAuthorToMap(author, document);
                        PagedList<Document> authorDocs = searchService.getDocumentsByAuthor(constructUrlValidString(author));
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
/*
            if (document.getUuid() != null && document.getTitle() != null) {
                PagedList<Document> related = searchService.getRelatedDocuments(document.getUuid());
                for (Document doc : related) {
                    System.out.println("   > powiązane z " + document.getTitle() + " sa nastepujace pozycje:");
                    printResult(doc);
                }
            }
*/


        }
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
        if (authorsMap.containsKey(getAuthorsMapKey(author))) {
            AuthorCounter existedAuthor = authorsMap.remove(getAuthorsMapKey(author));
            existedAuthor.setCounter(existedAuthor.getCounter() + 1);
            existedAuthor.addDocToAuthor(document);
            authorsMap.put(getAuthorsMapKey(author), existedAuthor);
        } else {
            AuthorCounter authorCounter = new AuthorCounter(author, 1);
            authorCounter.addDocToAuthor(document);
            authorsMap.put(getAuthorsMapKey(author), authorCounter);
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

    /**
     * Prints the result.
     *
     * @param document the document
     */
    private static void printResult(Document document) {
        StringBuilder builder = new StringBuilder();
        if (document.getTitle() != null) {
            builder.append(document.getTitle());
            if (document.getPublicationOutlet() != null) {
                builder.append(" pochodzacy z czasopisma: ").append(document.getPublicationOutlet());
            }
            System.out.println(builder.toString());
        }
    }
}

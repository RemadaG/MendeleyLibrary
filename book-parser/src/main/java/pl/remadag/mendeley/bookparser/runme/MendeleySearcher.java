package pl.remadag.mendeley.bookparser.runme;

import com.mendeley.oapi.common.PagedArrayList;
import com.mendeley.oapi.common.PagedList;
import com.mendeley.oapi.schema.Author;
import com.mendeley.oapi.schema.Document;
import com.mendeley.oapi.services.MendeleyException;
import com.mendeley.oapi.services.MendeleyServiceFactory;
import com.mendeley.oapi.services.SearchService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MendeleySearcher {

    private Map<String, Map<String, DocumentCounter>> generalMap = new HashMap<String, Map<String, DocumentCounter>>();

    private int documentSearchCounter = 0;

    private static final int DOCUMENT_SEARCH_LIMIT = Integer.MAX_VALUE;
    private static final long MILLIS = 1000L;

    public void searchService(MendeleyServiceFactory factory, String inputSentence) {
        Map<String, List<String>> mapWithKeys = SearcherUtil.parseInputSentence(inputSentence);
        sleepMe();
        SearchService searchService = factory.createSearchService();
        List<Document> documents = new ArrayList<Document>();
        documentSearchCounter++;
        for (String addTerm : mapWithKeys.get("ADD")) {
            if (documentSearchCounter <= DOCUMENT_SEARCH_LIMIT) {
                System.out.println("Wyszukiwanie ksiazek dla hasla " + addTerm.toUpperCase());
                try {
                    documents = searchService.search(addTerm);
                } catch (MendeleyException e) {
                    System.out.println("EXCEPTION: " + e.getMessage());
                }
                processReceivedDocsFromServiceToAdd(documents, addTerm, searchService);
                printSearcherResult("ADD", addTerm);
            }
        }

        for (String removeTerm : mapWithKeys.get("REMOVE")) {
            if (documentSearchCounter <= DOCUMENT_SEARCH_LIMIT) {
                try {
                    documents = searchService.search(removeTerm);
                } catch (MendeleyException e) {
                    System.out.println("EXCEPTION: " + e.getMessage());
                }
                processReceivedDocsFromServiceToRemove(documents, removeTerm, searchService);
                printSearcherResult("REMOVE", removeTerm);
            }
        }

    }

    private void processReceivedDocsFromServiceToRemove(List<Document> documents, String removeTerm, SearchService searchService) {
        for (Document document : documents) {
            if (document.getAuthors() != null && document.getAuthors().size() > 0 && document.getTitle() != null && document.getUuid() != null) {
                removeDocumentFromMap(document, removeTerm);
                sleepMe();
                PagedList<Document> relatedDocs = new PagedArrayList<Document>();
                try {
                    relatedDocs = searchService.getRelatedDocuments(document.getUuid());
                } catch (MendeleyException e) {
                    System.out.println("EXCEPTION: " + e.getMessage());
                }
                for (Document relDoc : relatedDocs) {
                    if (relDoc.getAuthors() != null && relDoc.getAuthors().size() > 0 && relDoc.getTitle() != null) {
                        removeDocumentFromMap(relDoc, removeTerm);
                    }
                }
                System.out.println("REM > Koniec dodawania dokumentow dla " + document.getTitle());
            }
        }

    }

    private void processReceivedDocsFromServiceToAdd(List<Document> documents, String addTerm, SearchService searchService) {
        for (Document document : documents) {
            if (document.getAuthors() != null && document.getAuthors().size() > 0 && document.getTitle() != null && document.getUuid() != null) {
                addDocumentToMap(document, addTerm);
                sleepMe();

                //related documents
                PagedList<Document> relatedDocs = new PagedArrayList<Document>();
                try {
                    relatedDocs = searchService.getRelatedDocuments(document.getUuid());
                } catch (MendeleyException e) {
                    System.out.println("EXCEPTION: " + e.getMessage());
                }
                for (Document relDoc : relatedDocs) {
                    if (relDoc.getAuthors() != null && relDoc.getAuthors().size() > 0 && relDoc.getTitle() != null) {
                        addDocumentToMap(relDoc, addTerm);
                    }
                }

                //for author
                for (Author author : document.getAuthors()) {
                    final String authorName = SearcherUtil.constructAuthorUrlValidString(author);
                    PagedList<Document> authorsDocs = new PagedArrayList<Document>();
                    try {
                        authorsDocs = searchService.getDocumentsByAuthor(authorName);
                    } catch (MendeleyException e) {
                        System.out.println("EXCEPTION: " + e.getMessage());
                    }
                    for (Document authDoc : authorsDocs) {
                        if (authDoc.getAuthors() != null && authDoc.getAuthors().size() > 0 && authDoc.getTitle() != null) {
                            addDocumentToMap(authDoc, addTerm);
                        }
                    }
                }
                System.out.println("ADD > Koniec dodawania dokumentow dla " + document.getTitle());
            }
        }
    }

    private void sleepMe() {
        try {
            Thread.sleep(MILLIS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void printSearcherResult(String flag, String term) {
        final Map<String, DocumentCounter> stringDocumentCounterMap = generalMap.get(term);
        if (stringDocumentCounterMap != null) {
            System.out.println(" Liczba wszystkich ksiazek przy fladze " + flag + " dla slowa " + term + " wynosi " + stringDocumentCounterMap.size());
        }
    }

    private void addDocumentToMap(Document document, String addTerm) {
        Map<String, DocumentCounter> documentMap;
        if (generalMap.containsKey(addTerm)) {
            documentMap = generalMap.get(addTerm);
        } else {
            documentMap = new HashMap<String, DocumentCounter>();
            generalMap.put(addTerm.toLowerCase(), documentMap);
        }

        if (documentMap.containsKey(SearcherUtil.getDocumentsMapKey(document))) {
            DocumentCounter existedDocCounter = documentMap.remove(SearcherUtil.getDocumentsMapKey(document));
            int counter = existedDocCounter.getCounter();
            documentMap.put(SearcherUtil.getDocumentsMapKey(document), new DocumentCounter(document, counter + 1));
        } else {
            DocumentCounter documentCounter = new DocumentCounter(document, 1);
            documentMap.put(SearcherUtil.getDocumentsMapKey(document), documentCounter);
        }
    }

    private void removeDocumentFromMap(Document document, String removeTerm) {
        addDocumentToMap(document, "R_" + removeTerm);

/*
        for (String docMapKey : documentMap.keySet()) {
            String searchedDocKey = SearcherUtil.getDocumentsMapKey(document);
            if (docMapKey.equals(searchedDocKey)) {
                documentMap.remove(docMapKey);
                break;
            }
        }
*/
    }


    private void printLastResults() {
        System.out.println("\n\nKONIEC\n\n");
        for (String key : generalMap.keySet()) {
            Map<String, DocumentCounter> map = generalMap.get(key);
            System.out.println("Dla hasła: " + key + " mam " + map.size() + " książek.");
            for (String documentCounterKey : map.keySet()) {
                DocumentCounter documentCounter = map.get(documentCounterKey);
                Document doc = documentCounter.getDocument();
                System.out.println(doc.getTitle() + " | " + getAuthors(doc.getAuthors()));
                System.out.println("\t o czestotliwosci " + documentCounter.getCounter());
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

    public void searchForKeys(List<String> keys, MendeleyServiceFactory factory) {
        for (String key : keys) {
            System.out.println("\n\nZaczynam przetwarzanie dla slow: " + key);
            searchService(factory, key);
            System.out.println("Zakonczylem przetwarzanie dla slow: " + key);
            printLastResults();
        }
    }
}

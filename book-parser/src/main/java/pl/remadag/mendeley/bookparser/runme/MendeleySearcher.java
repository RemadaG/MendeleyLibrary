package pl.remadag.mendeley.bookparser.runme;

import com.mendeley.oapi.common.PagedArrayList;
import com.mendeley.oapi.common.PagedList;
import com.mendeley.oapi.schema.Document;
import com.mendeley.oapi.services.MendeleyException;
import com.mendeley.oapi.services.MendeleyServiceFactory;
import com.mendeley.oapi.services.SearchService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MendeleySearcher {

    private Map<String, Map<String, DocumentCounter>> generalMap = new HashMap<String, Map<String, DocumentCounter>>();
    private Map<String, Set<String>> relatedDocMap = new HashMap<String, Set<String>>();
    private int documentSearchCounter = 0;

    private static final int DOCUMENT_SEARCH_LIMIT = 5;
    private static final long MILLIS = 500L;

    public void searchService(MendeleyServiceFactory factory, String inputSentence) {
        Map<String, List<String>> mapWithKeys = SearcherUtil.parseInputSentence(inputSentence);
        SearchService searchService = factory.createSearchService();
        List<Document> documents = new ArrayList<Document>();
        for (String addTerm : mapWithKeys.get("ADD")) {
            if (documentSearchCounter <= DOCUMENT_SEARCH_LIMIT) {
                System.out.println("Wyszukiwanie ksiazek dla hasla " + addTerm.toUpperCase());
                try {
                    sleepMe();
                    documentSearchCounter++;
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
                    sleepMe();
                    documentSearchCounter++;
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
/*
                PagedList<Document> relatedDocs = new PagedArrayList<Document>();
                if (documentSearchCounter <= DOCUMENT_SEARCH_LIMIT) {
                    try {
                        sleepMe();
                        documentSearchCounter++;
                        relatedDocs = searchService.getRelatedDocuments(document.getUuid());
                    } catch (MendeleyException e) {
                        System.out.println("EXCEPTION: " + e.getMessage());
                    }
                    for (Document relDoc : relatedDocs) {
                        if (relDoc.getAuthors() != null && relDoc.getAuthors().size() > 0 && relDoc.getTitle() != null) {
                            addRelatedDocToRelatedDocsMap(document, relDoc);
                            removeDocumentFromMap(relDoc, removeTerm);
                        }
                    }

                }    */
                System.out.println("REM > Koniec dodawania dokumentow dla " + document.getTitle());
            }
        }
    }

    private void processReceivedDocsFromServiceToAdd(List<Document> documents, String addTerm, SearchService searchService) {
        for (Document document : documents) {
            if (document.getAuthors() != null && document.getAuthors().size() > 0 && document.getTitle() != null && document.getUuid() != null) {
                addDocumentToMap(document, addTerm);

                //related documents
                PagedList<Document> relatedDocs = new PagedArrayList<Document>();
                if (documentSearchCounter <= DOCUMENT_SEARCH_LIMIT) {
                    try {
                        sleepMe();
                        documentSearchCounter++;
                        relatedDocs = searchService.getRelatedDocuments(document.getUuid());
                    } catch (MendeleyException e) {
                        System.out.println("EXCEPTION: " + e.getMessage());
                    }
                    for (Document relDoc : relatedDocs) {
                        if (relDoc.getAuthors() != null && relDoc.getAuthors().size() > 0 && relDoc.getTitle() != null) {
                            addRelatedDocToRelatedDocsMap(document, relDoc);
                            addDocumentToMap(relDoc, addTerm);
                        }
                    }
                }

                //for author
/*
                for (Author author : document.getAuthors()) {
                    final String authorName = SearcherUtil.constructAuthorUrlValidString(author);
                    PagedList<Document> authorsDocs = new PagedArrayList<Document>();
                    if (documentSearchCounter <= DOCUMENT_SEARCH_LIMIT) {
                        try {
                            sleepMe();
                            documentSearchCounter++;
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
                }
*/
                System.out.println("ADD > Koniec dodawania dokumentow dla " + document.getTitle());
            }
        }
    }

    private void addRelatedDocToRelatedDocsMap(final Document originalDoc, final Document relatedDoc) {
        final String formattedOrgDocTitle = originalDoc.getTitle().trim().toLowerCase();
        final String formattedRelDocTitle = relatedDoc.getTitle().trim().toLowerCase();
        if (relatedDocMap.containsKey(formattedOrgDocTitle)) {
            Set<String> listForExistingDoc = relatedDocMap.get(formattedOrgDocTitle);
            listForExistingDoc.add(formattedRelDocTitle);
        } else {
            final Set<String> docSet = new HashSet<String>();
            docSet.add(formattedRelDocTitle);
            relatedDocMap.put(formattedOrgDocTitle, docSet);
        }
    }

    private void sleepMe() {
        System.out.println(">>>>>>>>>>>>>>>>>>Obecnie counter to: " + documentSearchCounter);
        try {
            Thread.sleep(MILLIS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void printSearcherResult(String flag, String term) {
        final Map<String, DocumentCounter> stringDocumentCounterMap = generalMap.get(term.toLowerCase());
        if (stringDocumentCounterMap != null) {
            System.out.println("Liczba wszystkich ksiazek przy fladze " + flag + " dla slowa " + term
                    + " wynosi " + stringDocumentCounterMap.size());
        }
    }

    private void addDocumentToMap(Document document, String addTerm) {
        Map<String, DocumentCounter> documentMap;
        if (generalMap.containsKey(addTerm)) {
            documentMap = generalMap.get(addTerm.toLowerCase());
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
    }


    private void printLastResults() throws IOException {
        System.out.println("\n\nKONIEC\n\n");
        FileGeneratorUtil fileGenerator = new FileGeneratorUtil();
        String filesLocationPrefix = "/imageANDrecognitionANDgrammarNOTneural/";
        for (String term : generalMap.keySet()) {
            Map<String, DocumentCounter> documentCounterMap = generalMap.get(term.toLowerCase());
            Map<String, Set<Document>> sortedDocMap = new HashMap<String, Set<Document>>();
//            System.out.println("Dla hasła: " + term + " mam " + documentCounterMap.size() + " książek.");
            for (String documentTitle : documentCounterMap.keySet()) {
                DocumentCounter documentCounter = documentCounterMap.get(documentTitle);
                Document doc = documentCounter.getDocument();
                int counter = documentCounter.getCounter();
                putDocAndCounterToMap(doc, counter, sortedDocMap);
            }
            fileGenerator.createFilesForTherm(term, sortedDocMap, filesLocationPrefix);
        }

        fileGenerator.createRelatedDocsFile(relatedDocMap, filesLocationPrefix);
        fileGenerator.createDocsWithFitsAllCriteria(generalMap, filesLocationPrefix);
    }


    private void putDocAndCounterToMap(Document doc, int counter, Map<String, Set<Document>> sortedDocMap) {
        if (sortedDocMap.containsKey(String.valueOf(counter))) {
            Set<Document> docSet = sortedDocMap.remove(String.valueOf(counter));
            docSet.add(doc);
            sortedDocMap.put(String.valueOf(counter), docSet);
        } else {
            Set<Document> docSet = new HashSet<Document>();
            docSet.add(doc);
            sortedDocMap.put(String.valueOf(counter), docSet);
        }
    }

    public void searchForKeys(List<String> keys, MendeleyServiceFactory factory) {
        for (String key : keys) {
            System.out.println("\n\nZaczynam przetwarzanie dla slow: " + key);
            searchService(factory, key);
            System.out.println("Zakonczylem przetwarzanie dla slow: " + key);
            generateMapWithAllDocumentsWhichFitsAllCriteria();

            try {
                printLastResults();
            } catch (IOException e) {
                System.out.println("[searchForKeys] EXCEPTION: " + e.getMessage());
            }
        }
    }

    private void generateMapWithAllDocumentsWhichFitsAllCriteria() {
        Set<String> generalMapKeys = generalMap.keySet();
        System.out.println("[generateMapWithAllDocumentsWhichFitsAllCriteria] START");
        for (String keys: generalMap.keySet()) {

        }
    }
}

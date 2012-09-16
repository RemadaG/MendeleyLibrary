package pl.remadag.mendeley.bookparser.runme;

import com.mendeley.oapi.schema.Author;
import com.mendeley.oapi.schema.Document;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Test class.
 */
public class MendeleySearcherTest {

    final String CORRECT_TITLE = "Correct title";
    private int counter = 0;

    private Map<String, Map<String, DocumentCounter>> createGeneralMapWithFakeDocsForGivenTerms(String... terms) {
        HashMap<String, Map<String, DocumentCounter>> generalMap = new HashMap<String, Map<String, DocumentCounter>>();
        for (String term : terms) {
            Map<String, DocumentCounter> map = generateMapWithFakeKeys();
            generalMap.put(term, map);
        }
        return generalMap;
    }

    private Map<String, Map<String, DocumentCounter>> createGeneralMapWithCorrectDocsForGivenTerms(String... terms) {
        HashMap<String, Map<String, DocumentCounter>> generalMap = new HashMap<String, Map<String, DocumentCounter>>();
        for (String term : terms) {
            Map<String, DocumentCounter> map = generateMapWithFakeKeys();
            DocumentCounter generatedCorrectDoc = generateCorrectDoc();
            map.put(CORRECT_TITLE, generatedCorrectDoc);
            generalMap.put(term, map);
        }
        return generalMap;
    }

    private DocumentCounter generateCorrectDoc() {
        Document doc = new Document();
        doc.setTitle(CORRECT_TITLE);
        List<Author> authorList = new ArrayList<Author>();
        Author a1 = new Author();
        a1.setSurname("Surname1");
        a1.setForename("Forename1");
        authorList.add(a1);
        Author a2 = new Author();
        a2.setSurname("Surname2");
        a2.setForename("Forename2");
        authorList.add(a2);
        doc.setAuthors(authorList);
        return new DocumentCounter(doc, 1);
    }


    private Map<String, DocumentCounter> generateMapWithFakeKeys() {
        Map<String, DocumentCounter> staticMapWithKey = new HashMap<String, DocumentCounter>();
        addFakeDocsForGivenMap(staticMapWithKey, 5);
        return staticMapWithKey;
    }

    private void addFakeDocsForGivenMap(Map<String, DocumentCounter> staticMapWithKey, int size) {
        for (int i = 0; i < size; i++) {
            Document doc = createFakeDocument();
            DocumentCounter docCounter = new DocumentCounter(doc, i);
            staticMapWithKey.put("FTitle" + counter, docCounter);
        }
    }

    private Document createFakeDocument() {
        Document doc = new Document();
        doc.setTitle("FTitle_" + counter);
        List<Author> authorList = new ArrayList<Author>();
        Author a1 = new Author();
        a1.setSurname("FSurname1");
        a1.setForename("FForename1");
        authorList.add(a1);
        Author a2 = new Author();
        a2.setSurname("FSurname2");
        a2.setForename("FForename2");
        authorList.add(a2);
        doc.setAuthors(authorList);

        counter++;
        return doc;
    }


    @Test
    public void shouldReturnEmptyListForRemoveOnlyTerms() throws Exception {
        // given
        Map<String, Map<String, DocumentCounter>> map = createGeneralMapWithFakeDocsForGivenTerms("r_aaa", "r_bbb");

        // when
        MendeleySearcher searcher = new MendeleySearcher();
        Map<String, Integer> returnMap = searcher.generateMapWithAllDocumentsWhichFitsAllCriteria(map);

        // then
        Assert.assertEquals(returnMap.size(), 0);
        Assert.assertNotNull(returnMap);
    }

    @Test
    public void shouldReturnEmptyListForCorrectDocButRemoveOnlyTerms() throws Exception {
        // given
        Map<String, Map<String, DocumentCounter>> map = createGeneralMapWithCorrectDocsForGivenTerms("r_aaa", "r_bbb");

        // when
        MendeleySearcher searcher = new MendeleySearcher();
        Map<String, Integer> returnMap = searcher.generateMapWithAllDocumentsWhichFitsAllCriteria(map);

        // then
        Assert.assertEquals(returnMap.size(), 0);
        Assert.assertNotNull(returnMap);
    }

    @Test()
    public void shouldReturnListOnlyOneAddTerm() throws Exception {
        // given
        Map<String, Map<String, DocumentCounter>> map = createGeneralMapWithCorrectDocsForGivenTerms("aaa");

        // when
        MendeleySearcher searcher = new MendeleySearcher();
        Map<String, Integer> returnMap = searcher.generateMapWithAllDocumentsWhichFitsAllCriteria(map);

        // then
        Assert.assertNotNull(returnMap);
        Assert.assertEquals(returnMap.size(), 6);
    }

    @Test
    public void shouldReturnListWithOneDocForManyAddOnlyTerms() throws Exception {
        // given
        Map<String, Map<String, DocumentCounter>> map = createGeneralMapWithCorrectDocsForGivenTerms("aaa", "bbb", "ccc", "ddd");

        // when
        MendeleySearcher searcher = new MendeleySearcher();
        Map<String, Integer> returnMap = searcher.generateMapWithAllDocumentsWhichFitsAllCriteria(map);

        int docCounter = 0;
        for (String docTitleKey : returnMap.keySet()) {
            docCounter = returnMap.get(docTitleKey);
        }

        // then
        Assert.assertNotNull(returnMap);
        Assert.assertEquals(returnMap.size(), 1);
        Assert.assertEquals(docCounter, 4);
    }


}

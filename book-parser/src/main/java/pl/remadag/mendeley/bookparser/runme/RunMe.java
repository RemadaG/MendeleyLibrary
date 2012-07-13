package pl.remadag.mendeley.bookparser.runme;

import com.mendeley.oapi.services.MendeleyServiceFactory;
import com.mendeley.oapi.services.SearchService;
import com.mendeley.oapi.schema.Document;

import java.util.List;

public class RunMe {

    /**
     * The Constant CONSUMER_KEY.
     */
    private static final String CONSUMER_KEY = "1cceab9c2ce6c3cb4afe91949f9ff81105009b286";

    /**
     * The Constant CONSUMER_SECRET.
     */
    private static final String CONSUMER_SECRET = "3da2c8fc77a832f0ab86448c52a28f36";

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        MendeleyServiceFactory factory = MendeleyServiceFactory.newInstance(CONSUMER_KEY, CONSUMER_SECRET);
        SearchService service = factory.createSearchService();
        List<Document> documents = service.search("hadoop");
        for (Document document : documents) {
            printResult(document);
        }
    }

    /**
     * Prints the result.
     *
     * @param document the document
     */
    private static void printResult(Document document) {
        System.out.println(document);
    }

}

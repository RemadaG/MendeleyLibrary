package pl.remadag.mendeley.bookparser.runme;

import com.mendeley.oapi.common.PagedList;
import com.mendeley.oapi.schema.Author;
import com.mendeley.oapi.schema.Document;
import com.mendeley.oapi.services.MendeleyServiceFactory;
import com.mendeley.oapi.services.SearchService;

import java.util.Arrays;
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
        searchService(factory, "cybernetic");
    }

    private static void searchService(MendeleyServiceFactory factory, String... searchedTerms) {
        SearchService searchService = factory.createSearchService();
        List<Document> documents = searchService.search(searchedTerms);
        System.out.println("!START! Dla szukanego/szukanych terminów: " + Arrays.toString(searchedTerms) + " mam wszystkich dokumentów=" + documents.size());
        for (Document document : documents) {
            if (document.getTitle() != null) {
                System.out.println("document (" + document.getUuid() + ") = " + document.getTitle());
            }
            if (document.getAuthors() != null && document.getAuthors().size() > 0) {
                for (Author author : document.getAuthors()) {
                    if (author.getSurname() != null) {
                        System.out.println("   > author = " + author.getForename() + " " + author.getSurname());

                        PagedList<Document> authorDocs = searchService.getDocumentsByAuthor(constructUrlValidString(author));
                        for (Document doc : authorDocs) {
                            System.out.print("      > doc rel to autor = ");
                            printResult(doc);
                        }
                    }
                }
            }
            if (document.getUuid() != null && document.getTitle() != null) {
                PagedList<Document> related = searchService.getRelatedDocuments(document.getUuid());
                for (Document doc : related) {
                    System.out.println("   > powiązane z " + document.getTitle() + " sa nastepujace pozycje:");
                    printResult(doc);
                }
            }


        }
    }

    private static String constructUrlValidString(Author author) {
        String str =  author.getForename() + " " + author.getSurname();
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

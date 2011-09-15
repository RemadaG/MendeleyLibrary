package pl.remadag.mendeley.runnable;

import com.mendeley.oapi.schema.Category;
import com.mendeley.oapi.services.FolderService;
import com.mendeley.oapi.services.MendeleyServiceFactory;
import com.mendeley.oapi.services.SearchService;
import com.mendeley.oapi.services.oauth.MendeleyAccessToken;
import pl.remadag.mendeley.common.MendeleyUtil;

/**
 * Test class for Mendeley.
 */
public class TestMe {

    public static void main(String[] args) {
        System.out.println("Hello Mendeley app!");
        MendeleyServiceFactory factory = MendeleyServiceFactory.newInstance(MendeleyUtil.CONSUMER_KEY, MendeleyUtil.CONSUMER_SECRET);
        SearchService service = factory.createSearchService();
        for (Category category : service.getCategories()) {
            System.out.println("category = " + category);
        }

    }
}

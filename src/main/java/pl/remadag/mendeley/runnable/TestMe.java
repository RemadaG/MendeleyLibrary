package pl.remadag.mendeley.runnable;

import com.google.gson.JsonParseException;
import com.mendeley.oapi.common.PagedList;
import com.mendeley.oapi.schema.Category;
import com.mendeley.oapi.schema.Document;
import com.mendeley.oapi.schema.Folder;
import com.mendeley.oapi.schema.Publication;
import com.mendeley.oapi.schema.Tag;
import com.mendeley.oapi.schema.User;
import com.mendeley.oapi.services.DocumentService;
import com.mendeley.oapi.services.FolderService;
import com.mendeley.oapi.services.MendeleyServiceFactory;
import com.mendeley.oapi.services.PrivateStatsService;
import com.mendeley.oapi.services.PublicStatsService;
import com.mendeley.oapi.services.SearchService;
import com.mendeley.oapi.services.oauth.MendeleyAccessToken;
import pl.remadag.mendeley.common.MendeleyUtil;

import java.util.List;

/**
 * Test class for Mendeley.
 */
public class TestMe {

    public static void main(String[] args) {
        MendeleyServiceFactory factory = MendeleyServiceFactory.newInstance(MendeleyUtil.CONSUMER_KEY, MendeleyUtil.CONSUMER_SECRET);
        DocumentService service = factory.createDocumentService(new MendeleyAccessToken(MendeleyUtil.ACCESS_TOKEN, MendeleyUtil.TOKEN_SECRET));
        PagedList<String> ids = service.getDocumentIds();
        for (String id : ids) {
            try {
                Document details = service.getDocumentDetails(id);
                String abstractDoc = details.getAbstract();
                System.out.println(abstractDoc);
            } catch (JsonParseException e) {
                System.out.println("Problem with document with id: " + id + ", e: " + e.getMessage());
            }
        }
    }

    public void getAbstracts() {
        MendeleyServiceFactory factory = MendeleyServiceFactory.newInstance(MendeleyUtil.CONSUMER_KEY, MendeleyUtil.CONSUMER_SECRET);
        DocumentService service = factory.createDocumentService(new MendeleyAccessToken(MendeleyUtil.ACCESS_TOKEN, MendeleyUtil.TOKEN_SECRET));
        PagedList<String> ids = service.getDocumentIds();
        for (String id : ids) {
            System.out.println("ID = " + id);
            try {


                Document details = service.getDocumentDetails(id);
                String keyWords = details.getAbstract();
/*
            for (String keyWord : keyWords) {
                System.out.println("keyWord = " + keyWord);
            }
*/
            } catch (JsonParseException e) {
                System.out.println("Problem with document with id" + id);
                e.printStackTrace();
            }
        }
    }
}

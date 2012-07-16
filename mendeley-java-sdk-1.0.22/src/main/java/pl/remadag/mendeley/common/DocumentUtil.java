package pl.remadag.mendeley.common;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.mendeley.oapi.schema.Document;
import com.mendeley.oapi.services.MendeleyException;
import com.mendeley.oapi.services.constant.MendeleyApiUrls;
import com.mendeley.oapi.services.constant.ParameterNames;
import com.mendeley.oapi.services.impl.BaseMendeleyPublicService;
import com.mendeley.oapi.services.oauth.MendeleyApiConsumer;
import com.mendeley.oapi.services.oauth.MendeleyOAuthService;
import com.mendeley.oapi.services.oauth.MendeleyOAuthServiceFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by IntelliJ IDEA.
 * User: Marcin
 * Date: 17.09.11
 * Time: 20:27
 * To change this template use File | Settings | File Templates.
 */
public class DocumentUtil extends BaseMendeleyPublicService {


    /**
     * Instantiates a new base mendeley public service.
     *
     * @param apiConsumer the api consumer
     */
    public DocumentUtil(MendeleyApiConsumer apiConsumer) {
        super(apiConsumer);
    }

    @Override
    protected <T> T unmarshall(TypeToken<T> typeToken, JsonElement response) {
        Gson gson = getGsonBuilder().create();
        return (T) gson.fromJson(response, typeToken.getType());
    }

}

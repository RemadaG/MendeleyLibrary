package pl.remadag.mendeley.bookparser.runme;

import com.mendeley.oapi.services.MendeleyServiceFactory;

import java.util.ArrayList;
import java.util.List;

public class RunMe {

    /**
     * The Constant CONSUMER_KEY.
     */
    private static final String CONSUMER_KEY = "39ef5f1fa3624ebb37602132b8d45524050474851";

    /**
     * The Constant CONSUMER_SECRET.
     */
    private static final String CONSUMER_SECRET = "9276b0554888d0d8a4f9be9270d59f01";


    public static final int DOCUMENT_SEARCH_LIMIT = 1;
    public static final long MILLIS = 500L;
    public static final String DOC_DIR = "aaa";



    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        MendeleyServiceFactory factory = MendeleyServiceFactory.newInstance(CONSUMER_KEY, CONSUMER_SECRET);
        MendeleySearcher searcher = new MendeleySearcher();
        List<String> keys = new ArrayList<String>();
        keys.add("image AND recognition AND grammar NOT neural");
        searcher.searchForKeys(keys, factory);
    }


}

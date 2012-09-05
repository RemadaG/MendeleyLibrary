package pl.remadag.mendeley.bookparser.runme;

import com.mendeley.oapi.services.MendeleyServiceFactory;

public class RunMe {

    /**
     * The Constant CONSUMER_KEY.
     */
    private static final String CONSUMER_KEY = "39ef5f1fa3624ebb37602132b8d45524050474851";

    /**
     * The Constant CONSUMER_SECRET.
     */
    private static final String CONSUMER_SECRET = "9276b0554888d0d8a4f9be9270d59f01";

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        MendeleyServiceFactory factory = MendeleyServiceFactory.newInstance(CONSUMER_KEY, CONSUMER_SECRET);
        MendeleySearcher searcher = new MendeleySearcher();
        searcher.searchService(factory, "hadoop");
    }


}

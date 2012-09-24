package pl.remadag.mendeley.bookparser.runme;

import com.mendeley.oapi.services.MendeleyServiceFactory;

import java.io.File;
import java.io.IOException;
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


    public static int DOCUMENT_SEARCH_LIMIT = 5;
    public static final long MILLIS = 500L;
    public static String DOC_DIR = "";


    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) throws IOException {
        System.out.println("\n\n\n\n\n");
        String sentence = args[0];
        if(sentence == null) {
            sentence = "";
        }

        String searchCounter = args[1];
        if(searchCounter != null) {
            DOCUMENT_SEARCH_LIMIT = Integer.parseInt(searchCounter);
        }


        File directory = new File(".");
        DOC_DIR = directory.getCanonicalPath() + "/";

        System.out.println("Przygotowanie folderu... (" + DOC_DIR  + ")");
        Runtime.getRuntime().exec("rm ./correctDocs.txt");
        Runtime.getRuntime().exec("rm ./relatedDocs.txt");

        System.out.println("Szukane frazy to: " + sentence);

        MendeleyServiceFactory factory = MendeleyServiceFactory.newInstance(CONSUMER_KEY, CONSUMER_SECRET);
        MendeleySearcher searcher = new MendeleySearcher();
        List<String> keys = new ArrayList<String>();
        keys.add(sentence);
        searcher.searchForKeys(keys, factory);
        String copyCorrect = "cp " + DOC_DIR + "correctDocs.txt ./biblio";
        Runtime.getRuntime().exec(copyCorrect);

        String copyRelated = "cp " + DOC_DIR + "relatedDocs.txt ./biblio";
        Runtime.getRuntime().exec(copyRelated);

        System.out.println("Generowanie grafu...");
        Runtime.getRuntime().exec("./biblio/biblio ./biblio/correctDocs.txt ./biblio/relatedDocs.txt");
        System.out.println("Rysowanie grafu... (graph.png)");
        Runtime.getRuntime().exec("dot ./out.dot -Tpng -o graph.png");

        System.out.println("Czyszczenie...");
        Runtime.getRuntime().exec("rm ./biblio/correctDocs.txt");
        Runtime.getRuntime().exec("rm ./biblio/relatedDocs.txt");
    }


}

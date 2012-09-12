package pl.remadag.mendeley.bookparser.runme;

import com.mendeley.oapi.schema.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Class
 *
 * @author Marcin Gadamer
 */
public class SearcherUtil {

    public static String getDocumentsMapKey(Document document) {
        return document.getTitle().trim().toLowerCase();
    }

    public static Map<String, List<String>> parseInputSentence(String sentence) {
        Map<String, List<String>> outputMap = new HashMap<String, List<String>>();
        List<String> addList = new ArrayList<String>();
        List<String> removeList = new ArrayList<String>();

        StringTokenizer tokenizer = new StringTokenizer(sentence);
        String firstWord = tokenizer.nextToken();
        addList.add(firstWord);

        while (tokenizer.hasMoreTokens()) {
            String flag = tokenizer.nextToken();
            if ("and".equals(flag.toLowerCase())) {
                addList.add(tokenizer.nextToken().toLowerCase());
            } else {
                removeList.add(tokenizer.nextToken().toLowerCase());
            }
        }
        outputMap.put("ADD", addList);
        outputMap.put("REMOVE", removeList);
        return outputMap;
    }

}

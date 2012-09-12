package pl.remadag.mendeley.bookparser.runme;

import com.mendeley.oapi.schema.Author;
import com.mendeley.oapi.schema.Document;

/**
 * Class
 *
 * @author Marcin Gadamer
 */
public class SearcherUtil {

    public static String getAuthorsMapKey(Author author) {
        return author.getSurname() + " " + author.getForename();
    }

    public static String getDocumentsMapKey(Document document) {
        return document.getTitle().trim().toLowerCase();
    }

}

package pl.remadag.mendeley.bookparser.runme;

import com.mendeley.oapi.schema.Author;
import com.mendeley.oapi.schema.Document;

import java.util.HashMap;
import java.util.Map;

public class AuthorCounter {
    private Author author = new Author();
    private int counter = 0;
    private Map<String, Document> authorsDoc = new HashMap<String, Document>();


    public AuthorCounter(Author author, int counter) {
        this.author = author;
        this.counter = counter;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public Map<String, Document> getAuthorsDoc() {
        return authorsDoc;
    }

    public void addDocToAuthor(Document doc) {

        if(!authorsDoc.containsKey(SearcherUtil.getDocumentsMapKey(doc))) {
            authorsDoc.put(SearcherUtil.getDocumentsMapKey(doc), doc);
        }
    }
}


package pl.remadag.mendeley.bookparser.runme;

import com.mendeley.oapi.schema.Author;
import com.mendeley.oapi.schema.Document;

import java.util.HashSet;
import java.util.Set;

public class AuthorCounter {
    private Author author = new Author();
    private int counter = 0;
    private Set<Document> authorsDoc = new HashSet<Document>();


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

    public Set<Document> getAuthorsDoc() {
        return authorsDoc;
    }

    public void addDocToAuthor(Document doc) {
        authorsDoc.add(doc);
    }
}


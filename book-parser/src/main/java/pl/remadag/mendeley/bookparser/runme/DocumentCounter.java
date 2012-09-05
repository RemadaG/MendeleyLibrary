package pl.remadag.mendeley.bookparser.runme;

import com.mendeley.oapi.schema.Document;

public class DocumentCounter {
    private Document document = new Document();
    private int counter = 0;

    public DocumentCounter(Document document, int counter) {
        this.document = document;
        this.counter = counter;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}

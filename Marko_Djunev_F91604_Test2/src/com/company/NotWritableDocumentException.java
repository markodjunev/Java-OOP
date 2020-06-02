package com.company;

public class NotWritableDocumentException extends Exception {
    private Document document;

    public NotWritableDocumentException(Document document){
        this.document = document;
    }

    @Override
    public String toString() {
        return "NotWritableDocumentException{" +
                "Sorry but the document properties is " + this.document.getProperties() +
                '}';
    }
}
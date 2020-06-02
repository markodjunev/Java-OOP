package com.company;

import javax.print.Doc;

public class Main {

    public static void main(String[] args) throws NotWritableDocumentException {
        var document1 = new Document("NBU", Properties.READ_ONLY, 5);
        var document2 = new Document("UNSS", Properties.WRITABLE, 10);
        var document3 = new Document("FMI", Properties.READ_ONLY, 15);

        var rep = new Repository("Library");
        rep.addDocument(document1);
        rep.addDocument(document2);
        rep.addDocument(document3);

        var user1 = new User("Ivan");
        rep.addUser(user1);

        //rep.saveDocumentInFile(document1, "Doc1");

        var isContained1 = rep.readDocumentName(document2, "SS"); //true
        var isContained2 = rep.readDocumentName(document1, "U"); //true
        var isContained3 = rep.readDocumentName(document1, "EU"); //false

        //rep.writeTextInDocument(document1, "aaa"); error because the document is readonly
        //rep.writeTextInDocument(document2, "EE"); name changed successfully
        //System.out.println(document2.toString());
    }
}

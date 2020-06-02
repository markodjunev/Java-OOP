package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Repository {
    private String name;
    private List<Document> documents;
    private List<User> users;

    public Repository(String name) {
        this.name = name;
        this.documents = new ArrayList<Document>();
        this.users = new ArrayList<User>();
    }

    public void addDocument(Document document) {
        if (!documents.contains(document)) {
            this.documents.add(document);
        }
    }

    public void addUser(User user) {
        if (!users.contains(user)) {
            this.users.add(user);
        }
    }

    // Task 1
    public void writeTextInDocument(Document document, String text) throws NotWritableDocumentException {
        if (document.getProperties() == Properties.READ_ONLY){
            throw new NotWritableDocumentException(document);
        }

       document.addTextToName(text);
    }

    // Task 2
    public void saveDocumentInFile(Document document, String filename) {
        if (!this.documents.contains(document)){
            System.out.println("Sorry the document is not available in the store");
            return;
        }

        filename += ".txt";
        FileWriter fout = null;
        try {
            fout = new FileWriter(new File(filename), true);
            if (document != null) {
                fout.append(document.toString() + '%' + System.lineSeparator());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found " + e);
        } catch (IOException e) {
            System.out.println("IOException " + e);
        } finally {
            try {
                if (fout != null) {
                    fout.close();
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

    // Task 3
    public void serializeDocument(Document document, String filename) {
        try (FileOutputStream fos = new FileOutputStream(filename);
             ObjectOutputStream outputStream = new ObjectOutputStream(fos);) {
            outputStream.writeObject(document);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Task 3
    public Document deserializeDocument(String filename) {
        Document document= null;
        try (FileInputStream fis = new FileInputStream(filename);
             ObjectInputStream inputStream = new ObjectInputStream(fis);) {

            document = (Document) inputStream.readObject();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document;
    }

    // Task 4
    public boolean readDocumentName(Document document, String targetString) {

        for (int i = document.getName().length()/2; i < document.getName().length(); i++){
            if(i + targetString.length() > document.getName().length()){ // check if it is out of range
                return false;
            }

            var current = document.getName().substring(i, i + targetString.length());
            if (current.equals(targetString)){
                return true;
            }
        }

        return false;
    }

    // Task 5
    public void downloadDocuments(User user) {

    }

    @Override
    public String toString() {
        return "Repository{" +
                "name='" + name + '\'' +
                ", documents=" + documents +
                ", users=" + users +
                '}';
    }
}
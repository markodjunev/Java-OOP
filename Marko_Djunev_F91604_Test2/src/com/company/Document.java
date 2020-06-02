package com.company;

import java.io.Serializable;

public class Document implements Serializable {
    private String name;
    private Properties properties;
    private double size;

    public Document(String name, Properties properties, double size) {
        this.name = name;
        this.properties = properties;
        this.size = size;
    }

    public void addTextToName(String text){
        this.name += text;
    }

    public String getName() {
        return this.name;
    }

    public Properties getProperties() {
        return this.properties;
    }

    public void downloadDocument() {
        System.out.println("Downloading " + this.name);
    }

    @Override
    public String toString() {
        return "Document{" +
                "name='" + name + '\'' +
                ", properties=" + properties +
                ", size=" + size +
                '}';
    }
}
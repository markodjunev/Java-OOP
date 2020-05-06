package com.company;

public class Main {

    public static void main(String[] args) {
        var box = new Box(5,6,7);
        var material = new Material("Stone", true);
        var element = new Element(2, material);
        var fur = new Furniture("Adidas", 1000, box, "Geo milev", 5);

        fur.addElement(element);
        System.out.println(fur.toString());

    }
}

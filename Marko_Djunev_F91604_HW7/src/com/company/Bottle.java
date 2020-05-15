package com.company;

import java.io.Serializable;

public class Bottle implements Serializable {
    private static int count = 0;

    private final int id;
    private TypeOfBottle typeOfBottle;
    private double price;

    public Bottle(TypeOfBottle typeOfBottle, double price){
        this.id = ++count;
        this.typeOfBottle = typeOfBottle;
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    public TypeOfBottle getTypeOfBottle() {
        return this.typeOfBottle;
    }

    @Override
    public String toString() {
        return "Bottle{" +
                "id=" + this.id +
                ", typeOfBottle=" + this.typeOfBottle +
                '}';
    }
}

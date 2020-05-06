package com.company;

public class Cashier {
    private static int count = 0;

    private String name;
    private final int serialNumber;

    public Cashier(String name){
        this.name = name;
        this.serialNumber = ++count;
    }

    @Override
    public String toString() {
        return "Cashier{" +
                "name='" + this.name + '\'' +
                ", serialNumber=" + this.serialNumber +
                '}';
    }
}

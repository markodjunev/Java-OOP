package com.company;

public class Goods {
    private static double maxPrice = 15;
    private double price;

    public Goods(double price) {
        this.price = price;
    }

    public static double getMaxPrice() {
        return maxPrice;
    }

    public static void setMaxPrice(double maxPrice) {
        Goods.maxPrice = maxPrice;
    }

    public double getPrice() {
        return price;
    }
}

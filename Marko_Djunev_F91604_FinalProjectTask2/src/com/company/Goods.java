package com.company;

public class Goods {
    private static int count = 0;

    private String name;
    private double price;
    private final int identityNumber;
    private int expiryDate;
    private int quantity;

    public Goods(String name, double price, int quantity, int expiryDate){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
        this.identityNumber = ++count;
    }

    public int getIdentityNumber(){
        return this.identityNumber;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public void increaseQuantity(int quantity){
        this.quantity += quantity;
    }

    public void decreaseQuantity(int quantity){
        this.quantity-=quantity;
    }

    public int getQuantity(){
        return this.quantity;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + this.name + '\'' +
                ", price=" + this.price +
                ", quantity=" + this.quantity +
                ", identityNumber=" + this.identityNumber +
                ", expiryDate=" + this.expiryDate +
                '}';
    }
}

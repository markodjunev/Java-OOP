package com.company;

public class OrderProduct {
    private Goods goods;
    private int quantity;
    private double price;

    public OrderProduct(Goods goods, int quantity){
        this.goods = goods;
        this.quantity = quantity;
        this.price = this.goods.getPrice() * this.quantity;
    }

    public double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return "OrderProduct{" +
                "product name=" + this.goods.getName() +
                ", product price= " + this.goods.getPrice() +
                ", quantity=" + this.quantity +
                ", total price=" + this.price +
                '}';
    }
}

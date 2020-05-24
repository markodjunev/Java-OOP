package com.company;

public class InsufficientQuantityException extends Exception {
    private Goods goods;
    private int quantity;

    public InsufficientQuantityException(Goods goods, int quantity){
        this.goods = goods;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "InsufficientQuantityException{" +
                "You wanna buy " + this.quantity + " " + this.goods.getName() + ", but the quantity we have of " + this.goods.getName() + " is " + this.goods.getQuantity() +
                '}';
    }
}

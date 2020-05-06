package com.company;

public class OrderProduct {
    private Goods goods;
    private int quantity;
    private double price;
    private OrderProductStatus status;

    public OrderProduct(Goods goods, int quantity){
        this.goods = goods;
        this.quantity = quantity;
        this.price = this.goods.getPrice() * this.quantity;
        this.status = OrderProductStatus.Active;
    }

    public double getPrice() {
        return this.price;
    }

    public OrderProductStatus getStatus(){
        return this.status;
    }

    public void setCompletedStatus(){
        this.status = OrderProductStatus.Completed;
    }
    @Override
    public String toString() {
        return "OrderProduct{" +
                "goods=" + this.goods +
                ", quantity=" + this.quantity +
                ", price=" + this.price +
                '}';
    }
}

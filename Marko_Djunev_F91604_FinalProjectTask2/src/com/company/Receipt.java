package com.company;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private static int count = 0;

    private final int serialNumber;
    private Cashier cashier;
    private LocalTime dateOfCreation;
    private List<OrderProduct> orderProducts;

    public Receipt(Cashier cashier){
        this.cashier = cashier;
        this.dateOfCreation = LocalTime.now();
        this.serialNumber = ++count;
        this.orderProducts = new ArrayList<>();
    }

    public int getSerialNumber() {
        return this.serialNumber;
    }

    public double getSum(){
        var price = 0d;

        for (OrderProduct orderProduct:this.orderProducts) {
            price += orderProduct.getPrice();
        }

        return price;
    }

    public void setProducts(List<OrderProduct> orderProducts){
        this.orderProducts = orderProducts;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "serialNumber=" + this.serialNumber +
                ", cashier=" + this.cashier +
                ", dateOfCreation=" + this.dateOfCreation +
                ", price=" + this.getSum() +
                ", orderProducts=" + this.orderProducts.toString() +
                '}';
    }
}

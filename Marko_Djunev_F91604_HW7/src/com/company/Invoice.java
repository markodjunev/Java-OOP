package com.company;

import java.io.Serializable;
import java.time.LocalDate;

public class Invoice implements Serializable {
    private static int count = 0;

    private final int id;
    private DeliveryMan deliveryMan;
    private Customer customer;
    private MineralWater mineralWater;
    private double mineralWaterPrice;
    private int quantity;
    private double price;
    private LocalDate dateOfCreation;

    public Invoice(DeliveryMan deliveryMan, Customer customer, MineralWater mineralWater, int quantity){
        this.id = ++count;
        this.deliveryMan = deliveryMan;
        this.customer = customer;
        this.mineralWater = mineralWater;
        this.mineralWaterPrice = this.mineralWater.getBottle().getPrice();
        this.quantity = quantity;
        this.price = this.mineralWater.getBottle().getPrice() * quantity;
        this.dateOfCreation = LocalDate.now();
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + this.id +
                ", deliveryMan=" + this.deliveryMan +
                ", customer=" + this.customer +
                ", mineralWater=" + this.mineralWater +
                ", mineralWaterPrice=" + this.mineralWaterPrice +
                ", quantity=" + this.quantity +
                ", price=" + this.price +
                ", dateOfCreation=" + this.dateOfCreation +
                '}';
    }
}

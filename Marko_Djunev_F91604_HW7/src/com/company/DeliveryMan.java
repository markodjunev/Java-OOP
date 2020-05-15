package com.company;

public class DeliveryMan {
    private static int count = 0;
    private int id;

    public DeliveryMan(){
        this.id = ++count;
    }

    @Override
    public String toString() {
        return "DeliveryMan{" +
                "id=" + id +
                '}';
    }
}

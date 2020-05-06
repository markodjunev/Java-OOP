package com.company;

public class Furniture extends Item {
    private String brand;
    private double volumeNum;

    public Furniture(String brand,double volumeNum, Box box, String address, double priceDeliveryPerKg){
        super(box,address, priceDeliveryPerKg);
        this.brand = brand;
        this.volumeNum = volumeNum;
    }

    @Override
    public double shippingPrice() {
        boolean isValid = false;
        if (this.isFragile() && this.box.volume() > this.volumeNum){
            isValid = true;
        }

        double price = 0;
        for (Element element: this.elements) {
            price += element.getKg() * priceDeliveryPerKg;
        }

        if (isValid)
            return price * 1.015;

        return price;
    }
}

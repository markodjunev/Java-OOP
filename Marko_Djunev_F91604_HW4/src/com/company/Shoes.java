package com.company;

public class Shoes extends Item {
    private boolean canBeMeasured;

    public Shoes(boolean canBeMeasured, Box box, String address, double priceDeliveryPerKg){
        super(box,address, priceDeliveryPerKg);
        this.canBeMeasured = canBeMeasured;
    }

    @Override
    public double shippingPrice() {
        double price=0;
        for (Element element: this.elements) {
            price += this.priceDeliveryPerKg * element.getKg();
        }

        if (this.canBeMeasured)
            return price * 1.03;

        return price;
    }

    @Override
    public String toString() {
        return "Shoes{" + "address=" +
                this.address + ", priceDeliveryPerKg=" +
                this.priceDeliveryPerKg + "canBeMeasured=" +
                this.canBeMeasured + ", Box {" +
                "volume=" + this.box.volume() +
                '}' + "Elements{" + "elements=" +
                this.elements + '}';
    }
}

package com.company;

import java.util.ArrayList;
import java.util.List;

public abstract class Item implements Shipment{
    protected Box box;
    protected String address;
    protected double priceDeliveryPerKg;
    protected List<Element> elements;

    public Item(Box box, String address, double priceDeliveryPerKg){
        this.box = box;
        this.address = address;
        this.priceDeliveryPerKg = priceDeliveryPerKg;
        this.elements = new ArrayList<>();
    }

    public void addElement(Element element){
        this.elements.add(element);
    }

    public double totalWeight(){
        double weight = 0;
        for (Element element : this.elements) {
            weight += element.getKg();
        }

        return weight;
    }

    @Override
    public double shippingPrice(){
        double price = 0;
        for (Element element: this.elements) {
            price += element.getKg() * priceDeliveryPerKg;
        }

        return price;
    }

    public boolean isFragile(){
        for (Element element : this.elements) {
            if (element.isFragile())
                return true;
        }

        return false;
    }

    public List<Element> getElements(){
        return this.elements;
    }

    @Override
    public String toString() {
        return "Item{" + "address=" +
                this.address + ", priceDeliveryPerKg=" +
                this.priceDeliveryPerKg + ", Box {" +
                "volume=" + this.box.volume() +
                '}' + "Elements{" + "elements=" +
                this.elements + '}';
    }
}

package com.company;

import java.util.ArrayList;
import java.util.List;

public class CourierCompany {
    protected List<Item> items;

    public CourierCompany(){
        this.items = new ArrayList<>();
    }

    public void addItem(Item item){
        this.items.add(item);
    }

    public double totalEarnings(){
        double sum = 0;
        for (Item item:this.items) {
            sum+=item.shippingPrice();
        }

        return sum;
    }

    public double totalVolume(){
        double vol = 0;
        for (Item item:this.items) {
            vol += item.box.volume();
        }

        return vol;
    }

    @Override
    public String toString() {
        return "CourierCompany{" + "totalEarnings=" +
                this.totalEarnings() + ", totalVolume=" +
                this.totalVolume() + ", Items {" +
                "items=" + this.items + '}' + '}';
    }
    
}

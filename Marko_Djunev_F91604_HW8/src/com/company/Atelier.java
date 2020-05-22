package com.company;

import java.util.ArrayList;
import java.util.List;

public class Atelier {
    private String name;
    private List<Tailor> tailors;
    private int clothesToSew;

    public Atelier(String name, int clothesToSew){
        this.name = name;
        this.clothesToSew= clothesToSew;
        this.tailors = new ArrayList<>();
    }

    public void addTailor(Tailor tailor){
        for (Tailor tai:this.tailors) { // check if the tailor already works in the atelier
            if (tai == tailor){
                System.out.println("This tailor is already added!");
                return;
            }
        }

        this.tailors.add(tailor);
    }

    public int getClothesToSew() {
        return this.clothesToSew;
    }

    public boolean isTailorWorking(int id){
        for (Tailor tailor:this.tailors) {
            if (tailor.getId() == id)
                return true;
        }

        return false;
    }

    public void addClothesToSew(int count){
        if (count <= 0){
            System.out.println("Please enter a positive number!");
            return;
        }

        this.clothesToSew += count;
    }

    public void decreaseClothesQuantity(){
        this.clothesToSew--;
    }

    @Override
    public String toString() {
        return "Atelier{" +
                "name='" + this.name + '\'' +
                ", tailors=" + this.tailors +
                ", clothesToSew=" + this.clothesToSew +
                '}';
    }
}

package com.company;

public class Element {
    private double kg;
    private Material material;

    public Element(double kg, Material material){
        this.kg = kg;
        this.material = material;
    }

    public boolean isFragile(){
        return this.material.isFragile();
    }

    public double getKg(){
        return this.kg;
    }

    @Override
    public String toString() {
        return "Element{" + "kg=" +
                this.kg + ", Material {" +
                "name=" + this.material.getName() +
                ", isFragile=" + this.material.isFragile() +
                '}' + '}';
    }
}

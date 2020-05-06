package com.company;

public class Material {
    private String name;
    private boolean isFragile;

    public Material(String name, boolean isFragile){
        this.name = name;
        this.isFragile = isFragile;
    }

    public boolean isFragile(){
        return this.isFragile;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String toString() {
        return "Material{" + "name=" +
                name + ", isFragile=" +
                isFragile +'}';
    }
}

package com.company;

public enum TypeOfBottle {
    Plastic(0.5),
    Glass(0.5);

    private double volume;
    private TypeOfBottle(double volume){
        this.volume = volume;
    }
    public double getVolume(){
        return this.volume;
    }
}

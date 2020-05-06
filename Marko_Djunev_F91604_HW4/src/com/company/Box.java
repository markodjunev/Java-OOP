package com.company;

public class Box {
    private double a, b, c;

    public Box(double a, double b, double c){
        this.a =a ;
        this.b = b;
        this.c = c;
    }

    public double volume(){
        return this.a * this.b * this.c;
    }
}

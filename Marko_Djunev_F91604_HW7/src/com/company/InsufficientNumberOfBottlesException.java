package com.company;

public class InsufficientNumberOfBottlesException extends Exception{
    private TypeOfBottle typeOfBottle;

    public InsufficientNumberOfBottlesException(TypeOfBottle typeOfBottle){
        this.typeOfBottle = typeOfBottle;
    }

    @Override
    public String toString() {
        return "InsufficientNumberOfBottlesException{" +
                "typeOfBottle=" + this.typeOfBottle +
                '}';
    }
}

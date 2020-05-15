package com.company;

public class MineralWater {
    private static int count = 0;

    private final int id;
    private final double volume;
    private Bottle bottle;

    public MineralWater(Bottle bottle){
        this.id = ++count;
        this.bottle = bottle;
        this.volume = bottle.getTypeOfBottle().getVolume();
    }

    public Bottle getBottle(){

        return this.bottle;
    }

    @Override
    public String toString() {
        return "MineralWater{" +
                "id=" + this.id +
                ", volume=" + this.volume +
                ", bottle=" + this.bottle +
                '}';
    }
}

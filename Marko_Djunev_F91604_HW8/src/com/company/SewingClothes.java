package com.company;

public class SewingClothes implements Runnable {
    private Tailor tailor;
    private Atelier atelier;
    private int clothesCount;

    public SewingClothes(Tailor tailor, Atelier atelier, int clothesCount){
        this.tailor = tailor;
        this.atelier = atelier;
        this.clothesCount = clothesCount;
    }
    @Override
    public void run() {
        this.tailor.sewClothes(this.atelier, clothesCount);
    }
}

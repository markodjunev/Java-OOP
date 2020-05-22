package com.company;

public class Tailor {
    private static int count =0;
    private int id;
    private int sewedClothes;

    public Tailor(){
        this.id = ++count;
    }

    public int getId(){
        return this.id;
    }

    public synchronized void sewClothes(Atelier atelier, int clothesCount){
        var isWorking = atelier.isTailorWorking(this.id);

        if (!isWorking){
            System.out.println("Sorry but the tailor isn't working in the atelier");
            return;
        }

        for (int i=0; i<clothesCount; i++){
            if (atelier.getClothesToSew() - 1 >= 0){
                atelier.decreaseClothesQuantity();
                this.sewedClothes++;
            }
            else{
                System.out.println("Sorry but there are no available clothes to be sewed in the atelier!");
                return;
            }
        }
    }

    @Override
    public String toString() {
        return "Tailor{" +
                "id=" + this.id +
                ", sewedClothes=" + this.sewedClothes +
                '}';
    }
}

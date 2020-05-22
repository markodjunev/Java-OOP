package com.company;

public class Main {

    public static void main(String[] args)  throws InterruptedException {
        var atelier = new Atelier("NBU", 20);
        var tailor1 = new Tailor();
        var tailor2 = new Tailor();
        var tailor3 = new Tailor();

        atelier.addTailor(tailor1);
        atelier.addTailor(tailor2);
        atelier.addTailor(tailor2); // error because the tailor2 is already added

        Thread thread1 = new Thread(new SewingClothes(tailor1, atelier, 10), "thread1");
        Thread thread2 = new Thread(new SewingClothes(tailor2, atelier, 9), "thread2");
        Thread thread3 = new Thread(new SewingClothes(tailor3, atelier, 5), "thread3"); // error because tailor3 doesn't work in the atelier

        thread1.start();
        thread2.start();
        thread3.start();

        Thread.sleep(1000);// I use it because atelier.toString() is executed before the end of the thread1, thread2, thread3

        System.out.println(atelier.toString());
    }
}

package com.company;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        File filesDirectory = new File("files");
        final String fileInvoice = "files/Invoices.txt";

        final double pricePlasticBottle = 0.5;
        final double priceGlassBottle = 0.6;

        var factory = new Factory();
        factory.addBottle(TypeOfBottle.Glass, priceGlassBottle);
        factory.addBottle(TypeOfBottle.Glass, priceGlassBottle);
        factory.addBottle(TypeOfBottle.Glass, priceGlassBottle);

        try {
            factory.bottling(TypeOfBottle.Plastic); // this will be unsuccessful because there are no plastic bottles
        }
        catch(InsufficientNumberOfBottlesException e) {
            e.printStackTrace();
        }

        factory.addBottle(TypeOfBottle.Plastic, pricePlasticBottle);
        factory.addBottle(TypeOfBottle.Plastic, pricePlasticBottle);
        factory.addBottle(TypeOfBottle.Plastic, pricePlasticBottle);

        try {
            factory.bottling(TypeOfBottle.Plastic);
        }
        catch(InsufficientNumberOfBottlesException e) {
            e.printStackTrace();
        }

        var customer = new Customer("Ivan");
        var deliveryMan = new DeliveryMan();

        factory.addDeliveryMan(deliveryMan);

        factory.sellWater(customer, TypeOfBottle.Plastic, deliveryMan, 2); // unsuccessful because there is only one mineral water in plastic bottle

        factory.sellWater(customer, TypeOfBottle.Plastic, deliveryMan, 1);

        System.out.println(factory.toString());

        var invoices = factory.readInvoicesFromFile(fileInvoice);

        System.out.println(invoices);


    }
}

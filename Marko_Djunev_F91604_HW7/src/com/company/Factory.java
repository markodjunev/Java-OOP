package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Factory {
    private List<MineralWater> mineralWaters;
    private List<Bottle> bottles;
    private List<DeliveryMan> deliveryMen;
    private List<Invoice> invoices;
    private String fileInvoices = "files/Invoices.txt";
    private String fileBottle = "files/bottle.ser";

    public Factory(){
        this.mineralWaters = new ArrayList<>();
        this.bottles = new ArrayList<>();
        this.deliveryMen = new ArrayList<>();
        this.invoices = new ArrayList<>();
    }

    public void addBottle(TypeOfBottle typeOfBottle, double price){
        var bottle = new Bottle(typeOfBottle, price);
        this.bottles.add(bottle);
        serializeBottle(fileBottle, bottle);
        System.out.println(deserializeBottle(fileBottle));
    }

    public void addDeliveryMan(DeliveryMan deliveryMan){
        this.deliveryMen.add(deliveryMan);
    }

    public void bottling(TypeOfBottle typeOfBottle) throws InsufficientNumberOfBottlesException{
        var isAvailableTypeOfBottle = false;
        Bottle currentBottle = null;

        for (Bottle bottle:this.bottles) {
            if (bottle.getTypeOfBottle() == typeOfBottle){ // check if the type of bottle is available in the store
                isAvailableTypeOfBottle = true;
                currentBottle = bottle;
                break;
            }
        }

        if (isAvailableTypeOfBottle){
            var water = new MineralWater(currentBottle);
            this.mineralWaters.add(water);
            this.bottles.remove(currentBottle);
        }

        else{
            throw new InsufficientNumberOfBottlesException(typeOfBottle);
        }
    }

    public void sellWater(Customer customer, TypeOfBottle typeOfBottle, DeliveryMan deliveryMan, int quantity){
        if (quantity <= 0){
            System.out.println("The quantity must be a positive number!");
            return;
        }

        var availableMineralWaters = 0;

        for (MineralWater mineralWater:this.mineralWaters) { // check if there is enough quantity
            if (mineralWater.getBottle().getTypeOfBottle() == typeOfBottle){
                availableMineralWaters++;
            }
        }

        if (availableMineralWaters - quantity >= 0){
            var isDeliveryManWorking = false;

            for (DeliveryMan worker:this.deliveryMen) { //check if the delivery man is working in the factory
                if (worker.equals(deliveryMan)){
                    isDeliveryManWorking = true;
                    break;
                }
            }

            if (isDeliveryManWorking){
                var curCount = 0;
                for (MineralWater mineralWater:this.mineralWaters) {
                    if (mineralWater.getBottle().getTypeOfBottle() == typeOfBottle){ // check if there is available type of bottle
                        var invoice = new Invoice(deliveryMan, customer, mineralWater, quantity);
                        this.invoices.add(invoice);
                        writeInvoice(fileInvoices, invoice);
                        removeMineralWaterAndBottle(mineralWater);
                        curCount++;
                        if (curCount == quantity){ // check if the quantity is equal
                            break;
                        }
                    }
                }
            }

            else{
                System.out.println("Sorry, but the delivery man doesn't work for the factory!");
                return;
            }
        }

        else{
            System.out.println("Sorry, but we don't have enough quantity to complete your order!");
        }
    }

    private void removeMineralWaterAndBottle(MineralWater mineralWater){
        this.bottles.remove(mineralWater.getBottle());
        this.mineralWaters.remove(mineralWater);
    }

    private static void writeInvoice(String outputFilename, Invoice invoice) {
        FileWriter fout = null;
        try {
            fout = new FileWriter(new File(outputFilename), true);
            if (invoice != null) {
                fout.append(invoice.toString() + System.lineSeparator());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found " + e);
        } catch (IOException e) {
            System.out.println("IOException " + e);
        } finally {
            try {
                if (fout != null) {
                    fout.close();
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

    public List<String> readInvoicesFromFile(String inputFilename) {
        List<String> listOfInvoices = new ArrayList<>();
        try (FileReader fis = new FileReader(new File(inputFilename))) {
            BufferedReader bufferedReader = new BufferedReader(fis);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                listOfInvoices.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfInvoices;
    }

    private static void serializeBottle(String fileBottle, Bottle bottle) {
        try (FileOutputStream fos = new FileOutputStream(fileBottle);
             ObjectOutputStream outputStream = new ObjectOutputStream(fos);) {
            outputStream.writeObject(bottle);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Bottle deserializeBottle(String filePath) {
        Bottle bottle = null;
        try (FileInputStream fis = new FileInputStream(filePath);
             ObjectInputStream inputStream = new ObjectInputStream(fis);) {

            bottle = (Bottle) inputStream.readObject();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bottle;
    }

    @Override
    public String toString() {
        return "Factory{" +
                "mineralWaters=" + this.mineralWaters +
                ", bottles=" + this.bottles +
                ", deliveryMen=" + this.deliveryMen +
                ", invoices=" + this.invoices +
                '}';
    }
}

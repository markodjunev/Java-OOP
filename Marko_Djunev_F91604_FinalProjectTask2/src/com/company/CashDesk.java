package com.company;

import javax.print.DocFlavor;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class CashDesk {
    private Shop shop;
    private Cashier cashier;
    private List<Receipt> receipts;
    private List<OrderProduct> orderProducts;
    private String receiptFileName = " ";

    public CashDesk(Shop shop, Cashier cashier){
        this.shop = shop;
        this.cashier = cashier;
        this.receipts = new ArrayList<>();
        this.orderProducts = new ArrayList<>();
    }

    public synchronized void addProduct(Goods goods, int quantity) throws InsufficientQuantityException {
       if (this.shop.containsGoods(goods)){
           if (quantity <= 0){
               System.out.println("The quantity must be a positive number!");
               return;
           }
           else if (goods.getQuantity() - quantity >= 0){
               var orderProduct = new OrderProduct(goods, quantity);
               this.orderProducts.add(orderProduct);
               goods.decreaseQuantity(quantity);
           }

           else{
               throw new InsufficientQuantityException(goods, quantity);
           }
       }

       else{
           System.out.println("The product is not offered in the shop!");
       }
    }

    public void changeCashier(Cashier newCashier){
        if (this.shop.isCashierWorking(newCashier) == true){
            this.cashier = newCashier;
            return;
        }

        System.out.println("Sorry but the new cashier isn't working in the shop!");
    }

    public int getReceiptsCount(){

        return this.receipts.size();
    }

    public double getSumByReceipts(){
        double sum = 0;
        for (Receipt receipt:this.receipts) {
            sum += receipt.getSum();
        }

        return sum;
    }

    public synchronized void finalizeReceipt(){

        var activeProducts = new ArrayList<OrderProduct>();

        for (OrderProduct orderProduct:this.orderProducts) {
            activeProducts.add(orderProduct);
        }

        if (activeProducts.size() == 0){
            System.out.println("There are no ordered products in the cart! Please add products.");
            return;
        }

        var receipt = new Receipt(cashier);
        receipt.setProducts(activeProducts);
        this.receipts.add(receipt);
        this.receiptFileName = "Receipt" + receipt.getSerialNumber() + ".txt";
        writeReceipt(receiptFileName, receipt);
        this.orderProducts.clear();
    }

    private static void writeReceipt(String outputFilename, Receipt receipt) {
        FileWriter fout = null;
        try {
            fout = new FileWriter(new File(outputFilename), true);
            if (receipt != null) {
                fout.append(receipt.toString() + System.lineSeparator());
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

    @Override
    public String toString() {
        return "CashDesk{" +
                "cashier=" + this.cashier +
                ",receipts=" + this.receipts + '\n' +
                '}';
    }
}

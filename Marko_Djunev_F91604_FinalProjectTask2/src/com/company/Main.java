package com.company;

public class Main {

    public static void main(String[] args) {
        var cashier1 = new Cashier("Ivan");
        var cashier2 = new Cashier("Pesho");
        var cashier3 = new Cashier("Gosho");

        var shop = new Shop();
        shop.addCashier(cashier1);
        shop.addCashier(cashier2);
        shop.addCashier(cashier3);

        var product1 = new Goods("Fanta", 1.2, 10, 2);
        var product2 = new Goods("Sobranie Gold", 6.5, 5, 2);
        var product3 = new Goods("Water", 0.8, 15, 2);
        var product4 = new Goods("Chips", 1.9, 20, 2);
        var product5 = new Goods("Chocolate Bar", 3, 6, 2);

        shop.addGoods(product1);
        shop.addGoods(product2);
        shop.addGoods(product3);
        shop.addGoods(product4);
        //shop.addGoods(product5);

        var cashDesk = new CashDesk(shop, cashier1);
        shop.addCashDesk(cashDesk);
        cashDesk.addProduct(product2, 2);
        cashDesk.addProduct(product1, 1);
        cashDesk.finalizeReceipt();
        cashDesk.addProduct(product3, 2);
        cashDesk.finalizeReceipt();
        cashDesk.addProduct(product4, 2);
        cashDesk.finalizeReceipt();
        
        System.out.println(shop.toString());
    }
}

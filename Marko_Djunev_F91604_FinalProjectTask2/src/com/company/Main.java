package com.company;

public class Main {

    public static void main(String[] args) throws InsufficientQuantityException, InterruptedException {
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
        var cashDesk2 = new CashDesk(shop, cashier2);

        shop.addCashDesk(cashDesk);
        shop.addCashDesk(cashDesk2);
        
        var th1 = new Thread(new ProductSelling(cashDesk, product2, 2));
        var th2 = new Thread(new ProductSelling(cashDesk, product1, 1));
        th1.start();
        th2.start();

        Thread.sleep(300);

        var f = new Thread(new FinalizeOrder(cashDesk));
        f.start();


        Thread.sleep(300);

        th1 = new Thread(new ProductSelling(cashDesk, product3, 2));
        th1.start();

        Thread.sleep(300);

        f = new Thread(new FinalizeOrder(cashDesk));
        f.start();

        Thread.sleep(300);

        th1 = new Thread(new ProductSelling(cashDesk2, product4, 10));
        th2 = new Thread(new ProductSelling(cashDesk, product1, 1));
        th1.start();
        th2.start();

        Thread.sleep(300);

        var f2 = new Thread(new FinalizeOrder(cashDesk2));
        f = new Thread(new FinalizeOrder(cashDesk));
        f2.start();
        f.start();

        Thread.sleep(300);

        /*cashDesk2.addProduct(product1, 2);
        cashDesk.addProduct(product2, 2);
        cashDesk.addProduct(product1, 1);
        cashDesk.finalizeReceipt();
        cashDesk.addProduct(product3, 2);
        cashDesk.finalizeReceipt();
        cashDesk.addProduct(product4, 2);
        cashDesk.finalizeReceipt();*/
        //cashDesk.addProduct(product5, 1); error because product5 is not offered in the shop
        //cashDesk.finalizeReceipt(); error because there are no ordered products
        //cashDesk.addProduct(product2, 4); //throws InsufficientQuantityException because product3 has 3 counts

        //cashDesk.changeCashier(cashier2); // when the shift is over we can replace the cashier
        //cashDesk.addProduct(product1, 1);
        //cashDesk.finalizeReceipt();

        System.out.println(shop.toString());

        System.out.println(shop.getReceiptsCount());
    }
}

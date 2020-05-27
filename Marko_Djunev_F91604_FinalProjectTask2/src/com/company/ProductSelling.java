package com.company;

public class ProductSelling implements Runnable {
    private CashDesk cashDesk;
    private Goods goods;
    private int quantity;

    public ProductSelling(CashDesk cashDesk, Goods goods, int quantity){
        this.cashDesk = cashDesk;
        this.goods = goods;
        this.quantity = quantity;
    }

    public void ready(){
        this.cashDesk.finalizeReceipt();
    }

    @Override
    public void run() {
        try {
            this.cashDesk.addProduct(this.goods, this.quantity);
        } catch (InsufficientQuantityException e) {
            e.printStackTrace();
        }
    }
}

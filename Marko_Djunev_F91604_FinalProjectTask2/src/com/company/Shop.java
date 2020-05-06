package com.company;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<Cashier> cashiers;
    private List<Goods> goods;
    private double turnover;
    private List<CashDesk> cashDesks;

    public Shop(){
        this.goods = new ArrayList<>();
        this.cashiers = new ArrayList<>();
        this.cashDesks = new ArrayList<>();
    }

    public void addCashier(Cashier cashier){
        this.cashiers.add(cashier);
    }

    public void addCashDesk(CashDesk cashDesk){
        this.cashDesks.add(cashDesk);
    }

    public void addGoods(Goods goods){
        this.goods.add(goods);
    }

    public boolean containsGoods(Goods goods1){
        for (Goods product:this.goods) {
            if (product == goods1){
                return true;
            }
        }

        return false;
    }

    public int receiptsCount(){
        int count = 0;

        for (CashDesk cashDesk:this.cashDesks) {
            count += cashDesk.getReceiptsCount();
        }

        return count;
    }

    public double getTurnover() {
        double sum = 0;
        for (CashDesk cashDesk:this.cashDesks) {
            sum += cashDesk.getSumByReceipts();
        }

        this.turnover = sum;
        return Math.round(this.turnover * 100.0) / 100.0;
    }


    @Override
    public String toString() {
        return "Shop{" +
                "cashiers=" + cashiers +
                ", goods=" + goods +
                ", turnover=" + this.getTurnover() +
                ", cashDesks=" + cashDesks +
                '}';
    }
}

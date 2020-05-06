package com.company;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class CashDesk {
    private Shop shop;
    private Cashier cashier;
    private List<Receipt> receipts;
    private List<OrderProduct> orderProducts;

    public CashDesk(Shop shop, Cashier cashier){
        this.shop = shop;
        this.cashier = cashier;
        this.receipts = new ArrayList<Receipt>();
        this.orderProducts = new ArrayList<OrderProduct>();
    }

    public void addProduct(Goods goods, int quantity){
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
               System.out.println("The product in out of stock in the shop!");
               return;
           }
       }

       else{
           System.out.println("The product is not offered in the shop!");
       }
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

    public void finalizeReceipt(){

        var activeProducts = new ArrayList<OrderProduct>();

        for (OrderProduct orderProduct:this.orderProducts) {
            if (orderProduct.getStatus() == OrderProductStatus.Active){
                activeProducts.add(orderProduct);
                orderProduct.setCompletedStatus();
            }
        }

        if (activeProducts.size() == 0){
            System.out.println("There are no ordered products in the cart! Please add products.");
            return;
        }

        var receipt = new Receipt(cashier);
        receipt.setProducts(activeProducts);
        this.receipts.add(receipt);
        this.orderProducts.clear();
    }

    @Override
    public String toString() {
        return "CashDesk{" +
                "cashier=" + cashier +
                ",receipts=" + receipts + '\n' +
                '}';
    }
}

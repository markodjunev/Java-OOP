package com.company;

public class FinalizeOrder implements Runnable {
    private CashDesk cashDesk;

    public FinalizeOrder(CashDesk cashDesk){
        this.cashDesk = cashDesk;
    }

    @Override
    public void run() {
        this.cashDesk.finalizeReceipt();
    }
}

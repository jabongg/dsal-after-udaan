package com.java.projects.carrentalsystem;

public class Payment {
    boolean isBillPaid;

    public double payBill(Bill bill) {
        // do payment processing and update the bill status
       double amount =  bill.calculateBillAmount();
       isBillPaid = true;
       return amount;
    }
}

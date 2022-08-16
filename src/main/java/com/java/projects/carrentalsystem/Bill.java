package com.java.projects.carrentalsystem;

public class Bill {

    Reservation reservation;
    double totalBillAmount;

    public Bill(Reservation reservation) {
        this.reservation = reservation;
    }

    public double calculateBillAmount() {
        return 100d; // hardcoding for now.
    }
}

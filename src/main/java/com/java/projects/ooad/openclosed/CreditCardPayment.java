package com.java.projects.ooad.openclosed;

public class CreditCardPayment implements Payment {
    public void acceptPayment() {
        System.out.println("paid through credit card");
    }
}

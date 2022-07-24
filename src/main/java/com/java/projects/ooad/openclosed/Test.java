package com.java.projects.ooad.openclosed;

public class Test {

    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();
        processor.processPayment(new GiftCardPayment());
    }
}

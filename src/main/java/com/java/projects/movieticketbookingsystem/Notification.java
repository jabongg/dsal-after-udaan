package com.java.projects.movieticketbookingsystem;

public class Notification {
    public void sendBookingNotification(Ticket ticket) {
        System.out.println("you booked below ticket : " + ticket);
    }

    public void sendCancellationNotification(Ticket ticket) {
        System.out.println("you cancelled below ticket : " + ticket);
    }
}

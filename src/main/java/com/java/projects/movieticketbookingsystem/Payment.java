package com.java.projects.movieticketbookingsystem;

public class Payment {
    public void payBill(Ticket ticket) {
        System.out.println("Ticket Bill paid ₹" + ticket.ticketAmount); // we can pass the ticket here and get the amount from the ticket itself
    }  // while booking

    public void returnBill(){} // after cancellation
}

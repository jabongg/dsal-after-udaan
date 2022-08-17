package com.java.projects.movieticketbookingsystem;

import java.util.Date;

public class Ticket {
    User user;
    Movie movie;
    Date bookingDate;
    double ticketAmount;
    CinemaHall cinemaHall;
    boolean isCancelled;


    public Ticket bookTicket(User user, Movie movie, CinemaHall cinemaHall, Date bookingDate) {
       Ticket ticket = new Ticket(); // dependency injection here can be done for large industry level product/project
        ticket.user = user;
        ticket.movie = movie;
        ticket.bookingDate = bookingDate;
        ticket.cinemaHall = cinemaHall;
        ticket.ticketAmount = 100; // hardcoding for now assuming all seats (platinum, gold, silver) have same amount;
        return ticket;
    }


    public Ticket cancelTicket(Ticket ticket) {
        System.out.println("you are cancelling your ticket");
        Ticket cancelledTicket = new Ticket();
        isCancelled = true;

        System.out.println("your ticket is cancelled");
        // return payment
        return ticket;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "user=" + user +
                ", movie=" + movie +
                ", bookingDate=" + bookingDate +
                ", ticketAmount=" + ticketAmount +
                ", cinemaHall=" + cinemaHall +
                ", isCancelled=" + isCancelled +
                '}';
    }
}

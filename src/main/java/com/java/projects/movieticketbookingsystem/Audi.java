package com.java.projects.movieticketbookingsystem;


import java.util.List;
import java.util.Map;

public class Audi {
    int seatCapacity;
    int availableSeats;
    int bookedSeats;
    Movie movie;
    List<Seat> seats;
    // we can have a map of row and seats. Map<Character, List<Seats> like J, K, L then seat number 30, 40 41;
    Map<Character, List<Seat>> seatLabelMapping;

    // getters and setters
}

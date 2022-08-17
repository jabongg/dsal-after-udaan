package com.java.projects.movieticketbookingsystem;

import java.util.List;

public class CinemaHall {
    // we can have cinemaHall type enum like Mulitiplex or single Screen.
    String name;
    City city; // we can have location also Location lat,lng for exact location.
    List<Audi> audies; // for auditoriums in case of a multiplex.

    List<Movie> currentRunningMovies;  // movies whose poster will be out of the cinema i.e. cinema poster.


    @Override
    public String toString() {
        return "CinemaHall{" +
                "name='" + name + '\'' +
                ", city=" + city +
                ", audies=" + audies +
                ", currentRunningMovies=" + currentRunningMovies +
                '}';
    }
}

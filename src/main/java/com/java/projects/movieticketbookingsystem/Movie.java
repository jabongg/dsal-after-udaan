package com.java.projects.movieticketbookingsystem;

public class Movie {
    String movieName;
    MovieDetails description;

    @Override
    public String toString() {
        return "Movie{" +
                "movieName='" + movieName + '\'' +
                ", description=" + description +
                '}';
    }
}

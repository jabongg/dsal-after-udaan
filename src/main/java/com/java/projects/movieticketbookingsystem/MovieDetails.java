package com.java.projects.movieticketbookingsystem;

import java.util.Date;
import java.util.List;

public class MovieDetails {
    // these all will be private in the real production code with getters and setters.
    String description;  // like what is the story of the movie
    List<String> cast; // lead actors
    Date releaseDate;
    Genre genre; // we can make it to the list of Genre, one movie can be of more than 1 genre.
    String director;
    String producer;

    @Override
    public String toString() {
        return "MovieDetails{" +
                "description='" + description + '\'' +
                ", cast=" + cast +
                ", releaseDate=" + releaseDate +
                ", genre=" + genre +
                ", director='" + director + '\'' +
                ", producer='" + producer + '\'' +
                '}';
    }
}

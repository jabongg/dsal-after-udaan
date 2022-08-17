package com.java.projects.movieticketbookingsystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TicketBookingSystemDriver {
    //main
    public static void main(String[] args) {

        User user = new User();
        user.setName("Jang");
        user.setEmail("jbpvns@gmail.com");
        System.out.println("user is : " + user);

        // movies list
        Movie movie1 = new Movie();
        movie1.movieName = "Kartikey 2";

        MovieDetails movieDetails = new MovieDetails();
        movieDetails.description = "A sequel to mystic thriller Karthikeya, which deals with the personal problems of Karthik and how he comes out of them. His pursuit of the truth leads him to find out the power of Indian ancient system and Tatva of Lord Sri Krishna.";
        movieDetails.genre = Genre.ACTION;
        movieDetails.releaseDate = new Date(2022, 7, 13); // for now using it. will be replace with date and time api of java8.

        // cast
        List<String> cast = new ArrayList<>();
        cast.add("Nikhil Siddharth ");
        cast.add("Anupama Parameswaran ");
        cast.add("Anupam Kher ");

        movieDetails.cast = cast;
        movieDetails.director = "Chandoo Mondeti ";
        movieDetails.producer = "Abhishek Agarwal ";

        // crew
        movie1.description = movieDetails;
        System.out.println("movie is : " + movie1);

        Movie movie2 = new Movie();
        movie2.movieName = "Lal Singh Chaddha";

        Movie movie3 = new Movie();
        movie3.movieName = "Raksha Bandhan";


        // book Ticket
        //choose city, then cinema hall, then auditorium
        Ticket ticket = new Ticket();
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.city = City.BANGLURU;
        cinemaHall.name = "PVR CINEMAS";
        List<Movie> currentRunningMovies = new ArrayList<>();
        currentRunningMovies.add(movie1);
        currentRunningMovies.add(movie2);
        currentRunningMovies.add(movie3);
        cinemaHall.currentRunningMovies = currentRunningMovies;
        //ticket.ticketAmount = 100; // hardcoding for now
        ticket = ticket.bookTicket(user, movie1, cinemaHall, new Date()); // today's booking
        System.out.println("ticket description :" + ticket);

        // make payment
        Payment payment = new Payment();
        payment.payBill(ticket);

        // send notification to email or contact number : this can be done using SNS system and email sender
        Notification notification = new Notification();
        notification.sendBookingNotification(ticket);

        ticket.cancelTicket(ticket);
        notification.sendCancellationNotification(ticket);
    }
}

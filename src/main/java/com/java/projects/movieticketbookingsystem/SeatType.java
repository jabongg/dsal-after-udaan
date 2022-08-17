package com.java.projects.movieticketbookingsystem;

public enum SeatType {
    PLATINUM(700), GOLD(500), SILVER(300), GENERAL(200);


    int price;

    SeatType(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

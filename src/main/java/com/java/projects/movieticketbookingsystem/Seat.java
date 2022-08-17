package com.java.projects.movieticketbookingsystem;

public class Seat {
    private boolean isAvailable;  // is par poora khel thread ka shuru hoga.
    private SeatType seatType;
    private SeatPosition seatPosition;

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public SeatPosition getSeatPosition() {
        return seatPosition;
    }

    public void setSeatPosition(SeatPosition seatPosition) {
        this.seatPosition = seatPosition;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "isAvailable=" + isAvailable +
                ", seatType=" + seatType +
                ", seatPosition=" + seatPosition +
                '}';
    }
}

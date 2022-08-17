package com.java.projects.movieticketbookingsystem;

public class SeatPosition {
    char seatRow;
    int seatNumber;

    public SeatPosition() {
    }

    public SeatPosition(char seatRow, int seatNumber) {
        this.seatRow = seatRow;
        this.seatNumber = seatNumber;
    }

    public char getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(char seatRow) {
        this.seatRow = seatRow;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    @Override
    public String toString() {
        return "SeatPosition{" +
                "seatRow=" + seatRow +
                ", seatNumber=" + seatNumber +
                '}';
    }
}

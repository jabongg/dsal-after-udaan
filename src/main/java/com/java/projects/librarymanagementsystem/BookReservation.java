package com.java.projects.librarymanagementsystem;

import java.util.Date;

public class BookReservation {
    private Date creationDate;
    private ReservationStatus status;
    private String bookItemBarcode;
    private String memberId;

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    public String getBookItemBarcode() {
        return bookItemBarcode;
    }

    public void setBookItemBarcode(String bookItemBarcode) {
        this.bookItemBarcode = bookItemBarcode;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public static BookReservation fetchReservationDetails(String barcode) {
        return null;
    }

    public void sendBookAvailableNotification() {
    }

    public void updateStatus(ReservationStatus completed) {
    }
}

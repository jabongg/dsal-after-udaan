package com.java.projects.carrentalsystem;

import com.java.projects.librarymanagementsystem.ReservationStatus;

import java.util.Date;

public class Reservation {
    int reservationId;
    User user;
    Vehicle vehicle;
    Date dateBookedFrom;
    Date dateBookedTo;
    Long fromTimestamp;
    Long toTimestamp;
    Location pickupLocation;
    Location dropLocation;

    ReservationType reservationType;
    ReservationStatus reservationStatus;

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Date getDateBookedFrom() {
        return dateBookedFrom;
    }

    public void setDateBookedFrom(Date dateBookedFrom) {
        this.dateBookedFrom = dateBookedFrom;
    }

    public Date getDateBookedTo() {
        return dateBookedTo;
    }

    public void setDateBookedTo(Date dateBookedTo) {
        this.dateBookedTo = dateBookedTo;
    }

    public Long getFromTimestamp() {
        return fromTimestamp;
    }

    public void setFromTimestamp(Long fromTimestamp) {
        this.fromTimestamp = fromTimestamp;
    }

    public Long getToTimestamp() {
        return toTimestamp;
    }

    public void setToTimestamp(Long toTimestamp) {
        this.toTimestamp = toTimestamp;
    }

    public Location getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(Location pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public Location getDropLocation() {
        return dropLocation;
    }

    public void setDropLocation(Location dropLocation) {
        this.dropLocation = dropLocation;
    }

    public ReservationType getReservationType() {
        return reservationType;
    }

    public void setReservationType(ReservationType reservationType) {
        this.reservationType = reservationType;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }
}

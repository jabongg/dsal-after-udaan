package com.java.projects.carrentalsystem;

import java.util.ArrayList;
import java.util.List;

public class Store {
    int storeId; // these fields should be private. and should be accessed through the setter/getter methods, but i'm directly using these fields.
    VehicleInventoryManagement vehicleInventoryManagement;
    Location storeLocation;
    List<Reservation> reservations = new ArrayList<>();


    public List<Vehicle> getVehicles(VehicleType vehicleType) {

        // checking for the vehicleType
        if (vehicleType.name().equals("CAR") && Status.AVAILABLE.name() == "AVAILABLE") {
            return vehicleInventoryManagement.getVehicles();
        }
        // else return default vehicles, which will contain all type of vehicles say bike, scootty, racingBikes, vans etc.
        return vehicleInventoryManagement.getVehicles();

    } // add, update, delete can also be created for handling operations.

    public void setVehicles(List<Vehicle> vehicles) {
        vehicleInventoryManagement = new VehicleInventoryManagement(vehicles);
    }

    public boolean completeReservation(int reservationId) {

        // take the reservation from the list and call the method completeReservation
        return true;
    }

    public Reservation createReservation(Vehicle vehicle, User user) {
        Reservation reservation = new Reservation();
        reservation.setVehicle(vehicle);
        reservation.setUser(user);
        return reservation;
    }
}

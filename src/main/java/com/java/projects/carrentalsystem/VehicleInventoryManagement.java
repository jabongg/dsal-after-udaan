package com.java.projects.carrentalsystem;

import java.util.List;

public class VehicleInventoryManagement {

    List<Vehicle> vehicles;
    public VehicleInventoryManagement(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public List<Vehicle> getVehicles() {
        return this.vehicles;
    }


}

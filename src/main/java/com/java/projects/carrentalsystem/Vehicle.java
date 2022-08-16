package com.java.projects.carrentalsystem;

public class Vehicle {
    int vehicleId;
    String vehiclePlateNumber;
    VehicleType vehicleType;
    Status status;
    int dailyRentalCost = 100;// hardcode for now

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehiclePlateNumber() {
        return vehiclePlateNumber;
    }

    public void setVehiclePlateNumber(String vehiclePlateNumber) {
        this.vehiclePlateNumber = vehiclePlateNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getDailyRentalCost() {
        return dailyRentalCost;
    }

    public void setDailyRentalCost(int dailyRentalCost) {
        this.dailyRentalCost = dailyRentalCost;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId=" + vehicleId +
                ", vehiclePlateNumber='" + vehiclePlateNumber + '\'' +
                ", vehicleType=" + vehicleType +
                ", status=" + status +
                ", dailyRentalCost=" + dailyRentalCost +
                '}';
    }
}

package com.java.projects.carrentalsystem;

import java.util.ArrayList;
import java.util.List;

public class CarRentalSystemDriver {
    public static void main(String[] args) {
        List<User> users = addUsers();
        List<Vehicle> vehicles = addVehciles();
        List<Store> stores = addStores(vehicles);

        VehicleRentalSystem vehicleRentalSystem = new VehicleRentalSystem(stores, users);
        //1. user
        User user = users.get(0);
        System.out.println("user is : " + user);
        //2. search store based on the location // for now giving Gurgaon location phase 3
        Location location = new Location(28.493655290997985, 77.09261127216983);
        System.out.println("location has latitude: " + location.latitude + " and  longitude" + location.longitude);
        Store store = vehicleRentalSystem.getStore(location);

        //3. get all available vehicles as per your requirements
        List<Vehicle> storeVehicles = store.getVehicles(VehicleType.CAR);
        System.out.println("store vehicles : " + storeVehicles);
        //4. reserving the particular vehicle
        Reservation reservation = store.createReservation(vehicles.get(0), user);
        store.reservations.add(reservation);


        //5. Bill payment
        Bill bill = new Bill(reservation);

        //6.  make payment
        Payment payment = new Payment();
        double billAmount = payment.payBill(bill);
        System.out.println(billAmount);
        System.out.println("bill paid status : " + payment.isBillPaid);

        //6.return the vehicle after trip completion
        store.completeReservation(reservation.getReservationId());

        // review the service. we can have a review system... but we should keep things simple and stupid. so not adding any further scenarios.

    }

    private static List<Store> addStores(List<Vehicle> vehicles) {
        List<Store> stores = new ArrayList<>();
        Store store = new Store();
        store.storeId = 1;
        store.setVehicles(vehicles);
        stores.add(store);
        return stores;

    }

    private static List<Vehicle> addVehciles() {
        List<Vehicle> vehicles = new ArrayList<>();

        Vehicle vehicle1 = new Car();
        vehicle1.setVehicleId(1);
        vehicle1.setVehiclePlateNumber("UP65Y4669");
        vehicle1.setVehicleType(VehicleType.CAR);
        vehicle1.setStatus(Status.AVAILABLE);

        Vehicle vehicle2 = new Car();
        vehicle2.setVehicleId(2);
        vehicle2.setVehiclePlateNumber("HR38Y9328");
        vehicle2.setVehicleType(VehicleType.CAR);
        vehicle1.setStatus(Status.AVAILABLE);

        vehicles.add(vehicle1);
        vehicles.add(vehicle2);

        return vehicles;
    }

    private static List<User> addUsers() {
        List<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setUserName("ANURAG BREJA");
        user1.setUserId(1);
        user1.setDrivlingLicence("DL0420110149646");

        users.add(user1);
        return users;
    }

}

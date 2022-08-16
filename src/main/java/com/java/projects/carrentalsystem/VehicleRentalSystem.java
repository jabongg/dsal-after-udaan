package com.java.projects.carrentalsystem;

import java.util.List;

public class VehicleRentalSystem {
    List<User> users;
    List<Store> stores;

    public VehicleRentalSystem(List<Store> stores, List<User> users) {
        this.users = users;
        this.stores = stores;
    }

    public Store getStore(Location location) {

        // we can reverse geo code here for getting human readable address from latitude and longitude (using google locations api)
        return stores.get(0); // for now getting the first entry without any operation on location
    }
}

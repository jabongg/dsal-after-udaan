package com.java.projects.guitarinventory;

import java.util.*;

public class Inventory {
    private List<Instrument> inventory;

    public Inventory() {
        inventory = new LinkedList<>();
    }

    public void addInstrument(String serialNumber, double price, InstrumentSpec spec) {
        Instrument instrument = new Instrument(serialNumber, price, spec);
        inventory.add(instrument);
    }


    // to find on what basis serial number or which field of the guitar.
    public Instrument getInstrument(String serialNumber) {
        // iterate through the entire inventory and search for the particular guitar.
        for (Instrument currInstrument : inventory) {
            if (currInstrument.getSerialNumber().equals(serialNumber)) {
                return currInstrument;
            }
        }

        return null; // in case guitar is not found, returning null.
    }

    // to find on what basis serial number or which field of the guitar.
    public List<Instrument> search(InstrumentSpec searchSpec) {

        List<Instrument> matchingIGuitars = new ArrayList<>();
        for (Iterator i = inventory.iterator(); i.hasNext(); ) {
            Instrument guitar = (Instrument) i.next();
            // Ignore serial number since that’s unique
            // Ignore price since that’s unique
            if (guitar.getSpec().matches(searchSpec))
                matchingIGuitars.add(guitar);
        }
        return matchingIGuitars;
    }


    public void initializeInventory(Instrument instrument) {
        // add guitars to inventory
        inventory.add(instrument);
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "inventory=" + inventory +
                '}';
    }
}

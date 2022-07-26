package com.java.projects.guitarinventory;

import java.util.*;

public class Inventory {
    private List<Instrument> instruments;

    public Inventory() {
        instruments = new LinkedList<>();
    }

    public void addInstrument(String serialNumber, double price, InstrumentSpec spec) {
        Instrument instrument = null;
        if (spec instanceof GuitarSpec) {
            instrument = new Guitar(serialNumber, price, (GuitarSpec) spec);
        }

        if (spec instanceof MandolinSpec) {
            instrument = new Mandolin(serialNumber, price, (MandolinSpec) spec);
        }
    }

    public Instrument addInstrument(Instrument guitar) {
        instruments.add(guitar);
        return guitar;
    }


    // to find on what basis serial number or which field of the guitar.
    public Instrument getInstrument(String serialNumber) {
        // iterate through the entire inventory and search for the particular guitar.
        for (Instrument currInstrument : instruments) {
            if (currInstrument.getSerialNumber().equals(serialNumber)) {
                return currInstrument;
            }
        }

        return null; // in case guitar is not found, returning null.
    }

    // to find on what basis serial number or which field of the guitar.
    public List<Instrument> search(GuitarSpec searchSpec) {

        List<Instrument> matchingInstruments = new ArrayList<>();
        for (Iterator i = instruments.iterator(); i.hasNext(); ) {
            Instrument guitar = (Instrument) i.next();
            // Ignore serial number since that’s unique
            // Ignore price since that’s unique
            if (guitar.getSpec().matches(searchSpec))
                matchingInstruments.add(guitar);
        }
        return matchingInstruments;
    }

    // to find on what basis serial number or which field of the mandolin.
    public List<Instrument> search(MandolinSpec searchSpec) {
        List<Instrument> matchingInstruments = new ArrayList<>();
        for (Iterator i = instruments.iterator(); i.hasNext(); ) {
            Instrument guitar = (Instrument) i.next();
            // Ignore serial number since that’s unique
            // Ignore price since that’s unique
            if (guitar.getSpec().matches(searchSpec))
                matchingInstruments.add(guitar);
        }
        return matchingInstruments;
    }

    public void initializeInventory(Instrument instrument) {
        // add guitars to inventory
        instruments.add(instrument);
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "Instrument=" + instruments +
                '}';
    }
}

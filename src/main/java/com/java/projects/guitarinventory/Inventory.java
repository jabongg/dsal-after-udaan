package com.java.projects.guitarinventory;

import java.util.*;

public class Inventory {
    private List<Guitar> guitars;

    public Inventory() {
        guitars = new LinkedList<>();
    }

    public void addGuitar(String serialNumber, double price,
                          Builder builder, String model,
                          Type type, Wood backWood, Wood topWood, GuitarSpec spec) {
        Guitar guitar = new Guitar(serialNumber, price, builder,
                model, type, backWood, topWood, spec);

        guitars.add(guitar);
    }

    public Guitar addGuitar(Guitar guitar) {
        guitars.add(guitar);
        return guitar;
    }


    // to find on what basis serial number or which field of the guitar.
    public Guitar getGuitar(String serialNumber) {
        // iterate through the entire inventory and search for the particular guitar.
        for (Guitar currGuitar : guitars) {
            if (currGuitar.getSerialNumber().equals(serialNumber)) {
                return currGuitar;
            }
        }

        return null; // in case guitar is not found, returning null.
    }

    // to find on what basis serial number or which field of the guitar.
    public List<Guitar> search(GuitarSpec searchSpec) {

        List<Guitar> matchingGuitars = new ArrayList<>();
        for (Iterator i = guitars.iterator(); i.hasNext(); ) {
            Guitar guitar = (Guitar) i.next();
            // Ignore serial number since that’s unique
            // Ignore price since that’s unique
            GuitarSpec guitarSpec = guitar.getSpec();
            if (searchSpec.getNumStrings() != guitarSpec.getNumStrings())
                continue;
            if  (!searchSpec.getBuilder().equals(guitarSpec.getBuilder()))
                continue;
            String model = searchSpec.getModel().toLowerCase();
            if ((model != null) && (!model.equals("")) && (!model.equals(guitarSpec.getModel().toLowerCase())))
                continue;
            if (searchSpec.getType() != guitarSpec.getType())
                continue;
            if (searchSpec.getBackWood() != guitarSpec.getBackWood())
                continue;
            if (searchSpec.getTopWood() != guitarSpec.getTopWood())
                continue;

            matchingGuitars.add(guitar);
        }
        return matchingGuitars;
    }

    public void initializeInventory(Guitar guitar) {
        // add guitars to inventory
         guitars.add(guitar);
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "guitars=" + guitars +
                '}';
    }
}

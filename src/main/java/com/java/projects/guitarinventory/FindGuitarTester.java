package com.java.projects.guitarinventory;

import java.util.List;

public class FindGuitarTester {
    public static void main(String[] args) {
        //set up Rick's guitar inventory
        Inventory inventory = new Inventory();
        Instrument guitar1 = new Guitar("SNSTREL123406ALD", 4999, new GuitarSpec(Builder.FENDER, "Stratocastor",
                Type.ELECTRIC, Wood.ALDER, Wood.ALDER, 6));

        Instrument guitar2 = new Guitar("SNSTREL123407ALD", 4067, new GuitarSpec(Builder.COLLINGS, "Stratocastor",
                Type.ELECTRIC, Wood.ALDER, Wood.BRAZILIAN_ROSEWOOD, 6));

        Instrument mandolin1 = new Mandolin("SNSTREL123408ALD", 2999, new MandolinSpec(Builder.FENDER, "Stratocastor",
                Type.ACOUSTIC, Wood.ALDER, Wood.INDIAN_ROSEWOOD, Style.A));

        inventory.initializeInventory(guitar1);
        inventory.initializeInventory(guitar2);
        inventory.initializeInventory(mandolin1);

        inventory.addInstrument("V95693",
                1499.95, new GuitarSpec(Builder.FENDER, "Stratocastor",
                        Type.ACOUSTIC, Wood.INDIAN_ROSEWOOD, Wood.INDIAN_ROSEWOOD, 12));

        inventory.addInstrument("V9512",
                1549.95, new MandolinSpec(Builder.FENDER,
                        "Stratocastor", Type.ELECTRIC,
                        Wood.ALDER, Wood.ALDER, Style.F));


        System.out.println(inventory.toString());
        // erin's requirements
        MandolinSpec erinGuitarSpec = new MandolinSpec(Builder.FENDER, "Stratocastor",
                Type.ACOUSTIC, Wood.ALDER, Wood.INDIAN_ROSEWOOD, Style.A);



        //search for the matching guitars for the client/customer
        List<Instrument> matchingGuitars = inventory.search(erinGuitarSpec);

        if (matchingGuitars.size() == 0) {
            System.out.println("No instruments found.");
        }

        for (Instrument g : matchingGuitars) {
            if (g instanceof Guitar) {
                System.out.println("here's a matching Guitar = " + g.getSerialNumber());
                GuitarSpec spec = (GuitarSpec) g.getSpec();
                System.out.println(spec);

            } else if (g instanceof Mandolin) {
                System.out.println("here's a matching Mandolin = " + g.getSerialNumber());
                MandolinSpec spec = (MandolinSpec) g.getSpec();
                System.out.println(spec);

            }
        }

         //inventory.addGuitar(whatErinLikes); // enter guitar
    }
}

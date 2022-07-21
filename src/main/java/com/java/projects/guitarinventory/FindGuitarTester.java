package com.java.projects.guitarinventory;

import java.util.List;

public class FindGuitarTester {
    public static void main(String[] args) {
        //set up Rick's guitar inventory
        Inventory inventory = new Inventory();
        Guitar guitar1 = new Guitar("SNSTREL123406ALD", 4999, Builder.FENDER, "Stratocastor",
                Type.ELECTRIC, Wood.ALDER, Wood.ALDER, new GuitarSpec(Builder.FENDER, "Stratocastor",
                Type.ELECTRIC, Wood.ALDER, Wood.ALDER, 6));

        Guitar guitar2 = new Guitar("SNSTREL123407ALD", 4067, Builder.COLLINGS, "Stratocastor",
                Type.ELECTRIC, Wood.ALDER, Wood.BRAZILIAN_ROSEWOOD, new GuitarSpec(Builder.COLLINGS, "Stratocastor",
                Type.ELECTRIC, Wood.ALDER, Wood.BRAZILIAN_ROSEWOOD, 6));

        Guitar guitar3 = new Guitar("SNSTREL123408ALD", 2999, Builder.FENDER, "Stratocastor",
                Type.ACOUSTIC, Wood.ALDER, Wood.INDIAN_ROSEWOOD, new GuitarSpec(Builder.FENDER, "Stratocastor",
                Type.ACOUSTIC, Wood.ALDER, Wood.INDIAN_ROSEWOOD, 12));

        inventory.initializeInventory(guitar1);
        inventory.initializeInventory(guitar2);
        inventory.initializeInventory(guitar3);

        inventory.addGuitar("V95693",
                1499.95, Builder.FENDER, "Stratocastor",
                Type.ACOUSTIC, Wood.INDIAN_ROSEWOOD, Wood.INDIAN_ROSEWOOD, new GuitarSpec(Builder.FENDER, "Stratocastor",
                        Type.ACOUSTIC, Wood.INDIAN_ROSEWOOD, Wood.INDIAN_ROSEWOOD, 12));

        inventory.addGuitar("V9512",
                1549.95, Builder.FENDER,
                "Stratocastor", Type.ELECTRIC,
                Wood.ALDER, Wood.ALDER, new GuitarSpec(Builder.FENDER,
                        "Stratocastor", Type.ELECTRIC,
                        Wood.ALDER, Wood.ALDER, 4));


        System.out.println(inventory.toString());
        // erin's requirements
        GuitarSpec erinGuitarSpec = new GuitarSpec(Builder.FENDER, "Stratocastor",
                Type.ACOUSTIC, Wood.ALDER, Wood.INDIAN_ROSEWOOD, 12);



        //search for the matching guitars for the client/customer
        List<Guitar> matchingGuitars = inventory.search(erinGuitarSpec);
        for (Guitar g : matchingGuitars) {
            GuitarSpec spec = g.getSpec();
            System.out.println(spec);
            if (g != null) {
                System.out.println("here's your guitar = " + g);
            } else {
                System.out.println("We are sorry that we don't have the model which you are looking for.");
            }
        }

         //inventory.addGuitar(whatErinLikes); // enter guitar
    }
}

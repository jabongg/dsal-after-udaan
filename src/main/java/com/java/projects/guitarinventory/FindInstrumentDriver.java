package com.java.projects.guitarinventory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindInstrumentDriver {
    public static void main(String[] args) {
        //set up Rick's guitar inventory
        Inventory inventory = new Inventory();

        Map<String, String> properties1 = new HashMap<>();
        properties1.put("style", Style.A.toString());
        properties1.put("wood", Wood.ALDER.toString());
        properties1.put("type", Type.ELECTRIC.toString());


        Map<String, String> properties2 = new HashMap<>();
        properties2.put("style", Style.A.toString());
        properties2.put("wood", Wood.INDIAN_ROSEWOOD.toString());
        properties2.put("type", Type.ELECTRIC.toString());

        Map<String, String> properties3 = new HashMap<>();
        properties3.put("style", Style.F.toString());
        properties3.put("wood", Wood.ALDER.toString());
        properties3.put("type", Type.ACOUSTIC.toString());



        InstrumentSpec instrumentSpec1 = new InstrumentSpec(properties1);
        InstrumentSpec instrumentSpec2 = new InstrumentSpec(properties2);
        InstrumentSpec instrumentSpec3 = new InstrumentSpec(properties3);

        Instrument instrument1 = new Instrument("SNSTREL123406ALD", 4999, instrumentSpec1);
        Instrument instrument2 = new Instrument("SNSTREL123407ALD", 6999, instrumentSpec2);
        Instrument instrument3 = new Instrument("SNSTREL123408ALD", 9999, instrumentSpec3);

        inventory.initializeInventory(instrument1);
        inventory.initializeInventory(instrument2);
        inventory.initializeInventory(instrument3);

        System.out.println(inventory.toString());

        //search for the matching guitars for the client/customer
        List<Instrument> matchingGuitars = inventory.search(instrumentSpec2);

        if (matchingGuitars.size() == 0) {
            System.out.println("No instruments found.");
        }

        for (Instrument g : matchingGuitars) {
            System.out.println(g.getSerialNumber() + " " + g.getPrice() + " " + g.getSpec());
        }

         //inventory.addGuitar(whatErinLikes); // enter guitar
    }
}

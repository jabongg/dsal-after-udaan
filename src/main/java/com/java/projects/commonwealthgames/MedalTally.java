package com.java.projects.commonwealthgames;

import java.util.*;

// This is the driver class to show the tally / ranking on the basis of Gold, then silver then bronze.
public class MedalTally {

    private static HashMap<CountryType, Country> countryMedalMap;

    public static void main(String[] args) {

        // creating medals list of 5 countries as of now.
        //India
        List<Medal> indiaMedals = new ArrayList<>();
        Medal indiaGold = new Medal(MedalType.GOLD, 9);
        Medal indiaSilver = new Medal(MedalType.SILVER, 8);
        Medal indiaBronze = new Medal(MedalType.BRONZE, 10);
        indiaMedals.add(indiaGold);
        indiaMedals.add(indiaSilver);
        indiaMedals.add(indiaBronze);
        Country india = new Country(CountryType.INDIA,  indiaMedals);

        // Australia
        List<Medal> australiaMedals = new ArrayList<>();
        Medal australiaGold = new Medal(MedalType.GOLD, 50);
        Medal australiaSilver = new Medal(MedalType.SILVER, 44);
        Medal australiaBronze = new Medal(MedalType.BRONZE, 46);
        australiaMedals.add(australiaGold);
        australiaMedals.add(australiaSilver);
        australiaMedals.add(australiaBronze);
        Country australia = new Country(CountryType.AUSTRALIA,  australiaMedals);

        // England
        List<Medal> englandMedals = new ArrayList<>();
        Medal englandGold = new Medal(MedalType.GOLD, 47);
        Medal englandSilver = new Medal(MedalType.SILVER, 46);
        Medal englandBronze = new Medal(MedalType.BRONZE, 38);
        englandMedals.add(englandGold);
        englandMedals.add(englandSilver);
        englandMedals.add(englandBronze);
        Country england = new Country(CountryType.ENGLAND,  englandMedals);

        // Canada
        List<Medal> canadaMedals = new ArrayList<>();
        Medal canadaGold = new Medal(MedalType.GOLD, 19);
        Medal canadaSilver = new Medal(MedalType.SILVER, 24);
        Medal canadaBronze = new Medal(MedalType.BRONZE, 24);
        canadaMedals.add(canadaGold);
        canadaMedals.add(canadaSilver);
        canadaMedals.add(canadaBronze);
        Country canada = new Country(CountryType.CANADA,  canadaMedals);

        // Jamaica
        List<Medal> jamaicaMedals = new ArrayList<>();
        Medal jamaicaGold = new Medal(MedalType.GOLD, 3);
        Medal jamaicaSilver = new Medal(MedalType.SILVER, 2);
        Medal jamaicaBronze = new Medal(MedalType.BRONZE, 1);
        jamaicaMedals.add(jamaicaGold);
        jamaicaMedals.add(jamaicaSilver);
        jamaicaMedals.add(jamaicaBronze);
        Country jamaica = new Country(CountryType.JAMAICA,  jamaicaMedals);


        // now creating country medal map
        countryMedalMap = new HashMap<>();
        countryMedalMap.put(CountryType.AUSTRALIA, australia);
        countryMedalMap.put(CountryType.INDIA, india);
        countryMedalMap.put(CountryType.JAMAICA, jamaica);
        countryMedalMap.put(CountryType.ENGLAND, england);
        countryMedalMap.put(CountryType.CANADA, canada);

        System.out.println(countryMedalMap);


        System.out.println(new Country().getTotalMedals(india, countryMedalMap));
        System.out.println(new Country().getTotalMedals(australia, countryMedalMap));
        System.out.println(new Country().getTotalMedals(england, countryMedalMap));
        System.out.println(new Country().getTotalMedals(canada, countryMedalMap));
        System.out.println(new Country().getTotalMedals(jamaica, countryMedalMap));


        // get medal tally sorted on basis of Gold medals, then Silver medals and then Bronze
        Comparator<Medal> medalComparator = Comparator.comparing(Medal::getMedalType);//.thenComparing(Medal::getMedalCount);
        Collections.sort(indiaMedals, medalComparator);
        System.out.println(indiaMedals);
    }
}

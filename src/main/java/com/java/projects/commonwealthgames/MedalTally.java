package com.java.projects.commonwealthgames;

import java.util.*;
import java.util.stream.Collectors;

// This is the driver class to show the tally / ranking on the basis of Gold, then silver then bronze.
public class MedalTally {

    private static List<Country> countryMedalsList;

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
        india.setTotalMedals(india.getTotalMedals(india));

        // Australia
        List<Medal> australiaMedals = new ArrayList<>();
        Medal australiaGold = new Medal(MedalType.GOLD, 50);
        Medal australiaSilver = new Medal(MedalType.SILVER, 44);
        Medal australiaBronze = new Medal(MedalType.BRONZE, 46);
        australiaMedals.add(australiaGold);
        australiaMedals.add(australiaSilver);
        australiaMedals.add(australiaBronze);
        Country australia = new Country(CountryType.AUSTRALIA,  australiaMedals);
        australia.setTotalMedals(australia.getTotalMedals(australia));

        // England
        List<Medal> englandMedals = new ArrayList<>();
        Medal englandGold = new Medal(MedalType.GOLD, 47);
        Medal englandSilver = new Medal(MedalType.SILVER, 46);
        Medal englandBronze = new Medal(MedalType.BRONZE, 38);
        englandMedals.add(englandGold);
        englandMedals.add(englandSilver);
        englandMedals.add(englandBronze);
        Country england = new Country(CountryType.ENGLAND,  englandMedals);
        england.setTotalMedals(england.getTotalMedals(england));

        // Canada
        List<Medal> canadaMedals = new ArrayList<>();
        Medal canadaGold = new Medal(MedalType.GOLD, 19);
        Medal canadaSilver = new Medal(MedalType.SILVER, 24);
        Medal canadaBronze = new Medal(MedalType.BRONZE, 24);
        canadaMedals.add(canadaGold);
        canadaMedals.add(canadaSilver);
        canadaMedals.add(canadaBronze);
        Country canada = new Country(CountryType.CANADA,  canadaMedals);
        canada.setTotalMedals(canada.getTotalMedals(canada));

        // Jamaica
        List<Medal> jamaicaMedals = new ArrayList<>();
        Medal jamaicaGold = new Medal(MedalType.GOLD, 3);
        Medal jamaicaSilver = new Medal(MedalType.SILVER, 2);
        Medal jamaicaBronze = new Medal(MedalType.BRONZE, 1);
        jamaicaMedals.add(jamaicaGold);
        jamaicaMedals.add(jamaicaSilver);
        jamaicaMedals.add(jamaicaBronze);
        Country jamaica = new Country(CountryType.JAMAICA,  jamaicaMedals);
        jamaica.setTotalMedals(jamaica.getTotalMedals(jamaica));


        // now creating country medal map
        countryMedalsList = new ArrayList<>();
        countryMedalsList.add(australia);
        countryMedalsList.add(india);
        countryMedalsList.add(jamaica);
        countryMedalsList.add(england);
        countryMedalsList.add(canada);

        System.out.println(countryMedalsList);


        // get medal tally sorted on basis of Gold medals, then Silver medals and then Bronze
        for (Country country : countryMedalsList) {
            List<Medal> medals = country.getMedals();

            Comparator<Medal> medalComparator = Comparator.comparing(Medal::getMedalCount).reversed();//.thenComparing(Medal::getMedalCount);
            Collections.sort(medals, medalComparator);
            System.out.println(medals);
           // List list = country.getMedals().stream().filter(medal -> medal.getMedalType().name().equals("GOLD")).collect(Collectors.toList());
            //System.out.println(country);

            Comparator<Country> countryComparator = Comparator.comparing(Country::getCountryName);
        }
    }
}

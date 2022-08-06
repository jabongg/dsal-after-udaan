package com.java.projects.commonwealthgames;

import java.util.*;

// This is the driver class to show the tally / ranking on the basis of Gold, then silver then bronze.
public class MedalTally {

    private static List<Country> countryMedalsList;
    private static List<MedalTable> medalTables = new ArrayList<>();

    public static void main(String[] args) {

        // initialize the medals, country wise
        initialize();

        // get medal tally sorted on basis of Gold medals, then Silver medals and then Bronze
        createMedalTableUnsorted();

        // now using comparator on MedalTable to store prepare the final medal tally.
        createMedalTally();

        //decorating medal tally
        System.out.println("+------------------------------------------------------------+");
        System.out.println("+           COMMONWEALTH GAMES 2022 MEDALS TALLY             +");
        System.out.println("+------------------------------------------------------------+");
        System.out.println("+ country   |\t   gold  |\t silver  | \t bronze  | \t  total  +\t");
        System.out.println("+------------------------------------------------------------+");
        for (MedalTable medalTable : medalTables) {
            System.out.println("+ " + medalTable.getCountryName() + "\t\t\t" + medalTable.getGold() + "\t\t\t" + medalTable.getSilver() + "\t\t\t" + medalTable.getBronze() + "\t\t\t" + medalTable.getTotalMedals() + "\t +");
        }
        System.out.println("+------------------------------------------------------------+");


        //output :
        /*
                +------------------------------------------------------------+
                +           COMMONWEALTH GAMES 2022 MEDALS TALLY             +
                +------------------------------------------------------------+
                + country   |	   gold  |	 silver  | 	 bronze  | 	  total  +
                +------------------------------------------------------------+
                + AUSTRALIA			50			44			46			140	 +
                + ENGLAND			47			46			38			131	 +
                + CANADA			19			24			24			67	 +
                + INDIA			9			8			10			27	 +
                + INDONESIA			9			8			10			27	 +
                + NIGERIA			3			8			1			12	 +
                + JAMAICA			3			2			1			6	 +
                +------------------------------------------------------------+
         */
    }

    private static void createMedalTally() {
        Comparator<MedalTable> medalTableComparator = Comparator
                .comparing(MedalTable::getGold)
                .thenComparing(MedalTable::getSilver)
                .thenComparing(MedalTable::getBronze).reversed() //reverse in the end
                .thenComparing(MedalTable::getCountryName);

        Collections.sort(medalTables, medalTableComparator);

        // System.out.println(medalTables);
    }

    private static void createMedalTableUnsorted() {
        MedalTable medalTablesObj = new MedalTable();

        for (Country country : countryMedalsList) {
            List<Medal> medals = country.getMedals();

            for (Medal medal : medals) {
                switch (medal.getMedalType()) {
                    case GOLD:
                        medalTablesObj.setGold(medal.getMedalCount());
                        break;
                    case SILVER:
                        medalTablesObj.setSilver(medal.getMedalCount());
                        break;
                    case BRONZE:
                        medalTablesObj.setBronze(medal.getMedalCount());
                        break;
                    default:
                }
            }
            MedalTable medalTable = new MedalTable(country.getCountryName().name(), medalTablesObj.getGold(), medalTablesObj.getSilver(), medalTablesObj.getBronze(), country.getTotalMedals(country.getCountryName()));
            medalTables.add(medalTable);
        }

        //System.out.println(medalTables);
    }

    private static void initialize() {
        // creating medals list of 5 countries as of now.
        //India
        List<Medal> indiaMedals = new ArrayList<>();
        Medal indiaGold = new Medal(MedalType.GOLD, 9);
        Medal indiaSilver = new Medal(MedalType.SILVER, 8);
        Medal indiaBronze = new Medal(MedalType.BRONZE, 10);
        indiaMedals.add(indiaGold);
        indiaMedals.add(indiaSilver);
        indiaMedals.add(indiaBronze);
        Country india = new Country(CountryType.INDIA, indiaMedals);
        india.setTotalMedals(india.getTotalMedals(india));

        // Australia
        List<Medal> australiaMedals = new ArrayList<>();
        Medal australiaGold = new Medal(MedalType.GOLD, 50);
        Medal australiaSilver = new Medal(MedalType.SILVER, 44);
        Medal australiaBronze = new Medal(MedalType.BRONZE, 46);
        australiaMedals.add(australiaGold);
        australiaMedals.add(australiaSilver);
        australiaMedals.add(australiaBronze);
        Country australia = new Country(CountryType.AUSTRALIA, australiaMedals);
        australia.setTotalMedals(australia.getTotalMedals(australia));

        // England
        List<Medal> englandMedals = new ArrayList<>();
        Medal englandGold = new Medal(MedalType.GOLD, 47);
        Medal englandSilver = new Medal(MedalType.SILVER, 46);
        Medal englandBronze = new Medal(MedalType.BRONZE, 38);
        englandMedals.add(englandGold);
        englandMedals.add(englandSilver);
        englandMedals.add(englandBronze);
        Country england = new Country(CountryType.ENGLAND, englandMedals);
        england.setTotalMedals(england.getTotalMedals(england));

        // Canada
        List<Medal> canadaMedals = new ArrayList<>();
        Medal canadaGold = new Medal(MedalType.GOLD, 19);
        Medal canadaSilver = new Medal(MedalType.SILVER, 24);
        Medal canadaBronze = new Medal(MedalType.BRONZE, 24);
        canadaMedals.add(canadaGold);
        canadaMedals.add(canadaSilver);
        canadaMedals.add(canadaBronze);
        Country canada = new Country(CountryType.CANADA, canadaMedals);
        canada.setTotalMedals(canada.getTotalMedals(canada));

        // Jamaica
        List<Medal> jamaicaMedals = new ArrayList<>();
        Medal jamaicaGold = new Medal(MedalType.GOLD, 3);
        Medal jamaicaSilver = new Medal(MedalType.SILVER, 2);
        Medal jamaicaBronze = new Medal(MedalType.BRONZE, 1);
        jamaicaMedals.add(jamaicaGold);
        jamaicaMedals.add(jamaicaSilver);
        jamaicaMedals.add(jamaicaBronze);
        Country jamaica = new Country(CountryType.JAMAICA, jamaicaMedals);
        jamaica.setTotalMedals(jamaica.getTotalMedals(jamaica));

        // NIGERIA checking if gold count matches then, sorting on silver count or not.

        List<Medal> nigeriaMedals = new ArrayList<>();
        nigeriaMedals.add(jamaicaGold);
        nigeriaMedals.add(indiaSilver); //setting silver as  more than jamaica
        nigeriaMedals.add(jamaicaBronze);
        Country nigeria = new Country(CountryType.NIGERIA, nigeriaMedals);
        nigeria.setTotalMedals(nigeria.getTotalMedals(nigeria));


        // Indonesia... checking if every medals count matches, then sorting on the basis of country name or not. ascending order of country name.
        List<Medal> indonesiaMedals = new ArrayList<>();
        indonesiaMedals.add(indiaGold);
        indonesiaMedals.add(indiaSilver);
        indonesiaMedals.add(indiaBronze);
        Country indonesia = new Country(CountryType.INDONESIA, indonesiaMedals);
        indonesia.setTotalMedals(indonesia.getTotalMedals(indonesia));

        // now creating country medal map
        countryMedalsList = new ArrayList<>();
        countryMedalsList.add(australia);
        countryMedalsList.add(india);
        countryMedalsList.add(jamaica);
        countryMedalsList.add(england);
        countryMedalsList.add(canada);
        countryMedalsList.add(indonesia);
        countryMedalsList.add(nigeria);
        // System.out.println(countryMedalsList);
    }
}

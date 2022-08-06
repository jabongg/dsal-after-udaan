package com.java.projects.commonwealthgames;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Country {
    private CountryType countryName;
    private List<Medal> medals;
    private int totalMedals;
    private HashMap<CountryType, Integer> totalMedalsMap;

    public Country() {
    }

    public Country(CountryType countryName, List<Medal> medals) {
        this.countryName = countryName;
        this.medals = medals;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryName=" + countryName +
                ", medals=" + medals +
                ", totalMedals=" + this.totalMedals +
                '}';
    }

    // instead of calculating each time, we can put the total count in a map for a country after calculation.
    public int getTotalMedals(Country country) {
        int totalMedals = 0;
        List<Medal> medals = country.medals;
        for (Medal medal: medals) {
            totalMedals = totalMedals +  medal.getMedalCount();
        }
        this.totalMedals = totalMedals;
        totalMedalsMap = new HashMap<>();
        totalMedalsMap.put(country.countryName, totalMedals);
        return totalMedals;
    }

    public int getTotalMedals(CountryType country) {
        return totalMedalsMap.get(country);
    }

    public void setTotalMedals(int totalMedals) {
        this.totalMedals = totalMedals;
    }

    public CountryType getCountryName() {
        return countryName;
    }

    public List<Medal> getMedals() {
        return medals;
    }
}

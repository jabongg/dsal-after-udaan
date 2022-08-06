package com.java.projects.commonwealthgames;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Country {
    private CountryType countryName;
    private List<Medal> medals;
    private int totalMedals;

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
                ", totalMedals=" + totalMedals +
                '}';
    }

    public int getTotalMedals(Country country, HashMap<CountryType, Country> countryMedalMap) {
        int totalMedals = 0;
        Country currentCountry = countryMedalMap.get(country.countryName);
        List<Medal> medals = currentCountry.medals;
        for (Medal medal: medals) {
            totalMedals = totalMedals +  medal.getMedalCount();
        }
        this.totalMedals = totalMedals;
        return totalMedals;
    }
}

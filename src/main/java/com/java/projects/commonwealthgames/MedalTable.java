package com.java.projects.commonwealthgames;

public class MedalTable {
    private String countryName;
    private int gold;
    private int silver;
    private int bronze;
    private int totalMedals;

    public MedalTable() {
    }

    public MedalTable(String countryName, int gold, int silver, int bronze, int totalMedals) {
        this.countryName = countryName;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
        this.totalMedals = totalMedals;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getSilver() {
        return silver;
    }

    public void setSilver(int silver) {
        this.silver = silver;
    }

    public int getBronze() {
        return bronze;
    }

    public void setBronze(int bronze) {
        this.bronze = bronze;
    }

    public int getTotalMedals() {
        return totalMedals;
    }

    public void setTotalMedals(int totalMedals) {
        this.totalMedals = totalMedals;
    }


    @Override
    public String toString() {
        return "MedalTable{" +
                "countryName='" + countryName + '\'' +
                ", gold=" + gold +
                ", silver=" + silver +
                ", bronze=" + bronze +
                ", totalMedals=" + totalMedals +
                '}';
    }
}

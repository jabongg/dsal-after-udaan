package com.java.projects.commonwealthgames;

public class Medal {
    private MedalType medalType;
    private Integer medalCount;

    public Medal(MedalType medalType, Integer medalCount) {
        this.medalType = medalType;
        this.medalCount = medalCount;
    }


    public MedalType getMedalType() {
        return medalType;
    }

    public Integer getMedalCount() {
        return medalCount;
    }


    @Override
    public String toString() {
        return "Medal{" +
                "medalType=" + medalType +
                ", medalCount=" + medalCount +
                '}';
    }
}

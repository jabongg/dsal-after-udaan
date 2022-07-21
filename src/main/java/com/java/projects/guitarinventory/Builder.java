package com.java.projects.guitarinventory;

public enum Builder {
    FENDER, MARTIN, GIBSON, COLLINGS,
    OLSON, RYAN, PRS, ANY;

    public String toString() {
        switch (this) {
            case FENDER: return "fender";
            case COLLINGS: return "collings";
            case MARTIN: return "martin";
        }
        return null;
    }
}

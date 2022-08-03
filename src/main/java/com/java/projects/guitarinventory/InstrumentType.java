package com.java.projects.guitarinventory;

public enum InstrumentType {
    GUITAR, MANDOLINS, BANJO, DOBRO, FIDDLE, BASS;

    public String toString() {
        switch (this) {
            case BASS: return "BASS";
            case BANJO: return "BANJO";
            case DOBRO: return "DOBRO";
            case FIDDLE: return "FIDDLE";
            case GUITAR: return "GUITAR";
            case MANDOLINS: return "MANDOLINS";
            default: return "UNSPECIFIED";
        }
    }
}

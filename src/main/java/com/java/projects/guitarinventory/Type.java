package com.java.projects.guitarinventory;

public enum Type {
    ACOUSTIC, ELECTRIC;

    @Override
    public String toString() {
        switch (this) {
            case ACOUSTIC: return "acoustic";
            case ELECTRIC: return "electric";
        }
        return null;
    }
}

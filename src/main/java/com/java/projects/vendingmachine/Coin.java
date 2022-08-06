package com.java.projects.vendingmachine;

public enum Coin {
    FIVE(5), TEN(10), TWENTY(20);

    int value;

    Coin(int value) {
        this.value = value;
    }

    public static int[] parseCoins(String coins) {
        String[] coinsInText = coins.split(",");
        int[] denominations = new int[coinsInText.length];

        for (int i = 0; i < denominations.length; i++) {
            denominations[i] = Integer.parseInt(coinsInText[i]);
        }

        return denominations;
    }
}

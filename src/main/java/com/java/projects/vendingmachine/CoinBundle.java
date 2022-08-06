package com.java.projects.vendingmachine;

public class CoinBundle {
    public int _5RupeeCoin;
    public int _10RupeeCoin;
    public int _20RupeeCoin;

    public CoinBundle(int... coins) {
        this._5RupeeCoin = coins[0];
        this._10RupeeCoin = coins[1];
        this._20RupeeCoin = coins[2];
    }

    public int getTotal() {
        int total = 0;
        total = total + this._5RupeeCoin * 5;
        total = total + this._10RupeeCoin * 10;
        total = total + this._20RupeeCoin * 20;

        return total;
    }
}

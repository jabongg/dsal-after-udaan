package com.java.projects.vendingmachine;

public interface Calculator {

    int calculateTotal(CoinBundle enteredCoins);

    CoinBundle calculateChange(int moneyToReturn);
}

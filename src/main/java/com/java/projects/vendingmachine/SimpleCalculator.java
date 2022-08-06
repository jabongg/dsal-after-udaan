package com.java.projects.vendingmachine;

public class SimpleCalculator implements Calculator {
    @Override
    public int calculateTotal(CoinBundle enteredCoins) {
        return enteredCoins.getTotal();
    }

    @Override
    public CoinBundle calculateChange(int moneyToReturn) {
        CoinBundle change = new CoinBundle(new int[5]);
        int remainingAmount = moneyToReturn;
        change._20RupeeCoin = remainingAmount / 20;
        remainingAmount = remainingAmount % 20;

        change._10RupeeCoin = remainingAmount / 10;
        remainingAmount = remainingAmount % 10;

        change._5RupeeCoin = remainingAmount / 5;

        return  change;
    }
}

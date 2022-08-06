package com.java.projects.vendingmachine;

public interface VendingMachine {
    void displayProducts();

    void selectProducts(int product);

    void displayEnterCoinMessage();

    void enterCoins(int... coins);

    void displayChangeMessage();

}

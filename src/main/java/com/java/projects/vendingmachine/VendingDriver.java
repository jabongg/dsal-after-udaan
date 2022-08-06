package com.java.projects.vendingmachine;

import java.util.Scanner;

public class VendingDriver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        VendingMachine vendingMachine = new TextBasedVendingMachine();

        //product
        vendingMachine.displayProducts();
        String selectProduct = scanner.nextLine();
        int productNumber = Integer.parseInt(selectProduct);
        vendingMachine.selectProducts(productNumber);

        //coin
        vendingMachine.displayEnterCoinMessage();
        String enteredCoins = scanner.nextLine();
        int[] coins = Coin.parseCoins(enteredCoins); // TODO

        vendingMachine.enterCoins(coins);
        vendingMachine.displayChangeMessage();


    }

}

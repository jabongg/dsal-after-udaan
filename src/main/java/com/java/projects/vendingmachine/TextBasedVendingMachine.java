package com.java.projects.vendingmachine;

public class TextBasedVendingMachine implements VendingMachine {

    int selectedProduct;
    CoinBundle changeToReturn;
    @Override
    public void displayProducts() {
        System.out.println("*****************************************");
        System.out.println("|     WELCOME TO THE VENDING MACHINE    |");
        System.out.println("*****************************************");


        System.out.println("Products Available:");
        for (Product product: Product.values()) {
            System.out.println("product id : " + product.getId() + " product price : " + product.getPrice() );
        }

        System.out.println("select product : ");
    }

    @Override
    public void selectProducts(int product) {
        this.selectedProduct = product;
    }

    @Override
    public void displayEnterCoinMessage() {
        System.out.println("Enter Coins : ");
        System.out.println("you should enter the coins as binary format 0, 0, 1 means you inserted 20 rupee coin only: ");
        System.out.println("[5, 10, 20] is the order of the coins with given denominations ");


    }

    @Override
    public void enterCoins(int... coins) {
        Calculator calculator = new SimpleCalculator();
        Product product = Product.valueOf(this.selectedProduct);
        System.out.println("your selected product is : " + Product.valueOf(product.getId()));
        int total = calculator.calculateTotal(new CoinBundle(coins));
        int changedAmount = total - product.getPrice();
        this.changeToReturn = calculator.calculateChange(changedAmount);
    }

    @Override
    public void displayChangeMessage() {
        System.out.println("your change is as followed :" + changeToReturn.getTotal());
        System.out.println("5 Rupee coins : " + changeToReturn._5RupeeCoin);
        System.out.println("10 Rupee coins : " + changeToReturn._10RupeeCoin);
        System.out.println("20 Rupee coins : " + changeToReturn._20RupeeCoin);

    }
}

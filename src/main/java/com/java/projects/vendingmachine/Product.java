package com.java.projects.vendingmachine;

public enum Product {
    KURKURE(1, 10), COKE(2, 15), WATER(3, 20), SANDWITCH(4, 25);


    private int id;
    private int price;

    Product(int id, int price) {
        this.id = id;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public static Product valueOf(int selectedProduct) {
        for (Product product : Product.values()) {
            if (product.getId() == selectedProduct) {
                return product;
            }
        }
        return null;
    }
}

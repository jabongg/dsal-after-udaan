package com.java.interview.airtelafrica;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        Product product1 = new Product(1, "T-shirt", Color.BLUE, Size.MEDIUM);
        Product product2 = new Product(2, "slipper", Color.BLUE, Size.LARGE);
        Product product3 = new Product(3, "watch", Color.BLUE, Size.SMALL);
        Product product4 = new Product(4, "sunglass", Color.BLUE, Size.MEDIUM);

        Product product5 = new Product(5, "T-shirt", Color.BLUE, Size.MEDIUM);
        Product product6 = new Product(6, "slipper", Color.BLUE, Size.LARGE);
        Product product7 = new Product(7, "watch", Color.BLUE, Size.SMALL);
        Product product8 = new Product(8, "sunglass", Color.BLUE, Size.MEDIUM);

        products.add(product1); products.add(product2); products.add(product3); products.add(product4);
        products.add(product5); products.add(product6); products.add(product7); products.add(product8);


        // try using comparator to sort.
       // products.stream().
    }
}

package com.java.interview.airtelafrica;

import java.util.ArrayList;
import java.util.List;

public class ColourAndSizeFilter {

    public  List<Product> getItems(Color color, List<Product> products) {
        List<Product> products1 = new ArrayList<>();

        // iterate
        for (Product product : products) {
            if (product.getColor().equals(color)) {
                products1.add(product);
            }
        }

        return products1;
    }


    public void getItems(Color color, Size size) {

    }
}

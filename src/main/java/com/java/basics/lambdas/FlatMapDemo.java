package com.java.basics.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapDemo {
    public static void main(String[] args) {
        // making the arraylist object of List of Integer
        List<List<Integer> > number = new ArrayList<>();

        // adding the elements to number arraylist
        number.add(Arrays.asList(1, 2));
        number.add(Arrays.asList(3, 4));
        number.add(Arrays.asList(5, 6));
        number.add(Arrays.asList(7, 8));

        System.out.println("List of list-" + number);

        // now flatten it
        List<Integer> flatList = number.stream().flatMap(x -> x.stream()).collect(Collectors.toList());
        System.out.println(flatList);

    }
}

package com.java.basics.lambdas;

import java.util.Arrays;
import java.util.List;

public class ParellelStreamDemo {

    public static void main(String[] args)
    {
        // create a list
        List<String> list = Arrays.asList("Hello ",
                "G", "E", "E", "K", "S!");

        // using parallelStream()
        // method for parallel stream
        list.parallelStream().forEachOrdered(System.out::print);
        System.out.println();
        list.stream().forEach(System.out::print);
    }
}

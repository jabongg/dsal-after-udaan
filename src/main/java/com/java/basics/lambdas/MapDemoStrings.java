package com.java.basics.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class MapDemoStrings {


    public static void main(String[] args) {

        List<String> strings = new ArrayList<>();
        strings.add("Aman");
        strings.add("Babita");
        strings.add("Chinta");
        strings.add("Deepak");
        strings.add("Ekta");
        strings.add("Anila");
        strings.add("AnandaTyagrajan");

        System.out.println(strings);

        int longestStringLengthStartingWithA
                = strings.stream()
                .filter(s -> s.startsWith("A"))
                .mapToInt(String::length)
                .sum();

        System.out.println(longestStringLengthStartingWithA);
    }
}

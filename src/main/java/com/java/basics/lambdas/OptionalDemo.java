package com.java.basics.lambdas;

import java.util.Locale;
import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        String[] words = new String[10];
        words[0] = "Janki";
        words[1] = "Amita";
        words[2] = "Jiten";
        words[3] = "Lalita";
        words[4] = "Mahi";
        words[5] = "KaviTa";
       // String word = words[5].toLowerCase();
       // System.out.println(word);

        // to avoid NPE, we use Optional
        Optional<String> optional = Optional.ofNullable(words[5]);
        if (optional.isPresent()) {
            String word1 = words[5].toLowerCase(Locale.ROOT);
            System.out.println(optional.get());
            System.out.println(word1);
        } else {
            System.out.println("word[5] is null");
        }
    }
}

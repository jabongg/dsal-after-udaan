package com.java.hello;

import java.util.Arrays;
import java.util.Optional;

public class Hello {
    public static void main(String[] args) {
        System.out.println("hello");

        //find second highest number using java8
        Integer arr[] = {12, 16, 45, 11, 18, 22, 19, 20, 45};
        // 1. sort and then pick the second element
        // 2. push to the queue after sorting and pop then peek. (not recommended)
        // 3. using java8
        Optional<Integer> firstElement = Arrays.stream(arr).sorted().findFirst();
        System.out.printf("firstElement=" + firstElement);



    }
}

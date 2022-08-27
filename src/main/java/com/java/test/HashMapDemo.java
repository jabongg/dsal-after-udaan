package com.java.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapDemo {

    public static void main(String[] args) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(10);
        map.put(1, list1);

        List<Integer> list2 = new ArrayList<>();
        list2.add(20);
        list2.add(30);


        List<Integer> val1 = map.put(2, list2);
        System.out.println(map);

        System.out.println("val1 : " + val1);


        List<Integer> val2 = map.put(2, list1);
        System.out.println(map);

        System.out.println("val2 :" + val2);

    }
}

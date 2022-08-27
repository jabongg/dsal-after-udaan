package com.java.basics.lambdas;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListTest {

    public static void main(String[] args) {
        //List<Integer> list = List.of(82, 4, 8, 50, 21, 11, 92); // not allowed... available since jdk9


        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(21);
        list.add(3);
        list.add(46);
        list.add(50);

//        Iterator<Integer> it = list.iterator();
//        while (it.hasNext()) {
//            Integer value = it.next();
//            System.out.println("List Value:" + value);
//
//            //list.remove();
//            if (value.equals(3)) {
//                it.remove();//list.remove(value)
//                list.add(89); // ConcurrentModificationException
//            }
//        }

        // print even numbers;
        List<Integer> even = list.stream().filter(el -> el % 2 == 0).collect(Collectors.toList());
        System.out.println(even);

        //Stream<ArrayList<Integer>> stream = Stream.of(list);
        //stream.forEach(el -> System.out.print(el));

        list.stream().filter(el -> el % 2 == 0).collect(Collectors.toList()).stream().forEach(System.out::println);
        //System.out.println(sum);


    }

}

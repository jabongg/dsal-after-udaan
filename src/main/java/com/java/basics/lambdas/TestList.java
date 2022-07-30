package com.java.basics.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class TestList {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(61, 92, 34, 41, 75, 60, 83, 32, 19);

        // external iterators  as you are asking for each element
        // simple vs familiar
/*        for (Integer el: list) {
            System.out.println(el);
        }*/

        // internal iterators
 /*       list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
*/

        // method reference.
        //list.forEach(System.out::println);

      /*  list
                .stream()
                .map(String::valueOf)
                .forEach(System.out::print);
*/
        list.stream().map(e -> e.toString()).forEach(System.out::println);

        System.out.println(list.stream().reduce(Integer::sum).filter(e -> e > 2));
        System.out.println(list.stream().filter(e -> e % 2 == 0).mapToInt(e -> e * 2).limit(100).sum());
        System.out.println(Stream.iterate(100, e -> e + 1));

    }
}

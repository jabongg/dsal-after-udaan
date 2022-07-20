package com.java.basics;

import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String args[]){
        TreeSet<Integer> set = new TreeSet<>();
        //12, 1, 2, 3, 0, 11, 4
        set.add(12);
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(12);
        set.add(0);
        set.add(11);
        set.add(4);

        System.out.println(set.headSet(11).size());//0
        System.out.println(set.headSet(12).size());//1
        System.out.println(set.headSet(3).size());//2
        System.out.println(set.headSet(4).size());//3
        System.out.println(set.headSet(-1).size());//0!!Caution,returns 0 though it does not exist!

    }

}

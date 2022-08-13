package com.java.basics.lambdas;

import java.util.*;
import java.util.stream.Collectors;

public class Person {

    private int id;
    private String name;
    private int age;

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        Person p1 = new Person(1, "Abby", 30);
        Person p2 = new Person(1, "Bobby", 23);
        Person p3 = new Person(1, "Clinby", 38);
        Person p4 = new Person(1, "Dobby", 45);

        ArrayList<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);


        // todo print all the persons with age > 30
        List<Person> peopleOlderThan30 = list.stream().filter(e -> e.getAge() > 30).collect(Collectors.toList());
        System.out.println(peopleOlderThan30);

        //list.forEach(System.out::println);


        list.stream().filter(e -> e.getAge() > 30).collect(Collectors.toList()).forEach(person -> System.out.println(person.getAge()));


        Map<Integer, Person> personMap = new HashMap<>();
        personMap.put(30, p1);
        personMap.put(23, p2);
        personMap.put(38, p3);
        personMap.put(45, p3);

        System.out.println(personMap);


        // old way java 7
        for (Map.Entry<Integer, Person> map : personMap.entrySet()) {
            System.out.println(map.getValue().getAge()  +    " " + map.getValue().name);
        }

        // java 8
        personMap.entrySet().stream().forEach(e -> System.out.println(e.getValue().getName() + " " + e.getValue().getAge()));

        int[] arr = {0, 1, 0, 1, 0, 0, 1, 0, 1, 1};
        //Arrays.sort(arr); 1st way
        // 2nd way is to count the number of ones, and then iterate through the array and fill the ones with 1's count
        // bubble right karo 1's
        leftRight01(arr);
        //arrangeZerosAndOnes(arr);
        //print(arr);



    }

    private static void arrangeZerosAndOnes(int[] arr) {
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            while (arr[r] == 1) {
                r--;
            }

            while (arr[l] == 0) {
                l++;
            }


            if (arr[r] == 0 && arr[l] == 1) {
                if (r < l)
                    break;
                swap(arr, l, r);
                l++;
                r--;
            }
        }

    }

    private static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    public static void print(int[] A) {
        for (int el : A) {
            System.out.print(el + " ");
        }
    }


    // Main driver method
    public static void leftRight01(int[] a)
    {
        // Random array taken for consideration
        //int a[] = { 1, 1, 0, 0, 0, 0, 1, 1 };

        // Maintaining left pointer
        int left = 0;

        // Iteration over array using length function
        for (int i = 0; i < a.length; ++i) {

            // If zeros are present
            if (a[i] == 0) {

                // Swap the elements using
                // temporary variable
                int temp = a[left];
                a[left] = a[i];
                a[i] = temp;

                // Pre incrementing left pointer
                ++left;
            }
        }

        // Calling above function to
        // print updated array
        print(a);
    }
}

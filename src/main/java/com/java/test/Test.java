package com.java.test;

import java.util.ArrayList;
import java.util.List;
import java.lang.Math;
public class Test {

    private static final int age = 10;
    private static int type = 1;

    public static void main(String[] args) {

        Test.getType();
        Test t = null;
        t.getType(); // no NPE here as the method is static
        //t.getAge(); // expected null pointer exception here


        // copy student names and age from student to employee

        Student s1 = new Student("ajay", 16);
        Student s2 = new Student("vijay", 22);
        Student s3 = new Student("shilpa", 13);
        Student s4 = new Student("Divya", 27);

        List<Student> students = new ArrayList<>();
        students.add(s1); students.add(s2); students.add(s3); students.add(s4);

        //java 7 way
        List<Employee> employees = new ArrayList<>();
        for (Student student : students) {
            Employee employee = new Employee(student.name, student.age);
            employees.add(employee);
        }
        System.out.println(employees);

        // java 8 way

        System.out.println(Math.sqrt(4));

        int[] w = {1, 3, 4, 5};
        int[] val = {1, 4, 5, 7};
        int W = 7;

        System.out.println(knapsack(w, val, W, w.length));
    }


    public static void getType() {
        System.out.println("getType()");
    }

    public void getAge() {
        System.out.println("getAge()");
    }

    public static int knapsack(int[] w, int[] val, int W, int n) {
        if (W <= 0 || n == 0) {
            return 0;
        }

        //choice diagram
        if (w[n - 1] <= W) {
            // include
             return Math.max(val[n - 1] + knapsack(w, val, W - w[n - 1], n - 1 ), knapsack(w, val, W, n - 1 ));
        } else {
            // exclude
            return knapsack(w, val, W, n - 1 );
        }
    }
}

package com.java.test;

import java.util.ArrayList;
import java.util.List;

public class Test {

    private static final int age = 10;
    private static int type = 1;

    public static void main(String[] args) {

        Test.getType();
        Test t = null;
        t.getType(); // no NPE here as the method is static
        t.getAge(); // expected null pointer exception here


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


    }


    public static void getType() {
        System.out.println("getType()");
    }

    public void getAge() {
        System.out.println("getAge()");
    }
}

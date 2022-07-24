package com.java.projects.designpatterns.adapter;

public class AdapterDemo {

    public static void main(String[] args) {
        Adapted adapted = new Adapted();
        Adapter adapter = new Adapter(adapted);
        System.out.println(adapter.request());
    }


}

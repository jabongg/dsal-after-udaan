package com.java.designpatterns.adapter;

public class Adapter implements Target {

    private Adapted adapted;

    // plugging in like adapter.
    public Adapter(Adapted adapted) {
        this.adapted = adapted;
    }

    @Override
    public String request() {
        System.out.println("some adaption code goes here");
        return adapted.adapted();
    }
}

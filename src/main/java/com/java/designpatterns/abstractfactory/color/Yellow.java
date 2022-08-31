package com.java.designpatterns.abstractfactory.color;

public class Yellow implements Color {
    @Override
    public void fill() {
        System.out.println("Yellow color filled");
    }
}

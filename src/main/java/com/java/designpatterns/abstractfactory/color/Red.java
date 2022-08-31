package com.java.designpatterns.abstractfactory.color;

public class Red implements Color {

    @Override
    public void fill() {
        System.out.println("Red color filled");
    }
}

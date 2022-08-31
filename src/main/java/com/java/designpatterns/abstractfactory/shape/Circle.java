package com.java.designpatterns.abstractfactory.shape;

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("drawing circle");
    }
}

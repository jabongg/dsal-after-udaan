package com.java.designpatterns.abstractfactory.shape;

public class Triangle implements Shape {
    @Override
    public void draw() {
        System.out.println("drawing triangle");
    }
}

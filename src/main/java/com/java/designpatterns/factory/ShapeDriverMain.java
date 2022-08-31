package com.java.designpatterns.factory;

public class ShapeDriverMain {
    public static void main(String[] args) {
        ShapeFactory shape = new ShapeFactory();
        Shape square = shape.getShape("SQUARE");
        square.draw();

        Shape circle = shape.getShape("CIRCLE");
        circle.draw();

        Shape triangle = shape.getShape("TRIANGLE");
        triangle.draw();
    }
}

package com.java.designpatterns.factory;

import com.java.designpatterns.abstractfactory.AbstractFactory;
import com.java.designpatterns.abstractfactory.color.Color;

public class ShapeFactory {
    public Shape getShape(String shape) {
        switch (shape) {
            case "SQUARE":
                return new Square();
            case "CIRCLE":
                return new Circle();
            case "TRIANGLE":
                return new Triangle();
            default:
        }

        return new Triangle(); // in case of default
    }
}

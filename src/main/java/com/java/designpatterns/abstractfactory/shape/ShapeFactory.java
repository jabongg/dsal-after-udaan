package com.java.designpatterns.abstractfactory.shape;

import com.java.designpatterns.abstractfactory.AbstractFactory;
import com.java.designpatterns.abstractfactory.color.Color;

public class ShapeFactory extends AbstractFactory {

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

    @Override
    public Color getColor(String color) {
        return null;
    }
}

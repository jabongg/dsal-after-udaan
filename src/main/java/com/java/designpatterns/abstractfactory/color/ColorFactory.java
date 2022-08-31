package com.java.designpatterns.abstractfactory.color;

import com.java.designpatterns.abstractfactory.AbstractFactory;
import com.java.designpatterns.abstractfactory.shape.Shape;

public class ColorFactory extends AbstractFactory {

    @Override
    public Shape getShape(String shape) {
        return null;
    }

    @Override
    public Color getColor(String color) {
        switch (color) {
            case "YELLOW" : return new Yellow();
            case "RED" : return new Red();
            default:
        }

        return new Yellow();
    }
}

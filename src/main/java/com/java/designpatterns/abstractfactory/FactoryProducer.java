package com.java.designpatterns.abstractfactory;

import com.java.designpatterns.abstractfactory.color.ColorFactory;
import com.java.designpatterns.abstractfactory.shape.ShapeFactory;

public class FactoryProducer {
    public static AbstractFactory getFactory(String choice) {

        switch (choice) {
            case "SHAPE" : return new ShapeFactory();
            case "COLOR" : return new ColorFactory();
            default:
        }

        return null;
    }
}

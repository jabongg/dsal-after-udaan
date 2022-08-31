package com.java.designpatterns.abstractfactory;

import com.java.designpatterns.abstractfactory.color.Color;
import com.java.designpatterns.abstractfactory.shape.Shape;
import com.java.designpatterns.abstractfactory.shape.ShapeFactory;

public class AbstractFactoryDriverMain {
    public static void main(String[] args) {

        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        shape1.draw();

        Shape shape2 = shapeFactory.getShape("TRIANGLE");
        shape2.draw();

        AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");
        Color coloryellow = colorFactory.getColor("YELLOW");
        coloryellow.fill();

        Color colorRed = colorFactory.getColor("");
        colorRed.fill();
    }
}


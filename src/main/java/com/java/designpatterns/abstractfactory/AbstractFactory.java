package com.java.designpatterns.abstractfactory;

import com.java.designpatterns.abstractfactory.color.Color;
import com.java.designpatterns.abstractfactory.shape.Shape;

public abstract class AbstractFactory {
    public abstract Shape getShape(String shape);

    public abstract Color getColor(String color);
}

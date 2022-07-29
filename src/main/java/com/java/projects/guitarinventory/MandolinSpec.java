package com.java.projects.guitarinventory;

public class MandolinSpec extends InstrumentSpec {
    private Style style;

    public MandolinSpec(Builder builder, String model, Type type, Wood backWood, Wood topWood, Style style) {
        super(builder, model, type, backWood, topWood);
        this.style = style;
    }

    public boolean matches(MandolinSpec searchSpec) {
        return false;
    }

    @Override
    public boolean matches(InstrumentSpec otherSpec) {
        if (!super.matches(otherSpec))
            return false;
        if (!(otherSpec instanceof MandolinSpec))
            return false;
        MandolinSpec spec = (MandolinSpec)otherSpec;
        if (!style.equals(spec.style))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "MandolinSpec{" +
                "style=" + style +
                '}';
    }
}

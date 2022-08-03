package com.java.projects.guitarinventory;

import java.util.Iterator;
import java.util.Map;

public class InstrumentSpec {
    Map<String, String> properties;

    public InstrumentSpec(Map<String, String> properties) {
        this.properties = properties;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "InstrumentSpec{" +
                "properties=" + properties +
                '}';
    }
    public boolean matches(InstrumentSpec otherSpec) {
        for (Iterator i = otherSpec.getProperties().keySet().iterator(); i.hasNext(); ) {
            String propertyName = (String) i.next();
            if (!properties.get(propertyName).equals(otherSpec.getProperties().get(propertyName))) {
                return false;
            }
        }
        return true;
    }

}

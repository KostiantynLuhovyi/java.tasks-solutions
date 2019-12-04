package com.lugowoy.tasks.solutions.core.convertingDegreesTemperatures;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Konstantin Lugowoy on 11-Jan-17.
 */

public class Temperature implements Serializable, Cloneable {

    private double degreesTemperatures;

    private TemperatureScale scale;

    public Temperature() {
    }

    public Temperature(double degreesTemperatures, TemperatureScale scale) {
        this.degreesTemperatures = degreesTemperatures;
        this.scale = scale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Temperature)) return false;
        Temperature that = (Temperature) o;
        return Double.compare(that.getDegreesTemperatures(), getDegreesTemperatures()) == 0 &&
                getScale() == that.getScale();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDegreesTemperatures(), getScale());
    }

    @Override
    public String toString() {
        return "Temperature[" +
                "degreesTemperatures=" + degreesTemperatures +
                ", scale=" + scale +
                ']';
    }

    @Override
    public Temperature clone() {
        Temperature temperature = new Temperature();
        try {
            temperature = (Temperature) super.clone();
            temperature.setDegreesTemperatures(this.getDegreesTemperatures());
            temperature.setScale(this.getScale());
        } catch (CloneNotSupportedException ex) {
            new InternalError(ex.getMessage()).printStackTrace();
        }
        return temperature;
    }

    public double getDegreesTemperatures() {
        return degreesTemperatures;
    }

    public void setDegreesTemperatures(double degreesTemperatures) {
        this.degreesTemperatures = degreesTemperatures;
    }

    public TemperatureScale getScale() {
        return scale;
    }

    public void setScale(TemperatureScale scale) {
        this.scale = scale;
    }

}

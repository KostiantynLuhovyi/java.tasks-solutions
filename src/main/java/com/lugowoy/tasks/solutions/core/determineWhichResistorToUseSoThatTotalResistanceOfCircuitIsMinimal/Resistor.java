package com.lugowoy.tasks.solutions.core.determineWhichResistorToUseSoThatTotalResistanceOfCircuitIsMinimal;

import java.io.Serializable;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Konstantin Lugowoy on 10.11.2017.
 */

public class Resistor implements Serializable, Cloneable {

    private static final AtomicInteger ID_COUNT = new AtomicInteger();

    private final int idResistor;

    private double resistance;

    public Resistor() {
        this.idResistor = ID_COUNT.incrementAndGet();
    }

    public Resistor(int idResistor, double resistance) {
        this.idResistor = idResistor;
        this.resistance = resistance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Resistor)) return false;
        Resistor resistor = (Resistor) o;
        return getIdResistor() == resistor.getIdResistor() &&
                Double.compare(resistor.getResistance(), getResistance()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdResistor(), getResistance());
    }

    @Override
    public String toString() {
        return "Resistor[" +
                "idResistor=" + this.idResistor +
                ", resistance=" + this.resistance +
                ']';
    }

    @Override
    public Resistor clone() {
        Resistor resistor = new Resistor();
        try {
            resistor = (Resistor) super.clone();
            resistor.setResistance(this.getResistance());
        } catch (CloneNotSupportedException ex) {
            new InternalError(ex.getMessage()).printStackTrace();
        }
        return resistor;
    }

    public double getResistance() {
        return resistance;
    }

    public void setResistance(double resistance) {
        this.resistance = resistance;
    }

    public int getIdResistor() {
        return this.idResistor;
    }

}

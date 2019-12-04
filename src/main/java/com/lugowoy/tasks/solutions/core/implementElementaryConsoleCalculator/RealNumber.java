package com.lugowoy.tasks.solutions.core.implementElementaryConsoleCalculator;

import java.io.Serializable;

/**
 * Created by Konstantin Lugowoy on 11.09.2017.
 */

public class RealNumber implements Serializable, Cloneable {

    private double number;

    public RealNumber() {
    }

    public RealNumber(double number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RealNumber)) return false;

        RealNumber that = (RealNumber) o;

        return Double.compare(that.getNumber(), getNumber()) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(getNumber());
        return (int) (temp ^ (temp >>> 32));
    }

    @Override
    public String toString() {
        return "RealNumber[" + number +
                ']';
    }

    @Override
    public RealNumber clone() {
        RealNumber realNumber = new RealNumber();
        try {
            realNumber = (RealNumber) super.clone();
            realNumber.setNumber(this.getNumber());
        } catch (CloneNotSupportedException ex) {
            new InternalError(ex.getMessage()).printStackTrace();
        }
        return realNumber;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }
}

package com.lugowoy.tasks.calculateRootOfLinearEquation;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Konstantin Lugowoy on 14-Dec-16.
 */

public class LinearEquation implements Serializable, Cloneable {

    private double a;
    private double b;

    private double xRootOfTheLinearEquation;

    public LinearEquation() {
    }

    public LinearEquation(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LinearEquation)) return false;
        LinearEquation that = (LinearEquation) o;
        return Double.compare(that.getA(), getA()) == 0 &&
                Double.compare(that.getB(), getB()) == 0 &&
                Double.compare(that.xRootOfTheLinearEquation, xRootOfTheLinearEquation) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getA(), getB(), xRootOfTheLinearEquation);
    }

    @Override
    public String toString() {
        return "LinearEquation[" +
                "a=" + a +
                ", b=" + b +
                ", xRootOfTheLinearEquation=" + xRootOfTheLinearEquation +
                ']';
    }

    @Override
    public LinearEquation clone() {
        LinearEquation linearEquation = new LinearEquation();
        try {
            linearEquation = (LinearEquation) super.clone();
            linearEquation.setA(this.getA());
            linearEquation.setB(this.getB());
            linearEquation.setXRootLinearEquation(this.getXRootLinearEquation());
        } catch (CloneNotSupportedException ex) {
            new InternalError(ex.getMessage()).printStackTrace();
        }
        return linearEquation;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getXRootLinearEquation() {
        return xRootOfTheLinearEquation;
    }

    public void setXRootLinearEquation(double xRootLinearEquation) {
        this.xRootOfTheLinearEquation = xRootLinearEquation;
    }

}

package com.lugowoy.tasks.solutions.core.convertKilometersToMilesOfSeaAndLand;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Konstantin Lugowoy on 31-Dec-16.
 */

public class Length implements Serializable, Cloneable {

    private double kilometers;
    private double milesOfSea;
    private double milesOfLand;

    public Length() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Length)) return false;
        Length length = (Length) o;
        return Double.compare(length.getKilometers(), getKilometers()) == 0 &&
                Double.compare(length.getMilesOfSea(), getMilesOfSea()) == 0 &&
                Double.compare(length.getMilesOfLand(), getMilesOfLand()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getKilometers(), getMilesOfSea(), getMilesOfLand());
    }

    @Override
    public String toString() {
        return "Length[" +
                "kilometers=" + kilometers +
                ", milesOfSea=" + milesOfSea +
                ", milesOfLand=" + milesOfLand +
                ']';
    }

    @Override
    public Length clone() {
        Length length = new Length();
        try {
            length = (Length) super.clone();
            length.setKilometers(this.getKilometers());
            length.setMilesOfSea(this.getMilesOfSea());
            length.setMilesOfLand(this.getMilesOfLand());
        } catch (CloneNotSupportedException ex) {
            new InternalError(ex.getMessage()).printStackTrace();
        }
        return length;
    }

    public double getKilometers() {
        return kilometers;
    }

    public void setKilometers(double kilometers) {
        this.kilometers = kilometers;
    }

    public double getMilesOfSea() {
        return milesOfSea;
    }

    public void setMilesOfSea(double milesOfSea) {
        this.milesOfSea = milesOfSea;
    }

    public double getMilesOfLand() {
        return milesOfLand;
    }

    public void setMilesOfLand(double milesOfLand) {
        this.milesOfLand = milesOfLand;
    }

}

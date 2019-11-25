package com.lugowoy.tasks.calculationOfAmountOfPaintNeededToPaintRoom.models;

import com.rits.cloning.Cloner;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by LugowoyKonstantin on 21-Feb-17.
 */

public class Door implements Serializable, Cloneable {

    private BigDecimal widthDoor;
    private BigDecimal heightDoor;

    private BigDecimal areaDoor;

    public Door() {
    }

    public Door(BigDecimal widthDoor, BigDecimal heightDoor) {
        this.widthDoor = widthDoor;
        this.heightDoor = heightDoor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Door)) return false;

        Door door = (Door) o;

        if (getWidthDoor() != null ? !getWidthDoor().equals(door.getWidthDoor()) : door.getWidthDoor() != null)
            return false;
        if (getHeightDoor() != null ? !getHeightDoor().equals(door.getHeightDoor()) : door.getHeightDoor() != null)
            return false;
        return getAreaDoor() != null ? getAreaDoor().equals(door.getAreaDoor()) : door.getAreaDoor() == null;

    }

    @Override
    public int hashCode() {
        int result = getWidthDoor() != null ? getWidthDoor().hashCode() : 0;
        result = 31 * result + (getHeightDoor() != null ? getHeightDoor().hashCode() : 0);
        result = 31 * result + (getAreaDoor() != null ? getAreaDoor().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Door[" +
                "widthDoor=" + widthDoor +
                ", heightDoor=" + heightDoor +
                ", areaDoor=" + areaDoor +
                ']';
    }

    @Override
    public Door clone() {
        Door door = new Door();
        Cloner cloner = new Cloner();
        try {
            door = (Door) super.clone();
            door.setWidthDoor(cloner.deepClone(this.getWidthDoor()));
            door.setHeightDoor(cloner.deepClone(this.getHeightDoor()));
            door.setAreaDoor(cloner.deepClone(this.getAreaDoor()));
        } catch (CloneNotSupportedException ex) {
            new InternalError(ex.getMessage()).printStackTrace();
        }
        return door;
    }

    public BigDecimal getWidthDoor() {
        return widthDoor;
    }

    public void setWidthDoor(BigDecimal widthDoor) {
        this.widthDoor = widthDoor;
    }

    public BigDecimal getHeightDoor() {
        return heightDoor;
    }

    public void setHeightDoor(BigDecimal heightDoor) {
        this.heightDoor = heightDoor;
    }

    public BigDecimal getAreaDoor() {
        return areaDoor;
    }

    public void setAreaDoor(BigDecimal areaDoor) {
        this.areaDoor = areaDoor;
    }

}

package com.lugowoy.tasks.calculateHowManyMoviesWillFitOnUSBFlashDrive;

import java.io.Serializable;

/**
 * Created by Konstantin Lugowoy on 16.06.2017.
 */

public final class FlashDriveUSB implements Serializable, Cloneable {

    private double sizeFlashDriveUSB;

    public FlashDriveUSB() {
    }

    public FlashDriveUSB(double sizeFlashDriveUSB) {
        //The setters are used in the constructor, since the class is declared with the modifier final.
        this.setSizeFlashDriveUSB(sizeFlashDriveUSB);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FlashDriveUSB)) return false;

        FlashDriveUSB that = (FlashDriveUSB) o;

        return Double.compare(that.sizeFlashDriveUSB, sizeFlashDriveUSB) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(sizeFlashDriveUSB);
        return (int) (temp ^ (temp >>> 32));
    }

    @Override
    public String toString() {
        return "FlashDriveUSB[" +
                "sizeFlashDriveUSB=" + sizeFlashDriveUSB +
                ']';
    }

    @Override
    public FlashDriveUSB clone() {
        FlashDriveUSB flashDriveUSB = new FlashDriveUSB();
        try {
            flashDriveUSB = (FlashDriveUSB) super.clone();
            flashDriveUSB.setSizeFlashDriveUSB(this.getSizeFlashDriveUSB());
        } catch (CloneNotSupportedException ex) {
            new InternalError(ex.getMessage()).printStackTrace();
        }
        return flashDriveUSB;
    }

    public double getSizeFlashDriveUSB() {
        return sizeFlashDriveUSB;
    }

    public void setSizeFlashDriveUSB(double sizeFlashDriveUSB) {
        if (checkSizeFlashDriveUSB(sizeFlashDriveUSB)) {
            this.sizeFlashDriveUSB = sizeFlashDriveUSB;
        }
    }

    private boolean checkSizeFlashDriveUSB(double sizeFlashDriveUSB) {
        if (sizeFlashDriveUSB > 0) {
            return true;
        } else {
            throw new IllegalArgumentException("The size of the flash drive USB passed by the argument is less than or equal to 0.");
        }
    }

}

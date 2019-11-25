package com.lugowoy.tasks.programForCalculatingStudentRequiredFundsForLiving;

import com.rits.cloning.Cloner;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Created by LugowoyKonstantin on 02.11.2017.
 */

public class Stipend implements Serializable, Cloneable {

    private BigDecimal amountOfStipend;

    public Stipend() {
    }

    public Stipend(BigDecimal amountOfStipend) {
        this.amountOfStipend = amountOfStipend;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stipend)) return false;
        Stipend stipend = (Stipend) o;
        return Objects.equals(getAmountOfStipend(), stipend.getAmountOfStipend());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAmountOfStipend());
    }

    @Override
    public String toString() {
        return "Stipend[" +
                "amountOfStipend=" + amountOfStipend +
                ']';
    }

    @Override
    public Stipend clone() {
        Stipend stipend = new Stipend();
        try {
            stipend = (Stipend) super.clone();
            stipend.setAmountOfStipend(new Cloner().deepClone(this.getAmountOfStipend()));
        } catch (CloneNotSupportedException ex) {
            new InternalError(ex.getMessage()).printStackTrace();
        }
        return stipend;
    }

    public BigDecimal getAmountOfStipend() {
        return amountOfStipend;
    }

    public void setAmountOfStipend(BigDecimal amountOfStipend) {
        if (amountOfStipend.equals(new BigDecimal(0))) {
            throw new IllegalArgumentException("Amount of stipend can not by zero");
        }
    }
}

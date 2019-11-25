package com.lugowoy.tasks.calculationPercentageOfSum;

import com.rits.cloning.Cloner;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Konstantin Lugowoy on 30-Jan-17.
 */

public class Variable implements Serializable, Cloneable {

    private BigDecimal sum;
    private BigDecimal percent;
    private BigDecimal partOfSum;

    public Variable() {
    }

    public Variable(BigDecimal sum) {
        this.sum = sum;
    }

    public Variable(BigDecimal sum, BigDecimal partOfSum) {
        this.sum = sum;
        this.partOfSum = partOfSum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Variable)) return false;

        Variable variable = (Variable) o;

        if (getSum() != null ? !getSum().equals(variable.getSum()) : variable.getSum() != null) return false;
        if (getPercent() != null ? !getPercent().equals(variable.getPercent()) : variable.getPercent() != null)
            return false;
        return getPartOfSum() != null ? getPartOfSum().equals(variable.getPartOfSum()) : variable.getPartOfSum() == null;
    }

    @Override
    public int hashCode() {
        int result = getSum() != null ? getSum().hashCode() : 0;
        result = 31 * result + (getPercent() != null ? getPercent().hashCode() : 0);
        result = 31 * result + (getPartOfSum() != null ? getPartOfSum().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Variable[" +
                "sum=" + sum +
                ", percent=" + percent +
                ", partOfSum=" + partOfSum +
                ']';
    }

    @Override
    public Variable clone() {
        Variable variable = new Variable();
        Cloner cloner = new Cloner();
        try {
            variable = (Variable) super.clone();
            variable.setSum(cloner.deepClone(this.getSum()));
            variable.setPartOfSum(cloner.deepClone(this.getPartOfSum()));
            variable.setPercent(cloner.deepClone(this.getPercent()));
        } catch (CloneNotSupportedException ex) {
            new InternalError(ex.getMessage()).printStackTrace();
        }
        return variable;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public BigDecimal getPercent() {
        return percent;
    }

    public void setPercent(BigDecimal percent) {
        this.percent = percent;
    }

    public BigDecimal getPartOfSum() {
        return partOfSum;
    }

    public void setPartOfSum(BigDecimal partOfSum) {
        this.partOfSum = partOfSum;
    }

}

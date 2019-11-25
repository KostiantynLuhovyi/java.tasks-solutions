package com.lugowoy.tasks.identifyTwoIdenticalNumbers;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Konstantin Lugowoy on 07.11.2016.
 */

final class NumbersForComparison implements Serializable, Cloneable {

    private int firstNumber;
    private int secondNumber;
    private int thirdNumber;

    NumbersForComparison() {
    }

    public NumbersForComparison(int firstNumber, int secondNumber, int thirdNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.thirdNumber = thirdNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NumbersForComparison)) return false;
        NumbersForComparison that = (NumbersForComparison) o;
        return getFirstNumber() == that.getFirstNumber() &&
                getSecondNumber() == that.getSecondNumber() &&
                getThirdNumber() == that.getThirdNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstNumber(), getSecondNumber(), getThirdNumber());
    }

    @Override
    public String toString() {
        return "NumbersForComparison[" +
                "firstNumber=" + firstNumber +
                ", secondNumber=" + secondNumber +
                ", thirdNumber=" + thirdNumber +
                ']';
    }

    @Override
    public NumbersForComparison clone() {
        NumbersForComparison numbersForComparison = new NumbersForComparison();
        try {
            numbersForComparison = (NumbersForComparison) super.clone();
            numbersForComparison.setFirstNumber(this.getFirstNumber());
            numbersForComparison.setSecondNumber(this.getSecondNumber());
            numbersForComparison.setThirdNumber(this.getThirdNumber());
        } catch (CloneNotSupportedException ex) {
            new InternalError(ex.getMessage()).printStackTrace();
        }
        return numbersForComparison;
    }

    int getFirstNumber() {
        return firstNumber;
    }

    void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    int getSecondNumber() {
        return secondNumber;
    }

    void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    int getThirdNumber() {
        return thirdNumber;
    }

    void setThirdNumber(int thirdNumber) {
        this.thirdNumber = thirdNumber;
    }

}

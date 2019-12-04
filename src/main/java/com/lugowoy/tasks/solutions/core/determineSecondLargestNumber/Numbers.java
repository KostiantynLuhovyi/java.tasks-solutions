package com.lugowoy.tasks.solutions.core.determineSecondLargestNumber;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Konstantin Lugowoy on 14.11.2016.
 */

class Numbers implements Serializable, Cloneable {

    private int firstNumber;
    private int secondNumber;
    private int thirdNumber;

    public Numbers() {
    }

    public Numbers(int firstNumber, int secondNumber, int thirdNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.thirdNumber = thirdNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Numbers)) return false;
        Numbers numbers = (Numbers) o;
        return getFirstNumber() == numbers.getFirstNumber() &&
                getSecondNumber() == numbers.getSecondNumber() &&
                getThirdNumber() == numbers.getThirdNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstNumber(), getSecondNumber(), getThirdNumber());
    }

    @Override
    public String toString() {
        return "Numbers[" +
                "firstNumber=" + firstNumber +
                ", secondNumber=" + secondNumber +
                ", thirdNumber=" + thirdNumber +
                ']';
    }

    @Override
    public Numbers clone() {
        Numbers numbers = new Numbers();
        try {
            numbers = (Numbers) super.clone();
            numbers.setFirstNumber(this.getFirstNumber());
            numbers.setSecondNumber(this.getSecondNumber());
            numbers.setThirdNumber(this.getThirdNumber());
        } catch (CloneNotSupportedException ex) {
            new InternalError(ex.getMessage()).printStackTrace();
        }
        return numbers;
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    public int getThirdNumber() {
        return thirdNumber;
    }

    public void setThirdNumber(int thirdNumber) {
        this.thirdNumber = thirdNumber;
    }

}

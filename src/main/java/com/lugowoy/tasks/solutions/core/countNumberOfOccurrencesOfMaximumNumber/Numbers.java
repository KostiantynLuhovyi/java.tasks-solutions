package com.lugowoy.tasks.solutions.core.countNumberOfOccurrencesOfMaximumNumber;

import com.rits.cloning.Cloner;

import java.util.Arrays;
import java.util.Objects;

/**
 * Created by Konstantin Lugowoy on 14.11.2016.
 */

class Numbers {

    private Integer[] numbers;
    private int maxNumberCount;

    public Numbers() {
    }

    public Numbers(Integer[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Numbers)) return false;
        Numbers numbers1 = (Numbers) o;
        return getMaxNumberCount() == numbers1.getMaxNumberCount() &&
                Arrays.equals(getNumbers(), numbers1.getNumbers());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getMaxNumberCount());
        result = 31 * result + Arrays.hashCode(getNumbers());
        return result;
    }

    @Override
    public String toString() {
        return "Numbers[" +
                "numbers=" + Arrays.toString(numbers) +
                ", maxNumberCount=" + maxNumberCount +
                ']';
    }

    @Override
    public Numbers clone() {
        Numbers numbers = new Numbers();
        try {
            numbers = (Numbers) super.clone();
            numbers.setNumbers(new Cloner().deepClone(this.getNumbers()));
            numbers.setMaxNumberCount(this.getMaxNumberCount());
        } catch (CloneNotSupportedException ex) {
            new InternalError(ex.getMessage()).printStackTrace();
        }
        return numbers;
    }

    public int getMaxNumberCount() {
        return maxNumberCount;
    }

    public void setMaxNumberCount(int maxNumberCount) {
        this.maxNumberCount = maxNumberCount;
    }

    public Integer[] getNumbers() {
        return numbers;
    }

    public void setNumbers(Integer[] numbers) {
        this.numbers = numbers;
    }

}

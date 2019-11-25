package com.lugowoy.tasks.writeProgramToGetNumberOfMostFrequentAnswersInQuizAndTheirPercentages.models;

import java.io.Serializable;

/**
 * Created by LugowoyKonstantin on 07.04.2017.
 */

public class Option implements Comparable<Option>, Serializable, Cloneable {

    private int countChoice;

    private double percentageOfOption;

    private Enum valueForOption;

    public Option() {
    }

    public Option(Enum valueForOption) {
        this.valueForOption = valueForOption;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Option)) return false;

        Option option = (Option) o;

        if (getCountChoice() != option.getCountChoice()) return false;
        if (Double.compare(option.percentageOfOption, percentageOfOption) != 0) return false;
        return getValueForOption() != null ? getValueForOption().equals(option.getValueForOption()) : option.getValueForOption() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getCountChoice();
        temp = Double.doubleToLongBits(percentageOfOption);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (getValueForOption() != null ? getValueForOption().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Option[" +
                "countChoice=" + countChoice +
                ", percentageOfOption=" + percentageOfOption +
                ", valueForOption=" + valueForOption +
                ']';
    }

    @Override
    public Option clone() {
        Option option = new Option();
        try {
            option = (Option) super.clone();
            option.setCountChoice(this.getCountChoice());
            option.setPercentageOfOption(this.getPercentageOfOption());
            option.setValueForOption(this.getValueForOption());//Enum is a singleton, so refers to the same instance.
        } catch (CloneNotSupportedException ex) {
            new InternalError(ex.getMessage()).printStackTrace();
        }
        return option;
    }

    @Override
    public int compareTo(Option o) {
        int res = 0;
        if (this.countChoice > o.getCountChoice()) {
            res = 1;
        } else if (this.countChoice < o.getCountChoice()) {
            res = -1;
        }
        return res;
    }

    public int getCountChoice() {
        return countChoice;
    }

    public void setCountChoice(int countChoice) {
        this.countChoice = countChoice;
    }

    public Enum getValueForOption() {
        return valueForOption;
    }

    public void setValueForOption(Enum valueForOption) {
        this.valueForOption = valueForOption;
    }

    public double getPercentageOfOption() {
        return percentageOfOption;
    }

    public void setPercentageOfOption(double percentageOfOption) {
        this.percentageOfOption = percentageOfOption;
    }

}

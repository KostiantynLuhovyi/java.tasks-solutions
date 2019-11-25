package com.lugowoy.tasks.writeProgramToGetNumberOfMostFrequentAnswersInQuizAndTheirPercentages.voting;

import com.lugowoy.tasks.writeProgramToGetNumberOfMostFrequentAnswersInQuizAndTheirPercentages.models.Quiz;

/**
 * Created by LugowoyKonstantin on 10.04.2017.
 */

public abstract class Voting<T extends Enum> {

    private int quantityVote;
    private Class<T> valueForOption;

    public Voting() {
    }

    public Voting(int quantityVote) {
        this.quantityVote = quantityVote;
    }

    public Voting(Class<T> valueForOption) {
        this.valueForOption = valueForOption;
    }

    public Voting(int quantityVote, Class<T> valueForOption) {
        this.quantityVote = quantityVote;
        this.valueForOption = valueForOption;
    }

    public abstract void vote(Quiz quiz);

    public int getQuantityVote() {
        return quantityVote;
    }

    public void setQuantityVote(int quantityVote) {
        this.quantityVote = quantityVote;
    }

    public Class<T> getValueForOption() {
        return valueForOption;
    }

    public void setValueForOption(Class<T> valueForOption) {
        this.valueForOption = valueForOption;
    }

}

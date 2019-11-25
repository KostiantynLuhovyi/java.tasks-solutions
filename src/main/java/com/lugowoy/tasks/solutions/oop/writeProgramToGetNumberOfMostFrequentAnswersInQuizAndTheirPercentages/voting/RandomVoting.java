package com.lugowoy.tasks.writeProgramToGetNumberOfMostFrequentAnswersInQuizAndTheirPercentages.voting;

import com.lugowoy.tasks.writeProgramToGetNumberOfMostFrequentAnswersInQuizAndTheirPercentages.models.Option;
import com.lugowoy.tasks.writeProgramToGetNumberOfMostFrequentAnswersInQuizAndTheirPercentages.models.Quiz;

import java.util.Random;

/**
 * Created by LugowoyKonstantin on 07.04.2017.
 */

public class RandomVoting<T extends Enum> extends Voting<T> {

    public RandomVoting() {
    }

    public RandomVoting(int quantityVote) {
        super(quantityVote);
    }

    public RandomVoting(Class<T> valueForOption) {
        super(valueForOption);
    }

    public RandomVoting(int quantityVote, Class<T> valueForOption) {
        super(quantityVote, valueForOption);
    }

    public void vote(Quiz quiz) {
        for (int i = 0; i < this.getQuantityVote(); i++) {
            Option option = quiz.getOptionList().get(generateIndexOfRandomChoiceOfOption(this.getValueForOption()));
            option.setCountChoice(option.getCountChoice() + 1);
        }
    }

    private int generateIndexOfRandomChoiceOfOption(Class<T> valueEnumClass) {
        return new Random().nextInt(valueEnumClass.getEnumConstants().length);
    }

}

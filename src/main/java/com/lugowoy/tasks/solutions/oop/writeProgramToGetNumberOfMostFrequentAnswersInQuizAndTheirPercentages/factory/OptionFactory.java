package com.lugowoy.tasks.solutions.oop.writeProgramToGetNumberOfMostFrequentAnswersInQuizAndTheirPercentages.factory;

import com.lugowoy.tasks.solutions.oop.writeProgramToGetNumberOfMostFrequentAnswersInQuizAndTheirPercentages.models.Option;

/**
 * Created by LugowoyKonstantin on 07.04.2017.
 */

public class OptionFactory extends ModelFactory<Option> {

    @Override
    public Option createModel() {
        return new Option();
    }

}

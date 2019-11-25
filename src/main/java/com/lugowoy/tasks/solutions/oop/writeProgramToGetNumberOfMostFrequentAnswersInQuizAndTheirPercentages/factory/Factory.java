package com.lugowoy.tasks.writeProgramToGetNumberOfMostFrequentAnswersInQuizAndTheirPercentages.factory;

/**
 * Created by LugowoyKonstantin on 07.04.2017.
 */

@FunctionalInterface
public interface Factory<T> {

    T create();

}

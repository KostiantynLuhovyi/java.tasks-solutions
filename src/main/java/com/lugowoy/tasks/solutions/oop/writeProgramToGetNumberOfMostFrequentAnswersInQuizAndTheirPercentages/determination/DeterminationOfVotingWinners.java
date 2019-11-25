package com.lugowoy.tasks.writeProgramToGetNumberOfMostFrequentAnswersInQuizAndTheirPercentages.determination;

import java.util.Collection;

/**
 * Created by LugowoyKonstantin on 11.04.2017.
 */

public interface DeterminationOfVotingWinners<T extends Collection, V> extends Determination {

    T determine(V v);

}

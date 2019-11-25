package com.lugowoy.tasks.writeProgramToGetNumberOfMostFrequentAnswersInQuizAndTheirPercentages.voting;

/**
 * Created by LugowoyKonstantin on 10.04.2017.
 */

public class IncorrectInputValueOfOption extends IllegalArgumentException {

    public IncorrectInputValueOfOption() {
    }

    public IncorrectInputValueOfOption(String s) {
        super(s);
    }

    public IncorrectInputValueOfOption(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectInputValueOfOption(Throwable cause) {
        super(cause);
    }

}

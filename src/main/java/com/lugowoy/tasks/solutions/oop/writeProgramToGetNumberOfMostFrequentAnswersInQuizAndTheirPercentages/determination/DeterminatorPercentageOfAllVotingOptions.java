package com.lugowoy.tasks.writeProgramToGetNumberOfMostFrequentAnswersInQuizAndTheirPercentages.determination;

import com.lugowoy.tasks.writeProgramToGetNumberOfMostFrequentAnswersInQuizAndTheirPercentages.models.Option;
import com.lugowoy.tasks.writeProgramToGetNumberOfMostFrequentAnswersInQuizAndTheirPercentages.models.Quiz;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by LugowoyKonstantin on 11.04.2017.
 */

public class DeterminatorPercentageOfAllVotingOptions extends Determinator implements DeterminationPercentageOfAllVotingOptions<Quiz> {

    @Override
    public void determinePercentageOfAllVotingOptions(Quiz quiz) {
        for (Option option : quiz.getOptionList()) {
            if (option.getCountChoice() != 0) {
                option.setPercentageOfOption(new BigDecimal(option.getCountChoice()).divide(new BigDecimal(Quiz.getNumberOfParticipantsInVoting()), 2, RoundingMode.HALF_DOWN)
                        .multiply(new BigDecimal(100)).doubleValue());
            }
        }
    }

}

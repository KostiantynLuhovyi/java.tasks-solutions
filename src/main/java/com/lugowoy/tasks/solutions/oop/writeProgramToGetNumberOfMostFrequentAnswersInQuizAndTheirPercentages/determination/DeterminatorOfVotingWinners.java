package com.lugowoy.tasks.writeProgramToGetNumberOfMostFrequentAnswersInQuizAndTheirPercentages.determination;

import com.lugowoy.tasks.writeProgramToGetNumberOfMostFrequentAnswersInQuizAndTheirPercentages.models.Option;
import com.lugowoy.tasks.writeProgramToGetNumberOfMostFrequentAnswersInQuizAndTheirPercentages.models.Quiz;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by LugowoyKonstantin on 10.04.2017.
 */

public class DeterminatorOfVotingWinners extends Determinator implements DeterminationOfVotingWinners<Collection<Option>, Quiz> {

    @Override
    public Collection<Option> determine(Quiz quiz) {
        Collection<Option> collectionOptionOfVotingWinners = new ArrayList<>(0);

        Option optionMaxVote = Collections.max(quiz.getOptionList());
        collectionOptionOfVotingWinners.add(optionMaxVote);

        for (Option option : quiz.getOptionList()) {
            if (option.getCountChoice() == optionMaxVote.getCountChoice()) {
                if (!option.equals(optionMaxVote)) {
                    collectionOptionOfVotingWinners.add(option);
                }
            }
        }
        return collectionOptionOfVotingWinners;
    }

}

package com.lugowoy.tasks.writeProgramToGetNumberOfMostFrequentAnswersInQuizAndTheirPercentages.voting;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.tasks.writeProgramToGetNumberOfMostFrequentAnswersInQuizAndTheirPercentages.models.Option;
import com.lugowoy.tasks.writeProgramToGetNumberOfMostFrequentAnswersInQuizAndTheirPercentages.models.Quiz;

/**
 * Created by LugowoyKonstantin on 07.04.2017.
 */

public class UserVoting<T extends Enum> extends Voting<T> {

    private final Reader reader;

    public UserVoting(Reading reading) {
        this.reader = Reader.getReader(reading);
    }

    public void vote(Quiz quiz) {
        int countVote = 0;

        String resultInputData;

        while (true) {
            outputOptionsForVoting(quiz);
            System.out.println("To end the voting, enter 'stop'.");
            resultInputData = this.reader.readString();

            Quiz.setNumberOfParticipantsInVoting(countVote);
            countVote++;

            if (!resultInputData.equalsIgnoreCase("stop")) {
                try {
                    accrualOfVotesForParticularOption(quiz, resultInputData);
                } catch (IllegalArgumentException ex) {
                    System.out.println("Incorrect input value. Re-enter : ");
                    System.out.println();
                }
            } else {
                break;
            }
        }
    }

    public void vote(Quiz quiz, int quantityVote) {
        String resultInputData;
        for (int i = 0; i < quantityVote; i++) {
            while (true) {
                try {
                    outputOptionsForVoting(quiz);
                    resultInputData = this.reader.readString();
                    accrualOfVotesForParticularOption(quiz, resultInputData);
                    break;
                } catch (IllegalArgumentException ex) {
                    System.out.println("Incorrect input value. Re-enter : ");
                    System.out.println();
                }
            }
        }
    }

    private void accrualOfVotesForParticularOption(Quiz quiz, String resultInputData) throws IllegalArgumentException {
        if (resultInputData.matches("\\d+?")) {
            int value = Integer.parseInt(resultInputData);
            if ((value >= 0) && (value < quiz.getOptionList().size())) {
                Option option = quiz.getOptionList().get(value);
                quiz.getOptionList().get(value).setCountChoice(option.getCountChoice() + 1);
            } else {
                throw new IncorrectInputValueOfOption();
            }
        } else {
            throw new IncorrectInputValueOfOption();
        }
    }

    private static void outputOptionsForVoting(Quiz quiz) {
        System.out.println("Enter the number of your choice : ");
        for (int i = 0; i < quiz.getOptionList().size(); i++) {
            System.out.printf("Choose %d - %s ;%n", i, quiz.getOptionList().get(i).getValueForOption().name());
        }
    }

}

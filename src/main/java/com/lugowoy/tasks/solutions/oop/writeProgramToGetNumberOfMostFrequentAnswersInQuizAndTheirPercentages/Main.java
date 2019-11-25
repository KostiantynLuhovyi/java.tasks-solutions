package com.lugowoy.tasks.writeProgramToGetNumberOfMostFrequentAnswersInQuizAndTheirPercentages;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.tasks.writeProgramToGetNumberOfMostFrequentAnswersInQuizAndTheirPercentages.determination.Determinator;
import com.lugowoy.tasks.writeProgramToGetNumberOfMostFrequentAnswersInQuizAndTheirPercentages.determination.DeterminatorOfVotingWinners;
import com.lugowoy.tasks.writeProgramToGetNumberOfMostFrequentAnswersInQuizAndTheirPercentages.determination.DeterminatorPercentageOfAllVotingOptions;
import com.lugowoy.tasks.writeProgramToGetNumberOfMostFrequentAnswersInQuizAndTheirPercentages.factory.Factory;
import com.lugowoy.tasks.writeProgramToGetNumberOfMostFrequentAnswersInQuizAndTheirPercentages.factory.QuizFactory;
import com.lugowoy.tasks.writeProgramToGetNumberOfMostFrequentAnswersInQuizAndTheirPercentages.filling.Filling;
import com.lugowoy.tasks.writeProgramToGetNumberOfMostFrequentAnswersInQuizAndTheirPercentages.filling.FillingQuiz;
import com.lugowoy.tasks.writeProgramToGetNumberOfMostFrequentAnswersInQuizAndTheirPercentages.models.Option;
import com.lugowoy.tasks.writeProgramToGetNumberOfMostFrequentAnswersInQuizAndTheirPercentages.models.Quiz;
import com.lugowoy.tasks.writeProgramToGetNumberOfMostFrequentAnswersInQuizAndTheirPercentages.models.ValueForOptionJapanSymbols;
import com.lugowoy.tasks.writeProgramToGetNumberOfMostFrequentAnswersInQuizAndTheirPercentages.voting.RandomVoting;
import com.lugowoy.tasks.writeProgramToGetNumberOfMostFrequentAnswersInQuizAndTheirPercentages.voting.UserVoting;
import com.lugowoy.tasks.writeProgramToGetNumberOfMostFrequentAnswersInQuizAndTheirPercentages.voting.Voting;

/**
 * The radio company interviewed N radio listeners on the question: "What animal do you connect with Japan and the Japanese?"
 * To compile a program for obtaining k of the most frequently encountered answers and their shares (in percentages).
 * <p>
 * Created by LugowoyKonstantin on 07.04.2017.
 */

public class Main {

    private static final Reader READER = Reader.getReader(new ReadingConsole());

    private static final Factory<Quiz> QUIZ_FACTORY = new QuizFactory()::createModel;

    public static void main(String[] args) {

        Quiz quiz = QUIZ_FACTORY.create();

        Filling<ValueForOptionJapanSymbols> filling = new FillingQuiz<>();
        filling.fillOptionListForQuiz(quiz, ValueForOptionJapanSymbols.class);

        System.out.println();
        System.out.println("A vote is taken.");
        System.out.println();

        int resultChoiceKnownWhetherTheNumberOfParticipantsInTheVote = choiceIsKnownWhetherTheNumberOfParticipantsInTheVote();

        System.out.println();

        Voting<ValueForOptionJapanSymbols> voting;
        if (resultChoiceKnownWhetherTheNumberOfParticipantsInTheVote == 1) {
            System.out.println("Start voting.\n");
            voting = new UserVoting<>(new ReadingConsole());
            voting.vote(quiz);
        } else if (resultChoiceKnownWhetherTheNumberOfParticipantsInTheVote == 2) {

            Quiz.setNumberOfParticipantsInVoting(inputAndGetQuantityParticipants());

            int resultChoiceVotingOption = choiceVotingOption();
            if (resultChoiceVotingOption == 1) {
                voting = new UserVoting<>(new ReadingConsole());
                ((UserVoting) voting).vote(quiz, Quiz.getNumberOfParticipantsInVoting());
            } else if (resultChoiceVotingOption == 2) {
                voting = new RandomVoting<>(Quiz.getNumberOfParticipantsInVoting(), ValueForOptionJapanSymbols.class);
                voting.vote(quiz);
            }
        }

        Determinator determinator = new DeterminatorOfVotingWinners();

        System.out.println();
        System.out.println("Options won the vote : ");
        for (Option option : ((DeterminatorOfVotingWinners) determinator).determine(quiz)) {
            System.out.println("Choice : " + option.getCountChoice() + "; symbol : " + option.getValueForOption());
        }
        System.out.println();

        determinator = new DeterminatorPercentageOfAllVotingOptions();
        ((DeterminatorPercentageOfAllVotingOptions) determinator).determinePercentageOfAllVotingOptions(quiz);

        System.out.println("Percentage of all voting options : ");

        for (Option option : quiz.getOptionList()) {
            System.out.println(option);
        }
        System.out.println();

    }

    private static int inputAndGetQuantityParticipants() {
        int resultQuantity;
        System.out.println("Enter the number of voters : ");
        System.out.println("The number must not exceed 50 participants.");
        while (true) {
            int quantityParticipants = READER.readInt();
            if ((quantityParticipants > 0) && (quantityParticipants <= 50)) {
                resultQuantity = quantityParticipants;
                break;
            } else {
                System.out.println("Incorrect value of quantity a participants. Re-enter : ");
            }
        }
        return resultQuantity;
    }

    private static int choiceVotingOption() {
        System.out.println("You want to spend meaningful or random vote ?");
        int resultSelectionVotingOption;
        while (true) {
            System.out.println("Make a choice : ");
            System.out.println("Meaningful vote - press '1' ;\n" +
                    "Random vote - press '2' .");
            resultSelectionVotingOption = READER.readInt();
            if ((resultSelectionVotingOption > 0) && (resultSelectionVotingOption < 3)) {
                break;
            } else {
                System.out.println("Incorrect choice. Repeat.");
                System.out.println();
            }
        }
        return resultSelectionVotingOption;
    }

    private static int choiceIsKnownWhetherTheNumberOfParticipantsInTheVote() {
        int resultChoiceQuantityOfVote;
        System.out.println("You know the number of participants in vote ? ");
        while (true) {
            System.out.println("No - press '1' ;\n" +
                    "Yes - press '2' .");
            resultChoiceQuantityOfVote = READER.readInt();
            if ((resultChoiceQuantityOfVote > 0) && (resultChoiceQuantityOfVote < 3)) {
                break;
            } else {
                System.out.println("Incorrect input number of participants in vote. Re-enter : ");
                System.out.println();
            }
        }
        return resultChoiceQuantityOfVote;
    }

}

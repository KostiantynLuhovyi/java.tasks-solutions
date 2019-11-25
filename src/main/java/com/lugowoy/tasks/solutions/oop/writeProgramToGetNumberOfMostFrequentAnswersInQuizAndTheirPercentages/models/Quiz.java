package com.lugowoy.tasks.writeProgramToGetNumberOfMostFrequentAnswersInQuizAndTheirPercentages.models;

import com.rits.cloning.Cloner;

import java.io.Serializable;
import java.util.List;

/**
 * Created by LugowoyKonstantin on 06.04.2017.
 */

public class Quiz implements Serializable, Cloneable {

    private static int numberOfParticipantsInVoting;

    private List<Option> optionList;

    public Quiz() {
    }

    public Quiz(List<Option> optionList) {
        this.optionList = optionList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Quiz)) return false;

        Quiz quiz = (Quiz) o;

        return optionList != null ? optionList.equals(quiz.optionList) : quiz.optionList == null;
    }

    @Override
    public int hashCode() {
        return optionList != null ? optionList.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Quiz[" +
                "optionList=" + optionList +
                ']';
    }

    @Override
    public Quiz clone() {
        Quiz quiz = new Quiz();
        try {
            quiz = (Quiz) super.clone();
            quiz.setOptionList(new Cloner().deepClone(this.getOptionList()));
        } catch (CloneNotSupportedException ex) {
            new InternalError(ex.getMessage()).printStackTrace();
        }
        return quiz;
    }

    public static int getNumberOfParticipantsInVoting() {
        return numberOfParticipantsInVoting;
    }

    public static void setNumberOfParticipantsInVoting(int numberOfParticipantsInVoting) {
        Quiz.numberOfParticipantsInVoting = numberOfParticipantsInVoting;
    }

    public List<Option> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<Option> optionList) {
        this.optionList = optionList;
    }

}

package com.lugowoy.tasks.writeProgramToGetNumberOfMostFrequentAnswersInQuizAndTheirPercentages.filling;

import com.lugowoy.tasks.writeProgramToGetNumberOfMostFrequentAnswersInQuizAndTheirPercentages.factory.Factory;
import com.lugowoy.tasks.writeProgramToGetNumberOfMostFrequentAnswersInQuizAndTheirPercentages.factory.OptionFactory;
import com.lugowoy.tasks.writeProgramToGetNumberOfMostFrequentAnswersInQuizAndTheirPercentages.models.Option;
import com.lugowoy.tasks.writeProgramToGetNumberOfMostFrequentAnswersInQuizAndTheirPercentages.models.Quiz;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LugowoyKonstantin on 09.04.2017.
 */

public class FillingQuiz<T extends Enum> implements Filling<T> {

    @Override
    public void fillOptionListForQuiz(Quiz quiz, Class<T> valueEnumClass) {
        Factory<Option> optionFactory = new OptionFactory()::createModel;
        List<Option> optionList = new ArrayList<>(0);

        for (Enum value : valueEnumClass.getEnumConstants()) {
            Option option = optionFactory.create();
            option.setValueForOption(value);

            optionList.add(option);
        }
        quiz.setOptionList(optionList);
    }

}

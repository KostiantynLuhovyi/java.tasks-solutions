package com.lugowoy.tasks.solutions.arrays.onedimensional.convertSecondSequenceAccordingToRuleDefinedByFirstSequence;

import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.checking.CheckerArray;

/**
 * Created by Konstantin Lugowoy on 25.03.2017.
 */
@FunctionalInterface
public interface ConvertingSequenceByRule {

    void convert(ArrayInts firstArray, ArrayInts secondArray);

    static void convertSecondSequenceByRuleDefinedByFirstSequence(ArrayInts firstArray, ArrayInts secondArray) {
        if (CheckerArray.checkLengthInArray(firstArray) && CheckerArray.checkLengthInArray(secondArray)) {
            if (firstArray.size() == secondArray.size()) {
                for (int i = 0; i < firstArray.size(); i++) {
                    if (firstArray.get(i) <= 0) {
                        secondArray.set(i, secondArray.get(i) * 10);
                    } else {
                        secondArray.set(i, 0);
                    }
                }
            } else {
                throw new IllegalArgumentException("Sequences sizes are not equal.");
            }
        }
        System.out.println("Result second sequence after converting : \n" + secondArray);
    }

}

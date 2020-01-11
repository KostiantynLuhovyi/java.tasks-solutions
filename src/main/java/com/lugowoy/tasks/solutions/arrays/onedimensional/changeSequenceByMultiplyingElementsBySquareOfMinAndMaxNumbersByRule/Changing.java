package com.lugowoy.tasks.solutions.arrays.onedimensional.changeSequenceByMultiplyingElementsBySquareOfMinAndMaxNumbersByRule;

import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.checking.CheckerArray;

/**
 * Created by Konstantin Lugowoy on 25.03.2017.
 */
@FunctionalInterface
public interface Changing<T> {

    void change(T t, int firstArg, int secondArg);

    static void changeSequenceByMultiplyingElementsBySquareOfMinAndMaxNumberByRule(ArrayInts array, int squareMinNumber,
                                                                                                    int squareMaxNumber) {
        if (CheckerArray.checkLengthInArray(array)) {
            for (int i = 0; i < array.size(); i++) {
                if (array.get(i) >= 0) {
                    array.set(i, array.get(i) * squareMinNumber);
                } else if (array.get(i) <= 0) {
                    array.set(i, array.get(i) * squareMaxNumber);
                }
            }
        }
    }

}

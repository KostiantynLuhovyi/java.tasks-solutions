package com.lugowoy.tasks.solutions.arrays.onedimensional.changeSequenceByMultiplyingElementsBySquareOfMinAndMaxNumbersByRule;

import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.checking.CheckerArray;

/**
 * Given integers a1, a2, ..., an.
 * It is required to multiply all the terms of the sequence a1, a2, ... by the square of its smallest term, if ak ≥ 0,
 * and the square of its largest term, if ak ≤ 0.
 *
 * <p>Created by Konstantin Lugowoy on 25.03.2017.
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

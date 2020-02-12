package com.lugowoy.tasks.solutions.arrays.onedimensional.changeSequenceByMultiplyingElementsBySquareOfMinAndMaxNumbersByRule;

import com.lugowoy.helper.models.storages.arrays.AbstractArray;
import com.lugowoy.helper.models.storages.arrays.ArrayDoubles;
import com.lugowoy.helper.utils.checking.CheckerArray;

import java.math.BigDecimal;

/**
 * Created by Konstantin Lugowoy on 25.03.2017.
 */
@FunctionalInterface
public interface MultiplyingSequenceElementsByRule<T extends AbstractArray, K extends Number> {

    T multiply(T t, K firstArg, K secondArg);

    static ArrayDoubles multiplySequenceElementsBySquareOfMinAndMaxNumberByRule(ArrayDoubles array, double squareMinNumber,
                                                                                                    double squareMaxNumber) {
        if (CheckerArray.checkLengthInArray(array)) {
            for (int i = 0; i < array.size(); i++) {
                if (array.get(i) >= 0) {
                    array.set(i, multiplyElementBySquareNumber(array.get(i), squareMinNumber).doubleValue());
                } else if (array.get(i) <= 0) {
                    array.set(i, multiplyElementBySquareNumber(array.get(i), squareMaxNumber).doubleValue());
                }
            }
        }
        return array;
    }

    private static <K extends Number> BigDecimal multiplyElementBySquareNumber(K element, K squareNumber) {
        return new BigDecimal(element.doubleValue()).multiply(new BigDecimal(squareNumber.doubleValue()));
    }


}

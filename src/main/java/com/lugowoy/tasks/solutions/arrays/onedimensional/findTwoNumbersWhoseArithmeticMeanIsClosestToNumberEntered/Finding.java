package com.lugowoy.tasks.solutions.arrays.onedimensional.findTwoNumbersWhoseArithmeticMeanIsClosestToNumberEntered;

import com.lugowoy.helper.checkers.CheckerArray;
import com.lugowoy.helper.models.arrays.AbstractArray;
import com.lugowoy.helper.models.arrays.ArrayDoubles;
import com.lugowoy.helper.utils.Capacity;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Konstantin Lugowoy on 12.04.2017.
 */
@FunctionalInterface
public interface Finding<T extends AbstractArray, V extends Number> {

    void find(@NotNull final T tArray, @NotNull final V vNumber);

    static void findTwoNumbersWhoseArithmeticMeanIsClosestToNumber(
            @NotNull final ArrayDoubles array, double number) {
        CheckerArray.check(array, Capacity.UPPER.get());
        double diff = (array.get(0) + array.get(1)) / 2 - number;
        double firstNumber = array.get(0);
        double secondNumber = array.get(1);
        double temp;
        for (int i = 0; i < array.size(); i++) {
            for (int j = i + 1; j < array.size(); j++) {
                temp = (array.get(i) + array.get(j)) / 2 - number;
                if (Math.abs(temp) < Math.abs(diff)) {
                    diff = temp;
                    firstNumber = array.get(i);
                    secondNumber = array.get(j);
                }
            }
        }
        System.out.println("Result numbers : " + firstNumber
                           + " and " + secondNumber + " .");
    }

}

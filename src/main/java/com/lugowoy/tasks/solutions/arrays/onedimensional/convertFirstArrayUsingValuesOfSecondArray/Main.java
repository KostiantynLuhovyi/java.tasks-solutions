package com.lugowoy.tasks.solutions.arrays.onedimensional.convertFirstArrayUsingValuesOfSecondArray;

import com.lugowoy.helper.checkers.CheckerArray;
import com.lugowoy.helper.execution.Executor;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.array.numbers.primitives.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.models.arrays.AbstractArray;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.Capacity;
import com.lugowoy.helper.utils.HelperArrayFiller;

/**
 * Given integers a1, a2, ..., an and b1, b2, ..., bn. Convert the sequence b1,
 * b2, ..., bn by the rule: if ai ≤ 0, then bi is increased by a factor of 10
 * otherwise bi is replaced by zero.
 *
 * <p>Created by Konstantin Lugowoy on 25.03.2017.
 */
public class Main {

    private static final int LOWER_BOUND = -20;
    private static final int UPPER_BOUND = 20;

    public static void main(String[] args) {

        HelperArrayFiller fillerArray = new HelperArrayFiller();

        ArrayInts firstArray = new ArrayInts(fillerArray.getArray(
                new FillingArrayRandomPrimitiveIntegers(),
                AbstractArray.DEFAULT_CAPACITY, LOWER_BOUND, UPPER_BOUND));

        System.out.println("First array : \n" + firstArray + "\n");

        ArrayInts secondArray = new ArrayInts(fillerArray.getArray(
                new FillingArrayRandomPrimitiveIntegers(),
                AbstractArray.DEFAULT_CAPACITY, LOWER_BOUND, UPPER_BOUND));

        System.out.println("Second array : \n" + secondArray + "\n");

        new Executor().execute(() -> {
            CheckerArray.check(firstArray, Capacity.UPPER.get());
            CheckerArray.check(secondArray, Capacity.UPPER.get());
            if (firstArray.size() == secondArray.size()) {
                for (int i = 0; i < firstArray.size(); i++) {
                    if (firstArray.get(i) <= 0) {
                        secondArray.set(i, secondArray.get(i) * 10);
                    } else {
                        secondArray.set(i, 0);
                    }
                }
            } else {
                throw new IllegalArgumentException("Sizes of arrays are not equal.");
            }
            System.out.println(
                    "Result second array after converting : \n" + secondArray);
        }, new OutputExecutionTimeToConsole());
    }

}

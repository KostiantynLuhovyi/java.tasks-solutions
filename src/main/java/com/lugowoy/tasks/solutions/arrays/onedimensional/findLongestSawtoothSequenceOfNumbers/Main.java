package com.lugowoy.tasks.solutions.arrays.onedimensional.findLongestSawtoothSequenceOfNumbers;

import com.lugowoy.helper.checkers.CheckerArray;
import com.lugowoy.helper.execution.Executor;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.array.numbers.primitives.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.Capacity;
import com.lugowoy.helper.utils.HelperArrayFiller;
import com.lugowoy.helper.utils.HelperFillerValues;
import com.lugowoy.helper.utils.ReaderArrayLength;
import org.jetbrains.annotations.NotNull;

/**
 * Find the length of the longest "sawtooth" sequence of successive numbers
 * Xk <Xk + 1> Xk + 2> ...> Xk + m <Xk + m + 1 <... <Xn.
 *
 * <p>Created by Konstantin Lugowoy on 27.06.2017.
 */
public class Main {

    private static final int BOUND = 100;

    public static void main(String[] args) {

        ReaderArrayLength readerLength = new ReaderArrayLength();
        int lengthArray = readerLength.read(System.in, System.out,
                                            ReaderArrayLength.MSG_ENTER_ARRAY_LENGTH);

        HelperArrayFiller filler = new HelperArrayFiller();

        ArrayInts array = new ArrayInts(filler.getArray(
                new FillingArrayRandomPrimitiveIntegers(), lengthArray,
                HelperFillerValues.INT_ZERO, BOUND));

        System.out.println("Array: " + array + "\n");

        new Executor().execute(() -> {
            System.out.printf("The length of the longest sawtooth sequence is %d .",
                              findLengthSawOfArrayElements(array));
        }, new OutputExecutionTimeToConsole());

    }

    private static int findLengthSawOfArrayElements(@NotNull final ArrayInts array) {
        int lengthSaw = 0, maxLengthSaw = 0;
        boolean isPrev = false;
        CheckerArray.check(array, Capacity.UPPER.get());
        for (int i = 1; i < array.size() - 1; i++) {
                if ((array.get(i - 1) < array.get(i))
                        && (array.get(i) > array.get(i + 1))) {
                    if (isPrev) {
                        lengthSaw += 2;
                    } else {
                        lengthSaw = 3;
                        isPrev = true;
                    }
                    i++;
                } else {
                    isPrev = false;
                    maxLengthSaw = Math.max(maxLengthSaw, lengthSaw);
                }
            }
        return Math.max(maxLengthSaw, lengthSaw);
    }

}

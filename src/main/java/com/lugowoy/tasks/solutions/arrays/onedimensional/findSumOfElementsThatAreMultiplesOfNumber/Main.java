package com.lugowoy.tasks.solutions.arrays.onedimensional.findSumOfElementsThatAreMultiplesOfNumber;

import com.lugowoy.helper.checkers.CheckerArray;
import com.lugowoy.helper.execution.Executor;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.array.numbers.primitives.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.Capacity;
import com.lugowoy.helper.utils.HelperArrayFiller;
import com.lugowoy.helper.utils.HelperFillerValues;
import com.lugowoy.helper.utils.ReaderArrayLength;
import com.lugowoy.helper.utils.ReaderConsole;
import org.jetbrains.annotations.NotNull;

/**
 * Given an array of numbers. Find the sum of the elements that are multiples of to this K.
 *
 * <p>Created by Konstantin Lugowoy on 12-Feb-17.
 */
public class Main {

    private static final int BOUND = 50;

    public static void main(String[] args) {

        ReaderArrayLength readerLength = new ReaderArrayLength();
        int lengthArray = readerLength.read(System.in, System.out,
                                              ReaderArrayLength.MSG_ENTER_ARRAY_LENGTH);

        HelperArrayFiller filler = new HelperArrayFiller();

        ArrayInts array = new ArrayInts(filler.getArray(
                new FillingArrayRandomPrimitiveIntegers(), lengthArray,
                HelperFillerValues.INT_ZERO, BOUND));

        System.out.println("Array: " + array + "\n");

        System.out.println("Enter K number : ");
        int K = new ReaderConsole().readInt();

        new Executor().execute(() -> {
        System.out.println("Result : " +
                           calculateSumOfElementsThatAreMultiplesOfNumber(array, K));
        }, new OutputExecutionTimeToConsole());

    }

    private static int calculateSumOfElementsThatAreMultiplesOfNumber(
            @NotNull final ArrayInts array, final int numberK) {
        int resultSumElements = 0;
        CheckerArray.check(array, Capacity.UPPER.get());
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) % numberK == 0) {
                resultSumElements += array.get(i);
            }
        }
        return resultSumElements;
    };

}

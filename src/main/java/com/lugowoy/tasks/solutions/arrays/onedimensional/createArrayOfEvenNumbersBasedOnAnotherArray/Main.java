package com.lugowoy.tasks.solutions.arrays.onedimensional.createArrayOfEvenNumbersBasedOnAnotherArray;

import com.lugowoy.helper.checkers.CheckerArray;
import com.lugowoy.helper.execution.Executor;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.array.numbers.primitives.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.Capacity;
import com.lugowoy.helper.utils.HelperArrayFiller;
import com.lugowoy.helper.utils.HelperFillerValues;
import com.lugowoy.helper.utils.ReaderArrayLength;

/**
 * Given a array of positive numbers a1, a2, ..., an. Create an array of even
 * numbers of this array.
 *
 * <p>Created by Konstantin Lugowoy on 13-Feb-17.
 */

public class Main {

    public static void main(String[] args) {

        ReaderArrayLength readerArrayLength = new ReaderArrayLength();
        int lengthArray = readerArrayLength.read(System.in, Capacity.UPPER.get(),
                                                 System.out, ReaderArrayLength.MSG_ENTER_ARRAY_LENGTH);

        HelperArrayFiller fillerArray = new HelperArrayFiller();

        ArrayInts array = new ArrayInts(fillerArray.getArray(
                new FillingArrayRandomPrimitiveIntegers(), lengthArray,
                HelperFillerValues.INT_ZERO,
                HelperFillerValues.INT_POSITIVE_HUNDRED));

        System.out.println("Array : \n" + array + "\n");

        new Executor().execute(() -> {
            ArrayInts evenNumbersArray = getArrayWithEvenNumbers(array);
            System.out.println("Even numbers of original array : \n" + evenNumbersArray);
        }, new OutputExecutionTimeToConsole());

    }

    private static ArrayInts getArrayWithEvenNumbers(ArrayInts array) {
        ArrayInts resultArray = new ArrayInts(0);
        CheckerArray.check(array, Capacity.UPPER.get());
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) % 2 == 0) {
                resultArray.add(array.get(i));
            }
        }
        return resultArray;
    }

}

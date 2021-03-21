package com.lugowoy.tasks.solutions.arrays.onedimensional.createArrayOfZeroElementsOfAnotherArray;

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
 * There are zero elements in an integer array. Create an array of the index of
 * these elements.
 *
 * <p>Created by Konstantin Lugowoy on 12-Feb-17.
 */
public class Main {

    public static void main(String[] args) {

        ReaderArrayLength readerArrayLength = new ReaderArrayLength();
        int lengthArray = readerArrayLength.read(System.in,
                                                 Capacity.UPPER.get(),
                                                 System.out,
                                                 ReaderArrayLength.MSG_ENTER_ARRAY_LENGTH);

        HelperArrayFiller fillerArray = new HelperArrayFiller();

        ArrayInts array = new ArrayInts(fillerArray.getArray(
                new FillingArrayRandomPrimitiveIntegers(), lengthArray,
                HelperFillerValues.INT_NEGATIVE_ONE,
                HelperFillerValues.INT_POSITIVE_ONE));

        System.out.println("Array : \n" + array + "\n");

        new Executor().execute(() -> {
            ArrayInts resultArray = FILLING.fillArray(array);

            if (resultArray.size() != 0) {
                System.out.print("Index of zero elements of the original array : ");
                for (int i = 0; i < resultArray.size(); i++) {
                    System.out.print(resultArray.get(i) + " ");
                }
            } else {
                System.out.println("It does not contain zero elements.");
            }
        }, new OutputExecutionTimeToConsole());

    }

    private static final Filling<ArrayInts> FILLING = originalArray -> {
        ArrayInts tmpArray = new ArrayInts(0);
        CheckerArray.check(originalArray, Capacity.UPPER.get());
        for (int i = 0; i < originalArray.size(); i++) {
            if (originalArray.get(i) == 0) {
                tmpArray.add(i);
            }
        }
        return tmpArray;
    };

}

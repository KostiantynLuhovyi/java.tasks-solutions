package com.lugowoy.tasks.solutions.arrays.onedimensional.sortArrayInAscendingOrderWithoutChangingTheirRelativePosition;

import com.lugowoy.helper.execution.Executor;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.array.numbers.primitives.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.HelperArrayFiller;
import com.lugowoy.helper.utils.HelperFillerValues;
import com.lugowoy.helper.utils.ReaderArrayLength;

/**
 * In a one-dimensional array, rearrange the elements so that negative elements are first located, then zero, and then positive.
 * The relative arrangement of the elements does not change.
 *
 * <p>Created by Konstantin Lugowoy on 14.05.2017.
 */
public class Main {

    public static void main(String[] args) {

        ReaderArrayLength readerLength = new ReaderArrayLength();
        int lengthArray = readerLength.read(System.in, System.out,
                                            ReaderArrayLength.MSG_ENTER_ARRAY_LENGTH);

        HelperArrayFiller filler = new HelperArrayFiller();

        ArrayInts array = new ArrayInts(filler.getArray(
                new FillingArrayRandomPrimitiveIntegers(), lengthArray,
                HelperFillerValues.INT_NEGATIVE_HUNDRED,
                HelperFillerValues.INT_POSITIVE_HUNDRED));

        System.out.println("Array : " + array + "\n");

        new Executor().execute(() -> {
            Sorting sorting = Sorting::sortArrayInAscendingOrderWithoutChangingTheirRelativePosition;
            sorting.sort(array);

            System.out.println("After sorting : " + array);
        }, new OutputExecutionTimeToConsole());

    }

}

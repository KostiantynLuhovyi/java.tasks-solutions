package com.lugowoy.tasks.solutions.arrays.onedimensional.determineElementsThatAreEqualToHalfSumOfNeighboringElements;

import com.lugowoy.helper.execution.Executor;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.array.numbers.primitives.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.Capacity;
import com.lugowoy.helper.utils.HelperArrayFiller;
import com.lugowoy.helper.utils.HelperFillerValues;
import com.lugowoy.helper.utils.ReaderArrayLength;

/**
 * Determine the elements that are equal to the half-sum of the neighboring
 * elements.
 *
 * <p>Created by Konstantin Lugowoy on 03.09.2017.
 */
public class Main {

    private static final Determinant<ArrayInts> DETERMINANT =
            Determinant::determineElementsEqualToHalfSumOfNeighboringElements;

    private static final int BOUND = 20;

    public static void main(String[] args) {

        ReaderArrayLength readerArrayLength = new ReaderArrayLength();

        int lengthArray = readerArrayLength.read(System.in, System.out,
                                                 ReaderArrayLength.MSG_ENTER_ARRAY_LENGTH);

        HelperArrayFiller fillerArray = new HelperArrayFiller();

        ArrayInts array = new ArrayInts(fillerArray.getArray(
                new FillingArrayRandomPrimitiveIntegers(),
                lengthArray, HelperFillerValues.INT_ZERO, BOUND));

        System.out.println("Original array : " + array);

        new Executor().execute(() -> {
            System.out.println("Result : ");
            DETERMINANT.determine(array);
        }, new OutputExecutionTimeToConsole());

    }

}

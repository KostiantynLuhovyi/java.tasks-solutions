package com.lugowoy.tasks.solutions.arrays.onedimensional.determineNumberOfDifferentElementsInOneDimensionalArray;

import com.lugowoy.helper.execution.Executor;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.array.numbers.primitives.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.HelperArrayFiller;
import com.lugowoy.helper.utils.HelperFillerValues;
import com.lugowoy.helper.utils.ReaderArrayLength;

/**
 * Given a one-dimensional array of numbers. Find the number of different
 * numbers in this array.
 *
 * <p>Created by Konstantin Lugowoy on 28.05.2017.
 */
public class Main {

    private static final Determinant<ArrayInts> DETERMINANT =
            Determinant::determineNumberDifferentElementsInArray;

    public static void main(String[] args) {

        ReaderArrayLength readerLength = new ReaderArrayLength();
        int lengthArray = readerLength.read(System.in, System.out,
                                            ReaderArrayLength.MSG_ENTER_ARRAY_LENGTH);

        HelperArrayFiller fillerArray = new HelperArrayFiller();

        ArrayInts array = new ArrayInts(fillerArray.getArray(
                new FillingArrayRandomPrimitiveIntegers(), lengthArray,
                HelperFillerValues.INT_NEGATIVE_TEN,
                HelperFillerValues.INT_POSITIVE_TEN));

        System.out.println(array);

        new Executor().execute(() -> {
            int differentElements = DETERMINANT.determine(array);
            System.out.printf("In a array of %d different elements.", differentElements);
        }, new OutputExecutionTimeToConsole());

    }

}

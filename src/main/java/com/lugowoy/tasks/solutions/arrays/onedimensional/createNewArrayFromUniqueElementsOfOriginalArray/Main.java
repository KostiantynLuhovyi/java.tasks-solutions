package com.lugowoy.tasks.solutions.arrays.onedimensional.createNewArrayFromUniqueElementsOfOriginalArray;

import com.lugowoy.helper.execution.Executor;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.array.numbers.primitives.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.Capacity;
import com.lugowoy.helper.utils.HelperArrayFiller;
import com.lugowoy.helper.utils.HelperFillerValues;
import com.lugowoy.helper.utils.ReaderArrayLength;

/**
 * Given a one-dimensional array of numbers, among the elements of which are the
 * same. Create a new array from the various elements of the original array.
 *
 * <p>Created by Konstantin Lugowoy on 29.05.2017.
 */
public class Main {

    private static final DeterminantUniqueness<ArrayInts> DETERMINANT =
            DeterminantUniqueness::determineUniqueElementsOfArray;

    public static void main(String[] args) {

        ReaderArrayLength readerArrayLength = new ReaderArrayLength();
        int lengthArray = readerArrayLength.read(System.in, Capacity.UPPER.get(),
                                                 System.out, ReaderArrayLength.MSG_ENTER_ARRAY_LENGTH);

        HelperArrayFiller fillerArray = new HelperArrayFiller();

        ArrayInts array = new ArrayInts(fillerArray.getArray(
                new FillingArrayRandomPrimitiveIntegers(), lengthArray,
                HelperFillerValues.INT_NEGATIVE_TEN,
                HelperFillerValues.INT_POSITIVE_TEN));

        System.out.println("Array : \n" + array + "\n");

        new Executor().execute(() -> {
            ArrayInts newArrayFromTheUniqueElements = DETERMINANT.determineUniqueness(array);
            System.out.println("New array from the unique elements : \n"
                               + newArrayFromTheUniqueElements);
        }, new OutputExecutionTimeToConsole());
    }

}

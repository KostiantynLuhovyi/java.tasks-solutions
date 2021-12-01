package com.lugowoy.tasks.solutions.arrays.onedimensional.createOrderedArrayFromElementsOfOtherArrays;

import com.lugowoy.helper.execution.Executor;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.array.numbers.primitives.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.Capacity;
import com.lugowoy.helper.utils.HelperArrayFiller;
import com.lugowoy.helper.utils.HelperFillerValues;
import com.lugowoy.helper.utils.ReaderArrayLength;

import java.util.Arrays;

/**
 * Given two ordered arrays A and B. Form from the elements of these arrays an
 * ordered array C.
 *
 * <p>Created by Konstantin Lugowoy on 30.05.2017.
 */
public class Main {

    private static final String MSG_ENTER_FIRST_ARRAY_LENGTH =
            "Enter length of the first array : ";
    private static final String MSG_ENTER_SECOND_ARRAY_LENGTH =
            "Enter length of the second array : ";

    public static void main(String[] args) {

        ReaderArrayLength readerArrayLength = new ReaderArrayLength();

        int lengthFirstArray = readerArrayLength.read(System.in, Capacity.UPPER.get(),
                                                      System.out, MSG_ENTER_FIRST_ARRAY_LENGTH);

        int lengthSecondArray = readerArrayLength.read(System.in, Capacity.UPPER.get(),
                                                       System.out, MSG_ENTER_SECOND_ARRAY_LENGTH);

        HelperArrayFiller fillerArray = new HelperArrayFiller();

        int[] firstInts = fillerArray.getArray(new FillingArrayRandomPrimitiveIntegers(),
                                               lengthFirstArray,
                                               HelperFillerValues.INT_NEGATIVE_TEN,
                                               HelperFillerValues.INT_POSITIVE_TEN);
        Arrays.sort(firstInts);
        ArrayInts firstArray = new ArrayInts(firstInts);
        System.out.println("First array : \n" + firstArray + "\n");

        int[] secondInts = fillerArray.getArray(new FillingArrayRandomPrimitiveIntegers(),
                                                lengthSecondArray,
                                                HelperFillerValues.INT_NEGATIVE_TEN,
                                                HelperFillerValues.INT_POSITIVE_TEN);

        Arrays.sort(secondInts);
        ArrayInts secondArray = new ArrayInts(secondInts);
        System.out.println("Second array : \n" + secondArray + "\n");

        new Executor().execute(() -> {
            MergingArrays<ArrayInts> merging = MergingArrays::mergeArrays;
            ArrayInts resultArray = merging.merge(firstArray, secondArray);

            System.out.println("Result array : " + resultArray);
        }, new OutputExecutionTimeToConsole());

    }

}

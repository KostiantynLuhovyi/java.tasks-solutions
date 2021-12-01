package com.lugowoy.tasks.solutions.arrays.onedimensional.determineNumberOfElementsThatAreIdenticalInTwoSequences;

import com.lugowoy.helper.execution.Executor;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.array.numbers.primitives.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.HelperArrayFiller;
import com.lugowoy.helper.utils.HelperFillerValues;
import com.lugowoy.helper.utils.ReaderArrayLength;

/**
 * Two sequences of integers a1, a2, ..., an and b1, b2, ..., bm are given. All
 * the members of the sequences are distinct numbers. Find how many elements of
 * the first sequence coincide with the elements of the second sequence.
 *
 * <p>Created by Konstantin Lugowoy on 30.05.2017.
 */
public class Main {

    private static final Determinant<ArrayInts> DETERMINANT =
            Determinant::determineElementsThatAreIdenticalInTwoArray;

    private static final int BOUND = 50;

    public static void main(String[] args) {

        ReaderArrayLength readerLength = new ReaderArrayLength();
        int lengthFirstArray = readerLength.read(System.in, System.out,
                                                 ReaderArrayLength.MSG_ENTER_ARRAY_LENGTH);

        int lengthSecondArray = readerLength.read(System.in, System.out,
                                                  ReaderArrayLength.MSG_ENTER_ARRAY_LENGTH);

        HelperArrayFiller fillerArray = new HelperArrayFiller();

        ArrayInts firstArray = new ArrayInts(fillerArray.getArray(
                new FillingArrayRandomPrimitiveIntegers(), lengthFirstArray,
                HelperFillerValues.INT_ZERO, BOUND));
        ArrayInts secondArray = new ArrayInts(fillerArray.getArray(
                new FillingArrayRandomPrimitiveIntegers(), lengthSecondArray,
                HelperFillerValues.INT_ZERO, BOUND));

        System.out.println("First array : " + firstArray);
        System.out.println("Second array : " + secondArray);

        new Executor().execute(() -> {
            System.out.println("Number of identical elements in the two array : "
                               + DETERMINANT.determine(firstArray, secondArray));
        }, new OutputExecutionTimeToConsole());

    }

}

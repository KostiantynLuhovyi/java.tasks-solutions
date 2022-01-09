package com.lugowoy.tasks.solutions.arrays.onedimensional.determineWhetherElementsOfSecondSequenceInFirstSequence;

import com.lugowoy.helper.execution.Executor;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.array.numbers.primitives.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.HelperArrayFiller;
import com.lugowoy.helper.utils.HelperFillerValues;
import com.lugowoy.helper.utils.ReaderArrayLength;

/**
 * Two sequences a1, a2, ..., an and b1, b2, ..., bm (m <n) are given.
 * In each of them, the members are different.
 * Is it true that all members of the second sequence are in the first sequence?
 *
 * <p>Created by Konstantin Lugowoy on 12.04.2017.
 */
public class Main {

    private static final DeterminantContainsArrays<ArrayInts> DETERMINANT =
            DeterminantContainsArrays::determineFirstArrayContainsSecondArray;

    private static final int BOUND = 50;

    public static void main(String[] args) {

        ReaderArrayLength readerArrayLength = new ReaderArrayLength();

        int lengthFirstArray = readerArrayLength.read(System.in, System.out,
                                                      "Enter length of the first array : ");

        int lengthSecondArray = readerArrayLength.read(System.in, System.out,
                                                       "Enter length of the second array : ");

        HelperArrayFiller filler = new HelperArrayFiller();

        ArrayInts firstArray = new ArrayInts(filler.getArray(
                new FillingArrayRandomPrimitiveIntegers(), lengthFirstArray,
                HelperFillerValues.INT_ZERO, BOUND));

        ArrayInts secondArray = new ArrayInts(filler.getArray(
                new FillingArrayRandomPrimitiveIntegers(), lengthSecondArray,
                HelperFillerValues.INT_ZERO, BOUND));

        System.out.println("First : " + firstArray);
        System.out.println("Second : " + secondArray);
        System.out.println();

        new Executor().execute(() -> {
            boolean resultDetermine = DETERMINANT.determine(firstArray, secondArray);

            if (resultDetermine) {
                System.out.println("Elements of the second sequence are included in the first sequence.");
            } else {
                System.out.println("Elements of the second sequence are not included in the first sequence.");
            }
        }, new OutputExecutionTimeToConsole());

    }

}

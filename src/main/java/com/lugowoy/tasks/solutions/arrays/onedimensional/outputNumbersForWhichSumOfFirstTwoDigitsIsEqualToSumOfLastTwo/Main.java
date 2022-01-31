package com.lugowoy.tasks.solutions.arrays.onedimensional.outputNumbersForWhichSumOfFirstTwoDigitsIsEqualToSumOfLastTwo;

import com.lugowoy.helper.filling.array.numbers.primitives.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.HelperArrayFiller;
import com.lugowoy.helper.utils.ReaderArrayLength;

import java.util.Arrays;

/**
 * An array of n four-digit natural numbers is given.
 * Output to display only numbers those on which the sum of the first two digits is equal to the sum of the last two digits.
 *
 * <p>Created by Konstantin Lugowoy on 29.05.2017.
 */
public class Main {

    private static final int START_BOUND = 1000;
    private static final int END_BOUND = 10000;

    public static void main(String[] args) {

        ReaderArrayLength readerLength = new ReaderArrayLength();
        int lengthArray = readerLength.read(System.in, System.out,
                                            ReaderArrayLength.MSG_ENTER_ARRAY_LENGTH);

        HelperArrayFiller filler = new HelperArrayFiller();
        ArrayInts array = new ArrayInts(filler.getArray(new FillingArrayRandomPrimitiveIntegers(), lengthArray, START_BOUND, END_BOUND));

        System.out.println(array);

        System.out.println("Result numbers for which the sum of the first two digits"
                           + "is equal to the sum of the last two : ");
        Determinant determinant =
                Determinant::determineFirstTwoDigitsIsEqualLastTwo;
        Arrays.stream(array.toArray(new int[array.size()])).forEachOrdered(value -> {
            if (determinant.determine(value)) {
                System.out.print(value + " ");
            }
        });

    }

}

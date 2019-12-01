package com.lugowoy.tasks.solutions.arrays.onedimensional.outputNumbersForWhichSumOfFirstTwoDigitsIsEqualToSumOfLastTwo;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.ArrayLengthReader;

import java.util.Arrays;

/**
 * An array of n four-digit natural numbers is given.
 * Output to display only numbers those on which the sum of the first two digits is equal to the sum of the last two digits.
 *
 * <p> Created by Konstantin Lugowoy on 29.05.2017.
 */

public class Main {

    private static final int START_BOUND = 1000;
    private static final int END_BOUND = 10000;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = ArrayLengthReader.readLength(new ReadingConsole());

        ArrayInts array = new ArrayInts(new FillingArrayRandomPrimitiveIntegers().fill(lengthOfArray, START_BOUND, END_BOUND));

        System.out.println("Original array : " + array);
        System.out.println();

        System.out.println("Result numbers for which the sum of the first two digits is equal to the sum of the last two : ");
        Determinant determinant = Determinant::determineNumbersForWhichTheSumOfTheFirstTwoDigitsIsEqualToTheSumOfTheLastTwo;
        Arrays.stream(array.toArray(new int[array.size()])).forEachOrdered(value -> {
            if (determinant.determine(value)) {
                System.out.print(value + " ");
            }
        });

    }

}

package com.lugowoy.tasks.solutions.core.determinePeriodOfDecimalFractionForFirstTwoPositiveIntegersLocatedInRow;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.Array;
import com.lugowoy.helper.utils.ArrayLengthReader;

/**
 * Determine the period of the decimal fraction p = m / n for the first two positive integers n and m located in a series.
 * <p>
 * Created by Konstantin Lugowoy on 03.09.2017.
 */

public class Main {

    private static final int START_BOUND = 0;
    private static final int END_BOUND = 2;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = ArrayLengthReader.readLength(new ReadingConsole());

        Array<Integer> array = new Array<>(new FillingArrayRandomIntegers().fill(lengthOfArray, START_BOUND, END_BOUND));

        Determinant determinant = Determinant::determinePeriodOfDecimalFractionForFirstTwoPositiveIntegersLocatedInRow;
        determinant.determine(array);

    }

}

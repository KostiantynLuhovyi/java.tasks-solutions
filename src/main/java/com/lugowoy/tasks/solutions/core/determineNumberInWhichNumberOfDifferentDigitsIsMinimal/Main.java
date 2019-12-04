package com.lugowoy.tasks.solutions.core.determineNumberInWhichNumberOfDifferentDigitsIsMinimal;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.Array;
import com.lugowoy.helper.utils.ArrayLengthReader;

/**
 * Determine the number in which the number of different digits is minimal.
 * If there are several of them, then print the first number.
 * <p>
 * Created by Konstantin Lugowoy on 03.09.2018 .
 */

public class Main {

    private static final int BOUND = 100000;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = ArrayLengthReader.readLength(new ReadingConsole());

        Array<Integer> integerArray = new Array<>(new FillingArrayRandomIntegers().fill(lengthOfArray, BOUND));

        System.out.println("Original integer array : " + integerArray);

        Determinant determinant = Determinant::determineNumberInWhichNumberOfDifferentDigitsIsMinimal;
        System.out.println("Result number : " + determinant.determineNumber(integerArray));

    }

}

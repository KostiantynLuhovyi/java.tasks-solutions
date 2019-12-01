package com.lugowoy.tasks.solutions.arrays.onedimensional.determineGreatestCommonDivisorForArrayOfNumbers;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.ArrayLengthReader;

/**
 * Write a program that enter a sequence of integers that finds and prints their greatest common divisor.
 *
 * <p> Created by Konstantin Lugowoy on 09.05.2018.
 */

public class Main {

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = ArrayLengthReader.readLength(new ReadingConsole());

        FillingArrayRandomPrimitiveIntegers filler = new FillingArrayRandomPrimitiveIntegers();

        ArrayInts array = new ArrayInts(filler.fill(lengthOfArray));

        System.out.println("Array : " + array);

        print(DeterminantGreatestCommonDivisor::determineGreatestCommonDivisor, array);

    }

    private static void print(DeterminantGreatestCommonDivisor determinantGCD, ArrayInts array) {
        System.out.println("The greatest common divisor of the array is : " + determinantGCD.determine(array) + " .");
    }

}

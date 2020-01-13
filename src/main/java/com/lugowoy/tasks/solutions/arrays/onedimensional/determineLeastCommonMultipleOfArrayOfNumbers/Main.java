package com.lugowoy.tasks.solutions.arrays.onedimensional.determineLeastCommonMultipleOfArrayOfNumbers;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.ArrayLengthReader;

/**
 * Write a program that enter an array of integers, finds and prints their least common multiple a number.
 * <p> Created by Konstantin Lugowoy on 09.05.2018.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = ArrayLengthReader.readLength(new ReadingConsole());

        FillingArrayRandomPrimitiveIntegers filler = new FillingArrayRandomPrimitiveIntegers();

        ArrayInts array = new ArrayInts(filler.fill(lengthOfArray));

        System.out.println("Array " + array);

        printValueOfLeastCommonMultiple(DeterminantLeastCommonMultiple::determineLeastCommonMultiple, array);

    }

    private static void printValueOfLeastCommonMultiple(DeterminantLeastCommonMultiple determinantLCM, ArrayInts array) {
        System.out.println("The least common multiple of the array is : " + determinantLCM.determine(array) + " .");
    }

}

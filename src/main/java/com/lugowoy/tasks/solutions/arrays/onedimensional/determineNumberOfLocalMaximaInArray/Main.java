package com.lugowoy.tasks.solutions.arrays.onedimensional.determineNumberOfLocalMaximaInArray;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.ArrayLengthReader;

/**
 * Write a program that enter a non-empty array of integers and prints the number of local maximum
 * (an element is a local maximum if it has neighbors elements larger than itself).
 *
 * <p>Created by Konstantin Lugowoy on 07.05.2018.
 */

public class Main {

    private static final int BOUND = 200;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = ArrayLengthReader.readLength(new ReadingConsole());

        FillingArrayRandomPrimitiveIntegers filler = new FillingArrayRandomPrimitiveIntegers();

        ArrayInts array = new ArrayInts(filler.fill(lengthOfArray, BOUND));

        System.out.println("Array : " + array);

        Determinant determinant = Determinant::determineNumbersOfLocalMaximum;
        determinant.determine(array);

    }

}

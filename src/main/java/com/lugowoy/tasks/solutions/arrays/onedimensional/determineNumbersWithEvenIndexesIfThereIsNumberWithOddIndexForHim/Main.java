package com.lugowoy.tasks.solutions.arrays.onedimensional.determineNumbersWithEvenIndexesIfThereIsNumberWithOddIndexForHim;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.ArrayLengthReader;

/**
 * Write a program that enter a sequence of integers and prints numbers with even indexes if there is an equal number with an odd index.
 *
 * <p> Created by Konstantin Lugowoy on 07.05.2018.
 */

public class Main {

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = ArrayLengthReader.readLength(new ReadingConsole());

        FillingArrayRandomPrimitiveIntegers filler = new FillingArrayRandomPrimitiveIntegers();

        ArrayInts array = new ArrayInts(filler.fill(lengthOfArray));

        System.out.println("Array : " + array);

        Determinant determinant = Determinant::determineNumbersWithEvenIndexesIfThereIsNumberWithOddIndexForHim;
        determinant.determine(array);

    }

}

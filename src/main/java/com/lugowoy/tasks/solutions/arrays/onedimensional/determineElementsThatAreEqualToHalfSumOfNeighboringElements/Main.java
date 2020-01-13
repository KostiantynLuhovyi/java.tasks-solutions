package com.lugowoy.tasks.solutions.arrays.onedimensional.determineElementsThatAreEqualToHalfSumOfNeighboringElements;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.ArrayLengthReader;

/**
 * Determine the elements that are equal to the half-sum of the neighboring elements.
 * <p> Created by Konstantin Lugowoy on 03.09.2017.
 */
public class Main {

    private static final Determinant DETERMINANT = Determinant::determineElementsThatAreEqualToHalfSumOfNeighboringElements;

    private static final int BOUND = 20;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = ArrayLengthReader.readLength(new ReadingConsole());

        FillingArrayRandomPrimitiveIntegers filler = new FillingArrayRandomPrimitiveIntegers();

        ArrayInts array = new ArrayInts(filler.fill(lengthOfArray, BOUND));

        System.out.println("Original array : " + array);

        System.out.println("Result : ");
        DETERMINANT.determine(array);

    }

}

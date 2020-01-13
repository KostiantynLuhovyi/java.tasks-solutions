package com.lugowoy.tasks.solutions.arrays.onedimensional.determineNumberOfDifferentElementsInOneDimensionalArray;

import com.lugowoy.helper.filling.ValuesToFilling;
import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.ArrayLengthReader;

import static com.lugowoy.helper.filling.ValuesToFilling.INT_LOWER_BOUND;
import static com.lugowoy.helper.filling.ValuesToFilling.INT_UPPER_BOUND;

/**
 * Given a one-dimensional array of numbers. Find the number of different numbers in this array.
 * <p> Created by Konstantin Lugowoy on 28.05.2017.
 */
public class Main {

    private static final Determinant DETERMINANT = Determinant::determineTheNumberOfDifferentElementsInOneDimensionalArray;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = ArrayLengthReader.readLength(new ReadingConsole());

        FillingArrayRandomPrimitiveIntegers filler = new FillingArrayRandomPrimitiveIntegers();

        ArrayInts array = new ArrayInts(filler.fill(lengthOfArray, INT_LOWER_BOUND, INT_UPPER_BOUND));

        System.out.println(array);

        int numberOfDifferentElements = DETERMINANT.determine(array);

        System.out.printf("In a one-dimensional array of %d different elements.", numberOfDifferentElements);

    }

}

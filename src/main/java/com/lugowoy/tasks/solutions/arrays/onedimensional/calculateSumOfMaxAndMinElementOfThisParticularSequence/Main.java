package com.lugowoy.tasks.solutions.arrays.onedimensional.calculateSumOfMaxAndMinElementOfThisParticularSequence;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.ArrayLengthReader;

import static com.lugowoy.helper.filling.ValuesToFilling.INT_LOWER_BOUND;
import static com.lugowoy.helper.filling.ValuesToFilling.INT_UPPER_BOUND;

/**
 * Given onedimensional array A[n].
 * Find: max(a2, a4, ..., a2k) + min(a1, a3, ..., a2k-1).
 * <p> Created by Konstantin Lugowoy on 01.03.2017.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = ArrayLengthReader.readLength(new ReadingConsole());

        FillingArrayRandomPrimitiveIntegers filler = new FillingArrayRandomPrimitiveIntegers();

        ArrayInts array = new ArrayInts(filler.fill(lengthOfArray, INT_LOWER_BOUND, INT_UPPER_BOUND));

        System.out.println("Original : " + array);
        System.out.println();

        Determinant<ArrayInts, Integer> determinant = Determinant::determineMaxElement;
        int maxElement = determinant.determine(array);
        System.out.println("Max element in the array is " + maxElement);

        determinant = Determinant::determineMinElement;
        int minElement = determinant.determine(array);
        System.out.println("Min element in the array is " + minElement);

        System.out.println();

        System.out.println("Result summation : " + (maxElement + minElement));

    }

}

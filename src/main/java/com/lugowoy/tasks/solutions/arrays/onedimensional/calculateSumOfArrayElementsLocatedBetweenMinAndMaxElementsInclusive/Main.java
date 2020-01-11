package com.lugowoy.tasks.solutions.arrays.onedimensional.calculateSumOfArrayElementsLocatedBetweenMinAndMaxElementsInclusive;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.ArrayLengthReader;
import com.lugowoy.helper.utils.checking.CheckerArray;

import static com.lugowoy.helper.filling.ValuesToFilling.INT_LOWER_BOUND;
import static com.lugowoy.helper.filling.ValuesToFilling.INT_UPPER_BOUND;

/**
 * Calculate the sum of array elements located between the minimum and maximum elements inclusive.
 * <p> Created by Konstantin Lugowoy on 27.03.2017.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = ArrayLengthReader.readLength(new ReadingConsole());

        FillingArrayRandomPrimitiveIntegers filler = new FillingArrayRandomPrimitiveIntegers();

        ArrayInts array = new ArrayInts(filler.fill(lengthOfArray, INT_LOWER_BOUND, INT_UPPER_BOUND));

        System.out.println("Original array : " + array);
        System.out.println();

        Determinant determinant = Determinant::determineMinElementIndex;
        int indexMinElement = determinant.determine(array);
        System.out.println("Index min element in the array is : " + indexMinElement);

        determinant = Determinant::determineMaxElementIndex;
        int indexMaxElement = determinant.determine(array);
        System.out.println("Index max element in the array is : " + indexMaxElement);

        System.out.println();

        CALCULATING.calculate(array, indexMinElement, indexMaxElement);

    }

    private static final Calculating CALCULATING = (ArrayInts array, int indexMinElement, int indexMaxElement) -> {
        int resultSum = 0;
        if (CheckerArray.checkLengthInArray(array)) {
            if (indexMinElement <= indexMaxElement) {
                for (int i = indexMinElement; i <= indexMaxElement; i++) {
                    resultSum += array.get(i);
                }
                System.out.printf("Sum of array elements located between the min and max elements inclusive is : %d .", resultSum);
            } else {
                System.out.println("The index of the min value is greater or equal than the index of the max value.");
            }
        }
        return resultSum;
    };

}

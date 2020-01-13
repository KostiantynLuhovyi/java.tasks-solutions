package com.lugowoy.tasks.solutions.arrays.onedimensional.determineSequenceOfNumbersIsIncreasing;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.ArrayLengthReader;

import static com.lugowoy.helper.filling.ValuesToFilling.INT_LOWER_BOUND;
import static com.lugowoy.helper.filling.ValuesToFilling.INT_UPPER_BOUND;

/**
 * Given a sequence of integer numbers a1, a2, ..., an. Determine whether it is increasing.
 * <p> Created by Konstantin Lugowoy on 13-Feb-17.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = ArrayLengthReader.readLength(new ReadingConsole());

        FillingArrayRandomPrimitiveIntegers filler = new FillingArrayRandomPrimitiveIntegers();

        ArrayInts array = new ArrayInts(filler.fill(lengthOfArray, INT_LOWER_BOUND, INT_UPPER_BOUND));

        System.out.println("Sequence : " + array);

        boolean resultIncreasingSequence = false;
        if (array.get(1) > array.get(0)) {
            resultIncreasingSequence = true;
        }

        if (resultIncreasingSequence) {
            System.out.println("The sequence of increasing.");
        } else {
            System.out.println("The sequence of a not increasing");
        }

    }

}

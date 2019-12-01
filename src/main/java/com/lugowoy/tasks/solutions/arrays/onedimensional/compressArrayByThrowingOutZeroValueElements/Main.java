package com.lugowoy.tasks.solutions.arrays.onedimensional.compressArrayByThrowingOutZeroValueElements;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.ArrayLengthReader;
import com.lugowoy.helper.utils.checking.CheckerArray;

import static com.lugowoy.helper.filling.ValuesToFilling.INT_LOWER_BOUND;
import static com.lugowoy.helper.filling.ValuesToFilling.INT_UPPER_BOUND;

/**
 * An array containing integers is specified.
 * Compress it, throwing out the zero elements.
 *
 * <p>Created by Konstantin Lugowoy on 16.03.2017.
 */

public class Main {

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = ArrayLengthReader.readLength(new ReadingConsole());

        FillingArrayRandomPrimitiveIntegers filler = new FillingArrayRandomPrimitiveIntegers();

        ArrayInts array = new ArrayInts(filler.fill(lengthOfArray, INT_LOWER_BOUND, INT_UPPER_BOUND));

        System.out.println("Original array : " + array);
        System.out.println();

        COMPRESSING.compress(array);

        System.out.println();
        System.out.println("Result array : " + array);
    }

    private static final Compressing<Integer> COMPRESSING = array -> {
        int numberZeroElements = 0;
        if (CheckerArray.checkLengthInArray(array)) {
            ArrayInts tmpArray = new ArrayInts();
            for (int i = 0; i < array.size(); i++) {
                if (array.get(i) != 0) {
                    tmpArray.add(array.get(i));
                } else {
                    numberZeroElements++;
                }
            }
            array.setArray(tmpArray.toArray(new int[tmpArray.size()]));
        }
        System.out.printf("Number of zero elements in the array : %d .", numberZeroElements);
        System.out.println();
    };

}

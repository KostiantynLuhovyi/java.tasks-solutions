package com.lugowoy.tasks.solutions.arrays.onedimensional.compressArrayByThrowingEverySecondElement;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.ArrayLengthReader;
import com.lugowoy.helper.utils.checking.CheckerArray;
import com.lugowoy.tasks.solutions.arrays.onedimensional.compressArrayByThrowingEverySecondElement.Compressing;

import static com.lugowoy.helper.filling.ValuesToFilling.INT_LOWER_BOUND;
import static com.lugowoy.helper.filling.ValuesToFilling.INT_UPPER_BOUND;

/**
 * Given an array with the number of n elements.
 * Compress the array, throwing out every second element from it.
 *
 * Created by Konstantin Lugowoy on 13.03.2017.
 */

public class Main {

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = ArrayLengthReader.readLength(new ReadingConsole());

        FillingArrayRandomPrimitiveIntegers filler = new FillingArrayRandomPrimitiveIntegers();

        ArrayInts array = new ArrayInts(filler.fill(lengthOfArray, INT_LOWER_BOUND, INT_UPPER_BOUND));

        System.out.println("Original array : " + array);

        COMPRESSING.compress(array);

        System.out.println("Result of compress array : " + array);

    }

    private static final Compressing<ArrayInts> COMPRESSING = array -> {
        if (CheckerArray.checkLengthInArray(array)) {
            if (array.size() >= 2) {
                ArrayInts tmpArray = new ArrayInts();
                for (int i = 0; i < array.size(); i++) {
                    if ((i % 2 == 0) || (i == 0)) {
                        tmpArray.add(array.get(i));
                    }
                }
                array.setArray(tmpArray.toArray(new int[tmpArray.size()]));
            }
        }
    };

}

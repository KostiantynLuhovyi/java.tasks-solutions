package com.lugowoy.tasks.solutions.arrays.onedimensional.createArrayOfEvenNumbersBasedOnAnotherArray;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.ArrayLengthReader;
import com.lugowoy.helper.utils.checking.CheckerArray;

import static com.lugowoy.helper.filling.ValuesToFilling.INT_LOWER_BOUND;
import static com.lugowoy.helper.filling.ValuesToFilling.INT_UPPER_BOUND;

/**
 * Given a array of positive numbers a1, a2, ..., an. Create an array of even numbers of this array.
 *
 * <p>Created by Konstantin Lugowoy on 13-Feb-17.
 */

public class Main {

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = ArrayLengthReader.readLength(new ReadingConsole());

        FillingArrayRandomPrimitiveIntegers filler = new FillingArrayRandomPrimitiveIntegers();

        ArrayInts array = new ArrayInts(filler.fill(lengthOfArray, INT_LOWER_BOUND, INT_UPPER_BOUND));

        System.out.println("Original array numbers : " + array);

        ArrayInts evenNumbersArray = getArrayWithEvenNumbers(array);

        System.out.println("Even numbers of original array : " + evenNumbersArray);

    }

    private static ArrayInts getArrayWithEvenNumbers(ArrayInts array) {
        ArrayInts resultArray = new ArrayInts();
        if (CheckerArray.checkLengthInArray(array)) {
            for (int i = 0; i < array.size(); i++) {
                if (array.get(i) % 2 == 0) {
                    resultArray.add(array.get(i));
                }
            }
        }
        return resultArray;
    }

}

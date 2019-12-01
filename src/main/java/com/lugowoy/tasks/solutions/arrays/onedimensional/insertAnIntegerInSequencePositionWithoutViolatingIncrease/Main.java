package com.lugowoy.tasks.solutions.arrays.onedimensional.insertAnIntegerInSequencePositionWithoutViolatingIncrease;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.ArrayLengthReader;

import static com.lugowoy.helper.filling.ValuesToFilling.INT_LOWER_BOUND;
import static com.lugowoy.helper.filling.ValuesToFilling.INT_UPPER_BOUND;

/**
 * Given a sequence of integers a1 ≤ a2 ≤ ... ≤ an.
 * Insert an integer b into it so that the sequence remains non-decreasing.
 *
 * <p> Created by Konstantin Lugowoy on 11.03.2017.
 */

public class Main {

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = ArrayLengthReader.readLength(new ReadingConsole());

        FillingArrayRandomPrimitiveIntegers filler = new FillingArrayRandomPrimitiveIntegers();

        ArrayInts array = new ArrayInts(filler.fill(lengthOfArray, INT_LOWER_BOUND, INT_UPPER_BOUND));

        System.out.println("Original sequence : " + array);
        System.out.println();

        Sorting<Integer> sorting = Sorting::sortingIntegerSequence;
        sorting.sort(array);

        System.out.println("Sorted sequence : " + array);
        System.out.println();

        System.out.println("Enter numbers to insert : ");
        int insertNumber = new ReadingConsole().readInt();
        System.out.println();

        Inserting inserting = Inserting::insertElement;
        inserting.insert(insertNumber, array);

        System.out.println("Result sequence : " + array);

    }

}

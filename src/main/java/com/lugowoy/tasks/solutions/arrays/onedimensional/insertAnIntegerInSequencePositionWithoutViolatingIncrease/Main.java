package com.lugowoy.tasks.solutions.arrays.onedimensional.insertAnIntegerInSequencePositionWithoutViolatingIncrease;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.AbstractArray;
import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.ArrayLengthReader;
import com.lugowoy.helper.utils.generating.GeneratorRandomNumber;

import static com.lugowoy.helper.filling.ValuesToFilling.INT_LOWER_BOUND;
import static com.lugowoy.helper.filling.ValuesToFilling.INT_UPPER_BOUND;
import static com.lugowoy.helper.models.storages.arrays.AbstractArray.DEFAULT_LENGTH;

/**
 * Given a sequence of integers a1 ≤ a2 ≤ ... ≤ an.
 * Insert an integer b into it so that the sequence remains non-decreasing.
 * <p> Created by Konstantin Lugowoy on 11.03.2017.
 */
public class Main {

    private static final int LOWER_BOUND = 1000;
    private static final int UPPER_BOUND = 10000;

    public static void main(String[] args) {

        FillingArrayRandomPrimitiveIntegers filler = new FillingArrayRandomPrimitiveIntegers();

        ArrayInts array = new ArrayInts(filler.fill(DEFAULT_LENGTH, LOWER_BOUND, UPPER_BOUND));

        System.out.println("Original sequence : " + array);

        Sorting<Integer> sorting = Sorting::sortingIntegerSequence;
        sorting.sort(array);

        System.out.println("Sorted sequence : " + array);

        System.out.println("Enter numbers to insert : ");
        int insertNumber = new ReadingConsole().readInt();

        Inserting inserting = Inserting::insertElement;
        inserting.insert(insertNumber, array);

        System.out.println("Result sequence : " + array);

    }

}

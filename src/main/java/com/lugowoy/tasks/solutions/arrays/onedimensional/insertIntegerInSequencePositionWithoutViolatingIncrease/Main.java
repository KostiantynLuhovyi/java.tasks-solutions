package com.lugowoy.tasks.solutions.arrays.onedimensional.insertIntegerInSequencePositionWithoutViolatingIncrease;

import com.lugowoy.helper.execution.Executor;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.array.numbers.primitives.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.HelperArrayFiller;
import com.lugowoy.helper.utils.ReaderArrayLength;
import com.lugowoy.helper.utils.ReaderConsole;

/**
 * Given a sequence of integers a1 ≤ a2 ≤ ... ≤ an.
 * Insert an integer b into it so that the sequence remains non-decreasing.
 *
 * <p>Created by Konstantin Lugowoy on 11.03.2017.
 */
public class Main {

    private static final int LOWER_BOUND = 1000;
    private static final int UPPER_BOUND = 10000;

    public static void main(String[] args) {

        ReaderArrayLength readerLength = new ReaderArrayLength();
        int lengthArray = readerLength.read(System.in, System.out,
                                            ReaderArrayLength.MSG_ENTER_ARRAY_LENGTH);

        HelperArrayFiller filler = new HelperArrayFiller();
        ArrayInts array = new ArrayInts(filler.getArray(
                new FillingArrayRandomPrimitiveIntegers(), lengthArray,
                LOWER_BOUND, UPPER_BOUND));

        System.out.println("Array : " + array + "\n");

        Sorting sorting = Sorting::sortingIntegerArray;
        sorting.sort(array);

        System.out.println("Sorted array : " + array + "\n");

        System.out.println("Enter numbers to insert : ");
        int numberToInsert = new ReaderConsole().readInt();

        new Executor().execute(() -> {
            Inserting inserting = Inserting::insertElement;
            inserting.insert(array, numberToInsert);

            System.out.println("Result array : " + array);
        }, new OutputExecutionTimeToConsole());

    }

}

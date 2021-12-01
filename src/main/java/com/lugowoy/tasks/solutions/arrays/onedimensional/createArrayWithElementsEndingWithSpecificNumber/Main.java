package com.lugowoy.tasks.solutions.arrays.onedimensional.createArrayWithElementsEndingWithSpecificNumber;

import com.lugowoy.helper.checkers.CheckerArray;
import com.lugowoy.helper.execution.Executor;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.array.numbers.primitives.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.Capacity;
import com.lugowoy.helper.utils.HelperArrayFiller;
import com.lugowoy.helper.utils.ReaderArrayLength;
import com.lugowoy.helper.utils.ReaderConsole;
import org.jetbrains.annotations.NotNull;

/**
 * Create a new array whose elements will be elements of the source code ending
 * in a certain number.
 *
 * <p>Created by Konstantin Lugowoy on 27.03.2017.
 */
public class Main {

    private static final int START_BOUND = -10000;
    private static final int END_BOUND = 10000;

    public static void main(String[] args) {

        ReaderArrayLength readerArrayLength = new ReaderArrayLength();
        int lengthArray = readerArrayLength.read(System.in, Capacity.UPPER.get(),
                                                 System.out, ReaderArrayLength.MSG_ENTER_ARRAY_LENGTH);

        HelperArrayFiller fillerArray = new HelperArrayFiller();

        ArrayInts array = new ArrayInts(fillerArray.getArray(
                new FillingArrayRandomPrimitiveIntegers(), lengthArray,
                START_BOUND, END_BOUND));

        System.out.println("Array : " + array + "\n");

        System.out.println("Enter specific ending number : ");
        int specificEndingNumber = new ReaderConsole().readInt();

        new Executor().execute(() -> {
            ArrayInts resultArray = selectElementsEndingSpecificValue(array, specificEndingNumber);
            if (resultArray.size() != 0) {
                System.out.println("New array : " + resultArray);
                System.out.println();
            } else {
                System.out.println("No values were found with the specified ending.");
            }
        }, new OutputExecutionTimeToConsole());

    }

    private static ArrayInts selectElementsEndingSpecificValue(
            @NotNull final ArrayInts array, final int specificEndingValue) {
        ArrayInts resultArray = new ArrayInts(0);
        CheckerArray.check(array, Capacity.UPPER.get());
        for (int i = 0; i < array.size(); i++) {
            if (Math.abs(array.get(i)) % 10 == specificEndingValue) {
                resultArray.add(array.get(i));
            }
        }
        return resultArray;
    }

}

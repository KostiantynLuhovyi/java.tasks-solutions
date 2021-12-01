package com.lugowoy.tasks.solutions.arrays.onedimensional.cyclicallyShiftElementsOfArrayElementsToRightOrLeft;

import com.lugowoy.helper.execution.Executor;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.array.numbers.primitives.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.Capacity;
import com.lugowoy.helper.utils.HelperArrayFiller;
import com.lugowoy.helper.utils.HelperFillerValues;
import com.lugowoy.helper.utils.ReaderArrayLength;
import com.lugowoy.helper.utils.ReaderConsole;

/**
 * Given an array A. Cyclically shift the elements of the array to K elements to
 * the right (to the left).
 *
 * <p>Created by Konstantin Lugowoy on 19.06.2017.
 */
public class Main {

    private static final Shifting SHIFTING =
            Shifting::shiftElementsOfArrayElementsToRightOrLeft;

    private static final int BOUND = 100;

    public static void main(String[] args) {

        ReaderArrayLength readerArrayLength = new ReaderArrayLength();

        int lengthArray = readerArrayLength.read(System.in, Capacity.UPPER.get(),
                                                 System.out, ReaderArrayLength.MSG_ENTER_ARRAY_LENGTH);

        ArrayInts array = new ArrayInts(new HelperArrayFiller().getArray(
                new FillingArrayRandomPrimitiveIntegers(),
                lengthArray, HelperFillerValues.INT_ZERO, BOUND));

        System.out.println("Original : " + array);

        int numberK = enterNumberK(array.size());

        new Executor().execute(() -> {
            SHIFTING.shift(array, numberK);
            System.out.println("Result after shifting elements : " + array);
        }, new OutputExecutionTimeToConsole());
    }

    private static int enterNumberK(int sizeArray) {
        System.out.println("Enter integer number : ");
        ReaderConsole readerConsole = new ReaderConsole();
        int numberK;
        while (true) {
            numberK = readerConsole.readInt();
            if ((numberK >= sizeArray) || (numberK > -sizeArray)) {
                break;
            } else if (numberK == 0) {
                System.err.println("The number must not be zero. Re-enter : ");
            } else {
                System.err.println("The number does not match the condition. Re-enter : ");
            }
        }
        return numberK;
    }

}

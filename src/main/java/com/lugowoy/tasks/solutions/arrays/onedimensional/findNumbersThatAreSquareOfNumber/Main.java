package com.lugowoy.tasks.solutions.arrays.onedimensional.findNumbersThatAreSquareOfNumber;

import com.lugowoy.helper.execution.Executor;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.array.numbers.primitives.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.HelperArrayFiller;
import com.lugowoy.helper.utils.HelperFillerValues;
import com.lugowoy.helper.utils.ReaderArrayLength;
import com.lugowoy.helper.utils.ReaderConsole;

/**
 * Given positive integers a1, a2, a3, ..., an.
 * Find among them those whose square is equal to a certain number n.
 *
 * <p>Created by Konstantin Lugowoy on 12.03.2017.
 */
public class Main {

    private static final int BOUND = 50;

    public static void main(String[] args) {

        ReaderArrayLength readerLength = new ReaderArrayLength();
        int lengthArray = readerLength.read(System.in, System.out,
                                            ReaderArrayLength.MSG_ENTER_ARRAY_LENGTH);

        HelperArrayFiller filler = new HelperArrayFiller();
        ArrayInts array = new ArrayInts(filler.getArray(
                new FillingArrayRandomPrimitiveIntegers(), lengthArray,
                HelperFillerValues.INT_ZERO, BOUND));

        System.out.println("Array: " + array + "\n");

        new Executor().execute(() -> {
            System.out.println("Enter a number to compare : ");
            int compareNumber = new ReaderConsole().readInt();

            int quantityResult = 0;
            for (int i = 0; i < array.size(); i++) {
                int number = array.get(i);
                int squareRootNumber = (int) Math.pow(number, 2);
                if (compareNumber == squareRootNumber) {
                    System.out.printf("Sequence index : %d, element : %d;\n", i, number);
                    quantityResult++;
                }
            }
            if (quantityResult == 0) {
                System.out.println("There are no numbers in the sequence satisfying condition.");
            }
        }, new OutputExecutionTimeToConsole());
    }

}

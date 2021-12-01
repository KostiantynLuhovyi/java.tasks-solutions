package com.lugowoy.tasks.solutions.arrays.onedimensional.determineMostRepeatedElementInArray;

import com.lugowoy.helper.checkers.CheckerArray;
import com.lugowoy.helper.execution.Executor;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.array.numbers.primitives.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.Capacity;
import com.lugowoy.helper.utils.HelperArrayFiller;
import com.lugowoy.helper.utils.HelperFillerValues;
import com.lugowoy.helper.utils.ReaderArrayLength;

/**
 * In the array of integers with the number of elements n, find the most
 * repeated number. If there are several such numbers, then determine the
 * smallest of them.
 *
 * <p>Created by Konstantin Lugowoy on 22.03.2017.
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

        System.out.println("Original array : " + array);
        System.out.println();

        new Executor().execute(() -> DETERMINANT.determine(array),
                               new OutputExecutionTimeToConsole());

    }

    private static final Determinant<ArrayInts> DETERMINANT = array -> {
        CheckerArray.check(array, Capacity.UPPER.get());
        int count, countMax = 0, value = 1, num = 0;
        if (array.size() > 2) {
            for (int i = 0; i < array.size(); i++) {
                count = 1;
                for (int j = i + 1; j < array.size(); j++) {
                    if (array.get(i) == (array.get(j))) {
                        value = array.get(j);
                        count++;
                    } else if (count > countMax) {
                        countMax = count;
                        if (value <= array.get(i)) {
                            num = i;
                        }
                    }
                }
            }
        }
        if (countMax == 1) {
            System.out.println("No repetitive elements in the array.");
        } else {
            System.out.println("Element " + array.get(num) + ", repeated " + countMax);
        }
    };

}

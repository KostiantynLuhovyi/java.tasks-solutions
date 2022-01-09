package com.lugowoy.tasks.solutions.arrays.onedimensional.determinePairsOfNumbersFromSequenceWhoseSumIsEqualToEnteredNumber;

import com.lugowoy.helper.execution.Executor;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.array.numbers.primitives.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.HelperArrayFiller;
import com.lugowoy.helper.utils.HelperFillerValues;
import com.lugowoy.helper.utils.ReaderArrayLength;
import com.lugowoy.helper.utils.ReaderConsole;

/**
 * Given a sequence of integers a1, a2, ..., an. Indicate pairs of numbers ai,
 * aj such that ai + aj = m.
 *
 * <p>Created by Konstantin Lugowoy on 19.03.2017.
 */
public class Main {

    private static final int BOUND = 100;

    public static void main(String[] args) {

        ReaderArrayLength readerLength = new ReaderArrayLength();
        int lengthArray = readerLength.read(System.in, System.out,
                                            ReaderArrayLength.MSG_ENTER_ARRAY_LENGTH);

        HelperArrayFiller filler = new HelperArrayFiller();
        ArrayInts array = new ArrayInts(
                filler.getArray(new FillingArrayRandomPrimitiveIntegers(),
                                lengthArray, HelperFillerValues.INT_ZERO,
                                BOUND));

        System.out.println("Array: " + array + "\n");

        new Executor().execute(() -> {
            DeterminantNumbersEqualNumber<ArrayInts, Integer> determinant =
                    DeterminantNumbersEqualNumber::determineNumbersWhoseSumEqualNumber;
            determinant.determine(array, enterNumber());
        }, new OutputExecutionTimeToConsole());

    }

    private static int enterNumber() {
        System.out.println("Enter number : ");
        return new ReaderConsole().readInt();
    }

}

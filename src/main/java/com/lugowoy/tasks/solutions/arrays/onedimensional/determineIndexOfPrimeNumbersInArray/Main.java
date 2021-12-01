package com.lugowoy.tasks.solutions.arrays.onedimensional.determineIndexOfPrimeNumbersInArray;

import com.lugowoy.helper.checkers.CheckerArray;
import com.lugowoy.helper.execution.Executor;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.array.numbers.primitives.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.Capacity;
import com.lugowoy.helper.utils.HelperArrayFiller;
import com.lugowoy.helper.utils.HelperFillerValues;
import com.lugowoy.helper.utils.ReaderArrayLength;
import org.jetbrains.annotations.NotNull;

/**
 * The integer array of dimension of N is set. Whether there are among array
 * elements prime numbers? If yes, that to output index numbers of these
 * elements.
 *
 * <p>Created by Konstantin Lugowoy on 22.05.2017.
 */
public class Main {

    private static final int BOUND = 100;

    public static void main(String[] args) {

        ReaderArrayLength readerLength = new ReaderArrayLength();

        int lengthArray = readerLength.read(System.in, System.out,
                                            ReaderArrayLength.MSG_ENTER_ARRAY_LENGTH);

        HelperArrayFiller fillerArray = new HelperArrayFiller();

        ArrayInts array = new ArrayInts(fillerArray.getArray(
                new FillingArrayRandomPrimitiveIntegers(), lengthArray,
                HelperFillerValues.INT_ZERO, BOUND));

        System.out.println("Array : " + array);

        new Executor().execute(() -> {
            showIndexesOfPrimeNumbers(array);
        }, new OutputExecutionTimeToConsole());

    }

    private static void showIndexesOfPrimeNumbers(@NotNull final ArrayInts arrayInts) {
        CheckerArray.check(arrayInts, Capacity.UPPER.get());
        DeterminantPrimeNumber determinant = new DeterminantPrimeNumber();
        int countPrimeNumbers = 0;
        System.out.print("The indexes of elements which are prime numbers: ");
        for (int i = 0; i < arrayInts.size(); i++) {
            if (determinant.determine(arrayInts.get(i))) {
                System.out.print(i + " ");
                countPrimeNumbers++;
            }
        }
        if (countPrimeNumbers == 0) {
            System.out.print("No primes.");
        }
    }

}

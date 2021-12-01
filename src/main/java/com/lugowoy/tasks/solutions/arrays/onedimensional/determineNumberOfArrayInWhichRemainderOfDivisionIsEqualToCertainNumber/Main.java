package com.lugowoy.tasks.solutions.arrays.onedimensional.determineNumberOfArrayInWhichRemainderOfDivisionIsEqualToCertainNumber;

import com.lugowoy.helper.execution.Executor;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.array.numbers.primitives.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.HelperArrayFiller;
import com.lugowoy.helper.utils.ReaderArrayLength;
import com.lugowoy.helper.utils.ReaderConsole;

/**
 * Determine the number of the array in which the number is equal to dividing a
 * certain number.
 *
 * <p>Created by Konstantin Lugowoy on 14-Feb-17.
 */
public class Main {

    private static final int LOWER_BOUND = -200;
    private static final int UPPER_BOUND = 300;

    public static void main(String[] args) {

        ReaderArrayLength readerLength = new ReaderArrayLength();
        int lengthArray = readerLength.read(System.in, System.out,
                                            ReaderArrayLength.MSG_ENTER_ARRAY_LENGTH);

        HelperArrayFiller fillerArray = new HelperArrayFiller();

        ArrayInts array = new ArrayInts(fillerArray.getArray(
                new FillingArrayRandomPrimitiveIntegers(), lengthArray,
                LOWER_BOUND, UPPER_BOUND));

        System.out.println(array);

        ReaderConsole readerConsole = new ReaderConsole();

        System.out.println("Enter number to the modulo : ");
        int numberToModulo = readerConsole.readInt();

        System.out.println("Enter result to the modulo : ");
        int resultModulo = readerConsole.readInt();

        new Executor().execute(() -> DETERMINANT.determinate(array, numberToModulo, resultModulo),
                               new OutputExecutionTimeToConsole());

    }

    private static final Determinant<ArrayInts> DETERMINANT =
            (array, numberToModulo, resultModulo) -> {
                System.out.println("Result to the modulo operation : ");
                int countResult = 0;
                for (int number : array.toArray(new int[array.size()])) {
                    if (number % numberToModulo == resultModulo) {
                        System.out.print(number + " ");
                    } else {
                        countResult++;
                    }
                }
                if (countResult == array.size()) {
                    System.out.println("No numbers which satisfy the condition.");
                }
            };

}

package com.lugowoy.tasks.solutions.arrays.onedimensional.determineWhetherItIsPossibleToSelectContiguousElementsInOneOfArrays;

import com.lugowoy.helper.execution.Executor;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.array.numbers.primitives.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.HelperArrayFiller;
import com.lugowoy.helper.utils.HelperFillerValues;
import com.lugowoy.helper.utils.ReaderArrayLength;

/**
 * Two integer arrays are given.
 * Determine whether in the first of them one can choose k consecutive elements Xj, Xj + 1, ..., Xk-1,
 * so that Xj = Y1, Xj + 1 = Y2, ..., Xk-1 = Yk.
 *
 * <p>Created by Konstantin Lugowoy on 22.06.2017.
 */
public class Main {

    public static void main(String[] args) {

        ReaderArrayLength readerLength = new ReaderArrayLength();

        int lengthFirstArray = readerLength.read(System.in, System.out,
                                                 "Enter length of the first array : ");

        int lengthSecondArray = readerLength.read(System.in, System.out,
                                                  "Enter length of the second array : ");

        HelperArrayFiller fillerArray = new HelperArrayFiller();

        ArrayInts firstArray = new ArrayInts(fillerArray.getArray(
                new FillingArrayRandomPrimitiveIntegers(), lengthFirstArray,
                HelperFillerValues.INT_ZERO, HelperFillerValues.INT_POSITIVE_HUNDRED));
        ArrayInts secondArray = new ArrayInts(fillerArray.getArray(
                new FillingArrayRandomPrimitiveIntegers(), lengthSecondArray,
                HelperFillerValues.INT_ZERO, HelperFillerValues.INT_POSITIVE_HUNDRED));

        System.out.println("First array : \n" + firstArray + "\n");
        System.out.println("First array : \n" + secondArray + "\n");

        new Executor().execute(() -> {
            Determinant<ArrayInts> determine =
                    Determinant::determineWhetherItIsPossibleToSelectContiguousElements;
            ArrayInts resultArray = determine.determine(firstArray, secondArray);

            if (!resultArray.isEmpty()) {
                System.out.println("Result : " + resultArray);
            } else {
                System.out.println("Result array is empty.");
            }
        }, new OutputExecutionTimeToConsole());

    }

}

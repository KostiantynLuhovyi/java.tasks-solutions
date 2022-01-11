package com.lugowoy.tasks.solutions.arrays.onedimensional.findTwoNumbersWhoseArithmeticMeanIsClosestToNumberEntered;

import com.lugowoy.helper.execution.Executor;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.array.numbers.primitives.FillingArrayRandomPrimitiveDoubles;
import com.lugowoy.helper.models.arrays.ArrayDoubles;
import com.lugowoy.helper.utils.HelperArrayFiller;
import com.lugowoy.helper.utils.HelperFillerValues;
import com.lugowoy.helper.utils.ReaderArrayLength;
import com.lugowoy.helper.utils.ReaderConsole;

/**
 * Given a real number x and an array A [n].
 * In the array, find two members whose arithmetic mean is closest to x.
 * <p> Created by Konstantin Lugowoy on 12.04.2017.
 */
public class Main {

    private static final double BOUND = 200d;

    public static void main(String[] args) {

        ReaderArrayLength readerLength = new ReaderArrayLength();
        int lengthArray = readerLength.read(System.in, System.out,
                                            ReaderArrayLength.MSG_ENTER_ARRAY_LENGTH);

        HelperArrayFiller filler = new HelperArrayFiller();

        ArrayDoubles array = new ArrayDoubles(filler.getArray(
                new FillingArrayRandomPrimitiveDoubles(), lengthArray,
                HelperFillerValues.INT_ZERO, BOUND));

        System.out.println("Array : " + array + "\n");

        System.out.println("Enter number : ");
        double enterNumber = new ReaderConsole().readDouble();

        new Executor().execute(() -> {
            Finding<ArrayDoubles, Double> finding =
                    Finding::findTwoNumbersWhoseArithmeticMeanIsClosestToNumber;
            finding.find(array, enterNumber);
        }, new OutputExecutionTimeToConsole());

    }

}

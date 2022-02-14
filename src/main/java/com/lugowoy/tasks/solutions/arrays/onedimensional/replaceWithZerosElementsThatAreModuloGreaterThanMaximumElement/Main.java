package com.lugowoy.tasks.solutions.arrays.onedimensional.replaceWithZerosElementsThatAreModuloGreaterThanMaximumElement;

import com.lugowoy.helper.execution.Executor;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.filling.array.numbers.primitives.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.HelperArrayFiller;
import com.lugowoy.helper.utils.HelperFillerValues;
import com.lugowoy.helper.utils.ReaderArrayLength;

import java.util.Arrays;

/**
 * Given integers a1, a2, ..., an. Among them there are positive and negative.
 * Replace the zeros with those numbers that they are more modular than a certain number (| ai |> max {a1, a2, ..., an}).
 *
 * <p>Created by Konstantin Lugowoy on 11.03.2017.
 */
public class Main {

    public static void main(String[] args) {

        ReaderArrayLength readerLength = new ReaderArrayLength();
        int lengthArray = readerLength.read(System.in, System.out,
                                            ReaderArrayLength.MSG_ENTER_ARRAY_LENGTH);

        HelperArrayFiller filler = new HelperArrayFiller();

        ArrayInts array = new ArrayInts(filler.getArray(
                new FillingArrayRandomPrimitiveIntegers(), lengthArray,
                HelperFillerValues.INT_NEGATIVE_HUNDRED,
                HelperFillerValues.INT_POSITIVE_HUNDRED));

        System.out.println("Sequence : " + array + "\n");

        new Executor().execute(() -> {
            int maxElement = 0;
            if (Arrays.stream(array.toArray(new int[array.size()])).max().isPresent()) {
                maxElement = Arrays.stream(array.toArray(new int[array.size()]))
                                           .max()
                                           .getAsInt();
            }

            System.out.println("Result sequence : ");
            int finalMaxElement = maxElement;
            Arrays.stream(array.toArray(new int[array.size()])).forEachOrdered(integer -> {
                if (finalMaxElement != 0) {
                    if (Math.abs(integer) > finalMaxElement) {
                        integer = 0;
                    }
                }
                System.out.print(integer + " ");
            });
        }, new OutputExecutionTimeToConsole());

    }

}

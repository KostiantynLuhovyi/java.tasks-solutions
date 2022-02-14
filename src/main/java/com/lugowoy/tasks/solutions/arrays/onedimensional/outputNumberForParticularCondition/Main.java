package com.lugowoy.tasks.solutions.arrays.onedimensional.outputNumberForParticularCondition;

import com.lugowoy.helper.filling.array.numbers.primitives.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.utils.HelperFillerValues;
import com.lugowoy.helper.utils.ReaderArrayLength;

import java.util.Arrays;

/**
 * Given numbers a1 a2, .... an. Print out only the number, for which the condition ai ≤ i.
 * <p> Created by Konstantin Lugowoy on 14-Feb-17.
 */
public class Main {

    public static void main(String[] args) {

        ReaderArrayLength readerLength = new ReaderArrayLength();
        int lengthArray = readerLength.read(System.in, System.out,
                                            ReaderArrayLength.MSG_ENTER_ARRAY_LENGTH);

        FillingArrayRandomPrimitiveIntegers filling = new FillingArrayRandomPrimitiveIntegers();

        Numbers numbers = new Numbers(filling.fill(lengthArray,
                                                   HelperFillerValues.INT_NEGATIVE_HUNDRED,
                                                   HelperFillerValues.INT_POSITIVE_HUNDRED));

        System.out.println("Array : ");
        Arrays.stream(numbers.getNumbers()).forEachOrdered(value -> System.out.print(value + " "));
        System.out.println();

        System.out.println("Result: ");
        DISPLAY.show(numbers);

    }

    private static final Display DISPLAY = numbers -> {
        /*int firstValue = numbers.getNumbers()[0];*/
        for (int i = 0; i < numbers.getNumbers().length; i++) {
            if (/*firstValue*/numbers.getNumbers()[i] <= i) {
                System.out.println(i + " : " + numbers.getNumbers()[i]);
            }
        }
    };

}

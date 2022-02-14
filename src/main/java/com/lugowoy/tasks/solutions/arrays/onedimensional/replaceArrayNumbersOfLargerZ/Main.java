package com.lugowoy.tasks.solutions.arrays.onedimensional.replaceArrayNumbersOfLargerZ;

import com.lugowoy.helper.filling.array.numbers.primitives.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.utils.HelperFillerValues;
import com.lugowoy.helper.utils.ReaderArrayLength;
import com.lugowoy.helper.utils.ReaderConsole;

import java.util.Arrays;

/**
 * Given a sequence of integer numbers a1, a2, ..., an.
 * Replace all of its members, of the Z larger, this number. Count the number of substitutions.
 *
 * <p>Created by Konstantin Lugowoy on 13-Feb-17.
 */
public class Main {

    public static void main(String[] args) {

        ReaderArrayLength readerLength = new ReaderArrayLength();
        int lengthArray = readerLength.read(System.in, System.out,
                                            ReaderArrayLength.MSG_ENTER_ARRAY_LENGTH);

        FillingArrayRandomPrimitiveIntegers filling = new FillingArrayRandomPrimitiveIntegers();

        Numbers numbersSequence = new Numbers();
        numbersSequence.setNumbers(filling.fill(lengthArray,
                                                HelperFillerValues.INT_NEGATIVE_HUNDRED,
                                                HelperFillerValues.INT_POSITIVE_HUNDRED));

        System.out.println("Enter number of replace : ");
        int numberToReplace = new ReaderConsole().readInt();

        System.out.println("Original array : ");
        Arrays.stream(numbersSequence.getNumbers()).forEachOrdered(value -> System.out.print(value + " "));
        System.out.println();

        Replacement<Numbers, Integer> numbersReplacement = (Numbers numbers, Integer numberToExchange) -> {
            int countToReplace = 0;
            for (int i = 0; i < numbers.getNumbers().length; i++) {
                if (numbers.getNumbers()[i] > numberToExchange) {
                    numbers.getNumbers()[i] = numberToExchange;
                    countToReplace++;
                }
            }
            System.out.print("Count number of replacements : " + countToReplace);
        };

        numbersReplacement.replace(numbersSequence, numberToReplace);

        System.out.println();

        System.out.println("Result replace : ");
        Arrays.stream(numbersSequence.getNumbers()).forEachOrdered(value -> System.out.print(value + " "));

    }

}

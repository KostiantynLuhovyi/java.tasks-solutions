package com.lugowoy.tasks.solutions.arrays.onedimensional.replaceTheArrayNumbersOfLargerZ;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.utils.ArrayLengthReader;

import java.util.Arrays;

import static com.lugowoy.helper.filling.ValuesToFilling.INT_LOWER_BOUND;
import static com.lugowoy.helper.filling.ValuesToFilling.INT_UPPER_BOUND;

/**
 * Given a sequence of integer numbers a1, a2, ..., an.
 * Replace all of its members, of the Z larger, this number. Count the number of substitutions.
 * <p> Created by Konstantin Lugowoy on 13-Feb-17.
 */
public class Main {

    private static final Reader READER = new Reader(new ReadingConsole());

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = ArrayLengthReader.readLength(new ReadingConsole());

        Numbers numbersSequence = new Numbers();
        numbersSequence.setNumbers(new FillingArrayRandomPrimitiveIntegers().fill(lengthOfArray, INT_LOWER_BOUND, INT_UPPER_BOUND));

        System.out.println("Enter number of replace : ");
        int numberToReplace = READER.readInt();

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

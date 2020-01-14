package com.lugowoy.tasks.solutions.arrays.onedimensional.numberOfPreviouslyFoundPositiveOrNegative;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.utils.ArrayLengthReader;

import java.util.Arrays;

import static com.lugowoy.helper.filling.ValuesToFilling.INT_LOWER_BOUND;
import static com.lugowoy.helper.filling.ValuesToFilling.INT_UPPER_BOUND;

/**
 * The sequence of numbers a1, a2, ..., an. To find out what number is found before - positive or negative.
 * <p> Created by Konstantin Lugowoy on 12-Feb-17.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = ArrayLengthReader.readLength(new ReadingConsole());

        SequenceOfIntegers sequence = new SequenceOfIntegers();
        sequence.setSequenceOfIntegers(new FillingArrayRandomPrimitiveIntegers().fill(lengthOfArray, INT_LOWER_BOUND, INT_UPPER_BOUND));

        System.out.println("The sequence of integers to determine a sign of the number is the first in the sequence : ");
        Arrays.stream(sequence.getSequenceOfIntegers()).forEach(value -> System.out.print(value + " "));

        System.out.println();

        int firstElementInRheSequence = Arrays.stream(sequence.getSequenceOfIntegers()).findFirst().orElse(0);

        if (firstElementInRheSequence > 0) {
            System.out.println("The first element of the sequence positive.");
        } else if (firstElementInRheSequence < 0) {
            System.out.println("The first element of the sequence negative.");
        } else {
            System.out.println("The first element of the sequence is equal : 0.");
        }

    }

}

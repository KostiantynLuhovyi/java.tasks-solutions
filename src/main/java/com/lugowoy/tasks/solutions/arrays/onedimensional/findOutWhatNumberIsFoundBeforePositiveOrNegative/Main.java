package com.lugowoy.tasks.solutions.arrays.onedimensional.findOutWhatNumberIsFoundBeforePositiveOrNegative;

import com.lugowoy.helper.filling.array.numbers.primitives.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.utils.HelperFillerValues;
import com.lugowoy.helper.utils.ReaderArrayLength;

import java.util.Arrays;

/**
 * The sequence of numbers a1, a2, ..., an. To find out what number is found before - positive or negative.
 *
 * <p>Created by Konstantin Lugowoy on 12-Feb-17.
 */
public class Main {

    public static void main(String[] args) {

        ReaderArrayLength readerLength = new ReaderArrayLength();
        int lengthArray = readerLength.read(System.in, System.out,
                                            ReaderArrayLength.MSG_ENTER_ARRAY_LENGTH);

        SequenceOfIntegers sequence = new SequenceOfIntegers();
        sequence.setSequenceOfIntegers(new FillingArrayRandomPrimitiveIntegers().fill(lengthArray,
                                                                                      HelperFillerValues.INT_NEGATIVE_HUNDRED, HelperFillerValues.INT_POSITIVE_HUNDRED));

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

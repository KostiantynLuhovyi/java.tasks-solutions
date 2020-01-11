package com.lugowoy.tasks.solutions.arrays.onedimensional.convertSecondSequenceAccordingToRuleDefinedByFirstSequence;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.models.storages.arrays.ArrayInts;

import static com.lugowoy.helper.models.storages.arrays.AbstractArray.DEFAULT_LENGTH;

/**
 * Given integers a1, a2, ..., an and b1, b2, ..., bn.
 * Convert the sequence b1, b2, ..., bn by the rule: if ai ≤ 0, then bi is increased by a factor of 10 otherwise bi is replaced by zero.
 * <p> Created by Konstantin Lugowoy on 25.03.2017.
 */
public class Main {

    private static final int LOWER_BOUND = -20;
    private static final int UPPER_BOUND = 20;

    private static final Converting<Integer> CONVERTING = Converting::convertSecondSequenceAccordingToRuleDefinedByFirstSequence;

    public static void main(String[] args) {

        FillingArrayRandomPrimitiveIntegers filler = new FillingArrayRandomPrimitiveIntegers();

        ArrayInts firstArray = new ArrayInts(filler.fill(DEFAULT_LENGTH, LOWER_BOUND, UPPER_BOUND));
        System.out.println("A : " + firstArray);
        System.out.println();

        ArrayInts secondArray = new ArrayInts(filler.fill(DEFAULT_LENGTH, LOWER_BOUND, UPPER_BOUND));
        System.out.println("B : " + secondArray);
        System.out.println();

        CONVERTING.convert(firstArray, secondArray);

        System.out.println("Result second sequence after converting : " + secondArray);

    }

}

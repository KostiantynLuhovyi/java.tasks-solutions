package com.lugowoy.tasks.solutions.arrays.onedimensional.replaceSmallestNumberInSequenceByArithmeticMeanOfNumbers;

import org.jetbrains.annotations.NotNull;

/**
 * Created by Konstantin Lugowoy on 25.03.2017.
 */
@FunctionalInterface
public interface Replacement<T> {

    void replace(@NotNull final Sequence<T> sequence, @NotNull final T numberForReplace);

    static void replaceSmallestNumberInSequence(@NotNull final Sequence<Integer> sequence,
                                                @NotNull final Integer numberForReplace) {
        int indexOfValueForReplace = 0, valueForReplace = Integer.MAX_VALUE;
        for (int i = 0; i < sequence.getSequence().length; i++) {
            if (sequence.getSequence()[i] <= valueForReplace) {
                valueForReplace = sequence.getSequence()[i];
                indexOfValueForReplace = i;
            }
        }
        sequence.getSequence()[indexOfValueForReplace] = numberForReplace;
    }

}

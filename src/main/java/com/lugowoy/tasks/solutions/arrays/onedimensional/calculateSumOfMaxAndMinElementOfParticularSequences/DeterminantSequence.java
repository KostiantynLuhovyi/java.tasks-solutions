package com.lugowoy.tasks.solutions.arrays.onedimensional.calculateSumOfMaxAndMinElementOfParticularSequences;

import com.lugowoy.helper.checkers.CheckerArray;
import com.lugowoy.helper.models.arrays.AbstractArray;
import com.lugowoy.helper.models.arrays.ArrayInts;
import com.lugowoy.helper.utils.Capacity;
import org.jetbrains.annotations.NotNull;

/**
 * <p>Created by Konstantin Lugowoy on 09.01.2021.
 */
@FunctionalInterface
public interface DeterminantSequence {

    ArrayInts determine(@NotNull ArrayInts sequence);

    static ArrayInts determineEvenSequence(@NotNull final ArrayInts sequence) {
        CheckerArray.check(sequence, Capacity.UPPER.get());
        ArrayInts evenElementsSequence = new ArrayInts();
        for (int i = 0; i < sequence.size(); i++) {
            if (sequence.get(i) % 2 == 0) {
                evenElementsSequence.add(sequence.get(i));
            }
        }
        return evenElementsSequence;
    }

    static ArrayInts determineOddSequence(@NotNull final ArrayInts sequence) {
        CheckerArray.check(sequence, Capacity.UPPER.get());
        ArrayInts oddElementsSequence = new ArrayInts();
        for (int i = 0; i < sequence.size(); i++) {
            if (sequence.get(i) % 2 != 0) {
                oddElementsSequence.add(sequence.get(i));
            }
        }
        return oddElementsSequence;
    }

}

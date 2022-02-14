package com.lugowoy.tasks.solutions.arrays.onedimensional.replaceSmallestNumberInSequenceByArithmeticMeanOfNumbers;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Random;

/**
 * Given integers a1, a2, ..., an.
 * The smallest member of this sequence is replaced by the integer part of the arithmetic mean of all terms, leaving the remaining terms unchanged.
 * If there are several smaller terms in the sequence, then replace the last one in order.
 *
 * <p>Created by Konstantin Lugowoy on 25.03.2017.
 */
public class Main {

    private static final Replacement<Integer> REPLACEMENT =
            Replacement::replaceSmallestNumberInSequence;

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {

        Sequence<Integer> sequence = new Sequence<>(Arrays.stream(new int[20])
                                                          .map(operand -> RANDOM.nextInt(100))
                                                          .boxed()
                                                          .toArray(Integer[]::new));

        System.out.println("Original sequence: ");
        Arrays.stream(sequence.getSequence()).forEachOrdered(integer -> System.out.print(integer + " "));
        System.out.println();

        int resultArithmeticMeanOfSequence = getArithmeticMeanNumbersOfSequence(sequence);
        System.out.printf("Arithmetic mean number of the sequence is: %d", resultArithmeticMeanOfSequence);
        System.out.println();

        REPLACEMENT.replace(sequence, resultArithmeticMeanOfSequence);

        System.out.println("Sequence after replacement: ");
        Arrays.stream(sequence.getSequence()).forEachOrdered(value -> System.out.print(value + " "));
        System.out.println();

    }

    private static int getArithmeticMeanNumbersOfSequence(@NotNull final  Sequence<Integer> sequence) {
        double resultArithmeticMean = 0;

        double sumAllNumber = 0;
        for (int i = 0; i < sequence.getSequence().length; i++) {
            sumAllNumber += sequence.getSequence()[i];
            resultArithmeticMean = sumAllNumber / sequence.getSequence().length;
        }
        return (int)resultArithmeticMean;
    }

}

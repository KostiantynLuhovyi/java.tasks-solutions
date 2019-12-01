package com.lugowoy.tasks.solutions.arrays.onedimensional.determineNumberOfElementsThatAreIdenticalInTwoSequences;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.ArrayLengthReader;

/**
 * Two sequences of integers a1, a2, ..., an and b1, b2, ..., bm are given. All the members of the sequences are distinct numbers.
 * Find how many elements of the first sequence coincide with the elements of the second sequence.
 *
 * <p>Created by Konstantin Lugowoy on 30.05.2017.
 */

public class Main {

    private static final Determinant DETERMINANT = Determinant::determineTheNumberOfElementsThatAreIdenticalInTwoSequences;

    private static final int BOUND = 50;

    public static void main(String[] args) {

        System.out.println("Enter length of the first array : ");
        int lengthOfFirstArray = ArrayLengthReader.readLength(new ReadingConsole());

        System.out.println("Enter length of the second array : ");
        int lengthOfSecondArray = ArrayLengthReader.readLength(new ReadingConsole());

        FillingArrayRandomPrimitiveIntegers filler = new FillingArrayRandomPrimitiveIntegers();

        ArrayInts firstArray = new ArrayInts(filler.fill(lengthOfFirstArray, BOUND));
        ArrayInts secondArray = new ArrayInts(filler.fill(lengthOfSecondArray, BOUND));

        System.out.println("Elements of the first array : " + firstArray);
        System.out.println();

        System.out.println("Elements of the second array : " + secondArray);
        System.out.println();

        int numberOfIdenticalElementsInTheTwoSequence = DETERMINANT.determine(firstArray, secondArray);

        System.out.println("Number of identical elements in the two array : " + numberOfIdenticalElementsInTheTwoSequence);

    }

}

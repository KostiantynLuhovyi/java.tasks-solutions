package com.lugowoy.tasks.solutions.arrays.onedimensional.findNumbersInSequenceThatAreSquareOfNumber;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.ArrayLengthReader;

/**
 * Given positive integers a1, a2, a3, ..., an.
 * Find among them those whose square is equal to a certain number n.
 * <p> Created by Konstantin Lugowoy on 12.03.2017.
 */
public class Main {

    private static final int BOUND = 50;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = ArrayLengthReader.readLength(new ReadingConsole());

        FillingArrayRandomPrimitiveIntegers filler = new FillingArrayRandomPrimitiveIntegers();

        ArrayInts array = new ArrayInts(filler.fill(lengthOfArray, BOUND));

        System.out.println("Sequence : " + array);

        System.out.println("Enter a number to compare : ");
        int compareNumber = new ReadingConsole().readInt();

        int quantityResult = 0;
        for (int i = 0; i < array.size(); i++) {
            int number = array.get(i);
            int squareRootNumber = (int) Math.pow(number, 2);
            if (compareNumber == squareRootNumber) {
                System.out.printf("Sequence index : %d, element : %d;\n", i, number);
                quantityResult++;
            }
        }
        if (quantityResult == 0) {
            System.out.println("There are no numbers in the sequence satisfying condition.");
        }
    }

}

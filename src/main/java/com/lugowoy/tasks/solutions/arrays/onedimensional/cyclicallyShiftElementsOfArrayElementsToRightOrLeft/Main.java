package com.lugowoy.tasks.solutions.arrays.onedimensional.cyclicallyShiftElementsOfArrayElementsToRightOrLeft;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.ArrayLengthReader;

/**
 * Given an array A. Cyclically shift the elements of the array to K elements to the right (to the left).
 * <p> Created by Konstantin Lugowoy on 19.06.2017.
 */
public class Main {

    private static final Shifting SHIFTING = Shifting::shiftElementsOfArrayElementsToRightOrLeft;

    private static final int BOUND = 100;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = ArrayLengthReader.readLength(new ReadingConsole());

        FillingArrayRandomPrimitiveIntegers filler = new FillingArrayRandomPrimitiveIntegers();

        ArrayInts array = new ArrayInts(filler.fill(lengthOfArray, BOUND));

        System.out.println("Original : " + array);

        int numberK = enterNumberK(array.size());

        SHIFTING.shift(array, numberK);

        System.out.println("Result after shifting elements : " + array);

    }

    private static int enterNumberK(int sizeArray) {
        System.out.println("Enter integer number : ");
        ReadingConsole readingConsole = new ReadingConsole();
        int numberK;
        while (true) {
            numberK = readingConsole.readInt();
            if ((numberK >= sizeArray) || (numberK > -sizeArray)) {
                break;
            } else if (numberK == 0) {
                System.err.println("The number must not be zero. Re-enter : ");
            } else {
                System.err.println("The number does not match the condition. Re-enter : ");
            }
        }
        return numberK;
    }

}

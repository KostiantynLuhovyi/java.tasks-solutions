package com.lugowoy.tasks.solutions.arrays.onedimensional.determineIndexOfPrimeNumbersInArray;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.Array;
import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.ArrayLengthReader;

/**
 * The integer array of dimension of N is set.
 * Whether there are among array elements prime numbers?
 * If yes, that to output index numbers of these elements.
 * <p> Created by Konstantin Lugowoy on 22.05.2017.
 */
public class Main {

    private static final Determinant<Integer> DETERMINANT = Determinant::determineTheIndexOfPrimesInAnArray;

    private static final int BOUND = 100;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = ArrayLengthReader.readLength(new ReadingConsole());

        FillingArrayRandomPrimitiveIntegers filler = new FillingArrayRandomPrimitiveIntegers();

        ArrayInts array = new ArrayInts(filler.fill(lengthOfArray, BOUND));

        System.out.println("Array : " + array);

        showIndexesOfPrimeNumbers(array);

    }

    private static void showIndexesOfPrimeNumbers(ArrayInts arrayInts) {
        int countDeterminePrimeNumber = 0;
        System.out.print("The indexes of elements which are prime numbers : ");
        for (int i = 0; i < arrayInts.size(); i++) {
            if (DETERMINANT.determine(arrayInts.get(i))) {
                System.out.print(i + " ");
                countDeterminePrimeNumber++;
            }
        }
        if (countDeterminePrimeNumber == 0) {
            System.out.print("No primes.");
        }
    }

}

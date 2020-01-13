package com.lugowoy.tasks.solutions.arrays.onedimensional.determinePairsOfNumbersFromSequenceWhoseSumIsEqualToEnteredNumber;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.ArrayLengthReader;

/**
 * Given a sequence of integers a1, a2, ..., an. Indicate pairs of numbers ai, aj such that ai + aj = m.
 * <p> Created by Konstantin Lugowoy on 19.03.2017.
 */
public class Main {

    private static final Determinant<Integer> DETERMINANT = Determinant::determinePairsOfNumbersFromTheSequenceWhoseSumIsEqualToEnteredNumber;

    private static final int BOUND = 100;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = ArrayLengthReader.readLength(new ReadingConsole());

        FillingArrayRandomPrimitiveIntegers filler = new FillingArrayRandomPrimitiveIntegers();

        ArrayInts array = new ArrayInts(filler.fill(lengthOfArray, BOUND));

        System.out.println(array);

        int sumNumber = enterNumber();

        DETERMINANT.determine(array, sumNumber);

    }

    private static int enterNumber() {
        System.out.println("Enter number : ");
        return new ReadingConsole().readInt();
    }

}

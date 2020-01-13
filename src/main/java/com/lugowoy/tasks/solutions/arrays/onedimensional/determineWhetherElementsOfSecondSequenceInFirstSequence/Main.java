package com.lugowoy.tasks.solutions.arrays.onedimensional.determineWhetherElementsOfSecondSequenceInFirstSequence;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.ArrayLengthReader;

/**
 * Two sequences a1, a2, ..., an and b1, b2, ..., bm (m <n) are given.
 * In each of them, the members are different.
 * Is it true that all members of the second sequence are in the first sequence?
 * <p> Created by Konstantin Lugowoy on 12.04.2017.
 */
public class Main {

    private static final Determinant DETERMINANT = Determinant::determineFirstArrayContainsElementsOfSecondArray;

    private static final int BOUND = 50;

    public static void main(String[] args) {

        System.out.println("Enter length of the first array : ");
        int lengthOfFirstArray = ArrayLengthReader.readLength(new ReadingConsole());

        System.out.println("Enter length of the second array : ");
        int lengthSecondArray = ArrayLengthReader.readLength(new ReadingConsole());

        FillingArrayRandomPrimitiveIntegers filler = new FillingArrayRandomPrimitiveIntegers();

        ArrayInts firstArray = new ArrayInts(filler.fill(lengthOfFirstArray, BOUND));
        ArrayInts secondArray = new ArrayInts(filler.fill(lengthSecondArray, BOUND));

        System.out.println("First : " + firstArray);

        System.out.println("Second : " + secondArray);

        boolean resultDetermine = DETERMINANT.determine(firstArray, secondArray);

        if (resultDetermine) {
            System.out.println("Elements of the second sequence are included in the first sequence.");
        } else {
            System.out.println("Elements of the second sequence are not included in the first sequence.");
        }

    }

}

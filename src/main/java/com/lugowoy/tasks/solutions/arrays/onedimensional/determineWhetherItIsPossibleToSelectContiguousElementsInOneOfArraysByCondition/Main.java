package com.lugowoy.tasks.solutions.arrays.onedimensional.determineWhetherItIsPossibleToSelectContiguousElementsInOneOfArraysByCondition;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.ArrayLengthReader;

import java.util.List;

/**
 * Two integer arrays are given.
 * Determine whether in the first of them one can choose k consecutive elements Xj, Xj + 1, ..., Xk-1,
 * so that Xj = Y1, Xj + 1 = Y2, ..., Xk-1 = Yk.
 *
 * <p> Created by Konstantin Lugowoy on 22.06.2017.
 */

public class Main {

    private static final int BOUND = 100;

    public static void main(String[] args) {

        System.out.println("Enter length of the first array : ");
        int lengthOfFirstArray = ArrayLengthReader.readLength(new ReadingConsole());

        System.out.println("Enter length of the second array : ");
        int lengthOfSecondArray = ArrayLengthReader.readLength(new ReadingConsole());

        FillingArrayRandomPrimitiveIntegers filler = new FillingArrayRandomPrimitiveIntegers();

        ArrayInts firstArray = new ArrayInts(filler.fill(lengthOfFirstArray, BOUND));
        ArrayInts secondArray = new ArrayInts(filler.fill(lengthOfSecondArray, BOUND));

        Determinant<ArrayInts> determine = Determinant::determineWhetherItIsPossibleToSelectContiguousElements;
        List<ArrayInts> arrayList = determine.determine(firstArray, secondArray);

        if (!arrayList.isEmpty()) {
            System.out.println("Result : " + arrayList);
        } else {
            System.out.println("Result array is empty.");
        }

    }

}

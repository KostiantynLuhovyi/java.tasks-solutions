package com.lugowoy.tasks.solutions.arrays.onedimensional.createNewArrayWhoseElementsWillBeElementsOfSourceEndingInSpecificNumber;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.ArrayLengthReader;
import com.lugowoy.helper.utils.checking.CheckerArray;

/**
 * Create a new array whose elements will be elements of the source code ending in a certain number.
 * <p> Created by Konstantin Lugowoy on 27.03.2017.
 */
public class Main {

    private static final int START_BOUND = -10000;
    private static final int END_BOUND = 10000;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = ArrayLengthReader.readLength(new ReadingConsole());

        FillingArrayRandomPrimitiveIntegers filler = new FillingArrayRandomPrimitiveIntegers();

        ArrayInts array = new ArrayInts(filler.fill(lengthOfArray, START_BOUND, END_BOUND));

        System.out.println("Original array : " + array);
        System.out.println();

        System.out.println("Enter specific ending number : ");
        int specificEndingNumber = new ReadingConsole().readInt();

        ArrayInts newArray = createNewArrayWhoseElementsWillBeElementsOfSourceEndingInSpecificNumber(array, specificEndingNumber);

        if (newArray.size() != 0) {
            System.out.println("New array : " + newArray);
            System.out.println();
        } else {
            System.out.println("No values were found with the specified ending.");
        }

    }

    private static ArrayInts createNewArrayWhoseElementsWillBeElementsOfSourceEndingInSpecificNumber(ArrayInts array,
                                                                                                     int specificEndingNumber) {
        ArrayInts resultArray = new ArrayInts(0);
        if (CheckerArray.checkLengthInArray(array)) {
            for (int i = 0; i < array.size(); i++) {
                if (Math.abs(array.get(i)) % 10 == specificEndingNumber) {
                    resultArray.add(array.get(i));
                }
            }
        }
        return resultArray;
    }

}

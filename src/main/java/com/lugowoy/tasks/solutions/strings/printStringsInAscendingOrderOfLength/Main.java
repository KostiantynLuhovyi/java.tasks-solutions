package com.lugowoy.tasks.solutions.strings.printStringsInAscendingOrderOfLength;

import com.lugowoy.helper.filling.array.strings.FillingArrayRandomLengthStrings;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.Array;
import com.lugowoy.helper.utils.ArrayLengthReader;
import com.lugowoy.helper.utils.checking.CheckerArray;

/**
 * Sort and print the strings in ascending order of their lengths.
 * <p> Created by LugowoyKonstantin on 09.08.2018.
 */
public class Main {

    private static final int BOUND_STRINGS_LENGTH = 30;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = ArrayLengthReader.readLength(new ReadingConsole());

        FillingArrayRandomLengthStrings filler = new FillingArrayRandomLengthStrings("english");

        Array<String> stringsArray = new Array<>(filler.fill(lengthOfArray, BOUND_STRINGS_LENGTH));

        System.out.println("Strings in an array : " + stringsArray);

        printNumbersInAscendingOrdersOfLength(stringsArray);

        System.out.println("Result : " + stringsArray);

    }

    private static void printNumbersInAscendingOrdersOfLength(Array<String> stringsArray) {
        boolean toSort = true;
        while (toSort) {
            toSort = false;
            if (CheckerArray.checkLengthInArray(stringsArray)) {
                for (int j = 0; j < stringsArray.size() - 1; j++) {
                    if (stringsArray.get(j).length() > stringsArray.get(j + 1).length()) {
                        String tmp = stringsArray.get(j + 1);
                        stringsArray.set(j + 1, stringsArray.get(j));
                        stringsArray.set(j, tmp);
                        toSort = true;
                    }
                }
            }
        }
    }

}

package com.lugowoy.tasks.solutions.strings.determineNumbersOfStringsContainingOnlyLatinCharacters;

import com.lugowoy.helper.filling.array.strings.FillingArrayRandomValueStrings;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.Array;
import com.lugowoy.helper.utils.ArrayLengthReader;
import com.lugowoy.helper.utils.checking.CheckerArray;

/**
 * Determine the number of words containing only Latin characters.
 *
 * <p> Created by LugowoyKonstantin on 16.09.2018.
 */

public class Main {

    private static final int LENGTH_STRING = 5;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = ArrayLengthReader.readLength(new ReadingConsole());

        Array<String> stringArray = new Array<>(new FillingArrayRandomValueStrings("english+russian").fill(lengthOfArray, LENGTH_STRING));

        System.out.println("Strings : " + stringArray);

        determineNumbersOfStringsContainingOnlyLatinCharacters(stringArray);
    }

    private static void determineNumbersOfStringsContainingOnlyLatinCharacters(Array<String> stringArray) {
        int countOfStrings = 0;
        if (CheckerArray.checkLengthInArray(stringArray)) {
            for (int i = 0; i < stringArray.size(); i++) {
                String str = stringArray.get(i);
                if (str.matches("[a-zA-Z]+")) {
                    System.out.println("Result : " + str);
                    countOfStrings++;
                }
            }
            if (countOfStrings == 0) {
                System.out.println("No strings were found containing only Latin characters.");
            }
        }
    }

}

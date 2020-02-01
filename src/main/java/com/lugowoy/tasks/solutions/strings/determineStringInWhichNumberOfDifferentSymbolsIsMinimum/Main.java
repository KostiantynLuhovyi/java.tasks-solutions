package com.lugowoy.tasks.solutions.strings.determineStringInWhichNumberOfDifferentSymbolsIsMinimum;

import com.lugowoy.helper.filling.array.strings.FillingArrayRandomLengthStrings;
import com.lugowoy.helper.filling.array.strings.FillingArrayRandomValueStrings;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.Array;
import com.lugowoy.helper.utils.ArrayLengthReader;
import com.lugowoy.helper.utils.checking.CheckerArray;

/**
 * Determine the string in which the number of different characters minimum.
 * If there are several such string, find the first one.
 * <p> Created by LugowoyKonstantin on 14.09.2018.
 */
public class Main {

    private static final int UPPER_STRING_LENGTH = 20;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = ArrayLengthReader.readLength(new ReadingConsole());

        FillingArrayRandomLengthStrings filler = new FillingArrayRandomLengthStrings("english");

        Array<String> stringArray = new Array<>(filler.fill(lengthOfArray, UPPER_STRING_LENGTH));

        System.out.println("Strings in an array : " + stringArray);

        System.out.println("Result string : " + determineStringInWhichNumberOfDifferentSymbolsIsMinimum(stringArray));

    }

    private static String determineStringInWhichNumberOfDifferentSymbolsIsMinimum(Array<String> stringArray) {
        String resultString = "";
        int counter = 0, generalCounter = Integer.MAX_VALUE;
        if (CheckerArray.checkLengthInArray(stringArray)) {
            for (int i = 0; i < stringArray.size(); i++) {
                char[] chars = stringArray.get(i).toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    for (int k = 0; k < chars.length; k++) {
                        if (chars[j] == chars[k]) {
                            counter++;
                        }
                    }
                }
                if (counter < generalCounter) {
                    generalCounter = counter;
                    resultString = stringArray.get(i);
                }
                counter = 0;
            }
        }
        return resultString;
    }

}

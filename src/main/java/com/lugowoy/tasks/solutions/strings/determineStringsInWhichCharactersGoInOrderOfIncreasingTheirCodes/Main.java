package com.lugowoy.tasks.solutions.strings.determineStringsInWhichCharactersGoInOrderOfIncreasingTheirCodes;

import com.lugowoy.helper.filling.array.strings.FillingArrayRandomValueStrings;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.Array;
import com.lugowoy.helper.utils.ArrayLengthReader;
import com.lugowoy.helper.utils.checking.CheckerArray;

/**
 * Define a string, the characters in which are in the strict order of increasing their codes.
 * If there are several such strings, find the first one.
 *
 * <p> Created by LugowoyKonstantin on 27.09.2018.
 */

public class Main {

    private static final int LENGTH_STRING = 5;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = ArrayLengthReader.readLength(new ReadingConsole());

        Array<String> stringArray = new Array<>(new FillingArrayRandomValueStrings("english").fill(lengthOfArray, LENGTH_STRING));

        System.out.println("Strings in an array : " + stringArray);

        System.out.println("Result : ");
        determineStringsInWhichCharactersGoInOrderOfIncreasingTheirCodes(stringArray);

    }

    private static void determineStringsInWhichCharactersGoInOrderOfIncreasingTheirCodes(Array<String> stringArray) {
        String resultString = "";
        int countNumberOfResult = 0;
        int codeOfCharValue = Integer.MIN_VALUE;
        if (CheckerArray.checkLengthInArray(stringArray)) {
            for (int i = 0; i < stringArray.size(); i++) {
                String strValue = stringArray.get(i);
                for (int j = 0; j < strValue.length(); j++) {
                    int codeOfCurrentChar = (int) strValue.charAt(j);
                    if (codeOfCurrentChar > codeOfCharValue) {
                        codeOfCharValue = codeOfCurrentChar;
                        resultString = strValue;
                    } else {
                        resultString = "";
                        break;
                    }
                }
                if (!resultString.equals("")) {
                    System.out.println(resultString);
                    countNumberOfResult++;
                }
                codeOfCharValue = Integer.MIN_VALUE;
            }
            if (countNumberOfResult == 0) {
                System.out.println("No strings matching the condition.");
            }
        }
    }

}

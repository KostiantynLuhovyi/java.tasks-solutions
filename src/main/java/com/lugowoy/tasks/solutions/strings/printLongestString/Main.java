package com.lugowoy.tasks.solutions.strings.printLongestString;

import com.lugowoy.helper.filling.array.strings.FillingArrayRandomLengthStrings;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.Array;
import com.lugowoy.helper.utils.ArrayLengthReader;
import com.lugowoy.tasks.solutions.strings.printShortestString.Determinant;

/**
 * Enter n strings. Find the longest string. Print the string and its length.
 * <p> Created by LugowoyKonstantin on 08.06.2018.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = ArrayLengthReader.readLength(new ReadingConsole());

        System.out.println("Enter length of the strings : ");
        int lengthStrings = new ReadingConsole().readInt();

        Array<String> stringArray = new Array<>(new FillingArrayRandomLengthStrings("english").fill(lengthOfArray, lengthStrings));

        System.out.println("Strings in an array : " + stringArray);

        printLongestString(Determinant::determineLongestString, stringArray);

    }

    //The functional interface Determinant from the package com.lugowoy.tasks.printShortestString .
    private static void printLongestString(Determinant determinant, Array<String> stringArray) {
        String resultString = determinant.determine(stringArray);
        System.out.println("Result string : " + resultString);
        System.out.println("Length of the string : " + resultString.length());
    }

}

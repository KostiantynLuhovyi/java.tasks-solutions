package com.lugowoy.tasks.solutions.strings.printShortestString;

import com.lugowoy.helper.models.storages.arrays.Array;
import com.lugowoy.helper.utils.checking.CheckerArray;

/**
 * Created by LugowoyKonstantin on 26.07.2018.
 */

public interface Determinant {

    String determine(Array<String> stringArray);

    static String determineShortestString(Array<String> stringArray) {
        int shortestLength = Byte.MAX_VALUE, indexShortestString = 0;
        if (CheckerArray.checkLengthInArray(stringArray)) {
            for (int i = 0; i < stringArray.size(); i++) {
                int tmpStringLength = stringArray.get(i).length();
                if (tmpStringLength < shortestLength) {
                    shortestLength = tmpStringLength;
                    indexShortestString = i;
                }
            }
        }
        return stringArray.get(indexShortestString);
    }

    static String determineLongestString(Array<String> stringArray) {
        int longestLength = Byte.MIN_VALUE, indexLongestString = 0;
        if (CheckerArray.checkLengthInArray(stringArray)) {
            for (int i = 0; i < stringArray.size(); i++) {
                int tmpStringLength = stringArray.get(i).length();
                if (tmpStringLength > longestLength) {
                    longestLength = tmpStringLength;
                    indexLongestString = i;
                }
            }
        }
        return stringArray.get(indexLongestString);
    }

}

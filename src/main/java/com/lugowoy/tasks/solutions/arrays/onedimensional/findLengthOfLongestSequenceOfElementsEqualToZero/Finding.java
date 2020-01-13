package com.lugowoy.tasks.solutions.arrays.onedimensional.findLengthOfLongestSequenceOfElementsEqualToZero;

import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.checking.CheckerArray;

/**
 * Created by Konstantin Lugowoy on 18.06.2017.
 */
@FunctionalInterface
public interface Finding {

    int find(ArrayInts arrayInts);

    static Integer findLengthOfLongestSequenceOfElementsEqualToZero(ArrayInts array) {
        int resultCount = 0, count = 0;
        if (CheckerArray.checkLengthInArray(array)) {
            for (int i = 0; i < array.size(); i++) {
                if (array.get(i) == 0) {
                    count++;
                } else {
                    count = 0;
                }
                resultCount = resultCount < count ? count : resultCount;
            }
        }
        return resultCount;
    }

}

package com.lugowoy.tasks.calculatePercentageRatioOfDifferentNumberVariantsAmongRandomlyGeneratedNumbers.calculating;

import com.lugowoy.helper.models.Array;

/**
 * Created by Konstantin Lugowoy on 23.10.2017.
 */

public class Checker {

    static <T> boolean checkObjectOfArrayClassNonNull(Array<T> array) {
        boolean resultOfCheck = false;
        if (array != null) {
            resultOfCheck = true;
        } else {
            System.err.println("The object of Array class by passed to argument is equal null.");
        }
        return resultOfCheck;
    }

    static <T> boolean checkArrayNonNull(T[] array) {
        boolean resultOfCheck = false;
        if (array != null) {
            resultOfCheck = true;
        } else {
            System.err.println("The array by passed to argument is equal null.");
        }
        return resultOfCheck;
    }

}

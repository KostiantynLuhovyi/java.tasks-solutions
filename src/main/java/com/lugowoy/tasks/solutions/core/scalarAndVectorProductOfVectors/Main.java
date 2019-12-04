package com.lugowoy.tasks.solutions.core.scalarAndVectorProductOfVectors;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegers;
import com.lugowoy.helper.models.storages.arrays.Array;

/**
 * Scalar and vector product of vectors.
 * <p>
 * Created by Konstantin Lugowoy on 14.11.2017.
 */

public class Main {

    private static final int LENGTH_ARRAY = 5;
    private static final int MIN_BOUND = -5;
    private static final int MAX_BOUND = 5;

    public static void main(String[] args) {

        Array<Integer> firstArray = new Array<>(new FillingArrayRandomIntegers().fill(LENGTH_ARRAY, MIN_BOUND, MAX_BOUND));
        System.out.println("First array : " + firstArray);

        Array<Integer> secondArray = new Array<>(new FillingArrayRandomIntegers().fill(LENGTH_ARRAY, MIN_BOUND, MAX_BOUND));
        System.out.println("Second array : " + secondArray);

        Array<Integer> vectorProductOfVectors = new Array<>(LENGTH_ARRAY);

        double resultScalarProductOfVectors = 0;

        System.out.println();
        System.out.println("Result of vector product of vectors : ");
        for (int i = 0; i < LENGTH_ARRAY; i++) {
            resultScalarProductOfVectors += firstArray.get(i) * secondArray.get(i);
            vectorProductOfVectors.set(i, firstArray.get((i + 1) % 3) * secondArray.get((i + 2) % 3)
                    - firstArray.get((i + 2) % 3) * secondArray.get((i + 1) % 3));
        }

        System.out.println("Result of scalar product of vectors : " + resultScalarProductOfVectors);

    }

}

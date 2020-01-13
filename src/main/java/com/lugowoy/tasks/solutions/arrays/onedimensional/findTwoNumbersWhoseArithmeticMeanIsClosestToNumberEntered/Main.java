package com.lugowoy.tasks.solutions.arrays.onedimensional.findTwoNumbersWhoseArithmeticMeanIsClosestToNumberEntered;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomPrimitiveDoubles;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.storages.arrays.ArrayDoubles;
import com.lugowoy.helper.utils.ArrayLengthReader;

/**
 * Given a real number x and an array A [n].
 * In the array, find two members whose arithmetic mean is closest to x.
 * <p> Created by Konstantin Lugowoy on 12.04.2017.
 */
public class Main {

    private static final double BOUND = 200d;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = ArrayLengthReader.readLength(new ReadingConsole());

        FillingArrayRandomPrimitiveDoubles filler = new FillingArrayRandomPrimitiveDoubles();

        ArrayDoubles array = new ArrayDoubles(filler.fill(lengthOfArray, BOUND));

        System.out.println("Original array : " + array);

        System.out.println("Enter real number : ");
        double enterNumber = new ReadingConsole().readDouble();

        Finding<Double, ArrayDoubles> findable = Finding::findTwoNumbersWhoseArithmeticMeanIsClosestToNumber;
        findable.find(enterNumber, array);

    }

}

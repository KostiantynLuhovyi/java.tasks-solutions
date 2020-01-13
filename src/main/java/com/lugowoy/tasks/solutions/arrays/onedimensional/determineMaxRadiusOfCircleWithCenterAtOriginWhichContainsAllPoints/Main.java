package com.lugowoy.tasks.solutions.arrays.onedimensional.determineMaxRadiusOfCircleWithCenterAtOriginWhichContainsAllPoints;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.utils.generating.GeneratorRandomNumber;

import java.util.Arrays;

import static com.lugowoy.helper.filling.ValuesToFilling.INT_LOWER_BOUND;
import static com.lugowoy.helper.filling.ValuesToFilling.INT_UPPER_BOUND;

/**
 * In a one-dimensional array with an even number of elements (2N) there are coordinates of N points of the plane.
 * They are arranged in the following order: x1, y1, x2, y2, x3, y3, etc.
 * Determine the maximal radius of the circle with the center at the origin, which contains all the points.
 * <p> Created by Konstantin Lugowoy on 14.05.2017.
 */
public class Main {

    private static final Reader READER = new Reader(new ReadingConsole());

    private static final Determinant DETERMINANT = Determinant::determineTeMaxRadius;

    public static void main(String[] args) {

        ArrayOfCoordinates arrayOfCoordinates = new ArrayOfCoordinates();

        System.out.println("Enter the number of points to define : ");
        int numberOfPoints = READER.readInt();

        arrayOfCoordinates.setCoorOfPoints(Arrays.stream(new Integer[numberOfPoints * 2])
                                                 .mapToInt(value -> value = GeneratorRandomNumber.generateInt(INT_LOWER_BOUND, INT_UPPER_BOUND))
                                                 .toArray());

        System.out.println("Coordinates of points : ");
        int countLn = 0;
        for (int i = 0; i < arrayOfCoordinates.getCoorOfPoints().length; i++) {
            System.out.print(arrayOfCoordinates.getCoorOfPoints()[i] + " ");
            countLn++;
            if (countLn == 2) {
                System.out.println();
                countLn = 0;
            }
        }

        System.out.println();
        System.out.printf("Maximal radius is %.2f", DETERMINANT.determine(arrayOfCoordinates));

    }

}

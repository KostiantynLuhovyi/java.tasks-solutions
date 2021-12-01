package com.lugowoy.tasks.solutions.arrays.onedimensional.determineMaxRadiusOfCircleWithCenterAtOrigin;

import com.lugowoy.helper.execution.Executor;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.utils.Capacity;
import com.lugowoy.helper.utils.RandomNumber;
import com.lugowoy.helper.utils.ReaderConsole;

import java.util.Arrays;

/**
 * In a one-dimensional array with an even number of elements (2N) there are
 * coordinates of N points of the plane. They are arranged in the following
 * order: x1, y1, x2, y2, x3, y3, etc. Determine the maximal radius of the
 * circle with the center at the origin, which contains all the points.
 *
 * <p>Created by Konstantin Lugowoy on 14.05.2017.
 */
public class Main {

    private static final Determinant DETERMINANT = Determinant::determineTeMaxRadius;

    public static void main(String[] args) {

        ArrayOfCoordinates arrayOfCoordinates = new ArrayOfCoordinates();

        System.out.println("Enter the number of points to define : ");
        int numberPoints = new ReaderConsole().readInt(Capacity.LOWER.get(),
                                                       Capacity.UPPER.get());

        RandomNumber random = new RandomNumber();
        arrayOfCoordinates.setCoorOfPoints(Arrays.stream(
                new Integer[numberPoints * 2]).mapToInt(value -> value =
                        random.generateInt(Integer.MIN_VALUE, Integer.MAX_VALUE)).toArray());

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

        new Executor().execute(() -> System.out.printf("Maximal radius is %.2f",
                                                       DETERMINANT.determine(arrayOfCoordinates)),
                               new OutputExecutionTimeToConsole());

    }

}

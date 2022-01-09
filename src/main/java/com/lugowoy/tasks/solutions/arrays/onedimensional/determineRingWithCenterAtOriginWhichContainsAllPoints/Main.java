package com.lugowoy.tasks.solutions.arrays.onedimensional.determineRingWithCenterAtOriginWhichContainsAllPoints;

import com.lugowoy.helper.execution.Executor;
import com.lugowoy.helper.execution.OutputExecutionTimeToConsole;
import com.lugowoy.helper.utils.RandomNumber;
import com.lugowoy.helper.utils.ReaderArrayLength;

import java.util.Arrays;

/**
 * In a one-dimensional array with an even number of elements (2N) there are coordinates of N points of the plane.
 * They are arranged in the following order: x1, y1, x2, y2, x3, y3, etc.
 * Define a ring with center at the origin, which contains all points.
 *
 * <p>Created by Konstantin Lugowoy on 16.05.2017.
 */
public class Main {

    public static void main(String[] args) {

        ArrayOfCoordinates<Double> arrayOfCoordinates = new ArrayOfCoordinates<>();

        ReaderArrayLength reader = new ReaderArrayLength();
        int numberPoints = reader.read(System.in, System.out,
                                       "Enter the number of points for the task : ");

        RandomNumber random = new RandomNumber();
        arrayOfCoordinates.setArrayOfCoordinates(Arrays.stream(new Double[numberPoints * 2])
                                                       .mapToDouble(value -> value = random.generateDouble())
                                                       .boxed().toArray(Double[]::new));


        System.out.println("Coordinates of points : ");
        int countLn = 0;
        for (int i = 0; i < arrayOfCoordinates.getArrayOfCoordinates().length; i++) {
            System.out.print(arrayOfCoordinates.getArrayOfCoordinates()[i] + " ");
            countLn++;
            if (countLn == 2) {
                System.out.println();
                countLn = 0;
            }
        }

        new Executor().execute(() -> {
            Determinant<Double> determinant =
                    Determinant::determineRingWhichContainsAllCoordinatesOfPoints;
            determinant.determine(arrayOfCoordinates);
        }, new OutputExecutionTimeToConsole());

    }

}

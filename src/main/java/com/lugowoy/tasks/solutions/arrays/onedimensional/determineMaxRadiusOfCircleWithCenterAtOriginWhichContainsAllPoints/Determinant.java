package com.lugowoy.tasks.solutions.arrays.onedimensional.determineMaxRadiusOfCircleWithCenterAtOriginWhichContainsAllPoints;

/** Created by Konstantin Lugowoy on 14.05.2017. */

@FunctionalInterface
public interface Determinant {

    double determine(ArrayOfCoordinates arrayOfCoordinates);

    static double determineTeMaxRadius(ArrayOfCoordinates arrayOfCoordinates) {
        double result = 0;
            if (arrayOfCoordinates != null) {
                if (arrayOfCoordinates.getCoorOfPoints() != null) {
                    if ((arrayOfCoordinates.getCoorOfPoints().length % 2 == 0)
                            && (arrayOfCoordinates.getCoorOfPoints().length != 0)) {
                        for (int i = 0; i < arrayOfCoordinates.getCoorOfPoints().length - 1; i++) {
                            result = result < (arrayOfCoordinates.getCoorOfPoints()[i] * arrayOfCoordinates.getCoorOfPoints()[i]
                                                + arrayOfCoordinates.getCoorOfPoints()[i + 1] * arrayOfCoordinates.getCoorOfPoints()[i + 1])
                                            ? (arrayOfCoordinates.getCoorOfPoints()[i] * arrayOfCoordinates.getCoorOfPoints()[i]
                                                + arrayOfCoordinates.getCoorOfPoints()[i + 1] * arrayOfCoordinates.getCoorOfPoints()[i + 1])
                                            : result;

                        }
                    }
                }
            }
        return result;
    }

}

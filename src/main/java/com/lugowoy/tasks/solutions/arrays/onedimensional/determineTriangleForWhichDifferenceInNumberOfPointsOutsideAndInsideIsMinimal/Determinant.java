package com.lugowoy.tasks.solutions.arrays.onedimensional.determineTriangleForWhichDifferenceInNumberOfPointsOutsideAndInsideIsMinimal;

import com.lugowoy.helper.checkers.CheckerArray;
import com.lugowoy.helper.filling.array.points.FillingArrayPoints2DRandomDoubles;
import com.lugowoy.helper.models.arrays.AbstractArray;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.models.points.Point2D;
import com.lugowoy.helper.utils.Capacity;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Konstantin Lugowoy on 03.07.2017.
 */
@FunctionalInterface
public interface Determinant<T extends AbstractArray> {

    CheckInsidePoint CHECK_INSIDE_POINT =
            CheckInsidePoint::isInsideTrianglePoints;

    T define(@NotNull final T tArray);

    static Array<Point2D<Double>> defineTriangle(@NotNull final Array<Point2D<Double>> pointArray) {
        Array<Point2D<Double>> resultPointOfTriangle = new Array<>(
                new FillingArrayPoints2DRandomDoubles().fill(3));
        CheckerArray.check(pointArray, Capacity.UPPER.get());
        int lengthArray = pointArray.size();
        for (int i = 0; i < lengthArray; i++) {
            for (int j = i + 1; j < lengthArray; j++) {
                for (int k = j + 1; k < lengthArray; k++) {
                    int countLength = 0;
                    for (int l = 0; l < lengthArray; l++) {
                        if (i == l || j == l || k == l) {
                            continue;
                        }
                        countLength += CHECK_INSIDE_POINT.isInside(
                                pointArray.get(l), pointArray.get(i),
                                pointArray.get(j), pointArray.get(k));
                    }
                    countLength = Math.abs(countLength);
                    if (countLength < lengthArray) {
                        lengthArray = countLength;
                        resultPointOfTriangle.set(0, pointArray.get(i));
                        resultPointOfTriangle.set(1, pointArray.get(j));
                        resultPointOfTriangle.set(2, pointArray.get(k));
                    }

                }
            }
        }
        return resultPointOfTriangle;
    }

}

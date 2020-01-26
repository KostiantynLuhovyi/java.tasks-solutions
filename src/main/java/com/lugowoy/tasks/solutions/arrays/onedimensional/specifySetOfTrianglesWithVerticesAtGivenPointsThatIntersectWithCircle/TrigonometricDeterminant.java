package com.lugowoy.tasks.solutions.arrays.onedimensional.specifySetOfTrianglesWithVerticesAtGivenPointsThatIntersectWithCircle;

import com.lugowoy.helper.models.points.Point2D;
import com.lugowoy.helper.models.storages.arrays.Array;
import com.lugowoy.helper.utils.checking.CheckerArray;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * Created by Konstantin Lugowoy on 03.07.2017.
 */
@FunctionalInterface
public interface TrigonometricDeterminant<T, V> {

    void determine(T t, V v);

    static void determineSetOfTrianglesWithVerticesAtGivenPointsThatIntersectWithCircle(Array<Point2D<Integer>> pointArray, double radius) {
        if (CheckerArray.checkLengthInArray(pointArray)) {
            int countTriangle = 0;
            for (int i = 0; i < pointArray.size() - 2; i++) {
                for (int j = i + 1; j < pointArray.size() - 1; j++) {
                    for (int k = j + 1; k < pointArray.size(); k++) {
                        if (((sqrt(pow(pointArray.get(i).getX(), 2) + pow(pointArray.get(i).getY(), 2))) <= radius)
                                && ((sqrt(pow(pointArray.get(j).getX(), 2) + pow(pointArray.get(i).getX(), 2))) <= radius)
                                && ((sqrt(pow(pointArray.get(k).getX(), 2) + pow(pointArray.get(k).getY(), 2)) <= radius))) {
                            countTriangle++;
                            System.out.print(pointArray.get(i) + "; ");
                            System.out.print(pointArray.get(j) + "; ");
                            System.out.print(pointArray.get(k) + "; ");
                            System.out.print(" are the vertices of a triangle inscribed or intersecting with a circle.");
                            System.out.println();
                        }
                    }
                }
            }
            System.out.printf("The total number of triangles inscribed and intersecting with the circle is %d .", countTriangle);
        }
    }

}

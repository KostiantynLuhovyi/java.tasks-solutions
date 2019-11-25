package com.lugowoy.tasks.determineWhetherLineIsParallelToOrdinateOrToAbscissa;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.points.Point2D;

/**
 * Determine whether a particular straight line of the ordinate axis is parallel or the abscissa axis.
 * The straight line is given by two points.
 * <p>
 * Created by Konstantin Lugowoy on 27.09.2017.
 */

public class Main {

    private static final Reader READER = Reader.getReader(new ReadingConsole());

    public static void main(String[] args) {

        System.out.println("Enter the coordinates of the first point along the X axis : ");
        int firstPointCoordinateX = READER.readInt();
        System.out.println("Enter the coordinates of the first point along the Y axis : ");
        int firstPointCoordinateY = READER.readInt();

        Point2D<Integer> firstPoint = new Point2D<>(firstPointCoordinateX, firstPointCoordinateY);

        System.out.println("Enter the coordinates of the second point along the X axis : ");
        int secondPointCoordinateX = READER.readInt();
        System.out.println("Enter the coordinates of the second point along the Y axis : ");
        int secondPointCoordinateY = READER.readInt();

        Point2D<Integer> secondPoint = new Point2D<>(secondPointCoordinateX, secondPointCoordinateY);

        Determinant determinant = DeterminantOfLineParallelism::determineWhetherLineIsParallelToOrdinateOrToAbscissa;
        determinant.determine(firstPoint, secondPoint);

    }

}

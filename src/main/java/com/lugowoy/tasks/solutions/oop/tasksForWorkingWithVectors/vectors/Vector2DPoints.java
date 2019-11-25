package com.lugowoy.tasks.tasksForWorkingWithVectors.vectors;

import com.lugowoy.helper.models.Point;

import java.math.BigDecimal;
import java.util.Comparator;

/**
 * Created by Konstantin Lugowoy on 19.12.2018.
 */

public class Vector2DPoints<T extends Number> extends Vector<Point<T>> {

    public Vector2DPoints(int dimension) {
        super(dimension);
    }

    public Vector2DPoints(Point<T>[] vector) {
        super(vector);
    }

    public boolean equalsVectors(Vector2DPoints<T> vector2DPoints) {
        boolean equalsResult = false;
        if (vector2DPoints != null) {
            if ((this.comparePointsCoordinateX(this.getPointX(), vector2DPoints.getPointX())
                                      && this.comparePointsCoordinateY(this.getPointX(), vector2DPoints.getPointX()))
                    && (this.comparePointsCoordinateX(this.getPointY(), vector2DPoints.getPointY())
                                      && (this.comparePointsCoordinateY(this.getPointY(), vector2DPoints.getPointY())))) {
                equalsResult = true;
            }
        }
        return equalsResult;
    }

    public BigDecimal getModuleVector() {
        return new BigDecimal(Math.sqrt(this.powX().add(this.powY()).doubleValue()));
    }

    public void setPointX(Point<T> pointX) {
        super.getVector()[0] = pointX;
    }

    public Point<T> getPointX() {
        return super.getVector()[0];
    }

    public void setPointY(Point<T> pointY) {
        super.getVector()[1] = pointY;
    }

    public Point<T> getPointY() {
        return super.getVector()[1];
    }

    private boolean comparePointsCoordinateX(Point<T> firstPoint, Point<T> secondPoint) {
        Comparator<Double> comparator = Comparator.comparing(Double::doubleValue);
        return comparator.compare(firstPoint.getCoordinateX().doubleValue(), secondPoint.getCoordinateX().doubleValue()) == 0;
    }

    private boolean comparePointsCoordinateY(Point<T> firstPoint, Point<T> secondPoint) {
        Comparator<Double> comparator = Comparator.comparing(Double::doubleValue);
        return comparator.compare(firstPoint.getCoordinateY().doubleValue(), secondPoint.getCoordinateY().doubleValue()) == 0;
    }

    private BigDecimal powX() {
        BigDecimal sumXs = new BigDecimal(new BigDecimal(this.getPointX().getCoordinateX().doubleValue())
                               .add(new BigDecimal(this.getPointY().getCoordinateX().doubleValue())).doubleValue());
        return new BigDecimal(Math.pow(sumXs.doubleValue(), 2));
    }

    private BigDecimal powY() {
        BigDecimal sumXs = new BigDecimal(new BigDecimal(this.getPointX().getCoordinateY().doubleValue())
                .add(new BigDecimal(this.getPointY().getCoordinateY().doubleValue())).doubleValue());
        return new BigDecimal(Math.pow(sumXs.doubleValue(), 2));
    }

}

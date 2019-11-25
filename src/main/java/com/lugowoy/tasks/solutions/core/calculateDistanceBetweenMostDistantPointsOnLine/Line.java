package com.lugowoy.tasks.calculateDistanceBetweenMostDistantPointsOnLine;

import com.rits.cloning.Cloner;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by Konstantin Lugowoy on 10.07.2017.
 */

public final class Line<T extends Number> implements Serializable, Cloneable {

    private static final int MIN_NUMBER_POINTS_ON_LINE = 3;

    private T[] pointsOnLine;

    private T minValueOfPoint;
    private T maxValueOfPoint;

    public Line() {
    }

    public Line(T[] pointsOnLine) throws IllegalArgumentException {
        //The setters are used in the constructor, since the class is declared with the modifier final.йй
        this.setPointsOnLine(pointsOnLine);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Line)) return false;

        Line<?> line = (Line<?>) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(getPointsOnLine(), line.getPointsOnLine())) return false;
        if (getValueMinPoint() != null ? !getValueMinPoint().equals(line.getValueMinPoint()) : line.getValueMinPoint() != null)
            return false;
        return getValueMaxPoint() != null ? getValueMaxPoint().equals(line.getValueMaxPoint()) : line.getValueMaxPoint() == null;
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(pointsOnLine);
        result = 31 * result + (maxValueOfPoint != null ? maxValueOfPoint.hashCode() : 0);
        result = 31 * result + (minValueOfPoint != null ? minValueOfPoint.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Line[" +
                "pointsOnLine=" + Arrays.toString(pointsOnLine) +
                ", maxValueOfPoint=" + maxValueOfPoint +
                ", minValueOfPoint=" + minValueOfPoint +
                ']';
    }

    @SuppressWarnings("unchecked")
    @Override
    protected Line<T> clone() {
        Line<T> line = new Line<>();
        Cloner cloner = new Cloner();
        try {
            line = (Line<T>) super.clone();
            line.setPointsOnLine(cloner.deepClone(this.getPointsOnLine()));
            line.setValueMinPoint(cloner.deepClone(this.getValueMinPoint()));
            line.setValueMaxPoint(cloner.deepClone(this.getValueMaxPoint()));
        } catch (CloneNotSupportedException ex) {
            new InternalError(ex.getMessage()).printStackTrace();
        }
        return line;
    }

    public T[] getPointsOnLine() {
        return Arrays.copyOf(pointsOnLine, pointsOnLine.length);
    }

    public void setPointsOnLine(T[] pointsOnLine) {
        if (checkPointsOnLineNonNull(pointsOnLine)
                && checkNumbersOfPointsOnLineGreatestOrEqualMinNumberPoints(pointsOnLine)) {
            this.pointsOnLine = Arrays.copyOf(pointsOnLine, pointsOnLine.length);
        }
    }

    public T getValueMinPoint() {
        return minValueOfPoint;
    }

    public void setValueMinPoint(T valueMinPoint) {
        try {
            if (valueMinPoint != null) {
                this.minValueOfPoint = valueMinPoint;
            } else {
                throw new IllegalArgumentException(
                        new NullPointerException("The min value of Point on the line passed by argument is equal to null."));
            }
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public T getValueMaxPoint() {
        return maxValueOfPoint;
    }

    public void setValueMaxPoint(T valueMaxPoint) {
        try {
            if (valueMaxPoint != null) {
                this.maxValueOfPoint = valueMaxPoint;
            } else {
                throw new IllegalArgumentException(
                        new NullPointerException("The max value of Point on the line passed by argument is equal to null."));
            }
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private static <T> boolean checkPointsOnLineNonNull(T[] pointsOnLine) {
        boolean resultOfCheck = false;
        try {
            if (pointsOnLine != null) {
                resultOfCheck = true;
            } else {
                throw new IllegalArgumentException("The array passed by argument is equal to null.");
            }
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }
        return resultOfCheck;
    }

    private static <T> boolean checkNumbersOfPointsOnLineGreatestOrEqualMinNumberPoints(T[] pointsOnLine) {
        boolean resultOfCheck = false;
        try {
            if (pointsOnLine.length >= MIN_NUMBER_POINTS_ON_LINE) {
                resultOfCheck = true;
            } else {
                throw new IllegalArgumentException("The array passed by argument is not correspond to the correct size.");
            }
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }
        return resultOfCheck;
    }

}

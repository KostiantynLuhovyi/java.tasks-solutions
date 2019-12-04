package com.lugowoy.tasks.solutions.core.writeProgramToCalculateCoordinatesOfBallThrownAtArbitraryTime;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.points.Point2D;

/**
 * The elastic ball is thrown at an angle to the horizon at some initial velocity.
 * When the ball falls on a flat horizontal surface, there is an elastic beating, so that the horizontal component of the speed of the ball does not change,
 * and the vertical component changes to the opposite one.
 * It is necessary to write a program that calculates the position (coordinates) of the ball at any time.
 * <p>
 * Created by Konstantin Lugowoy on 08.11.2017.
 */

public class Main {

    private static final Reader READER = new Reader(new ReadingConsole());

    private static final double g = 9.832;

    public static void main(String[] args) {

        System.out.println("Enter the value of the initial speed (m/sec) : ");
        double initialSpeed = READER.readDouble();

        System.out.println("Enter the value of the angle (degree) under which the ball was thrown : ");
        double angle = Math.toRadians(READER.readDouble());

        System.out.println("Enter the time (seconds) value for which to calculate : ");
        double timeMoment = READER.readDouble();

        double momentOfLastImpactOnSurface = calculateMomentOfLastImpactOnSurface(
                calculateFlightTimeOfBallBeforeHittingHorizontalSurface(initialSpeed, angle), timeMoment);

        Point2D<Double> ballPoint = new Point2D(0d, 0d);
        ballPoint.setX(Math.round(100 * calculateCoordinateX(initialSpeed, angle, timeMoment)) / 100.0);
        ballPoint.setY(Math.round(100 * calculateCoordinateY(initialSpeed, angle, timeMoment, momentOfLastImpactOnSurface)) / 100.0);

        System.out.printf("At the time %f, the position of the thrown ball is at the point with the coordinates : ", timeMoment);
        System.out.println(ballPoint);

    }

    private static double calculateFlightTimeOfBallBeforeHittingHorizontalSurface(double initialSpeed, double angle) {
        return 2 * initialSpeed * Math.sin(angle) / g;
    }

    private static double calculateMomentOfLastImpactOnSurface(double timeFlightBeforeHitting, double timeMoment) {
        return timeFlightBeforeHitting * Math.floor(timeMoment / timeFlightBeforeHitting);
    }

    private static double calculateCoordinateX(double initialSpeed, double angle, double timeMoment) {
        return initialSpeed * Math.cos(angle) * timeMoment;
    }

    private static double calculateCoordinateY(double initialSpeed, double angle, double timeMoment, double momentOfLastImpact) {
        return initialSpeed * Math.sin(angle) * (timeMoment - momentOfLastImpact) - g * (timeMoment - momentOfLastImpact) * (timeMoment - momentOfLastImpact) / 2;
    }

}

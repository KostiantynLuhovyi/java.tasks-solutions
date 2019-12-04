package com.lugowoy.tasks.solutions.core.calculationOfCoordinatesOfBodyCastAtAngleToHorizon;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.points.Point2D;

/**
 * Write a program for calculating the coordinate time at the specified time body, thrown at an angle to the horizon.
 * We assume that the mass of the body m is known, the initial velocity V, the angle a, under which the body is thrown to the horizon.
 * In addition, we believe that the body acts as an air resistance force,
 * modulo proportional to the speed of the body and directed opposite to the direction of flight of the body.
 * <p>
 * Created by Konstantin Lugowoy on 06.11.2017.
 */

public class Main {

    private static final Reader READER = new Reader(new ReadingConsole());

    private static final double g = 9.832;

    public static void main(String[] args) {

        double angle = enterAngle();
        angle = convertAngleFromDegreesToRadians(angle);

        double mass = enterMass();

        double gamma = enterGamma();

        double V = enterSpeed();

        double t = enterTime();

        System.out.println("The point in which there is a body having parameters entered by you : ");

        double xCoor = calculateCoordinateX(V, mass, angle, gamma, t);
        double yCoor = calculateCoordinateY(V, mass, angle, gamma, t);

        Point2D<Double> point = new Point2D<>(xCoor, yCoor);

        System.out.println(point);

    }

    private static double convertAngleFromDegreesToRadians(double angle) {
        return angle / (180 / Math.PI);
    }

    private static double calculateCoordinateX(double speed, double mass, double angle, double gamma, double time) {
        return (speed * mass * Math.cos(angle) / gamma * (1 - Math.exp(-gamma * time / mass)));
    }

    private static double calculateCoordinateY(double speed, double mass, double angle, double gamma, double time) {
        return mass * (speed * Math.sin(angle) * gamma + mass * gamma) / gamma / gamma
                * (1 - Math.exp(-gamma * time / mass)) - mass * g * time / gamma;
    }

    private static double enterAngle() {
        System.out.println("Enter the angle at which the body was thrown : ");
        double resultAngle;
        while (true) {
            resultAngle = READER.readDouble();
            if ((resultAngle > 0) && (resultAngle < 180)) {
                break;
            } else {
                System.out.println("Incorrect entered value. Re-enter : ");
            }
        }
        return resultAngle;
    }

    private static double enterMass() {
        System.out.println("Enter body weight (kg) : ");
        return READER.readDouble();
    }

    private static double enterGamma() {
        System.out.println("Enter the air resistance factor to the body : ");
        return READER.readDouble();
    }

    private static double enterSpeed() {
        System.out.println("Enter the speed (m/s) at which the body was thrown :");
        return READER.readDouble();
    }

    private static double enterTime() {
        System.out.println("Enter the time (seconds) when you want to know the location of the body relative to the horizon : ");
        return READER.readDouble();
    }

}

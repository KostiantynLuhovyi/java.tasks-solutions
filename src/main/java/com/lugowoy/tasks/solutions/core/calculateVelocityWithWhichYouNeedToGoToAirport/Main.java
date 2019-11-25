package com.lugowoy.tasks.calculateVelocityWithWhichYouNeedToGoToAirport;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;

/**
 * The user enters from the keyboard the distance to the airport (in kilometers, there may be a real value)
 * and the time for which you need to reach (in minutes).
 * Calculate the speed (km / h) with which you need to go.
 * <p>
 * Created by Konstantin Lugowoy on 06.06.2017.
 */

public class Main {

    private static final Reader READER = Reader.getReader(new ReadingConsole());

    public static void main(String[] args) {

        double S = enterDistance();

        double minutesOfTime = enterMinutesOfTime();

        double V = S / (minutesOfTime / 60);

        System.out.println("Speed from which you will reach the airport : " + V + "km/h .");

    }

    public static double enterMinutesOfTime() {
        System.out.println("Enter the number of minutes for which you need to get to the airport : ");
        double minutesOfTime;
        while (true) {
            minutesOfTime = READER.readDouble();
            if (minutesOfTime > 0) {
                break;
            } else {
                System.out.println("Incorrect value. Re-enter : ");
            }
        }
        return minutesOfTime;
    }

    public static double enterDistance() {
        System.out.println("Enter the distance to the airport in kilometers : ");
        double distance;
        while (true) {
            distance = READER.readDouble();
            if (distance > 0) {
                break;
            } else {
                System.out.println("Incorrect value. Re-enter : ");
            }
        }
        return distance;
    }

}

package com.lugowoy.tasks.solutions.core.calculateHeightOfSatellitesOrbitAboveEarthsSurface;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;

/**
 * Calculate the height of the satellite's orbit above the Earth's surface.
 * <p>
 * Created by Konstantin Lugowoy on 07.11.2017.
 */

public class Main {

    private static final Reader READER = new Reader(new ReadingConsole());

    private static final double G = 6.672E-11;
    private static final double EARTH_MASS = 5.96e24;
    private static final double EARTH_RADIUS = 6.37E6;

    public static void main(String[] args) {

        System.out.println("Enter the satellite orbital period (hours) : ");
        double orbitalPeriod = READER.readDouble();
        orbitalPeriod *= 3600;

        double heightOfSatellitesOrbitInMeters = calculateHeightOfSatellitesOrbitInMeters(orbitalPeriod);

        double heightOfSatellitesOrbitInKilometers = calculateHeightOfSatellitesOrbitInKilometers(heightOfSatellitesOrbitInMeters);

        System.out.println("The height of the satellite's orbit : " + heightOfSatellitesOrbitInKilometers);

    }

    private static double calculateHeightOfSatellitesOrbitInKilometers(double heightOfSatellitesOrbitInMeters) {
        return (double) (Math.round(heightOfSatellitesOrbitInMeters)) / 1000;
    }

    private static double calculateHeightOfSatellitesOrbitInMeters(double orbitalPeriod) {
        return Math.pow(G * EARTH_MASS * orbitalPeriod * orbitalPeriod / 4 / Math.PI / Math.PI, (double) 1 / 3) - EARTH_RADIUS;
    }

}

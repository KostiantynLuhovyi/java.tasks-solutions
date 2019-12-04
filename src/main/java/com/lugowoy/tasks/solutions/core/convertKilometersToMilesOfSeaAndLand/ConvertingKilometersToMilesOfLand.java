package com.lugowoy.tasks.solutions.core.convertKilometersToMilesOfSeaAndLand;

/**
 * Created by Konstantin Lugowoy on 31-Dec-16.
 */

public class ConvertingKilometersToMilesOfLand implements Converting<Length> {

    private static final double MILES_OF_LAND_IN_THE_ONE_KILOMETERS = 0.621371;

    @Override
    public Length convert(Length length) {
        length.setMilesOfLand(length.getKilometers() * MILES_OF_LAND_IN_THE_ONE_KILOMETERS);
        return length;
    }

    @Override
    public double convert(double kilometers) {
        return kilometers * MILES_OF_LAND_IN_THE_ONE_KILOMETERS;
    }

}

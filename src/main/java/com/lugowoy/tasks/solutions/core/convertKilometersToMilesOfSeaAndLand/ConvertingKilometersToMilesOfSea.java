package com.lugowoy.tasks.convertKilometersToMilesOfSeaAndLand;

/**
 * Created by Konstantin Lugowoy on 31-Dec-16.
 */

public class ConvertingKilometersToMilesOfSea implements Converting<Length> {

    private static final double MILES_OF_SEA_IN_THE_ONE_KILOMETERS = 0.539957;

    @Override
    public Length convert(Length length) {
        length.setMilesOfSea(length.getKilometers() * MILES_OF_SEA_IN_THE_ONE_KILOMETERS);
        return length;
    }

    @Override
    public double convert(double kilometers) {
        return kilometers * MILES_OF_SEA_IN_THE_ONE_KILOMETERS;
    }

}

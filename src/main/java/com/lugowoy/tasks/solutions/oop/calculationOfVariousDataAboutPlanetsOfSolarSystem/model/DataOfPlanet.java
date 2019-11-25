package com.lugowoy.tasks.calculationOfVariousDataAboutPlanetsOfSolarSystem.model;

/**
 * Created by LugowoyKonstantin on 07.03.2017.
 */

public enum DataOfPlanet {
    MERCURY(3.303E+23),
    VENUS(4.869E+24),
    EARTH(5.976E+24),
    MARS(6.421E+23),
    JUPITER(1.9E+27),
    SATURN(5.688E+26),
    URANUS(8.686E+25),
    NEPTUNE(1.024E+26);

    private final double mass;

    DataOfPlanet(double mass) {
        this.mass = mass;
    }

    public double getMass() {
        return mass;
    }

    public static DataOfPlanet getDataOfPlanet(int ordinal) {
        DataOfPlanet dataOfPlanet;
        switch (ordinal) {
            case 0: dataOfPlanet = DataOfPlanet.MERCURY; break;
            case 1: dataOfPlanet = DataOfPlanet.VENUS; break;
            case 2: dataOfPlanet = DataOfPlanet.EARTH; break;
            case 3: dataOfPlanet = DataOfPlanet.MARS; break;
            case 4: dataOfPlanet = DataOfPlanet.JUPITER; break;
            case 5: dataOfPlanet = DataOfPlanet.SATURN; break;
            case 6: dataOfPlanet = DataOfPlanet.URANUS; break;
            case 7: dataOfPlanet = DataOfPlanet.NEPTUNE; break;
            default: dataOfPlanet = null;
        }
        return dataOfPlanet;
    }

}

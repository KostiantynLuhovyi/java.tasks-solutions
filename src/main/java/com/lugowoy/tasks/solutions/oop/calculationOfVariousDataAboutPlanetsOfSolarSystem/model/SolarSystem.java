package com.lugowoy.tasks.calculationOfVariousDataAboutPlanetsOfSolarSystem.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by LugowoyKonstantin on 07.03.2017.
 */

public class SolarSystem implements Serializable, Cloneable {

    public static final int PLANETS_IN_THE_SOLAR_SYSTEM = 8;

    private List<Planet> planetList;

    public List<Planet> getPlanetList() {
        return planetList;
    }

    public void setPlanetList(List<Planet> planetList) {
        this.planetList = planetList;
    }

}

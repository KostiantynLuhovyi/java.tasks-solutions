package com.lugowoy.tasks.calculationOfVariousDataAboutPlanetsOfSolarSystem.calculating;

import com.lugowoy.tasks.calculationOfVariousDataAboutPlanetsOfSolarSystem.model.Planet;

import java.math.BigDecimal;
import java.util.Collection;

/**
 * Created by LugowoyKonstantin on 07.03.2017.
 */

public class CalculatorMassAllPlanets {

    public static BigDecimal calculateMassAllPlanets(Collection<Planet> collection) {
        BigDecimal resultCalculate = new BigDecimal(0);
        for (Planet planet : collection) {
            if (planet != null) {
                resultCalculate = resultCalculate.add(planet.getMassPlanet());
            }
        }
        return resultCalculate;
    }

}

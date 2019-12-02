package com.lugowoy.tasks.solutions.oop.calculationOfVariousDataAboutPlanetsOfSolarSystem.calculating;

import com.lugowoy.tasks.solutions.oop.calculationOfVariousDataAboutPlanetsOfSolarSystem.model.Planet;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;

import static com.lugowoy.tasks.solutions.oop.calculationOfVariousDataAboutPlanetsOfSolarSystem.model.SolarSystem.PLANETS_IN_THE_SOLAR_SYSTEM;

/**
 * Created by LugowoyKonstantin on 07.03.2017.
 */

public class CalculatorArithmeticMeanOfTheMassesOfAllPlanets {

    public static BigDecimal calculateArithmeticMeanOfTheMassesOfAllPlanets(Collection<Planet> collection) {
        return CalculatorMassAllPlanets.calculateMassAllPlanets(collection).divide(new BigDecimal(PLANETS_IN_THE_SOLAR_SYSTEM), 2, RoundingMode.HALF_DOWN);
    }

}

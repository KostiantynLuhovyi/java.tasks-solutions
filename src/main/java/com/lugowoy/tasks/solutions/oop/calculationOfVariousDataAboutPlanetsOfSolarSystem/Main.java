package com.lugowoy.tasks.calculationOfVariousDataAboutPlanetsOfSolarSystem;

import com.lugowoy.tasks.calculationOfVariousDataAboutPlanetsOfSolarSystem.calculating.Calculating;
import com.lugowoy.tasks.calculationOfVariousDataAboutPlanetsOfSolarSystem.calculating.CalculatorArithmeticMeanOfTheMassesOfAllPlanets;
import com.lugowoy.tasks.calculationOfVariousDataAboutPlanetsOfSolarSystem.calculating.CalculatorMassAllPlanets;
import com.lugowoy.tasks.calculationOfVariousDataAboutPlanetsOfSolarSystem.model.DataOfPlanet;
import com.lugowoy.tasks.calculationOfVariousDataAboutPlanetsOfSolarSystem.model.Planet;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.lugowoy.tasks.calculationOfVariousDataAboutPlanetsOfSolarSystem.model.SolarSystem.PLANETS_IN_THE_SOLAR_SYSTEM;

/**
 * Calculate the total mass of all the planets of the solar system.
 * Calculate the arithmetic mean of the masses of the planets.
 * Then - the mass of each planet in percentages, if we take as 100% the total mass of all the planets.
 * <p>
 * Created by LugowoyKonstantin on 07.03.2017.
 */

public class Main {

    public static void main(String[] args) {

        List<Planet> planetsList = new ArrayList<>(PLANETS_IN_THE_SOLAR_SYSTEM);

        FILLING.fill(planetsList);

        planetsList.stream().filter(Objects::nonNull).forEachOrdered(System.out::println);
        System.out.println();

        Calculating<BigDecimal, Planet> calculating = CalculatorMassAllPlanets::calculateMassAllPlanets;

        BigDecimal sumMassAllPlanetsInTheSolarSystem = new BigDecimal(calculating.calculate(planetsList).doubleValue());

        System.out.println("The mass of all planets is : " + sumMassAllPlanetsInTheSolarSystem);
        System.out.println();

        calculating = CalculatorArithmeticMeanOfTheMassesOfAllPlanets::calculateArithmeticMeanOfTheMassesOfAllPlanets;
        BigDecimal arithmeticMeanOfTheMassesOfAllPlanets = calculating.calculate(planetsList);

        System.out.println("The arithmetic mean of the masses of all planets is : " + arithmeticMeanOfTheMassesOfAllPlanets);
        System.out.println();

        System.out.println("The mass of each planet in percentages, if we take as 100% the total mass of all the planets.");
        planetsList.forEach(planet -> System.out.println(planet.getNamePlanet() + " = "
                            + new BigDecimal(100).multiply(planet.getMassPlanet()
                                                      .divide(sumMassAllPlanetsInTheSolarSystem, 5, RoundingMode.HALF_DOWN))));

    }

    private static final Filling<Planet> FILLING = planets -> {
        for (int i = 0; i < PLANETS_IN_THE_SOLAR_SYSTEM; i++) {
            Planet planet = new Planet();
            DataOfPlanet dataOfPlanet = DataOfPlanet.getDataOfPlanet(i);
            planet.setNamePlanet(dataOfPlanet.name());
            planet.setMassPlanet(new BigDecimal(dataOfPlanet.getMass()));
            planets.add(planet);
        }
    };

}

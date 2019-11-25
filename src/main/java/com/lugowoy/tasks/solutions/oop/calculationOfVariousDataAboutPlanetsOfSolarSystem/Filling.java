package com.lugowoy.tasks.calculationOfVariousDataAboutPlanetsOfSolarSystem;

import java.util.Collection;

/**
 * Created by LugowoyKonstantin on 07.03.2017.
 */

@FunctionalInterface
public interface Filling<T> {

    void fill(Collection<T> tCollection);

}

package com.lugowoy.tasks.solutions.core.checkCorrectnessOfEnteredTimeData;

/**
 * Created by Konstantin Lugowoy on 01.10.2017.
 */

@FunctionalInterface
public interface Checker {

    boolean check(int value);

}

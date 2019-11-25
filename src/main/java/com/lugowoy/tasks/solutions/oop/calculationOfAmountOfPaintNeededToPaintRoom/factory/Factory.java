package com.lugowoy.tasks.calculationOfAmountOfPaintNeededToPaintRoom.factory;

/**
 * Created by LugowoyKonstantin on 17-Feb-17.
 */

@FunctionalInterface
public interface Factory<T> {

    T create();

}

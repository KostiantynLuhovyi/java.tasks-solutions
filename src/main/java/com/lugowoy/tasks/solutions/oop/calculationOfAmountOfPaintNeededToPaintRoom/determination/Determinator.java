package com.lugowoy.tasks.calculationOfAmountOfPaintNeededToPaintRoom.determination;

/**
 * Created by LugowoyKonstantin on 20-Feb-17.
 */

@FunctionalInterface
public interface Determinator<T, V, Z> {

    T determine(V v, Z z);

}

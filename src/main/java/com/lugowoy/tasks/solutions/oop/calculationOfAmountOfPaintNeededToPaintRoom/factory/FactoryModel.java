package com.lugowoy.tasks.solutions.oop.calculationOfAmountOfPaintNeededToPaintRoom.factory;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.Reading;

/**
 * Created by LugowoyKonstantin on 21-Feb-17.
 */

public abstract class FactoryModel<T> {

    private final Reader reader;

    public FactoryModel(Reader reader) {
        this.reader = reader;
    }

    public FactoryModel(Reading reading) {
        this.reader = new Reader(reading);
    }

    public Reader getReader() {
        return reader;
    }

}

package com.lugowoy.tasks.outputVoiceThatIsEmittedByAnimal.animals;

import java.io.Serializable;
import java.util.Objects;

/** Created by Konstantin Lugowoy on 04.10.2017. */

public abstract class Animal implements Serializable, Cloneable {

    private String voice;

    public Animal(String voice) {
        this.voice = voice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal)) return false;
        Animal animal = (Animal) o;
        return Objects.equals(getVoice(), animal.getVoice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVoice());
    }

    @Override
    public String toString() {
        return "[" +
                "voice='" + voice + '\'' +
                ']';
    }

    public String getVoice() {
        return voice;
    }

    protected void setVoice(String voice) {
        this.voice = voice;
    }

}

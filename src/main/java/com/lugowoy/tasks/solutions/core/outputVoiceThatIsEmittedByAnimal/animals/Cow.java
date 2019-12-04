package com.lugowoy.tasks.solutions.core.outputVoiceThatIsEmittedByAnimal.animals;

import com.rits.cloning.Cloner;

/** Created by Konstantin Lugowoy on 04.10.2017. */

public class Cow extends Animal {

    public Cow() {
        super("Moo-moo !");
    }

    @Override
    public String toString() {
        return this.getClass() + super.toString();
    }

    @Override
    public Cow clone() {
        Cow cow = new Cow();
        try {
            cow = (Cow) super.clone();
            cow.setVoice(new Cloner().deepClone(this.getVoice()));
        } catch (CloneNotSupportedException ex) {
            new InternalError(ex.getMessage()).printStackTrace();
        }
        return cow;
    }

}

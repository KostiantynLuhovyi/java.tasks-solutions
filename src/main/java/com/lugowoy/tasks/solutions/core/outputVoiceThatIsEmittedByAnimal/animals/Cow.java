package com.lugowoy.tasks.outputVoiceThatIsEmittedByAnimal.animals;

import static com.lugowoy.helper.other.DeepCloning.CLONER;

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
            cow.setVoice(CLONER.deepClone(this.getVoice()));
        } catch (CloneNotSupportedException ex) {
            new InternalError(ex.getMessage()).printStackTrace();
        }
        return cow;
    }

}

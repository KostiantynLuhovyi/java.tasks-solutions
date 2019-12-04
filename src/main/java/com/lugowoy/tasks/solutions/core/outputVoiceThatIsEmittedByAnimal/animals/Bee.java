package com.lugowoy.tasks.solutions.core.outputVoiceThatIsEmittedByAnimal.animals;

import com.rits.cloning.Cloner;

/** Created by Konstantin Lugowoy on 04.10.2017. */

public class Bee extends Animal {

    public Bee() {
        super("Z - Z - Z !");
    }

    @Override
    public String toString() {
        return this.getClass() + super.toString();
    }

    @Override
    public Bee clone() {
        Bee bee = new Bee();
        try {
            bee = (Bee) super.clone();
            bee.setVoice(new Cloner().deepClone(this.getVoice()));
        } catch (CloneNotSupportedException ex) {
            new InternalError(ex.getMessage()).printStackTrace();
        }
        return bee;
    }

}

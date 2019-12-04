package com.lugowoy.tasks.solutions.core.outputVoiceThatIsEmittedByAnimal.animals;

import com.rits.cloning.Cloner;

/** Created by Konstantin Lugowoy on 04.10.2017. */

public class Chick extends Animal {

    public Chick() {
        super("Cheep-cheep !");
    }

    @Override
    public String toString() {
        return this.getClass() + super.toString();
    }

    @Override
    public Chick clone() {
        Chick chick = new Chick();
        try {
            chick = (Chick) super.clone();
            chick.setVoice(new Cloner().deepClone(this.getVoice()));
        } catch (CloneNotSupportedException ex) {
            new InternalError(ex.getMessage()).printStackTrace();
        }
        return chick;
    }

}

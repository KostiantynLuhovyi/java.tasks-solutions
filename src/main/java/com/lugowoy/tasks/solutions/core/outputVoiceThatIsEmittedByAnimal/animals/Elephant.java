package com.lugowoy.tasks.solutions.core.outputVoiceThatIsEmittedByAnimal.animals;

import com.rits.cloning.Cloner;

/** Created by Konstantin Lugowoy on 04.10.2017. */

public class Elephant extends Animal {

    public Elephant() {
        super("Ugh, ugh !");
    }


    @Override
    public String toString() {
        return this.getClass() + super.toString();
    }

    @Override
    public Elephant clone() {
        Elephant elephant = new Elephant();
        try {
            elephant = (Elephant) super.clone();
            elephant.setVoice(new Cloner().deepClone(this.getVoice()));
        } catch (CloneNotSupportedException ex) {
            new InternalError(ex.getMessage()).printStackTrace();
        }
        return elephant;
    }

}

package com.lugowoy.tasks.outputVoiceThatIsEmittedByAnimal.animals;

import static com.lugowoy.helper.other.DeepCloning.CLONER;

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
            elephant.setVoice(CLONER.deepClone(this.getVoice()));
        } catch (CloneNotSupportedException ex) {
            new InternalError(ex.getMessage()).printStackTrace();
        }
        return elephant;
    }

}

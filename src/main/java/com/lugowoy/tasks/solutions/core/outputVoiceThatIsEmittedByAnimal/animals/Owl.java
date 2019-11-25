package com.lugowoy.tasks.outputVoiceThatIsEmittedByAnimal.animals;

import static com.lugowoy.helper.other.DeepCloning.CLONER;

/** Created by Konstantin Lugowoy on 04.10.2017. */

public class Owl extends Animal {

    public Owl() {
        super("To - who !");
    }

    @Override
    public String toString() {
        return this.getClass() + super.toString();
    }

    @Override
    public Owl clone() {
        Owl owl = new Owl();
        try {
            owl = (Owl) super.clone();
            owl.setVoice(CLONER.deepClone(this.getVoice()));
        } catch (CloneNotSupportedException ex) {
            new InternalError(ex.getMessage()).printStackTrace();
        }
        return owl;
    }

}

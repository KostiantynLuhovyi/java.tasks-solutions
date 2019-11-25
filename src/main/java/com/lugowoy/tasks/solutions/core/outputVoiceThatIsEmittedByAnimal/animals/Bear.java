package com.lugowoy.tasks.outputVoiceThatIsEmittedByAnimal.animals;

import static com.lugowoy.helper.other.DeepCloning.CLONER;

/** Created by Konstantin Lugowoy on 04.10.2017. */

public class Bear extends Animal {

    public Bear() {
        super("Gr - Gr - Gr !");
    }

    @Override
    public String toString() {
        return this.getClass() + super.toString();
    }

    @Override
    public Bear clone() {
        Bear bear = new Bear();
        try {
            bear = (Bear) super.clone();
            bear.setVoice(CLONER.deepClone(this.getVoice()));
        } catch (CloneNotSupportedException ex) {
            new InternalError(ex.getMessage()).printStackTrace();
        }
        return bear;
    }

}

package com.lugowoy.tasks.outputVoiceThatIsEmittedByAnimal.animals;

import static com.lugowoy.helper.other.DeepCloning.CLONER;

/** Created by Konstantin Lugowoy on 04.10.2017. */

public class Rooster extends Animal {

    public Rooster() {
        super("Cock-a-doodle-doo !");
    }

    @Override
    public String toString() {
        return this.getClass() + super.toString();
    }

    @Override
    public Rooster clone() {
        Rooster rooster = new Rooster();
        try {
            rooster = (Rooster) super.clone();
            rooster.setVoice(CLONER.deepClone(this.getVoice()));
        } catch (CloneNotSupportedException ex) {
            new InternalError(ex.getMessage()).printStackTrace();
        }
        return rooster;
    }

}

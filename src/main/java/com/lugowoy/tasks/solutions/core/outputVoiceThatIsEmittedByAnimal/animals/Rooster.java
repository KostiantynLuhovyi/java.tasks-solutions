package com.lugowoy.tasks.solutions.core.outputVoiceThatIsEmittedByAnimal.animals;

import com.rits.cloning.Cloner;

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
            rooster.setVoice(new Cloner().deepClone(this.getVoice()));
        } catch (CloneNotSupportedException ex) {
            new InternalError(ex.getMessage()).printStackTrace();
        }
        return rooster;
    }

}

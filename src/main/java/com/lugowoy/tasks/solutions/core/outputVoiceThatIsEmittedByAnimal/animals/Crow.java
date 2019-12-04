package com.lugowoy.tasks.solutions.core.outputVoiceThatIsEmittedByAnimal.animals;

import com.lugowoy.tasks.solutions.core.outputVoiceThatIsEmittedByAnimal.animals.Animal;
import com.rits.cloning.Cloner;

/** Created by Konstantin Lugowoy on 04.10.2017. */

public class Crow extends Animal {

    public Crow() {
        super("Caw, caw !");
    }

    @Override
    public String toString() {
        return this.getClass() + super.toString();
    }

    @Override
    public Crow clone() {
        Crow crow = new Crow();
        try {
            crow = (Crow) super.clone();
            crow.setVoice(new Cloner().deepClone(this.getVoice()));
        } catch (CloneNotSupportedException ex) {
            new InternalError(ex.getMessage()).printStackTrace();
        }
        return crow;
    }

}

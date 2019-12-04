package com.lugowoy.tasks.solutions.core.outputVoiceThatIsEmittedByAnimal.animals;

import com.rits.cloning.Cloner;

/** Created by Konstantin Lugowoy on 04.10.2017. */

public class Dog extends Animal {

    public Dog() {
        super("Woof !");
    }

    @Override
    public String toString() {
        return this.getClass() + super.toString();
    }

    @Override
    public Dog clone() {
        Dog dog = new Dog();
        try {
            dog = (Dog) super.clone();
            dog.setVoice(new Cloner().deepClone(this.getVoice()));
        } catch (CloneNotSupportedException ex) {
            new InternalError(ex.getMessage()).printStackTrace();
        }
        return dog;
    }

}

package com.lugowoy.tasks.outputVoiceThatIsEmittedByAnimal.animals;

import static com.lugowoy.helper.other.DeepCloning.CLONER;

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
            dog.setVoice(CLONER.deepClone(this.getVoice()));
        } catch (CloneNotSupportedException ex) {
            new InternalError(ex.getMessage()).printStackTrace();
        }
        return dog;
    }

}

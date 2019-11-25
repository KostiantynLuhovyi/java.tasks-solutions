package com.lugowoy.tasks.outputVoiceThatIsEmittedByAnimal;

import com.lugowoy.tasks.outputVoiceThatIsEmittedByAnimal.animals.Animal;

/**
 * Created by Konstantin Lugowoy on 04.10.2017.
 */

public class Screaming {

    public void scream(Animal animal) {
        System.out.println(animal.getVoice());
    }

}

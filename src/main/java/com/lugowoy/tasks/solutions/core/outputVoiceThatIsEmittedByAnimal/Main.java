package com.lugowoy.tasks.solutions.core.outputVoiceThatIsEmittedByAnimal;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.tasks.solutions.core.outputVoiceThatIsEmittedByAnimal.animals.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a program that prompts the user to select an animal from the list (1 - cat, 2 - dog, etc.),
 * and in response shows what voices the selected animal makes.
 * There should be at least 10 animals on the list.
 * <p>
 * Created by Konstantin Lugowoy on 04.10.2017.
 */

public class Main {

    private static final Reader READER = new Reader(new ReadingConsole());

    public static void main(String[] args) {

        List<Animal> animalList = fillArrayListAnimal();

        int number = getSelectAnimal(animalList);

        Screaming screaming = new Screaming();
        screaming.scream(animalList.get(number));

    }

    private static int getSelectAnimal(List<Animal> animalList) {
        System.out.println("Enter number animal : ");
        int number;
        while (true) {
            number = READER.readInt();
            if ((number >= 0) && (number <= animalList.size())) {
                break;
            } else {
                System.out.println("Not correct number. Re-enter : ");
            }
        }
        return number;
    }

    private static List<Animal> fillArrayListAnimal() {
        List<Animal> animalList = new ArrayList<>(0);
        animalList.add(new Bear());
        animalList.add(new Bee());
        animalList.add(new Cat());
        animalList.add(new Chick());
        animalList.add(new Cow());
        animalList.add(new Crow());
        animalList.add(new Dog());
        animalList.add(new Donkey());
        animalList.add(new Elephant());
        animalList.add(new Mouse());
        animalList.add(new Owl());
        animalList.add(new Rooster());
        return animalList;
    }

}

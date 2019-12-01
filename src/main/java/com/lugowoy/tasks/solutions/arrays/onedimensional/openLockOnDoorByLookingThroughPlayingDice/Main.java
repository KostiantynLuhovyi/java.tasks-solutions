package com.lugowoy.tasks.solutions.arrays.onedimensional.openLockOnDoorByLookingThroughPlayingDice;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;

/**
 * The secret lock for the safe consists of 10 cells arranged in a row, into which it is necessary to insert the playing dice.
 * But the door is opened only if in any three neighboring cells the sum of the points on the front faces of the cubes is 10.
 * (The dice has 1 to 6 dots on each face.)
 * Write a program that unravels the lock code, provided that two dice already inserted in the cells.
 *
 * <p> Created by Konstantin Lugowoy on 27.03.2017.
 */

public class Main {

    private static final Reader READER = new Reader(new ReadingConsole());

    private static final Filling FILLING = Filling::fillingDoorLock;

    private static final Opening OPENING = Opening::openDoorLock;

    public static void main(String[] args) {
        DoorLock doorLock = new DoorLock();
        System.out.println(doorLock);

        String resume;
        do {
            FILLING.filling(doorLock);
            System.out.println(doorLock);
            if (OPENING.open(doorLock)) {
                System.out.println("Door open.");
                break;
            } else {
                System.out.println("Door not open. Do you want to repeat, press \'r\'.");
                System.out.println("If you do not want to repeat, press \'f\'.");
                System.out.println("Enter : ");
                resume = READER.readString();

                if (resume.equals("f")) break;
            }

        } while (resume.equals("r"));

    }

}

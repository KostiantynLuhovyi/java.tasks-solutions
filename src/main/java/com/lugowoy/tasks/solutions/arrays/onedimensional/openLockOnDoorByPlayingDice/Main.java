package com.lugowoy.tasks.solutions.arrays.onedimensional.openLockOnDoorByPlayingDice;

import com.lugowoy.helper.utils.RandomNumber;

import java.util.Arrays;

import static com.lugowoy.tasks.solutions.arrays.onedimensional.openLockOnDoorByPlayingDice.PlayingDice.LOWER_VALUE_PLAYING_DICE;
import static com.lugowoy.tasks.solutions.arrays.onedimensional.openLockOnDoorByPlayingDice.PlayingDice.UPPER_VALUE_PLAYING_DICE;

/**
 * The secret lock for the safe consists of 10 cells arranged in a row, into which it is necessary to insert the playing dice.
 * But the door is opened only if in any three neighboring cells the sum of the points on the front faces of the cubes is 10.
 * (The dice has 1 to 6 dots on each face.)
 * Write a program that unravels the lock code, provided that two dice already inserted in the cells.
 *
 * <p>Created by Konstantin Lugowoy on 27.03.2017.
 */
public class Main {

    private static final Opening OPENING = Opening::openDoorLock;

    public static void main(String[] args) {

        PlayingDice[] playingDices = createStartPlayingDicesArray();
        System.out.println("Start playing dices : " + Arrays.toString(playingDices));

        DoorLock doorLock = new DoorLock();

        OPENING.open(doorLock, playingDices);
        System.out.println("Finish playing dices : " + Arrays.toString(playingDices));

        if (doorLock.isLock()) {
            System.out.println("The door lock did not open.");
        } else {
            System.out.println("The door lock has opened.");
        }

    }

    private static PlayingDice[] createStartPlayingDicesArray() {
        RandomNumber random = new RandomNumber();
        int amountPlayingDice = 10;
        PlayingDice[] playingDices = new PlayingDice[amountPlayingDice];
        int countPlayingDice = 0;
        while (countPlayingDice < 2) {
            int randomIndex = random.generateInt(amountPlayingDice - 1);
            int diceValue = random.generateInt(LOWER_VALUE_PLAYING_DICE,
                                               UPPER_VALUE_PLAYING_DICE);
            playingDices[randomIndex] = new PlayingDice(diceValue);
            countPlayingDice++;
        }
        return playingDices;
    }

}

package com.lugowoy.tasks.solutions.arrays.onedimensional.openLockOnDoorByPlayingDice;

/**
 * Created by Konstantin Lugowoy on 27.03.2017.
 */
public class PlayingDice {

    public static final int LOWER_VALUE_PLAYING_DICE = 0;
    public static final int UPPER_VALUE_PLAYING_DICE = 6;

    private int value;

    public PlayingDice(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "PlayingDice[" +
                "value=" + value +
                ']';
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}

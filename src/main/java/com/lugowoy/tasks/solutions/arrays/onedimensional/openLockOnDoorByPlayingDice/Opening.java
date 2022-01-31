package com.lugowoy.tasks.solutions.arrays.onedimensional.openLockOnDoorByPlayingDice;

import com.lugowoy.helper.utils.RandomNumber;

import static com.lugowoy.tasks.solutions.arrays.onedimensional.openLockOnDoorByPlayingDice.DoorLock.VALUE_FOR_OPENING;
import static com.lugowoy.tasks.solutions.arrays.onedimensional.openLockOnDoorByPlayingDice.PlayingDice.LOWER_VALUE_PLAYING_DICE;
import static com.lugowoy.tasks.solutions.arrays.onedimensional.openLockOnDoorByPlayingDice.PlayingDice.UPPER_VALUE_PLAYING_DICE;

/**
 * Created by Konstantin Lugowoy on 27.03.2017.
 */
@FunctionalInterface
public interface Opening {

    void open(DoorLock doorLock, PlayingDice[] playingDices);

    static void openDoorLock(DoorLock doorLock, PlayingDice[] playingDices) {
        fillArrayPlayingDices(playingDices);
        for (int i = 2; i < playingDices.length; i++) {
            int tmpValue = playingDices[i].getValue()
                           + playingDices[i - 1].getValue()
                           + playingDices[i - 2].getValue();
            if (tmpValue == VALUE_FOR_OPENING) {
                doorLock.open(false);
                break;
            }
        }
    }

    private static void fillArrayPlayingDices(PlayingDice[] playingDices) {
        RandomNumber random = new RandomNumber();
        for (int i = 0; i < playingDices.length; i++) {
            if (playingDices[i] == null) {
                playingDices[i] = new PlayingDice(random.generateInt(
                        LOWER_VALUE_PLAYING_DICE, UPPER_VALUE_PLAYING_DICE));
            }
        }
    }

}

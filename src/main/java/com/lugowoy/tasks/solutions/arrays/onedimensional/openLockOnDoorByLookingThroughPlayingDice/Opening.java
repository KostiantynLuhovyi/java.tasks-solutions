package com.lugowoy.tasks.solutions.arrays.onedimensional.openLockOnDoorByLookingThroughPlayingDice;

import com.lugowoy.helper.utils.generating.GeneratorRandomNumber;

import static com.lugowoy.tasks.solutions.arrays.onedimensional.openLockOnDoorByLookingThroughPlayingDice.DoorLock.VALUE_FOR_OPENING;
import static com.lugowoy.tasks.solutions.arrays.onedimensional.openLockOnDoorByLookingThroughPlayingDice.PlayingDice.LOWER_VALUE_PLAYING_DICE;
import static com.lugowoy.tasks.solutions.arrays.onedimensional.openLockOnDoorByLookingThroughPlayingDice.PlayingDice.UPPER_VALUE_PLAYING_DICE;

/**
 * Created by Konstantin Lugowoy on 27.03.2017.
 */
@FunctionalInterface
public interface Opening {

    void open(DoorLock doorLock, PlayingDice[] playingDices);

    static void openDoorLock(DoorLock doorLock, PlayingDice[] playingDices) {
        fillArrayPlayingDices(playingDices);
        for (int i = 2; i < playingDices.length; i++) {
            int tmpValue = playingDices[i].getValue() + playingDices[i - 1].getValue() + playingDices[i - 2].getValue();
            if (tmpValue == VALUE_FOR_OPENING) {
                doorLock.open(false);
                break;
            }
        }
    }

    private static void fillArrayPlayingDices(PlayingDice[] playingDices) {
        for (int i = 0; i < playingDices.length; i++) {
            if (playingDices[i] == null) {
                playingDices[i] = new PlayingDice(GeneratorRandomNumber.generateInt(LOWER_VALUE_PLAYING_DICE, UPPER_VALUE_PLAYING_DICE));
            }
        }
    }

}

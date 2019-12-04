package com.lugowoy.tasks.solutions.core.checkCorrectnessOfEnteredTimeData;

/**
 * Created by Konstantin Lugowoy on 02.10.2017.
 */

public class CheckerSeconds {

    public static boolean checkCorrectSeconds(int seconds) {
        boolean resultCheck = false;
        if ((seconds >= 0) && (seconds <= 59)) {
            resultCheck = true;
        }
        return resultCheck;
    }

}

package com.lugowoy.tasks.solutions.core.checkCorrectnessOfEnteredTimeData;

/**
 * Created by Konstantin Lugowoy on 02.10.2017.
 */

public class CheckerHours {

    public static boolean checkCorrectHours(int hours) {
        boolean resultCheck = false;
        if ((hours >= 0) && (hours <= 23)) {
            resultCheck = true;
        }
        return resultCheck;
    }

}

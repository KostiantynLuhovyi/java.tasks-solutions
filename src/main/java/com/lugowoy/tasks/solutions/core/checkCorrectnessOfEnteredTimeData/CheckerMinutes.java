package com.lugowoy.tasks.solutions.core.checkCorrectnessOfEnteredTimeData;

/**
 * Created by Konstantin Lugowoy on 02.10.2017.
 */

public class CheckerMinutes {

    public static boolean checkCorrectMinutes(int minutes) {
        boolean resultCheck = false;
        if ((minutes >= 0) && (minutes <= 59)) {
            resultCheck = true;
        }
        return resultCheck;
    }

}

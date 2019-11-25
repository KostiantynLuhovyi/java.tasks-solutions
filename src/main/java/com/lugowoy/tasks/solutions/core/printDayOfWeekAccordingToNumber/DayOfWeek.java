package com.lugowoy.tasks.printDayOfWeekAccordingToNumber;

/**
 * Created by Konstantin Lugowoy on 01.10.2017.
 */

public enum DayOfWeek {
    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7);

    private final int indexDay;

    DayOfWeek(int indexDay) {
        this.indexDay = indexDay;
    }

    public int getIndexDay() {
        return indexDay;
    }

}

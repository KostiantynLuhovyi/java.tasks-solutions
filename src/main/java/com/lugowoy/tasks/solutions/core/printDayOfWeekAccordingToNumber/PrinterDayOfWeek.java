package com.lugowoy.tasks.printDayOfWeekAccordingToNumber;

/**
 * Created by Konstantin Lugowoy on 01.10.2017.
 */

@FunctionalInterface
public interface PrinterDayOfWeek {

    DayOfWeek print(int indexDay);

    static DayOfWeek printDayOfWeekAccordingToNumberToUseSwitchInstruction(int indexDay) {
        DayOfWeek dayOfWeek = null;
        switch (indexDay) {
            case 1 : dayOfWeek = DayOfWeek.MONDAY; break;
            case 2 : dayOfWeek = DayOfWeek.TUESDAY; break;
            case 3 : dayOfWeek = DayOfWeek.WEDNESDAY; break;
            case 4 : dayOfWeek = DayOfWeek.THURSDAY; break;
            case 5 : dayOfWeek = DayOfWeek.FRIDAY; break;
            case 6 : dayOfWeek = DayOfWeek.SATURDAY; break;
            case 7 : dayOfWeek = DayOfWeek.SUNDAY; break;
        }
        return dayOfWeek;
    }

    static DayOfWeek printDayOfWeekAccordingToNumberToUseIfInstruction(int indexDay) {
        DayOfWeek dayOfWeek = null;
        if (indexDay == 1) {
            dayOfWeek = DayOfWeek.MONDAY;
        } else if (indexDay == 2) {
            dayOfWeek = DayOfWeek.TUESDAY;
        } else if (indexDay == 3) {
            dayOfWeek = DayOfWeek.WEDNESDAY;
        } else if (indexDay == 4) {
            dayOfWeek = DayOfWeek.THURSDAY;
        } else if (indexDay == 5) {
            dayOfWeek = DayOfWeek.FRIDAY;
        } else if (indexDay == 6) {
            dayOfWeek = DayOfWeek.SATURDAY;
        } else if (indexDay == 7) {
            dayOfWeek = DayOfWeek.SUNDAY;
        }
        return dayOfWeek;
    }

}

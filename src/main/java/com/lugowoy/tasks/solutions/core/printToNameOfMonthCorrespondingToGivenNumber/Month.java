package com.lugowoy.tasks.solutions.core.printToNameOfMonthCorrespondingToGivenNumber;

/**
 * Created by Konstantin Lugowoy on 29.09.2018.
 */

public enum Month {
    JANUARY(1),
    FEBRUARY(2),
    MARCH(3),
    APRIL(4),
    MAY(5),
    JUNE(6),
    JULY(7),
    AUGUST(8),
    SEPTEMBER(9),
    OCTOBER(10),
    NOVEMBER(11),
    DECEMBER(12);

    private int indexOFMonth;

    Month(int indexOFMonth) {
        this.indexOFMonth = indexOFMonth;
    }

    public int getIndexOFMonth() {
        return indexOFMonth;
    }

}

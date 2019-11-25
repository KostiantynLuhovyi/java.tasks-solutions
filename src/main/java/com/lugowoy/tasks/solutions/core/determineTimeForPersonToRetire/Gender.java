package com.lugowoy.tasks.determineTimeForPersonToRetire;

/**
 * Created by Konstantin Lugowoy on 02.10.2017.
 */

public enum Gender {
    MEN(0),
    WOMAN(1);

    private int indexGender;

    Gender(int indexGender) {
        this.indexGender = indexGender;
    }

    @Override
    public String toString() {
        return "Gender[" +
                "indexGender=" + indexGender +
                ']';
    }

    public int getIndexGender() {
        return indexGender;
    }

    public void setIndexGender(int indexGender) {
        this.indexGender = indexGender;
    }
}

package com.lugowoy.tasks.programForCalculatingStudentRequiredFundsForLiving;

import com.rits.cloning.Cloner;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by LugowoyKonstantin on 02.11.2017.
 */

public class Name implements Serializable, Cloneable {

    private String firstName;
    private String secondName;

    public Name() {
    }

    public Name(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Name)) return false;
        Name name = (Name) o;
        return Objects.equals(getFirstName(), name.getFirstName()) &&
                Objects.equals(getSecondName(), name.getSecondName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getSecondName());
    }

    @Override
    public String toString() {
        return "Name[" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ']';
    }

    @Override
    public Name clone() {
        Name name = new Name();
        Cloner cloner = new Cloner();
        try {
            name = (Name) super.clone();
            name.setFirstName(cloner.deepClone(this.getFirstName()));
            name.setSecondName(cloner.deepClone(this.getSecondName()));
        } catch (CloneNotSupportedException ex) {
            new InternalError(ex.getMessage()).printStackTrace();
        }
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.isEmpty()) {
            throw new IllegalArgumentException("First name can not be empty.");
        } else {
            this.firstName = firstName;
        }
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        if (secondName.isEmpty()) {
            throw new IllegalArgumentException("Second name can not be empty");
        } else {
            this.secondName = secondName;
        }
    }
}

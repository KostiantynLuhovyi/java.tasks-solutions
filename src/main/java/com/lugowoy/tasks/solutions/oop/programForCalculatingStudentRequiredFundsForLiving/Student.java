package com.lugowoy.tasks.programForCalculatingStudentRequiredFundsForLiving;

import com.rits.cloning.Cloner;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Created by LugowoyKonstantin on 02.11.2017.
 */

public class Student extends User {

    private Name name;

    private Stipend stipend;

    public Student() {
    }

    public Student(Name name, Stipend stipend) {
        this.name = name;
        this.stipend = stipend;
    }

    public Student(String firstName, String secondName, double amountOfStipend) {
        this.name = new Name(firstName, secondName);
        this.stipend = new Stipend(new BigDecimal(amountOfStipend));
    }

    public Student(long userId, Name name, Stipend stipend) {
        super(userId);
        this.name = name;
        this.stipend = stipend;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(getName(), student.getName()) &&
                Objects.equals(getStipend(), student.getStipend());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getName(), getStipend());
    }

    @Override
    public String toString() {
        return super.toString() + "[" +
                "name=" + name +
                ", stipend=" + stipend +
                ']';
    }

    @Override
    public Student clone() {
        Student student = (Student) super.clone();
        Cloner cloner = new Cloner();
        student.setName(cloner.deepClone(this.getName()));
        student.setStipend(cloner.deepClone(this.getStipend()));
        return student;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        if (name != null) {
            this.name = name;
        } else {
            throw new NullPointerException("null");
        }
    }

    public Stipend getStipend() {
        return stipend;
    }

    public void setStipend(Stipend stipend) {
        if (stipend != null) {
            this.stipend = stipend;
        } else {
            throw new NullPointerException("null");
        }
    }

}

package com.lugowoy.tasks.solutions.core.determineTimeForPersonToRetire;

import java.io.Serializable;

/**
 * Created by Konstantin Lugowoy on 02.10.2017.
 */

public class Person implements Serializable, Cloneable {

    private int age;
    private Gender gender;

    public Person() {
    }

    public Person(int age, Gender gender) {
        this.age = age;
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        return gender == person.gender;
    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Person[" +
                "age=" + age +
                ", sex=" + gender +
                ']';
    }

    @Override
    public Person clone() {
        Person person = new Person();
        try {
            person = (Person) super.clone();
            person.setAge(this.getAge());
            person.setGender(this.getGender());
        } catch (CloneNotSupportedException ex) {
            new InternalError(ex.getMessage()).printStackTrace();
        }
        return person;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

}

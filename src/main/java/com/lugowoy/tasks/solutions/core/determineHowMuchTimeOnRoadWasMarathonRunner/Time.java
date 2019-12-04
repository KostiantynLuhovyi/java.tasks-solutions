package com.lugowoy.tasks.solutions.core.determineHowMuchTimeOnRoadWasMarathonRunner;

import java.util.Calendar;
import java.util.Objects;

/**
 * Created by Konstantin Lugowoy on 23.03.2017.
 */

public class Time {

    private int hour;
    private int minutes;
    private int second;

    private Calendar time;

    public Time() {
    }

    public Time(int hour, int minutes, int second) {
        this.time = Calendar.getInstance();

        this.hour = hour;
        this.time.add(Calendar.HOUR_OF_DAY, hour);

        this.minutes = minutes;
        this.time.add(Calendar.MINUTE, minutes);

        this.second = second;
        this.time.add(Calendar.SECOND, second);
    }

    public Time(Calendar time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Time)) return false;
        Time time1 = (Time) o;
        return getHour() == time1.getHour() &&
                getMinutes() == time1.getMinutes() &&
                getSecond() == time1.getSecond() &&
                Objects.equals(getTime(), time1.getTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHour(), getMinutes(), getSecond(), getTime());
    }

    @Override
    public String toString() {
        return "Time[" +
                "hour=" + hour +
                ", minutes=" + minutes +
                ", second=" + second +
                ']';
    }

    @Override
    public Time clone() {
        Time time = new Time();
        try {
            time = (Time) super.clone();
            time.setHour(this.getHour());
            time.setMinutes(this.getMinutes());
            time.setSecond(this.getSecond());
        } catch (CloneNotSupportedException ex) {
            new InternalError(ex.getMessage()).printStackTrace();
        }
        return time;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public Calendar getTime() {
        return time;
    }

    public void setTime(Calendar time) {
        this.time = time;
    }

}

package com.lugowoy.tasks.solutions.core.determineHowMuchTimeOnRoadWasMarathonRunner;

import com.rits.cloning.Cloner;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Konstantin Lugowoy on 23.03.2017.
 */

public class MarathonRunner implements Serializable, Cloneable {

    private double distance;
    private double speed;

    private Time time;

    public MarathonRunner() {
    }

    public MarathonRunner(double distance, double speed) {
        this.distance = distance;
        this.speed = speed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MarathonRunner)) return false;
        MarathonRunner that = (MarathonRunner) o;
        return Double.compare(that.getDistance(), getDistance()) == 0 &&
                Double.compare(that.getSpeed(), getSpeed()) == 0 &&
                Objects.equals(getTime(), that.getTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDistance(), getSpeed(), getTime());
    }

    @Override
    public String toString() {
        return "MarathonRunner[" +
                "distance=" + distance +
                ", speed=" + speed +
                ", time=" + time +
                ']';
    }

    @Override
    public MarathonRunner clone() {
        MarathonRunner marathonRunner = new MarathonRunner();
        try {
            marathonRunner = (MarathonRunner) super.clone();
            marathonRunner.setDistance(this.getDistance());
            marathonRunner.setSpeed(this.getSpeed());
            marathonRunner.setTime(new Cloner().deepClone(this.getTime()));
        } catch (CloneNotSupportedException ex) {
            new InternalError(ex.getMessage()).printStackTrace();
        }
        return marathonRunner;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Time getTime() {
        return time;
    }

}

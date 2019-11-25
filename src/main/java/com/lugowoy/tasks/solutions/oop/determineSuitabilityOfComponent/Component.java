package com.lugowoy.tasks.determineSuitabilityOfComponent;

import java.io.Serializable;

/**
 * Created by LugowoyKonstantin on 07.03.2017.
 */

public class Component implements Serializable, Cloneable {

    private int size;

    public Component() {
    }

    public Component(int size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Component)) return false;

        Component component = (Component) o;

        return getSize() == component.getSize();
    }

    @Override
    public int hashCode() {
        return getSize();
    }

    @Override
    public String toString() {
        return "Component[" +
                "size=" + size +
                ']';
    }

    @Override
    public Component clone() {
        Component component = new Component();
        try {
            component = (Component) super.clone();
            component.setSize(this.getSize());
        } catch (CloneNotSupportedException ex) {
            new InternalError(ex.getMessage()).printStackTrace();
        }
        return component;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}

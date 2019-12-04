package com.lugowoy.tasks.solutions.core.exchangePlacesTwoVariablesWithAndWithoutUseOfThirdVariable;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Konstantin Lugowoy on 18-Jan-17.
 */

public class Variables implements Serializable, Cloneable {

    private int firstVariable;
    private int secondVariable;

    public Variables() {
    }

    public Variables(int firstVariable, int secondVariable) {
        this.firstVariable = firstVariable;
        this.secondVariable = secondVariable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Variables)) return false;
        Variables variables = (Variables) o;
        return getFirstVariable() == variables.getFirstVariable() &&
                getSecondVariable() == variables.getSecondVariable();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstVariable(), getSecondVariable());
    }

    @Override
    public String toString() {
        return "Variables[" +
                "firstVariable=" + firstVariable +
                ", secondVariable=" + secondVariable +
                ']';
    }

    @Override
    public Variables clone() {
        Variables variables = new Variables();
        try {
            variables = (Variables) super.clone();
            variables.setFirstVariable(this.getFirstVariable());
            variables.setSecondVariable(this.getSecondVariable());
        } catch (CloneNotSupportedException ex) {
            new InternalError(ex.getMessage()).printStackTrace();
        }
        return variables;
    }

    public int getSecondVariable() {
        return secondVariable;
    }

    public void setSecondVariable(int secondVariable) {
        this.secondVariable = secondVariable;
    }

    public int getFirstVariable() {
        return firstVariable;
    }

    public void setFirstVariable(int firstVariable) {
        this.firstVariable = firstVariable;
    }

}

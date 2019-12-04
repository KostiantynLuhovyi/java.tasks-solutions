package com.lugowoy.tasks.solutions.core.calculateRootOfLinearEquation;

/**
 * Created by Konstantin Lugowoy on 14-Dec-16.
 */

public class CalculatingLinearEquation {

    public LinearEquation calculateLinearEquation(LinearEquation equation) {
        if ((equation.getA() == 0) && (equation.getB() == 0)) {
            System.out.println("Linear equation have many solutions");
        } else if ((equation.getA() == 0) && (equation.getB() != 0)) {
            System.out.println("Linear equation not have solutions");
        } else if ((equation.getA() != 0) && (equation.getB() != 0)) {
            equation.setXRootLinearEquation(-(equation.getB() / equation.getA()));
        }
        return equation;
    }

}

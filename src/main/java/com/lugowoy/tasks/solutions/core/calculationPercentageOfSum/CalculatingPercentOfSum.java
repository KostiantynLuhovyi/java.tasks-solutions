package com.lugowoy.tasks.solutions.core.calculationPercentageOfSum;

import java.math.BigDecimal;

/**
 * Created by Konstantin Lugowoy on 04-Jan-17.
 */

public class CalculatingPercentOfSum {

    public Variable calculateThePercentageOfTheSum(Variable variable) {
        Double valuePercent = (variable.getPartOfSum()).doubleValue() / variable.getSum().doubleValue() * 100;
        variable.setPercent(new BigDecimal(valuePercent));

        return variable;
    }

}

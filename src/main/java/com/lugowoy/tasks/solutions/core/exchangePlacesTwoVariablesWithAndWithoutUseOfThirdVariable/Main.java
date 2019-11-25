package com.lugowoy.tasks.exchangePlacesTwoVariablesWithAndWithoutUseOfThirdVariable;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;

/**
 * Exchange the values of two variables, first using an additional third variable, and then - without third variable.
 * <p>
 * Created by Konstantin Lugowoy on 18-Jan-17.
 */

public class Main {

    private static final Reader READER = Reader.getReader(new ReadingConsole());

    public static void main(String[] args) {

        Variables variableForExchangePlacesTwoVariableWithThirdVariables = new Variables();

        System.out.println("Enter the value of the first variable : ");
        int firstValue = READER.readInt();
        variableForExchangePlacesTwoVariableWithThirdVariables.setFirstVariable(firstValue);

        System.out.println("Enter the value of the second variable : ");
        int secondValue = READER.readInt();
        variableForExchangePlacesTwoVariableWithThirdVariables.setSecondVariable(secondValue);

        Exchange<Variables> variablesExchangeWithTheUseThirdVariable = (variableForExchangeWithTheUseThirdVariables) -> {
            if (variableForExchangeWithTheUseThirdVariables != null) {
                int tmp = variableForExchangeWithTheUseThirdVariables.getFirstVariable();
                variableForExchangeWithTheUseThirdVariables.setFirstVariable(variableForExchangeWithTheUseThirdVariables.getSecondVariable());
                variableForExchangeWithTheUseThirdVariables.setSecondVariable(tmp);
            } else {
                System.out.println("Variables is equal null");
            }
        };

        variablesExchangeWithTheUseThirdVariable.exchange(variableForExchangePlacesTwoVariableWithThirdVariables);

        System.out.printf("After the exchange of variable values using the third variable, the result is : \n" +
                                "firstVariable = %d;\n" +
                                "secondVariable = %d;\n",
                                    variableForExchangePlacesTwoVariableWithThirdVariables.getFirstVariable(),
                                    variableForExchangePlacesTwoVariableWithThirdVariables.getSecondVariable());

        Variables variableForExchangePlacesTwoVariableWithoutThirdVariables = new Variables(firstValue, secondValue);

        Exchange<Variables> variablesExchangeTwoVariablesWithoutTheUseThirdVariable =
                (variableForExchangeTwoVariableWithoutTheUseThirdVariables) -> {
                    variableForExchangeTwoVariableWithoutTheUseThirdVariables.setFirstVariable(variableForExchangeTwoVariableWithoutTheUseThirdVariables.getFirstVariable()
                            + variableForExchangeTwoVariableWithoutTheUseThirdVariables.getSecondVariable());
                    variableForExchangeTwoVariableWithoutTheUseThirdVariables.setSecondVariable(variableForExchangeTwoVariableWithoutTheUseThirdVariables.getFirstVariable()
                            - variableForExchangeTwoVariableWithoutTheUseThirdVariables.getSecondVariable());
                    variableForExchangeTwoVariableWithoutTheUseThirdVariables.setFirstVariable(variableForExchangeTwoVariableWithoutTheUseThirdVariables.getFirstVariable()
                            - variableForExchangeTwoVariableWithoutTheUseThirdVariables.getSecondVariable());
                };

        variablesExchangeTwoVariablesWithoutTheUseThirdVariable.exchange(variableForExchangePlacesTwoVariableWithoutThirdVariables);

        System.out.printf("After the exchange of variable values without using the third variable, the result is : \n" +
                                "firstVariable = %d;\n" +
                                "secondVariable = %d;",
                                    variableForExchangePlacesTwoVariableWithThirdVariables.getFirstVariable(),
                                    variableForExchangePlacesTwoVariableWithThirdVariables.getSecondVariable());

    }

}

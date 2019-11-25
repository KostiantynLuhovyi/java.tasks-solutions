package com.lugowoy.tasks.determineWhichResistorToUseSoThatTotalResistanceOfCircuitIsMinimal;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.other.GeneratorRandomNumber;

/**
 * Suppose that the area of the electrical circuit must consist of two blocks, in each of which two parallel resistors are located.
 * The blocks are connected in series. There are three resistors of known resistance that can be freely shifted between blocks, and one main resistor, which must be in the second block.
 * It is necessary to determine which resistor is inserted into the second block in addition to the main one, so that the total resistance of the circuit section is minimal.
 * <p>
 * Created by Konstantin Lugowoy on 10.11.2017.
 */

public class Main {

    private static final Reader READER = Reader.getReader(new ReadingConsole());

    private static final int BOUND = 1000;

    public static void main(String[] args) {

        System.out.println("Enter the value of the main resistor : ");
        Resistor mainResistor = new Resistor(GeneratorRandomNumber.generateInt(BOUND), READER.readDouble());

        System.out.println("Enter the value of the first resistor :");
        Resistor firstResistor = new Resistor(GeneratorRandomNumber.generateInt(BOUND), READER.readDouble());

        System.out.println("Enter the value of the second resistor :");
        Resistor secondResistor = new Resistor(GeneratorRandomNumber.generateInt(BOUND), READER.readDouble());

        System.out.println("Enter the value of the third resistor :");
        Resistor thirdResistor = new Resistor(GeneratorRandomNumber.generateInt(BOUND), READER.readDouble());

        Calculator calculator = Calculator::calculationOfResistanceOfCircuitForFirstConnectionMethods;
        double firstValueOfChainSection = calculator.calculate(mainResistor, firstResistor, secondResistor, thirdResistor);
        double secondValueOfChainSection = calculator.calculate(mainResistor, firstResistor, secondResistor, thirdResistor);
        double thirdValueOfChainSection = calculator.calculate(mainResistor, firstResistor, secondResistor, thirdResistor);

        Determinant determinant = Determinant::determineFirstVariantOfMethodConnection;
        boolean A = determinant.determineMethodOfConnection(firstValueOfChainSection, secondValueOfChainSection, thirdValueOfChainSection);
        boolean B = determinant.determineMethodOfConnection(firstValueOfChainSection, secondValueOfChainSection, thirdValueOfChainSection);
        System.out.println("To achieve the minimum resistance in the chain section, it is necessary to use : ");
        System.out.println(A ? firstResistor : B ? secondResistor : thirdResistor);

    }

}

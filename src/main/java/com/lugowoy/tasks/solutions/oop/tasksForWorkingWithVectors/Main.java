package com.lugowoy.tasks.tasksForWorkingWithVectors;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.tasks.tasksForWorkingWithVectors.calculating.CalculatingVector2D;
import com.lugowoy.tasks.tasksForWorkingWithVectors.vectors.Vector2D;
import com.lugowoy.tasks.tasksForWorkingWithVectors.vectors.Vector3D;

import java.math.BigDecimal;

/**
 * Created by Konstantin Lugowoy on 29.11.2018.
 */

public class Main {

    private static final Reader READER = Reader.getReader(new ReadingConsole());

    public static void main(String[] args) {

        int choiceTypeOfVectors = getChoiceTypeOfVectors();

        int numberVectors = getNumberVectors();

        System.out.println("Fill in the first vector.");
        Vector2D<BigDecimal> firstVector2D = new Vector2D<>();
        fillVector2D(firstVector2D);

        System.out.println("Fill in the second vector.");
        Vector2D<BigDecimal> secondVector2D = new Vector2D<>();
        fillVector2D(secondVector2D);

        CalculatingVector2D<BigDecimal> calculation = CalculatingVector2D::calculateAdditionOfVectors;
        System.out.println("Result summation : " + calculation.calculate(firstVector2D, secondVector2D));
        calculation = CalculatingVector2D::calculateSubtractionOfVectors;
        System.out.println("Result subtraction : " + calculation.calculate(firstVector2D, secondVector2D));
        calculation = CalculatingVector2D::calculateMultiplicationOfVectors;
        System.out.println("Result multiplication : " + calculation.calculate(firstVector2D, secondVector2D));

        System.out.println("Equals result : " + firstVector2D);

    }

    private static int getChoiceTypeOfVectors() {
        System.out.println("Enter the type of vector to create : ");
        System.out.println(" - 2 - on the plane (2 points of coordinates)");
        System.out.println(" - 3 - in space (3 points of coordinate)");
        int choiceTypeForVectors;
        while (true) {
            choiceTypeForVectors = READER.readInt();
            if (choiceTypeForVectors == 1) {
                break;
            } else if (choiceTypeForVectors == 2) {
                break;
            } else {
                System.out.println("Incorrect value. Re-enter : ");
            }
        }
        return choiceTypeForVectors;
    }

    private static int getNumberVectors() {
        System.out.println("Enter the number from 0 to 20 for the creation of vectors : ");
        int numberVectors;
        while (true) {
            numberVectors = READER.readInt();
            if (numberVectors >= 0 && numberVectors <= 20) {
                break;
            } else {
                System.out.println("Incorrect value. Re-enter : ");
            }
        }
        return numberVectors;
    }

    private static void fillVector2D(Vector2D<BigDecimal> vector2D) {
        System.out.println("Enter X value : ");
        vector2D.setX(new BigDecimal(READER.readDouble()));
        System.out.println("Enter Y value : ");
        vector2D.setY(new BigDecimal(READER.readDouble()));
    }

    private static void fillVector3D(Vector3D<BigDecimal> vector3D) {
        System.out.println("Enter X value : ");
        vector3D.setX(new BigDecimal(READER.readDouble()));
        System.out.println("Enter Y value : ");
        vector3D.setY(new BigDecimal(READER.readDouble()));
        System.out.println("Enter Z value : ");
        vector3D.setZ(new BigDecimal(READER.readDouble()));
    }

}

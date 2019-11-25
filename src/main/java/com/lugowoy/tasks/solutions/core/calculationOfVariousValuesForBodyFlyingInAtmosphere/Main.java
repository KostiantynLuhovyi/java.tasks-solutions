package com.lugowoy.tasks.calculationOfVariousValuesForBodyFlyingInAtmosphere;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;

/**
 * Calculate the trajectory of the motion of a body thrown at an angle to the horizon, provided that the body,
 * in addition to the force of gravity, also acts on the strength of air resistance.
 * Assume that in the atmosphere, depending on the height above the surface,
 * the force of air resistance is different: in the first lower layer it is proportional to the square of the velocity of the body (and is directed against the velocity vector),
 * in the second central layer, the air resistance force is proportional to the speed of the body, and in the third,
 * the upper layer of the atmosphere, the force of air resistance is absent.
 * <p>
 * Created by Konstantin Lugowoy on 14.11.2017.
 */

public class Main {

    private static final Reader READER = Reader.getReader(new ReadingConsole());

    private static final double g = 9.832;

    public static void main(String[] args) {

        System.out.println("Enter body weight (kg) : ");
        double mass = READER.readDouble();
        System.out.println("Enter the initial speed (m/sec) : ");
        double V = READER.readDouble();
        System.out.println("Enter value of angle (degree) : ");
        double angle = READER.readDouble();

        System.out.println("Enter the length (m) of the airspace levels.");
        System.out.println("First the airspace level : ");
        double firstAirspaceLevel = READER.readDouble();
        System.out.println("Second the airspace level : ");
        double secondAirspaceLevel = READER.readDouble();

        System.out.println("Enter the value of the first resistance coefficient : ");
        double firstResistanceCoefficient = READER.readDouble();
        System.out.println("Enter the value of the second resistance coefficient");
        double secondResistanceCoefficient = READER.readDouble();

        System.out.println("Enter the time interval value (sec) : ");
        double timeInterval = READER.readDouble();

        double bodyCoordinateX = 0, bodyCoordinateY = 0;

        double horizontalProjectionOfSpeed, verticalProjectionOfSpeed;

        double projectionOfResistanceForceX, projectionOfResistanceForceY;

        double timeFlyingBody, distanceFlyingBody, heightFlyingBody = 0;

        int zoneNumberIndicator;

        angle = Math.toRadians(angle);

        horizontalProjectionOfSpeed = V * Math.cos(angle);
        verticalProjectionOfSpeed = V * Math.sin(angle);

        for (int i = 1; true; i++) {

            bodyCoordinateY += verticalProjectionOfSpeed * timeInterval;
            if (bodyCoordinateY < 0) {
                timeFlyingBody = Math.round((i - 1) * timeInterval * 100) / 100.0;
                distanceFlyingBody = Math.round(bodyCoordinateX * 100) / 100.0;
                heightFlyingBody = Math.round(heightFlyingBody * 100) / 100.0;
                break;
            }

            bodyCoordinateX += horizontalProjectionOfSpeed * timeInterval;
            if (bodyCoordinateY > heightFlyingBody) {
                heightFlyingBody = bodyCoordinateY;
            }

            zoneNumberIndicator = bodyCoordinateY < firstAirspaceLevel ? 1 : bodyCoordinateY < secondAirspaceLevel ? 2 : 3;

            switch (zoneNumberIndicator) {
                case 1:
                    projectionOfResistanceForceX = firstResistanceCoefficient * horizontalProjectionOfSpeed
                            * Math.sqrt(horizontalProjectionOfSpeed * horizontalProjectionOfSpeed
                            + verticalProjectionOfSpeed * verticalProjectionOfSpeed);
                    projectionOfResistanceForceY = firstResistanceCoefficient * verticalProjectionOfSpeed
                            * Math.sqrt(horizontalProjectionOfSpeed * horizontalProjectionOfSpeed
                            + verticalProjectionOfSpeed * verticalProjectionOfSpeed);
                    break;
                case 2:
                    projectionOfResistanceForceX = secondResistanceCoefficient * horizontalProjectionOfSpeed;
                    projectionOfResistanceForceY = secondResistanceCoefficient * verticalProjectionOfSpeed;
                    break;
                default:
                    projectionOfResistanceForceX = 0;
                    projectionOfResistanceForceY = 0;
                    break;
            }

            horizontalProjectionOfSpeed += -projectionOfResistanceForceX * timeInterval / mass;
            verticalProjectionOfSpeed += -g * timeInterval - projectionOfResistanceForceY * timeInterval / mass;
        }

        System.out.println("Time of flying of the body : " + timeFlyingBody + " seconds.");
        System.out.println("Distance of flying of the body : " + distanceFlyingBody + " metres.");
        System.out.println("Max height of flying of the body " + heightFlyingBody + " metres.");

    }

}

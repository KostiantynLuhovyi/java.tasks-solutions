package com.lugowoy.tasks.calculationOfAmountOfPaintNeededToPaintRoom;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.tasks.calculationOfAmountOfPaintNeededToPaintRoom.calculating.area.*;
import com.lugowoy.tasks.calculationOfAmountOfPaintNeededToPaintRoom.calculating.expense.CalculatingExpensePaintForRoom;
import com.lugowoy.tasks.calculationOfAmountOfPaintNeededToPaintRoom.calculating.expense.CalculatorExpensePaintForRoom;
import com.lugowoy.tasks.calculationOfAmountOfPaintNeededToPaintRoom.determination.Determinator;
import com.lugowoy.tasks.calculationOfAmountOfPaintNeededToPaintRoom.determination.DeterminatorExpensesOfPaintPerSquareMeterOfConcreteSurface;
import com.lugowoy.tasks.calculationOfAmountOfPaintNeededToPaintRoom.factory.*;
import com.lugowoy.tasks.calculationOfAmountOfPaintNeededToPaintRoom.models.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * Enter the length, width and height of the room.
 * Calculate how much paint will go to painting the walls of this room,
 * if there are N liters of paint per 1 m2 of wall and M% of the wall surface is occupied by windows and doors.
 * Also, calculate the total cost of paint, taking into account that one liter of paint costs R UAH.
 * <p>
 * Created by LugowoyKonstantin on 17-Feb-17.
 */

public class Main {

    private static final Reader READER = Reader.getReader(new ReadingConsole());

    private static final Factory<Window> FACTORY_WINDOW = new FactoryWindow(READER)::createWindow;
    private static final Factory<Door> FACTORY_DOOR = new FactoryDoor(READER)::createDoor;
    private static final Factory<Room> FACTORY_ROOM = new FactoryRoom(READER)::createRoom;
    private static final Factory<Paint> FACTORY_PAINT = new FactoryPaint(READER)::createPaint;

    private static final int SCALE = 2;

    private static final Determinator<BigDecimal, TypeOfSurface, TypeOfPaint> DETERMINE_EXPENSE_OF_PAINT_PER_SQUARE_METER_OF_CONCRETE_SURFACE
            = DeterminatorExpensesOfPaintPerSquareMeterOfConcreteSurface::determineExpenseOfPaintPerSquareMeterOfConcreteSurface;

    public static void main(String[] args) {

        System.out.println("Fill in the data for the room.");
        Room room = FACTORY_ROOM.create();

        CalculatorObjectArea<Room> calculatorForRoomArea = new CalculatorRoomArea();
        calculatorForRoomArea.calculateArea(room);
        System.out.println("Total area of the room : " + room.getTotalAreaRoom() + "\u33A1 .");
        System.out.println();

        room.setTypeOfSurface(chooseWallSurfaceInRoom());

        System.out.println("Enter the number of windows in the room : ");
        int numberWindowInRoom = READER.readInt();
        System.out.println();

        room.setWindowListInFlat(getListOfWindowsInRoom(numberWindowInRoom));

        CalculatingTotalAreaOfObjectInRoom<Window> calculatorForWindowsArea = new CalculatorWindowsArea();
        room.setTotalAreaOfWindowsInRoom(calculatorForWindowsArea.calculateTotalAreaOfObjectInRoom(room));

        CalculatingPercentOfAreaOfObjectsFromRoomArea calculatingPercentOfAreaOfObjectsFromRoomArea
                = new CalculatorPercentOfAreaOfWindowsFromRoomArea();
        room.setPercentageOfAreaOfWindowsFromAreaRoom(calculatingPercentOfAreaOfObjectsFromRoomArea.calculatePercentage(room));
        System.out.println("Total area of windows in the room : " + room.getTotalAreaOfWindowsInRoom() + "\u33A1 .");
        System.out.println("Percentage of windows in the room from the total area : "
                + room.getPercentageOfAreaOfWindowsFromAreaRoom().setScale(SCALE, RoundingMode.HALF_DOWN).doubleValue());
        System.out.println();

        System.out.println("Enter the number of door int the room : ");
        int numberDoorInRoom = READER.readInt();
        System.out.println();

        room.setDoorListInFlat(getListOfDoorInRoom(numberDoorInRoom));

        CalculatingTotalAreaOfObjectInRoom<Door> calculatorForDoorsArea = new CalculatorDoorsArea();
        room.setTotalAreaOfDoorsInRoom(calculatorForDoorsArea.calculateTotalAreaOfObjectInRoom(room));

        calculatingPercentOfAreaOfObjectsFromRoomArea
                = new CalculatorPercentOfAreaOfDoorsFromRoomArea();
        room.setPercentageOfAreaOfDoorsFromAreaRoom(calculatingPercentOfAreaOfObjectsFromRoomArea.calculatePercentage(room));

        System.out.println("Total area of doors in the room : " + room.getTotalAreaOfDoorsInRoom() + "\u33A1 .");
        System.out.println("Percentage of doors in the room from the total area : "
                + room.getPercentageOfAreaOfDoorsFromAreaRoom().setScale(SCALE, RoundingMode.HALF_DOWN).doubleValue());
        System.out.println();

        room.setAreaRoomWithoutAreaDoorsAndWindows((room.getTotalAreaRoom()
                .subtract(room.getTotalAreaOfWindowsInRoom())
                .subtract(room.getTotalAreaOfDoorsInRoom())));
        System.out.println("Area of the room without windows and doors : " + room.getAreaRoomWithoutAreaDoorsAndWindows());
        System.out.println();

        Paint paint = FACTORY_PAINT.create();

        paint.setExpenseOfPaintPerSquareMeter(DETERMINE_EXPENSE_OF_PAINT_PER_SQUARE_METER_OF_CONCRETE_SURFACE
                .determine(room.getTypeOfSurface(), paint.getTypeOfPaint()));

        CalculatingExpensePaintForRoom calculatingExpensePaintForRoom = new CalculatorExpensePaintForRoom();
        BigDecimal amountOfPaintNeededToPaintRoom = calculatingExpensePaintForRoom.calculateExpensePaintForRoom(room, paint);

        System.out.println("The amount of paint needed to paint the room : "
                + amountOfPaintNeededToPaintRoom.setScale(SCALE, RoundingMode.HALF_DOWN));

        BigDecimal totalCostOfPaintForRoom = amountOfPaintNeededToPaintRoom.multiply(paint.getPricePerLiter());
        System.out.println("Total cost of paint for the room : "
                + totalCostOfPaintForRoom.setScale(SCALE, RoundingMode.HALF_DOWN));
    }

    private static List<Window> getListOfWindowsInRoom(int numberWindowInRoom) {
        ArrayList<Window> windowArrayList = new ArrayList<>(numberWindowInRoom);
        for (int i = 0; i < numberWindowInRoom; i++) {

            int numberWindow = i;
            numberWindow++;

            System.out.println("Fill in the data for the " + numberWindow + " window.");
            windowArrayList.add(FACTORY_WINDOW.create());
        }
        return windowArrayList;
    }

    private static List<Door> getListOfDoorInRoom(int numberDoorInRoom) {
        ArrayList<Door> doorArrayList = new ArrayList<>(numberDoorInRoom);
        for (int i = 0; i < numberDoorInRoom; i++) {

            int numberDoor = i;
            numberDoor++;

            System.out.println("Fill in the data for the " + numberDoor + " door.");
            doorArrayList.add(FACTORY_DOOR.create());
        }
        return doorArrayList;
    }

    private static TypeOfSurface chooseWallSurfaceInRoom() {
        TypeOfSurface resultTypeOfSurface = null;
        System.out.println("Choose a wall surface in the room : ");
        System.out.println("METAL : 1; \n" +
                           "SMOOTH : 2; \n" +
                           "WOOD : 3; \n" +
                           "PLASTER : 4; \n" +
                           "GYPSUM PLASTERBOARD : 5;");
        int chooseResult = READER.readInt();
        if ((chooseResult >= 1) && (chooseResult <= 5)) {
            resultTypeOfSurface = determinationOfResultWallSurface(chooseResult);
            System.out.println("You choosed : " + resultTypeOfSurface.toString());
            System.out.println();
        } else {
            System.out.println("Wrong choice. Repeat the selection.");
            chooseWallSurfaceInRoom();
        }
        return resultTypeOfSurface;
    }

    private static TypeOfSurface determinationOfResultWallSurface(int chooseResult) {
        TypeOfSurface resultTypeOfSurface = null;
        switch (chooseResult) {
            case 1: resultTypeOfSurface = TypeOfSurface.TYPE_METAL_SURFACE; break;
            case 2: resultTypeOfSurface = TypeOfSurface.TYPE_SMOOTH_SURFACE; break;
            case 3: resultTypeOfSurface = TypeOfSurface.TYPE_WOOD_SURFACE; break;
            case 4: resultTypeOfSurface = TypeOfSurface.TYPE_PLASTER_SURFACE; break;
            case 5: resultTypeOfSurface = TypeOfSurface.TYPE_GYPSUM_PLASTERBOARD_SURFACE; break;
        }
        return resultTypeOfSurface;
    }

}

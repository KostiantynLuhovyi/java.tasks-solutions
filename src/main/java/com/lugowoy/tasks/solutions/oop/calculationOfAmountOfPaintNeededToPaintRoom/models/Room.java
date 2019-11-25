package com.lugowoy.tasks.calculationOfAmountOfPaintNeededToPaintRoom.models;

import com.rits.cloning.Cloner;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**Created by LugowoyKonstantin on 17-Feb-17.*/

public class Room implements Serializable, Cloneable {

    private BigDecimal widthRoom;
    private BigDecimal lengthRoom;
    private BigDecimal heightRoom;

    private BigDecimal totalAreaRoom;
    private BigDecimal areaRoomWithoutAreaDoorsAndWindows;

    private List<Window> windowListInFlat;
    private BigDecimal percentageOfAreaOfWindowsFromAreaRoom;
    private BigDecimal totalAreaOfWindowsInRoom;

    private List<Door> doorListInFlat;
    private BigDecimal percentageOfAreaOfDoorsFromAreaRoom;
    private BigDecimal totalAreaOfDoorsInRoom;

    private TypeOfSurface typeOfSurface;

    public Room() {
    }

    public Room(BigDecimal widthRoom, BigDecimal lengthRoom, BigDecimal heightRoom) {
        this.widthRoom = widthRoom;
        this.lengthRoom = lengthRoom;
        this.heightRoom = heightRoom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;

        Room room = (Room) o;

        if (getWidthRoom() != null ? !getWidthRoom().equals(room.getWidthRoom()) : room.getWidthRoom() != null)
            return false;
        if (getLengthRoom() != null ? !getLengthRoom().equals(room.getLengthRoom()) : room.getLengthRoom() != null)
            return false;
        if (getHeightRoom() != null ? !getHeightRoom().equals(room.getHeightRoom()) : room.getHeightRoom() != null)
            return false;
        if (getTotalAreaRoom() != null ? !getTotalAreaRoom().equals(room.getTotalAreaRoom()) : room.getTotalAreaRoom() != null)
            return false;
        if (getAreaRoomWithoutAreaDoorsAndWindows() != null ? !getAreaRoomWithoutAreaDoorsAndWindows().equals(room.getAreaRoomWithoutAreaDoorsAndWindows()) : room.getAreaRoomWithoutAreaDoorsAndWindows() != null)
            return false;
        if (getWindowListInFlat() != null ? !getWindowListInFlat().equals(room.getWindowListInFlat()) : room.getWindowListInFlat() != null)
            return false;
        if (getPercentageOfAreaOfWindowsFromAreaRoom() != null ? !getPercentageOfAreaOfWindowsFromAreaRoom().equals(room.getPercentageOfAreaOfWindowsFromAreaRoom()) : room.getPercentageOfAreaOfWindowsFromAreaRoom() != null)
            return false;
        if (getTotalAreaOfWindowsInRoom() != null ? !getTotalAreaOfWindowsInRoom().equals(room.getTotalAreaOfWindowsInRoom()) : room.getTotalAreaOfWindowsInRoom() != null)
            return false;
        if (getDoorListInFlat() != null ? !getDoorListInFlat().equals(room.getDoorListInFlat()) : room.getDoorListInFlat() != null)
            return false;
        if (getPercentageOfAreaOfDoorsFromAreaRoom() != null ? !getPercentageOfAreaOfDoorsFromAreaRoom().equals(room.getPercentageOfAreaOfDoorsFromAreaRoom()) : room.getPercentageOfAreaOfDoorsFromAreaRoom() != null)
            return false;
        if (getTotalAreaOfDoorsInRoom() != null ? !getTotalAreaOfDoorsInRoom().equals(room.getTotalAreaOfDoorsInRoom()) : room.getTotalAreaOfDoorsInRoom() != null)
            return false;
        return getTypeOfSurface() == room.getTypeOfSurface();

    }

    @Override
    public int hashCode() {
        int result = getWidthRoom() != null ? getWidthRoom().hashCode() : 0;
        result = 31 * result + (getLengthRoom() != null ? getLengthRoom().hashCode() : 0);
        result = 31 * result + (getHeightRoom() != null ? getHeightRoom().hashCode() : 0);
        result = 31 * result + (getTotalAreaRoom() != null ? getTotalAreaRoom().hashCode() : 0);
        result = 31 * result + (getAreaRoomWithoutAreaDoorsAndWindows() != null ? getAreaRoomWithoutAreaDoorsAndWindows().hashCode() : 0);
        result = 31 * result + (getWindowListInFlat() != null ? getWindowListInFlat().hashCode() : 0);
        result = 31 * result + (getPercentageOfAreaOfWindowsFromAreaRoom() != null ? getPercentageOfAreaOfWindowsFromAreaRoom().hashCode() : 0);
        result = 31 * result + (getTotalAreaOfWindowsInRoom() != null ? getTotalAreaOfWindowsInRoom().hashCode() : 0);
        result = 31 * result + (getDoorListInFlat() != null ? getDoorListInFlat().hashCode() : 0);
        result = 31 * result + (getPercentageOfAreaOfDoorsFromAreaRoom() != null ? getPercentageOfAreaOfDoorsFromAreaRoom().hashCode() : 0);
        result = 31 * result + (getTotalAreaOfDoorsInRoom() != null ? getTotalAreaOfDoorsInRoom().hashCode() : 0);
        result = 31 * result + (getTypeOfSurface() != null ? getTypeOfSurface().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Room[" +
                "widthRoom=" + widthRoom +
                ", lengthRoom=" + lengthRoom +
                ", heightRoom=" + heightRoom +
                ", totalAreaRoom=" + totalAreaRoom +
                ", areaRoomWithoutAreaDoorsAndWindows=" + areaRoomWithoutAreaDoorsAndWindows +
                ", windowListInFlat=" + windowListInFlat +
                ", percentageOfAreaOfWindowsFromAreaRoom=" + percentageOfAreaOfWindowsFromAreaRoom +
                ", totalAreaOfWindowsInRoom=" + totalAreaOfWindowsInRoom +
                ", doorListInFlat=" + doorListInFlat +
                ", percentageOfAreaOfDoorsFromAreaRoom=" + percentageOfAreaOfDoorsFromAreaRoom +
                ", totalAreaOfDoorsInRoom=" + totalAreaOfDoorsInRoom +
                ", typeOfSurface=" + typeOfSurface +
                ']';
    }

    @Override
    public Room clone() {
        Room room = new Room();
        Cloner cloner = new Cloner();
        try {
            room = (Room) super.clone();
            room.setWidthRoom(cloner.deepClone(this.getWidthRoom()));
            room.setLengthRoom(cloner.deepClone(this.getLengthRoom()));
            room.setHeightRoom(cloner.deepClone(this.getHeightRoom()));
            room.setTotalAreaRoom(cloner.deepClone(this.getTotalAreaRoom()));
            room.setAreaRoomWithoutAreaDoorsAndWindows(cloner.deepClone(this.getAreaRoomWithoutAreaDoorsAndWindows()));
            room.setWindowListInFlat(cloner.deepClone(this.getWindowListInFlat()));
            room.setPercentageOfAreaOfWindowsFromAreaRoom(cloner.deepClone(this.getPercentageOfAreaOfWindowsFromAreaRoom()));
            room.setTotalAreaOfWindowsInRoom(cloner.deepClone(cloner.deepClone(this.getTotalAreaOfWindowsInRoom())));
            room.setDoorListInFlat(cloner.deepClone(this.getDoorListInFlat()));
            room.setPercentageOfAreaOfDoorsFromAreaRoom(cloner.deepClone(this.getPercentageOfAreaOfDoorsFromAreaRoom()));
            room.setTotalAreaOfDoorsInRoom(cloner.deepClone(this.getTotalAreaOfDoorsInRoom()));
            room.setTypeOfSurface(this.getTypeOfSurface());//Enum is a singleton, so refers to the same instance
        } catch (CloneNotSupportedException ex) {
            new InternalError(ex.getMessage()).printStackTrace();
        }
        return room;
    }

    public BigDecimal getWidthRoom() {
        return widthRoom;
    }

    public void setWidthRoom(BigDecimal widthRoom) {
        this.widthRoom = widthRoom;
    }

    public BigDecimal getLengthRoom() {
        return lengthRoom;
    }

    public void setLengthRoom(BigDecimal lengthRoom) {
        this.lengthRoom = lengthRoom;
    }

    public BigDecimal getHeightRoom() {
        return heightRoom;
    }

    public void setHeightRoom(BigDecimal heightRoom) {
        this.heightRoom = heightRoom;
    }

    public BigDecimal getTotalAreaRoom() {
        return totalAreaRoom;
    }

    public void setTotalAreaRoom(BigDecimal totalAreaRoom) {
        this.totalAreaRoom = totalAreaRoom;
    }

    public BigDecimal getAreaRoomWithoutAreaDoorsAndWindows() {
        return areaRoomWithoutAreaDoorsAndWindows;
    }

    public void setAreaRoomWithoutAreaDoorsAndWindows(BigDecimal areaRoomWithoutAreaDoorsAndWindows) {
        this.areaRoomWithoutAreaDoorsAndWindows = areaRoomWithoutAreaDoorsAndWindows;
    }

    public List<Window> getWindowListInFlat() {
        return windowListInFlat;
    }

    public void setWindowListInFlat(List<Window> windowListInFlat) {
        this.windowListInFlat = windowListInFlat;
    }

    public BigDecimal getPercentageOfAreaOfWindowsFromAreaRoom() {
        return percentageOfAreaOfWindowsFromAreaRoom;
    }

    public void setPercentageOfAreaOfWindowsFromAreaRoom(BigDecimal percentageOfAreaOfWindowsFromAreaRoom) {
        this.percentageOfAreaOfWindowsFromAreaRoom = percentageOfAreaOfWindowsFromAreaRoom;
    }

    public BigDecimal getTotalAreaOfWindowsInRoom() {
        return totalAreaOfWindowsInRoom;
    }

    public void setTotalAreaOfWindowsInRoom(BigDecimal totalAreaOfWindowsInRoom) {
        this.totalAreaOfWindowsInRoom = totalAreaOfWindowsInRoom;
    }

    public List<Door> getDoorListInFlat() {
        return doorListInFlat;
    }

    public void setDoorListInFlat(List<Door> doorListInFlat) {
        this.doorListInFlat = doorListInFlat;
    }

    public BigDecimal getPercentageOfAreaOfDoorsFromAreaRoom() {
        return percentageOfAreaOfDoorsFromAreaRoom;
    }

    public void setPercentageOfAreaOfDoorsFromAreaRoom(BigDecimal percentageOfAreaOfDoorsFromAreaRoom) {
        this.percentageOfAreaOfDoorsFromAreaRoom = percentageOfAreaOfDoorsFromAreaRoom;
    }

    public BigDecimal getTotalAreaOfDoorsInRoom() {
        return totalAreaOfDoorsInRoom;
    }

    public void setTotalAreaOfDoorsInRoom(BigDecimal totalAreaOfDoorsInRoom) {
        this.totalAreaOfDoorsInRoom = totalAreaOfDoorsInRoom;
    }

    public TypeOfSurface getTypeOfSurface() {
        return typeOfSurface;
    }

    public void setTypeOfSurface(TypeOfSurface typeOfSurface) {
        this.typeOfSurface = typeOfSurface;
    }

}

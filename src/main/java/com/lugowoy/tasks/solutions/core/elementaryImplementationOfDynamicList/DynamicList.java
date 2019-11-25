package com.lugowoy.tasks.elementaryImplementationOfDynamicList;

/**
 * Created by Konstantin Lugowoy on 18.11.2017.
 */

public class DynamicList {

    private int numberOfElement;

    private DynamicList next = this;

    public void create(int length) {
        DynamicList objA = this;
        DynamicList objB;
        for (int i = 0; i < length; i++) {
            objB = new DynamicList();
            objA.next = objB;
            objB.numberOfElement = objA.numberOfElement + 1;
            objA = objB;
        }
        objA.next = this;
    }

    public int getElement(int number) {
        DynamicList obj = this;
        for (int i = 0; i < number; i++) {
            obj = obj.next;
        }
        return obj.numberOfElement;
    }

}

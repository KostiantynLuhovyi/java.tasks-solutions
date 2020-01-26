package com.lugowoy.tasks.solutions.arrays.onedimensional.openLockOnDoorByLookingThroughPlayingDice;

/**
 * Created by Konstantin Lugowoy on 27.03.2017.
 */
public class DoorLock {

    public static final int VALUE_FOR_OPENING = 10;

    /*private PlayingDice[] playingDices = new PlayingDice[10];*/

    private boolean lock = true;

/*    public DoorLock() {
        Random random = new Random();
        for (int i = 0; i < 2; i++) {
            playingDices[random.nextInt(10)] = new PlayingDice((int) (Math.random() * 6) + 1);
        }
    }*/

    @Override
    public String toString() {
        return "DoorLock{" +
                "lock=" + lock +
                '}';
    }

    public boolean isLock() {
        return lock;
    }

    public void lock() {
        this.lock = true;
    }

    public void open(boolean open) {
        this.lock = open;
    }

}

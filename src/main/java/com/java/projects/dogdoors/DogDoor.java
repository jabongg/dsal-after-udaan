package com.java.projects.dogdoors;

import java.util.Timer;
import java.util.TimerTask;

public class DogDoor {
    private boolean open;
    private Integer doorHeight;

    public DogDoor() {
        this.open = false; // initially the door is closed.
    }

    public void open() {
        System.out.println("The dog door opens.");
        open = true;

        // automatically close the door after 5 seconds
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                close();
                timer.cancel();
            }
        }, 5000);
    }


    public void close() {
        System.out.println("The dog door closes.");
        open = false;
    }

    public boolean isOpen() {
        return open;
    }

    public Integer getDoorHeight() {
        return doorHeight;
    }

    public void setDoorHeight(Integer doorHeight) {
        this.doorHeight = doorHeight;
    }
}

package com.java.projects.dogdoors;

import java.util.Timer;
import java.util.TimerTask;

public class DogDoor {
    private boolean open;
    private Integer doorHeight;
    private String dogVoice;
    private Bark allowedBark;

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

    public boolean isOwnersDogsBark(String dogVoice) {
        if (this.dogVoice.equals(dogVoice)) { // String's equals() method checks content and not the reference unlike Object's equals() method.
            return true;
        } else {
            return false;
        }
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

    public void setOpen(boolean open) {
        this.open = open;
    }

    public String getDogVoice() {
        return dogVoice;
    }

    public void setDogVoice(String dogVoice) {
        this.dogVoice = dogVoice;
    }

    public Bark getAllowedBark() {
        return allowedBark;
    }

    public void setAllowedBark(Bark allowedBark) {
        this.allowedBark = allowedBark;
    }
}

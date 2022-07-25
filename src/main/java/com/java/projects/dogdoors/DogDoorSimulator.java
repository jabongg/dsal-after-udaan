package com.java.projects.dogdoors;

public class DogDoorSimulator {
    public static void main(String[] args) {
        DogDoor door = new DogDoor();
        door.setDogVoice("Woof");
        door.setDoorHeight(12);
        BarkRecognizer recognizer = new BarkRecognizer(door);

        System.out.println("door height is= " + door.getDoorHeight());
        Remote remote = new Remote(door);

        System.out.println();
        remote.pressButton();

        System.out.println("Fido barks to go outside...");
        recognizer.recognize("Woof");
        // remote.pressButton();
        System.out.println("\nFido has gone outside...");
        System.out.println("\nFido’s all done...");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("but he is stuck outside!");
        System.out.println("Fido starts barking...");
        recognizer.recognize("Woof");
        System.out.println("So Gina grabs the remote control.");
        remote.pressButton();

        System.out.println("\nFido’s back inside...");
    }
}

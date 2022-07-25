package com.java.projects.dogdoors;

public class BarkRecognizer {

    private DogDoor door;

    public BarkRecognizer(DogDoor door) {
        this.door = door;
    }

    public Boolean recognize(String bark) {
        System.out.println("Recognizer heard a bark. " + bark);

        if (door.isOwnersDogsBark(bark)) {
            System.out.println("Owner's dog's bark");
            door.open();
        } else {
            System.out.println("Not owner's dog's bark.");
            System.exit(2);
            return false;
        }
        return true;
    }
}

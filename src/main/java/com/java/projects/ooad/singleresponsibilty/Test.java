package com.java.projects.ooad.singleresponsibilty;

public class Test {
    public static void main(String[] args) {
        User user1 = new User("9599229614", "jbpvns@gmail.com", "user1.txt");
        User user2 = new User("9599229613", "shilpid18@gmail.com", "user2.txt");

        //Printing user report
        user1.createUser();
        user1.generateUserReport();

        user2.createUser();
        user2.generateUserReport();



    }
}

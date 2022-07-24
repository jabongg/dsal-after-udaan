package com.java.projects.ooad.singleresponsibilty;

public class Test {
    public static void main(String[] args) {

        UserDao userDao = new UserDao("file1.txt");

        User user1 = new User();
        User user2 = new User();

        user1.createUser();
        user2.createUser();
        //Printing user report
        UserReport userReport = new UserReport(userDao);
        userReport.printTotalUsers();



    }
}

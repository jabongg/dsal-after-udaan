package com.java.projects.ooad.singleresponsibilty;

import java.util.List;

public class UserReport {
    private UserDao userDao;

    public UserReport(UserDao userDao) {
        this.userDao = userDao;
    }

    public void printTotalUsers() {
        System.out.println("user report");

        // get all users
        List<String> users = userDao.findAllUserRecords();
        System.out.println(users);
    }
}

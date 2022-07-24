package com.java.projects.ooad.singleresponsibilty;

import java.io.*;

public class User {
    private String phone;
    private String email;
    private String filepath;

    public User() {
    }

    UserDao userDao = new UserDao("file1.txt");

    public void createUser() {
        //some logic to create user

        //persist the user record
        userDao.save("935352932", "abc@gmail.com");
    }

}

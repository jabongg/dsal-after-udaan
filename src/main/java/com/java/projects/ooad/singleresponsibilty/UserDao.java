package com.java.projects.ooad.singleresponsibilty;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private String filePath;

    public UserDao(String filePath) {
        this.filePath = filePath;
    }


    //write user data into the file

    public void save(String phone, String email) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))){
            writer.write(phone + " " + email);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // read all persisted user data

    public List<String> findAllUserRecords() {
        System.out.println("fetching user report");

        List<String> userRecords = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line = reader.readLine()) != null) {
                userRecords.add(line.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userRecords;
    }
}

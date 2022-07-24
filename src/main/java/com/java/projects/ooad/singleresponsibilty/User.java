package com.java.projects.ooad.singleresponsibilty;

import java.io.*;

public class User {
    private String name;
    private String email;
    private String filepath;

    public User(String name, String email, String filepath) {
        this.name = name;
        this.email = email;
        this.filepath = filepath;
    }

    public void createUser() {
        //some logic to create user

        //persist the user record
        save();
    }

    private void save() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath, true))){
            writer.write(name + " " + email);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generateUserReport() {
        System.out.println("creating user report");

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))){
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

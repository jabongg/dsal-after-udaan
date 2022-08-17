package com.java.projects.movieticketbookingsystem;

public class User {
    // these fileds would be private and we will use getters and setters.
    // but for now i'm directly using them.
    private String name;
    private String email; // notification would be sent on this email;
    private String contactNumber; // notification would be sent on this number;


    // getters and setters here


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }
}

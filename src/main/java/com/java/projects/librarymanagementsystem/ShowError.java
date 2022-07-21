package com.java.projects.librarymanagementsystem;

public class ShowError extends RuntimeException {
    String msg;
    public  ShowError(String msg) {
        this.msg = msg;
        return;
    }
}

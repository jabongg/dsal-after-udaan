package com.java.librarymanagementsystem;

public abstract class Account {
    Integer id;
    String password;
    AccountStatus status;
    Person person;

    public abstract Boolean resetPassword();

    protected abstract String getMemberId();

    protected abstract void decrementTotalBooksCheckedout();

    protected abstract String getId();
}

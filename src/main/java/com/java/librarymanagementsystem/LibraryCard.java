package com.java.librarymanagementsystem;

import java.util.Date;

public class LibraryCard {
    String cardNumber;
    String barcode;
    Date issuedAt;
    Boolean active;

    public Boolean isActive() {
        return active;
    }
}

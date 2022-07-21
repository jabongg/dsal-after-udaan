package com.java.projects.librarymanagementsystem;

import java.time.LocalDate;
import java.util.List;

public abstract class Book {
    private String ISBN;
    private String title;
    private String subject;
    private String publisher;
    private String language;
    private int numberOfPages;
    private List<Author> authors;

    public abstract void updateDueDate(LocalDate plusDays);

    protected abstract void updateBookItemStatus(BookStatus loaned);

    protected abstract String getBarCode();

    public abstract void updateBookItemState(BookStatus reserved);

    protected abstract boolean getIsReferenceOnly();
}

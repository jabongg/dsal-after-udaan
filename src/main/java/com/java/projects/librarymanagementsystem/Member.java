package com.java.projects.librarymanagementsystem;

import java.time.LocalDate;
import java.util.Date;

public class Member extends Account {
    Date dateOfMembership;
    Integer totalBooksCheckedOut;

    public Integer getTotalBooksCheckedOut() {
        return totalBooksCheckedOut;
    }

    @Override
    public Boolean resetPassword() {
        return null;
    }

    @Override
    protected String getMemberId() {
        return null;
    }

    @Override
    protected void decrementTotalBooksCheckedout() {

    }

    @Override
    protected String getId() {
        return null;
    }

    public int getTotalBooksCheckedout() {
        return 0;
    }

    public boolean reserveBookItem(BookItem bookItem) {
        return false;
    }

    private void incrementTotalBooksCheckedout() {

    }

    public boolean checkoutBookItem(BookItem bookItem) {
        if (this.getTotalBooksCheckedOut() >= Constants.MAX_BOOKS_ISSUED_TO_A_USER) {
            new ShowError("The user has already checked-out maximum number of books");
            return false;
        }
        BookReservation bookReservation = BookReservation.fetchReservationDetails(bookItem.getBarcode());
        if (bookReservation != null && bookReservation.getMemberId() != this.getId()) {
            // book item has a pending reservation from another user
            new ShowError("This book is reserved by another member");
            return false;
        } else if (bookReservation != null) {
            // book item has a pending reservation from the give member, update it
            bookReservation.updateStatus(ReservationStatus.COMPLETED);
        }

        if (!bookItem.checkout(this.getId())) {
            return false;
        }

        this.incrementTotalBooksCheckedout();
        return true;
    }

    private void checkForFine(String bookItemBarcode) {
        BookLending bookLending = BookLending.fetchLendingDetails(bookItemBarcode);
        Date dueDate = bookLending.getDueDate();
        Date today = new Date();
        // check if the book has been returned within the due date
        if (today.compareTo(dueDate) > 0) {
            Date todayDate = new Date();
            long diff = todayDate.getTime() - dueDate.getTime();
            long diffDays = diff / (24 * 60 * 60 * 1000);
            String memberId = new Member().getMemberId();
            Fine.collectFine(memberId, diffDays);
        }
    }

    public void returnBookItem(BookItem bookItem) {
        this.checkForFine(bookItem.getBarcode());
        BookReservation bookReservation = BookReservation.fetchReservationDetails(bookItem.getBarcode());
        if (bookReservation != null) {
            // book item has a pending reservation
            bookItem.updateBookItemStatus(BookStatus.RESERVED);
            bookReservation.sendBookAvailableNotification();
        }
        bookItem.updateBookItemStatus(BookStatus.AVAILABLE);
    }

    public void renewBookItem(BookItem bookItem) {
        this.checkForFine(bookItem.getBarcode());
        BookReservation bookReservation = BookReservation.fetchReservationDetails(bookItem.getBarcode());
        // check if this book item has a pending reservation from another member
        if (bookReservation != null && bookReservation.getMemberId() != this.getMemberId()) {
            new ShowError("This book is reserved by another member");
            Member member = new Member();
            member.decrementTotalBooksCheckedout();
            bookItem.updateBookItemState(BookStatus.RESERVED);
            bookReservation.sendBookAvailableNotification();
        } else if (bookReservation != null) {
            // book item has a pending reservation from this member
            bookReservation.updateStatus(ReservationStatus.COMPLETED);
        }
        BookLending.lendBook(bookItem.getBarCode(), this.getMemberId());
        bookItem.updateDueDate(LocalDate.now().plusDays(Constants.MAX_LENDING_DAYS));
    }
}

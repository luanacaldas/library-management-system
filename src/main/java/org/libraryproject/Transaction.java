package org.libraryproject;

import java.time.LocalDate;

public class Transaction {
    private Book book;
    private Member member;
    private LocalDate issueDate;
    private LocalDate returnDate;
    private boolean isReturned;

    public Transaction(Book book, Member member, LocalDate issueDate) {
        this.book = book;
        this.member = member;
        this.issueDate = issueDate;
        this.isReturned = false;
    }

    // Getters and setters
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isReturned() {
        return isReturned;
    }

    public void setReturned(boolean returned) {
        isReturned = returned;
    }
}

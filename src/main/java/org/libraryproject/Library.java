package org.libraryproject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Library implements Subject {
    private static Library instance;
    private List<Book> books = new ArrayList<>();
    private List<Member> members = new ArrayList<>();
    private List<Transaction> transactions = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();

    private Library() {} // Private constructor

    public static Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
    }

    public void addBook(String title, String author, String isbn, int quantity) {
        Book book = LibraryFactory.createBook(title, author, isbn, quantity);
        books.add(book);
        notifyObservers(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void addMember(String name, int id, String contactInfo) {
        Member member = LibraryFactory.createMember(name, id, contactInfo);
        members.add(member);
    }

    public void issueBook(Book book, Member member) {
        if (book.getAvailableCopies() > 0) {
            book.setAvailableCopies(book.getAvailableCopies() - 1);
            Transaction transaction = new Transaction(book, member, LocalDate.now());
            transactions.add(transaction);
            System.out.println("Book issued successfully.");
            notifyObservers(book);
        } else {
            System.out.println("No available copies of this book.");
        }
    }

    public void returnBook(Book book, Member member) {
        for (Transaction transaction : transactions) {
            if (transaction.getBook().equals(book) && !transaction.isReturned()) {
                transaction.setReturned(true);
                transaction.setReturnDate(LocalDate.now());
                book.setAvailableCopies(book.getAvailableCopies() + 1);
                System.out.println("Book returned successfully.");
                notifyObservers(book);
                return;
            }
        }
        System.out.println("No active transaction found for this book and member.");
    }

    public void displayBooks() {
        System.out.println("\n=== Books in Library ===");
        for (Book book : books) {
            System.out.println(book.getTitle() + " by " + book.getAuthor() + " | Available: " + book.getAvailableCopies() + " / " + book.getQuantity());
        }
    }

    public void displayMembers() {
        System.out.println("\n=== Members of Library ===");
        for (Member member : members) {
            System.out.println(member.getName() + " (ID: " + member.getId() + ")");
        }
    }

    public void displayTransactions() {
        System.out.println("\n=== Transactions ===");
        for (Transaction transaction : transactions) {
            System.out.println(transaction.getMember().getName() + " issued " + transaction.getBook().getTitle() + " on " + transaction.getIssueDate());
            if (transaction.isReturned()) {
                System.out.println("Returned on " + transaction.getReturnDate());
            } else {
                System.out.println("Not yet returned.");
            }
        }
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Book book) {
        for (Observer observer : observers) {
            observer.update(book);
        }
    }

    // Getters for books and members
    public List<Book> getBooks() {
        return books;
    }

    public List<Member> getMembers() {
        return members;
    }
}

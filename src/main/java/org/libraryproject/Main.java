package org.libraryproject;

import java.util.Scanner;

public class Main {
    private static Library library = Library.getInstance();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Observer bookObserver = new BookObserver();
        library.registerObserver(bookObserver);

        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    addMember();
                    break;
                case 4:
                    issueBook();
                    break;
                case 5:
                    returnBook();
                    break;
                case 6:
                    displayBooks();
                    break;
                case 7:
                    displayMembers();
                    break;
                case 8:
                    displayTransactions();
                    break;
                case 9:
                    System.out.println("Exiting the system.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        System.out.print("Enter book ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter book quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        library.addBook(title, author, isbn, quantity);
    }

    private static void removeBook() {
        System.out.print("Enter book ISBN to remove: ");
        String isbn = scanner.nextLine();

        Book bookToRemove = null;
        for (Book book : library.getBooks()) {
            if (book.getIsbn().equals(isbn)) {
                bookToRemove = book;
                break;
            }
        }

        if (bookToRemove != null) {
            library.removeBook(bookToRemove);
        } else {
            System.out.println("Book not found.");
        }
    }

    private static void addMember() {
        System.out.print("Enter member name: ");
        String name = scanner.nextLine();
        System.out.print("Enter member ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter member contact info: ");
        String contactInfo = scanner.nextLine();

        library.addMember(name, id, contactInfo);
    }

    private static void issueBook() {
        System.out.print("Enter book ISBN to issue: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter member ID: ");
        int memberId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Book bookToIssue = null;
        Member memberToIssue = null;

        for (Book book : library.getBooks()) {
            if (book.getIsbn().equals(isbn)) {
                bookToIssue = book;
                break;
            }
        }

        for (Member member : library.getMembers()) {
            if (member.getId() == memberId) {
                memberToIssue = member;
                break;
            }
        }

        if (bookToIssue != null && memberToIssue != null) {
            library.issueBook(bookToIssue, memberToIssue);
        } else {
            System.out.println("Book or Member not found.");
        }
    }

    private static void returnBook() {
        System.out.print("Enter book ISBN to return: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter member ID: ");
        int memberId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Book bookToReturn = null;
        Member memberToReturn = null;

        for (Book book : library.getBooks()) {
            if (book.getIsbn().equals(isbn)) {
                bookToReturn = book;
                break;
            }
        }

        for (Member member : library.getMembers()) {
            if (member.getId() == memberId) {
                memberToReturn = member;
                break;
            }
        }

        if (bookToReturn != null && memberToReturn != null) {
            library.returnBook(bookToReturn, memberToReturn);
        } else {
            System.out.println("Book or Member not found.");
        }
    }

    private static void displayBooks() {
        library.displayBooks();
    }

    private static void displayMembers() {
        library.displayMembers();
    }

    private static void displayTransactions() {
        library.displayTransactions();
    }

    private static void displayMenu() {
        System.out.println("\n=== Library Management System ===");
        System.out.println("1. Add Book");
        System.out.println("2. Remove Book");
        System.out.println("3. Add Member");
        System.out.println("4. Issue Book");
        System.out.println("5. Return Book");
        System.out.println("6. Display Books");
        System.out.println("7. Display Members");
        System.out.println("8. Display Transactions");
        System.out.println("9. Exit");
        System.out.print("Enter your choice: ");
    }
}

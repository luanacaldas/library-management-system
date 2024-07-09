package org.libraryproject;

public class LibraryFactory {
    public static Book createBook(String title, String author, String isbn, int quantity) {
        return new Book(title, author, isbn, quantity);
    }

    public static Member createMember(String name, int id, String contactInfo) {
        return new Member(name, id, contactInfo);
    }
}

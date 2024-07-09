package org.libraryproject;

public class BookObserver implements Observer {
    @Override
    public void update(Book book) {
        System.out.println("Observer: Book " + book.getTitle() + " has been updated. Available copies: " + book.getAvailableCopies());
    }
}

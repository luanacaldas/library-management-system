# 📚 Library Management System

**Overview**

The Library Management System is a console-based Java application designed to streamline the management of a library's books, members, and transactions. Leveraging a variety of design patterns, the system prioritizes clean, maintainable, and scalable code.

This project was developed as an activity for the Dio Santander Bootcamp to put the knowledge of design patterns in Java into practice and reinforce it.

**🚀 Features**

* **Add and Remove Books:** Easily add new books to the library's collection or remove existing ones.
* **Manage Members:** Add new members to the library's registry and maintain their contact information.
* **Issue and Return Books:** Seamlessly issue books to members and process book returns.
* **Display Information:** View comprehensive lists of books, members, and transaction histories.
* **Observer Pattern:** Automatically notify observers when a book's availability status changes.
* **Factory Method Pattern:** Simplify the creation of book and member objects.
* **Singleton Pattern:** Guarantee a single, globally accessible instance of the library throughout the application.

**📐 Design Patterns Used**

* **Singleton Pattern:** Ensures that the `Library` class has only one instance across the entire application, providing a unified access point.
* **Factory Method Pattern:** Facilitates the creation of `Book` and `Member` objects, promoting loose coupling by encapsulating instantiation logic within the factory class.
* **Observer Pattern:** The `Observer` and `Subject` interfaces, along with the `BookObserver` class, implement the observer pattern to automatically inform observers of any changes in book availability.

**🏗️ Class Structure**

* **Library:** The central class representing the library. Implements the `Subject` interface for the observer pattern.
* **Book:** Represents a book in the library.
* **Member:** Represents a library member.
* **Transaction:** Represents a transaction (issuing or returning a book).
* **LibraryFactory:** Factory class for creating `Book` and `Member` objects.
* **Observer:** Interface for implementing the observer pattern.
* **Subject:** Interface for the subject in the observer pattern.
* **BookObserver:** Concrete implementation of the `Observer` interface to monitor changes in `Book` objects.
* **LibraryApp:** The main application class containing the `main` method and the user interface logic.

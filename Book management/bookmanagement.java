package com.bookmanagement.bm;

import java.util.ArrayList;
import java.util.List;

public class BookManager {
	private List<Book> books = new ArrayList<>();

    // Initialize with hardcoded books
    public BookManager() {
        initializeBooks();
    }

    private void initializeBooks() {
        books.add(new Book(1, "C Programming", "Dennis Ritchie", "Programming", 450.00f, 4.8f));
        books.add(new Book(2, "Clean Code", "Robert C. Martin", "Programming", 550.00f, 4.7f));
        books.add(new Book(3, "Introduction to Algorithms", "Cormen", "Algorithms", 900.00f, 4.9f));
        books.add(new Book(4, "Design Patterns", "Erich Gamma", "Software Design", 700.00f, 4.5f));
        books.add(new Book(5, "Python Crash Course", "Eric Matthes", "Programming", 400.00f, 4.6f));
    }

    // Add a new book
    public void addBook(Book book) {
        if (findBookById(book.getId()) != null) {
            System.out.println("Error: Duplicate Book ID. Book not added.");
            return;
        }
        books.add(book);
        System.out.println("Book added successfully.");
    }

    // Remove a book by ID
    public void removeBook(int id) {
        Book book = findBookById(id);
        if (book != null) {
            books.remove(book);
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Error: Book ID not found.");
        }
    }

    // Search a book by ID
    public Book findBookById(int id) {
        return books.stream().filter(b -> b.getId() == id).findFirst().orElse(null);
    }

    // Search books by name
    public void searchBookByName(String name) {
        books.stream().filter(b -> b.getName().equalsIgnoreCase(name)).forEach(System.out::println);
    }

    // Filter books by author
    public void filterBooksByAuthor(String author) {
        books.stream().filter(b -> b.getAuthor().equalsIgnoreCase(author)).forEach(System.out::println);
    }

    // Display all books
    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the database.");
            return;
        }
        System.out.printf("\n%-10s%-30s%-25s%-20s%-10s%-10s\n", "ID", "Name", "Author", "Category", "Price", "Rating");
        System.out.println("----------------------------------------------------------------------------------------");
        books.forEach(System.out::println);
    }

    // Sort books by price or rating
    public void sortBooksBy(int sortBy) {
        books.sort((b1, b2) -> (sortBy == 1) ? Float.compare(b1.getPrice(), b2.getPrice()) : Float.compare(b2.getRating(), b1.getRating()));
        System.out.println("Books sorted successfully.");
        displayAllBooks();
    }

    // Update book details
    public void updateBook(int id, float newPrice, float newRating) {
        Book book = findBookById(id);
        if (book != null) {
            book.setPrice(newPrice);
            book.setRating(newRating);
            System.out.println("Book updated successfully.");
        } else {
            System.out.println("Error: Book ID not found.");
        }
    }
}

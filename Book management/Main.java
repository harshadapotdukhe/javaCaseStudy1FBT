package com.bookmanagement.bm;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        BookManager manager = new BookManager();
        int choice;

        while (true) {
            System.out.println("\nBook Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book by ID");
            System.out.println("4. Search Book by Name");
            System.out.println("5. Filter Books by Author");
            System.out.println("6. Display All Books");
            System.out.println("7. Sort Books by Price");
            System.out.println("8. Sort Books by Rating");
            System.out.println("9. Update Book (Price/Rating)");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Book Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Author Name: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter Category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter Price: ");
                    float price = scanner.nextFloat();
                    System.out.print("Enter Rating: ");
                    float rating = scanner.nextFloat();
                    manager.addBook(new Book(id, name, author, category, price, rating));
                    break;

                case 2:
                    System.out.print("Enter Book ID to remove: ");
                    manager.removeBook(scanner.nextInt());
                    break;

                case 3:
                    System.out.print("Enter Book ID to search: ");
                    Book book = manager.findBookById(scanner.nextInt());
                    System.out.println(book != null ? book : "Error: Book ID not found.");
                    break;

                case 4:
                    System.out.print("Enter Book Name to search: ");
                    scanner.nextLine();
                    manager.searchBookByName(scanner.nextLine());
                    break;

                case 5:
                    System.out.print("Enter Author Name to filter: ");
                    scanner.nextLine();
                    manager.filterBooksByAuthor(scanner.nextLine());
                    break;

                case 6:
                    manager.displayAllBooks();
                    break;

                case 7:
                    manager.sortBooksBy(1);
                    break;

                case 8:
                    manager.sortBooksBy(2);
                    break;

                case 9:
                    System.out.print("Enter Book ID to update: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Enter New Price: ");
                    float newPrice = scanner.nextFloat();
                    System.out.print("Enter New Rating: ");
                    float newRating = scanner.nextFloat();
                    manager.updateBook(updateId, newPrice, newRating);
                    break;

                case 10:
                    System.out.println("Exiting program. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
	}	
}

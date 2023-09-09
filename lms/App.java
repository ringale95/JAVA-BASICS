import models.Library;
import models.Cart;

import java.util.Scanner;
import java.io.*;

public class App {
    private static final String LIBRARY_FILE = "library.ser";

    public static void main(String[] args) {
        Library library = loadLibrary();
        Cart cart = new Cart();
        Scanner scanner = new Scanner(System.in);

        // Seed books data into the library
        seedData(library);

        while (true) {
            clearConsole();
            System.out.println("Library Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Get Book by Title");
            System.out.println("3. Add Book to Cart");
            System.out.println("4. View Cart");
            System.out.println("5. Exit");
            System.out.println("6. Search By Genre");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    clearConsole();
                    System.out.println("Add Book:");
                    System.out.print("Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character

                    library.addBook(title, author, genre, isbn, price);
                    System.out.println("Book added successfully.");
                    pauseExecution();
                    break;

                case 2:
                    clearConsole();
                    System.out.println("Get Book by Title:");
                    System.out.print("Enter Title: ");
                    String bookTitle = scanner.nextLine();
                    System.out.println(library.getBookByTitle(bookTitle));
                    pauseExecution();
                    break;

                

                case 3:
                    clearConsole();
                    System.out.println("Add Book to Cart:");
                    System.out.print("Enter Title: ");
                    String cartTitle = scanner.nextLine();
                    cart.addToCart(library.getBookByTitle(cartTitle));
                    System.out.println("Book added to cart.");
                    pauseExecution();
                    break;

                case 4:
                    clearConsole();
                    System.out.println("View Cart:");
                    System.out.println(cart);
                    pauseExecution();
                    break;

                case 5:
                    saveLibrary(library); // Save the library before exiting
                    clearConsole();
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);

                case 6:
                    clearConsole();
                    System.out.println("Get Book by Genre:");
                    System.out.print("Enter Genre: ");
                    genre = scanner.nextLine();
                    //List<Book> booksByGenre = library.searchByGenre(genre);
                    System.out.println("Books in "+ genre+ " are:");
                    System.out.println(library.searchByGenre(genre));
                    pauseExecution();
                    break;


                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    pauseExecution();
            }
        }
    }

    private static void clearConsole() {
        // Clears the console screen for improved user experience.
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void pauseExecution() {
        // Pauses execution and waits for user input to continue.
        System.out.print("Press Enter to continue...");
        new Scanner(System.in).nextLine();
    }

    private static Library loadLibrary() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(LIBRARY_FILE))) {
            return (Library) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new Library("Snell Library"); // Create a new library if the file doesn't exist or cannot be read
        }
    }

    private static void saveLibrary(Library library) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(LIBRARY_FILE))) {
            oos.writeObject(library);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void seedData(Library library) {
        // Seed books data into the library
        library.addBook("Harry Potter: Chamber of Secrets", "J.K Rowling", "Fantasy/Adventure", "2980131BN", 13.99);
        library.addBook("Harry Potter: Prisoner of Azkaban", "J.K Rowling", "Fantasy/Adventure", "2991131BN", 11.99);
        library.addBook("To Kill a Mockingbird", "Harper Lee", "Classic", "9780061120084", 9.99);
        library.addBook("The Great Gatsby", "F. Scott Fitzgerald", "Classic", "9780743273565", 10.99);
        library.addBook("1984", "George Orwell", "Dystopian", "9780451524935", 12.99);
        library.addBook("The Catcher in the Rye", "J.D. Salinger", "Classic", "9780316769488", 8.99);
    }

}

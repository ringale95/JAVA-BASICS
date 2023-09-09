package models;

import models.Book;
import models.User;
import java.util.*;

public class Library{
    private String name;
    private List<Book> booksCatalog;
    private List<User> usersDirectory;

    public Library(String name){
        this.name = name;
        this.booksCatalog = new ArrayList<Book>();
        this.usersDirectory = new ArrayList<User>();
    }

    public Book addBook(String title, String author, String genre, String isbn, double price){
        Book newBook = new Book(title,author,genre,isbn,price);
        this.booksCatalog.add(newBook);
        return newBook;
    }

    public User addUser(String username, String password, String role){
        User newUser = new User(username,password,role);
        this.usersDirectory.add(newUser);
        return newUser;
    }

    public Book getBookByTitle(String title){
        for(Book book:booksCatalog){
            if(book.getTitle().contains(title))
                return book;
        }
        return null;
    }

}
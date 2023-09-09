package models;

public class Book {
    private String title;
    private String author;
    private String genre;
    private String isbn;
    private double price;

    public Book(String title, String author, String genre, String isbn, double price) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isbn = isbn;
        this.price = price;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getGenre() {
        return this.genre;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public double getPrice() {
        return this.price;
    }

    public String toString() {
        return "\nTitle: " + this.title
                + "\nAuthor: " + this.author
                + "\nGenre: " + this.genre
                + "\nISBN: " + this.isbn
                + "\nPrice: $" + this.price
                + "\n";
    }
}

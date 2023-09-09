package models;

import java.util.*;

public class Cart{
    private List<Book> books;

    public Cart(){
        this.books = new ArrayList();
    }

    public void addToCart(Book book){
        this.books.add(book);
    }

    public String toString(){
        String ret = "Books added to cart...\n\n";
        for(Book book:books){
            ret += book + "\n";
        }
        return ret;
    }

}
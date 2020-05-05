package com.example.libraryntcc;

import java.util.ArrayList;

public class ARBook {
    ArrayList<Book> BookResponse;

    public ARBook(ArrayList<Book> bookResponse) {
        BookResponse = bookResponse;
    }

    public ARBook() {
    }

    public ArrayList<Book> getBookResponse() {
        return BookResponse;
    }

    public void setBookResponse(ArrayList<Book> bookResponse) {
        BookResponse = bookResponse;
    }
}

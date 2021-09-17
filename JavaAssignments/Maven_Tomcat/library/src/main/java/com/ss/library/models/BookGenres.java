package com.ss.library.models;

public class BookGenres {
    //Attributes for relationships
    private Genre genreId;
    private Book bookId;

    //Getter and Setters for relationships
    public Book getBookId() {
        return bookId;
    }
    public void setBookId(Book bookId) {
        this.bookId = bookId;
    }
    public Genre getGenreId() {
        return genreId;
    }
    public void setGenreId(Genre genreId) {
        this.genreId = genreId;
    }
}

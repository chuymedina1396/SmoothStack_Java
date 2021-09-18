package com.ss.library.models;

public class BookAuthors {
    
    private Book bookId;
    private Author authorId;

    public Author getAuthorId() {
        return authorId;
    }
    public void setAuthorId(Author authorId) {
        this.authorId = authorId;
    }
    public Book getBookId() {
        return bookId;
    }
    public void setBookId(Book bookId) {
        this.bookId = bookId;
    }
}

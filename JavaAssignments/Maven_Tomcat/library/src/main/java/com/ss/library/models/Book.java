package com.ss.library.models;
import java.util.List;

public class Book {
    //Atrrributes
    private Integer bookId;
    private String bookTitle;
    //Relationships
    private Publisher pubId;
    private List<BookLoans> bookLoans;
    private List<BookCopies> bookCopies;
    private List<BookAuthors> bookAuthors;

    //Getters and Setters for attributes
    public Integer getBookId() {
        return bookId;
    }
    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }
    public String getTitle() {
        return bookTitle;
    }
    public void setTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
    //Getter and Setter for relationship.
    public Publisher getPubId() {
        return pubId;
    }
    public void setPubId(Publisher pubId) {
        this.pubId = pubId;
    }
    public List<BookCopies> getBookCopies() {
        return bookCopies;
    }
    public void setBookCopies(List<BookCopies> bookCopies) {
        this.bookCopies = bookCopies;
    }
    public List<BookAuthors> getBookAuthors() {
        return bookAuthors;
    }
    public void setBookAuthors(List<BookAuthors> bookAuthors) {
        this.bookAuthors = bookAuthors;
    }
    public List<BookLoans> getBookLoans() {
        return bookLoans;
    }
    public void setBookLoans(List<BookLoans> bookLoans) {
        this.bookLoans = bookLoans;
    }
    @Override
    public String toString(){
        return this.bookTitle;
    }

}

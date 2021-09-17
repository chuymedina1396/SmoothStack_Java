package com.ss.library.models;
import java.util.List;

public class Book {
    //Atrrributes
    private Integer bookId;
    private String title;
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
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
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

}

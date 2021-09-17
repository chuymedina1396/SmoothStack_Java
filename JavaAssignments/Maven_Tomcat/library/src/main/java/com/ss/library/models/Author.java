package com.ss.library.models;
import java.util.List;

public class Author {
    //Attributes
    //We use private so a user doesn't modify the class level variables.
    private Integer authorId;
    private String authorName;
    //Relationships
    private List<BookAuthors> bookAuthors;

    //Getter and setter for attributes
    public Integer getAuthorId() {
        return authorId;
    }
    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }
    public String getAuthorName() {
        return authorName;
    }
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
    //Getter and setter for relationships
    public List<BookAuthors> getBookAuthors() {
        return bookAuthors;
    }
    public void setBookAuthors(List<BookAuthors> bookAuthors) {
        this.bookAuthors = bookAuthors;
    }
    
}

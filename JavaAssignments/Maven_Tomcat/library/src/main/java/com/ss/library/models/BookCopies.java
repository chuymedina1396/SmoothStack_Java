package com.ss.library.models;

public class BookCopies {
    //Attributes
    private Integer noOfCopies;
    
    //Relationships
    private Book bookId;
    private LibraryBranch branchId;


    //Getter and Setter for attributes.
    public Integer getNoOfCopies() {
        return noOfCopies;
    }
    public void setNoOfCopies(Integer noOfCopies) {
        this.noOfCopies = noOfCopies;
    }

    //Getters and setters for relationships
    public Book getBookId() {
        return bookId;
    }
    public void setBookId(Book bookId) {
        this.bookId = bookId;
    }
    public LibraryBranch getBranchId() {
        return branchId;
    }
    public void setBranchId(LibraryBranch branchId) {
        this.branchId = branchId;
    }
}

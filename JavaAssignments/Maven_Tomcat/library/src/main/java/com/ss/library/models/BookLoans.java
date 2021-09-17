package com.ss.library.models;

public class BookLoans {
    //Atrributes
    private String dateOut;
    private String dueDate;
    private String dateIn;

    //Relationships
    private Book bookId;
    private LibraryBranch branchId;
    private Borrower cardNo;


   
    // Getters and Setters for attributes
    public String getDateIn() {
        return dateIn;
    }
    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }
    public String getDateOut() {
        return dateOut;
    }
    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
    }
    public String getDueDate() {
        return dueDate;
    }
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
    
    // Getter and setters for relationships
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
    public Borrower getCardNo() {
        return cardNo;
    }
    public void setCardNo(Borrower cardNo) {
        this.cardNo = cardNo;
    }
    

}

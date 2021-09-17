package com.ss.library.models;
import java.util.List;

public class LibraryBranch {
    // Attributes
    private Integer branchId;
    private String branchName;
	private String branchAddress;

    //Relationships
    List<BookCopies> bookCopies;
    List<BookLoans> bookLoans;

    //Getters and Setters for Attributes.
    public Integer getBranchId() {
        return branchId;
    }
    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }
    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchAddress() {
        return branchAddress;
    }
    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
    }

    //Getters and Setters for relationships;
    public List<BookLoans> getBookLoans() {
        return bookLoans;
    }
    public void setBookLoans(List<BookLoans> bookLoans) {
        this.bookLoans = bookLoans;
    }

    public List<BookCopies> getBookCopies() {
        return bookCopies;
    }
    public void setBookCopies(List<BookCopies> bookCopies) {
        this.bookCopies = bookCopies;
    }
}

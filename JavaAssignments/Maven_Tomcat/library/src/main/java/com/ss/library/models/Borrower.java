package com.ss.library.models;
import java.util.List;

public class Borrower {
    //Atrributes
    private Integer cardNo;
    private String name;
    private String address;
    private String phone;
    //Relationships
    List<BookLoans> bookLoans;

    //Getters and setters for attributes.
    public Integer getCardNo() {
        return cardNo;
    }
    
    public void setCardNo(Integer cardNo) {
        this.cardNo = cardNo;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    // Getter and Setter for the relationship: 1:n

    public List<BookLoans> getBookLoans() {
        return bookLoans;
    }
    public void setBookLoans(List<BookLoans> bookLoans) {
        this.bookLoans = bookLoans;
    }

}

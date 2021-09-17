package com.ss.library.models;
import java.util.List;

public class Publisher {
    //Attributes
    private Integer publisherId;
    private String publisherName;
    private String publisherAddress;
    private String publisherPhone;

    //Relationships
    //This is the only non-indenetifying relationship in the db. Do we need to specify anything?
    private List<Book> books;

    //Getter and setters for attributes
    public Integer getPublisherId() {
        return publisherId;
    }
    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }
    public String getPublisherName() {
        return publisherName;
    }
    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }
    public String getPublisherAddress() {
        return publisherAddress;
    }
    public void setPublisherAddress(String publisherAddress) {
        this.publisherAddress = publisherAddress;
    }
    public String getPublisherPhone() {
        return publisherPhone;
    }
    public void setPublisherPhone(String publisherPhone) {
        this.publisherPhone = publisherPhone;
    }

    //Getter and Setters for relationships
    public void setBooks(List<Book> books) {
        this.books = books;
    }
    public List<Book> getBooks() {
        return books;
    }
}

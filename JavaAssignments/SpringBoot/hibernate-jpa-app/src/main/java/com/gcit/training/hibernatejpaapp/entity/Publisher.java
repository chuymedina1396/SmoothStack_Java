package com.gcit.training.hibernatejpaapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "publisher") // Telling Hibernate that we have a table called publisher
public class Publisher {
	
	// All these properties map to columns.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincremented ID. So everytime we persist, it will auto generate the key.
	private Integer publisherId;
    
    @Column(name = "publisher_name")
	private String publisherName; // this will map to the publisher_name column
    
    @Column(name = "publisher_address") // same as above.
	private String publisherAddress;
	
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
	
}

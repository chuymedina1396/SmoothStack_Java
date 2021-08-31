package com.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "airport") // Telling Hibernate that we have a table called airport
public class Airport {
	
	// All these properties map to columns.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private String iata_id;
    
    @Column(name = "city") // same as above.
	private String airportCity;
	
	public String airportId() {
		return publisherId;
	}
	public void setPublisherId(Integer publisherId) {
		this.publisherId = publisherId;
	}
	
}

package com.ss.utopia_spring.entities;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "airport")
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private String airportCode;
    @Column(name = "city")
	private String city;
    // @OneToMany(mappedBy="airport")
	// private List<Route> routes;
    // @OneToMany(mappedBy="airport")
    // private Route destination_id;


    public Airport() {
    }

    public Airport(String airportCode, String city) {
        this.airportCode = airportCode;
        this.city = city;
    }

    public String getAirportCode() {
        return this.airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Airport airportCode(String airportCode) {
        setAirportCode(airportCode);
        return this;
    }

    public Airport city(String city) {
        setCity(city);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Airport)) {
            return false;
        }
        Airport airport = (Airport) o;
        return Objects.equals(airportCode, airport.airportCode) && Objects.equals(city, airport.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(airportCode, city);
    }

    @Override
    public String toString() {
        return "{" +
            " airportCode='" + getAirportCode() + "'" +
            ", city='" + getCity() + "'" +
            "}";
    }




}

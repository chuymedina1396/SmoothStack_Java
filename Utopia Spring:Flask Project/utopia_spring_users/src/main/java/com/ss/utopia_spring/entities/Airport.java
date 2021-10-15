package com.ss.utopia_spring.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Objects;


@Entity
@Table(name = "airport")
public class Airport {

    @Id
    @Column(name = "iata_id")
	private String iata_id;
    @Column(name = "city")
	private String city;


    public Airport() {
    }

    public Airport(String iata_id, String city) {
        this.iata_id = iata_id;
        this.city = city;
    }

    public String getIata_id() {
        return this.iata_id;
    }

    public void setIata_id(String iata_id) {
        this.iata_id = iata_id;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Airport iata_id(String iata_id) {
        setIata_id(iata_id);
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
        return Objects.equals(iata_id, airport.iata_id) && Objects.equals(city, airport.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iata_id, city);
    }

    @Override
    public String toString() {
        return "{" +
            " iata_id='" + getIata_id() + "'" +
            ", city='" + getCity() + "'" +
            "}";
    }

    




}

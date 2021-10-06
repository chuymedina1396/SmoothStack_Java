package com.ss.utopia_spring.entities;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

// Java packaged we learned about in Java Basics Five
import java.time.LocalDateTime;

public class Flight{
    
    private Integer id;

    // 1-1 Relationships
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "route_id", referencedColumnName = "id")
    private Route route;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "airplane_id", referencedColumnName = "id")
    private Airplane airplane;

    private LocalDateTime departureTime;
    private Integer reservedSeats;
    private Float seatPrice;


    public Flight() {
    }

    public Flight(Integer id, Route route, Airplane airplane, LocalDateTime departureTime, Integer reservedSeats, Float seatPrice) {
        this.id = id;
        this.route = route;
        this.airplane = airplane;
        this.departureTime = departureTime;
        this.reservedSeats = reservedSeats;
        this.seatPrice = seatPrice;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Route getRoute() {
        return this.route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Airplane getAirplane() {
        return this.airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public LocalDateTime getDepartureTime() {
        return this.departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public Integer getReservedSeats() {
        return this.reservedSeats;
    }

    public void setReservedSeats(Integer reservedSeats) {
        this.reservedSeats = reservedSeats;
    }

    public Float getSeatPrice() {
        return this.seatPrice;
    }

    public void setSeatPrice(Float seatPrice) {
        this.seatPrice = seatPrice;
    }

    public Flight id(Integer id) {
        setId(id);
        return this;
    }

    public Flight route(Route route) {
        setRoute(route);
        return this;
    }

    public Flight airplane(Airplane airplane) {
        setAirplane(airplane);
        return this;
    }

    public Flight departureTime(LocalDateTime departureTime) {
        setDepartureTime(departureTime);
        return this;
    }

    public Flight reservedSeats(Integer reservedSeats) {
        setReservedSeats(reservedSeats);
        return this;
    }

    public Flight seatPrice(Float seatPrice) {
        setSeatPrice(seatPrice);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Flight)) {
            return false;
        }
        Flight flight = (Flight) o;
        return Objects.equals(id, flight.id) && Objects.equals(route, flight.route) && Objects.equals(airplane, flight.airplane) && Objects.equals(departureTime, flight.departureTime) && Objects.equals(reservedSeats, flight.reservedSeats) && Objects.equals(seatPrice, flight.seatPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, route, airplane, departureTime, reservedSeats, seatPrice);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", route='" + getRoute() + "'" +
            ", airplane='" + getAirplane() + "'" +
            ", departureTime='" + getDepartureTime() + "'" +
            ", reservedSeats='" + getReservedSeats() + "'" +
            ", seatPrice='" + getSeatPrice() + "'" +
            "}";
    }

    
    

    
}
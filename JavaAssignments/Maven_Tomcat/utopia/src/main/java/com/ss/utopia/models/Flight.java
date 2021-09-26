package com.ss.utopia.models;

import java.util.Objects;

// Java packaged we learned about in Java Basics Five
import java.time.LocalDateTime;

public class Flight{
    
    private Integer flightId;

    // 1-1 Relationships
    private Route route;
    private Airplane airplane;

    private String departureTime;
    private Integer reservedSeats;
    private Float seatPrice;



    public Flight() {
    }

    public Flight(Integer flightId, Route route, Airplane airplane, String departureTime, Integer reservedSeats, Float seatPrice) {
        this.flightId = flightId;
        this.route = route;
        this.airplane = airplane;
        this.departureTime = departureTime;
        this.reservedSeats = reservedSeats;
        this.seatPrice = seatPrice;
    }

    public Integer getFlightId() {
        return this.flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
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

    public String getDepartureTime() {
        return this.departureTime;
    }

    public void setDepartureTime(String departureTime) {
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

    public Flight flightId(Integer flightId) {
        setFlightId(flightId);
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

    public Flight departureTime(String departureTime) {
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
        return Objects.equals(flightId, flight.flightId) && Objects.equals(route, flight.route) && Objects.equals(airplane, flight.airplane) && Objects.equals(departureTime, flight.departureTime) && Objects.equals(reservedSeats, flight.reservedSeats) && Objects.equals(seatPrice, flight.seatPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightId, route, airplane, departureTime, reservedSeats, seatPrice);
    }

    @Override
    public String toString() {
        return "{" +
            " flightId='" + getFlightId() + "'" +
            ", route='" + getRoute() + "'" +
            ", airplane='" + getAirplane() + "'" +
            ", departureTime='" + getDepartureTime() + "'" +
            ", reservedSeats='" + getReservedSeats() + "'" +
            ", seatPrice='" + getSeatPrice() + "'" +
            "}";
    }
    

    
}
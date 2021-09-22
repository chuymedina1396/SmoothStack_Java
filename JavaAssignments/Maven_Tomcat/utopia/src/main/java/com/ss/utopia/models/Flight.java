package com.ss.utopia.models;

import java.util.Objects;

public class Flight{
    
    private Integer flightId;

    // 1-1 Relationships
    private Route routeId;
    private Airplane airplaneId;

    private String departure_time;
    private Integer reserved_seats;
    private Float seat_price;
    

    public Flight() {
    }

    public Flight(Integer flightId, Route routeId, Airplane airplaneId, String departure_time, Integer reserved_seats, Float seat_price) {
        this.flightId = flightId;
        this.routeId = routeId;
        this.airplaneId = airplaneId;
        this.departure_time = departure_time;
        this.reserved_seats = reserved_seats;
        this.seat_price = seat_price;
    }

    public Integer getFlightId() {
        return this.flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public Route getRouteId() {
        return this.routeId;
    }

    public void setRouteId(Route routeId) {
        this.routeId = routeId;
    }

    public Airplane getAirplaneId() {
        return this.airplaneId;
    }

    public void setAirplaneId(Airplane airplaneId) {
        this.airplaneId = airplaneId;
    }

    public String getDeparture_time() {
        return this.departure_time;
    }

    public void setDeparture_time(String departure_time) {
        this.departure_time = departure_time;
    }

    public Integer getReserved_seats() {
        return this.reserved_seats;
    }

    public void setReserved_seats(Integer reserved_seats) {
        this.reserved_seats = reserved_seats;
    }

    public Float getSeat_price() {
        return this.seat_price;
    }

    public void setSeat_price(Float seat_price) {
        this.seat_price = seat_price;
    }

    public Flight flightId(Integer flightId) {
        setFlightId(flightId);
        return this;
    }

    public Flight routeId(Route routeId) {
        setRouteId(routeId);
        return this;
    }

    public Flight airplaneId(Airplane airplaneId) {
        setAirplaneId(airplaneId);
        return this;
    }

    public Flight departure_time(String departure_time) {
        setDeparture_time(departure_time);
        return this;
    }

    public Flight reserved_seats(Integer reserved_seats) {
        setReserved_seats(reserved_seats);
        return this;
    }

    public Flight seat_price(Float seat_price) {
        setSeat_price(seat_price);
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
        return Objects.equals(flightId, flight.flightId) && Objects.equals(routeId, flight.routeId) && Objects.equals(airplaneId, flight.airplaneId) && Objects.equals(departure_time, flight.departure_time) && Objects.equals(reserved_seats, flight.reserved_seats) && Objects.equals(seat_price, flight.seat_price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightId, routeId, airplaneId, departure_time, reserved_seats, seat_price);
    }

    @Override
    public String toString() {
        return "{" +
            " flightId='" + getFlightId() + "'" +
            ", routeId='" + getRouteId() + "'" +
            ", airplaneId='" + getAirplaneId() + "'" +
            ", departure_time='" + getDeparture_time() + "'" +
            ", reserved_seats='" + getReserved_seats() + "'" +
            ", seat_price='" + getSeat_price() + "'" +
            "}";
    }

    
    
}
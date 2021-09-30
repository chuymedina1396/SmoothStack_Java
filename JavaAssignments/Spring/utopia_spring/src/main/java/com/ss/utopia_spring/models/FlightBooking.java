package com.ss.utopia_spring.models;

import java.util.Objects;

public class FlightBooking {

    private Flight flghtId;
    private Booking bookingId;

    public FlightBooking() {
    }

    public FlightBooking(Flight flghtId, Booking bookingId) {
        this.flghtId = flghtId;
        this.bookingId = bookingId;
    }

    public Flight getFlghtId() {
        return this.flghtId;
    }

    public void setFlghtId(Flight flghtId) {
        this.flghtId = flghtId;
    }

    public Booking getBookingId() {
        return this.bookingId;
    }

    public void setBookingId(Booking bookingId) {
        this.bookingId = bookingId;
    }

    public FlightBooking flghtId(Flight flghtId) {
        setFlghtId(flghtId);
        return this;
    }

    public FlightBooking bookingId(Booking bookingId) {
        setBookingId(bookingId);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof FlightBooking)) {
            return false;
        }
        FlightBooking flightBooking = (FlightBooking) o;
        return Objects.equals(flghtId, flightBooking.flghtId) && Objects.equals(bookingId, flightBooking.bookingId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flghtId, bookingId);
    }

    @Override
    public String toString() {
        return "{" +
            " flghtId='" + getFlghtId() + "'" +
            ", bookingId='" + getBookingId() + "'" +
            "}";
    }


}
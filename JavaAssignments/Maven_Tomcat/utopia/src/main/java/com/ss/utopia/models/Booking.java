package com.ss.utopia.models;

import java.util.List;
import java.util.Objects;

public class Booking {

    private Integer bookingId;
    private Integer isActive; 
    private String confirmationCode;

    private List<FlightBooking> flightBookings;

    private List<Passenger> passengers;

    private BookingPayment bookingPayment;

    private BookingAgent bookingAgent;

    private BookingUser bookingUser;

    private BookingGuest bookingGuest;


    public Booking() {
    }

    public Booking(Integer bookingId, Integer isActive, String confirmationCode, List<FlightBooking> flightBookings, List<Passenger> passengers, BookingPayment bookingPayment, BookingAgent bookingAgent, BookingUser bookingUser, BookingGuest bookingGuest) {
        this.bookingId = bookingId;
        this.isActive = isActive;
        this.confirmationCode = confirmationCode;
        this.flightBookings = flightBookings;
        this.passengers = passengers;
        this.bookingPayment = bookingPayment;
        this.bookingAgent = bookingAgent;
        this.bookingUser = bookingUser;
        this.bookingGuest = bookingGuest;
    }

    public Integer getBookingId() {
        return this.bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Integer getIsActive() {
        return this.isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public String getConfirmationCode() {
        return this.confirmationCode;
    }

    public void setConfirmationCode(String confirmationCode) {
        this.confirmationCode = confirmationCode;
    }

    public List<FlightBooking> getFlightBookings() {
        return this.flightBookings;
    }

    public void setFlightBookings(List<FlightBooking> flightBookings) {
        this.flightBookings = flightBookings;
    }

    public List<Passenger> getPassengers() {
        return this.passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public BookingPayment getBookingPayment() {
        return this.bookingPayment;
    }

    public void setBookingPayment(BookingPayment bookingPayment) {
        this.bookingPayment = bookingPayment;
    }

    public BookingAgent getBookingAgent() {
        return this.bookingAgent;
    }

    public void setBookingAgent(BookingAgent bookingAgent) {
        this.bookingAgent = bookingAgent;
    }

    public BookingUser getBookingUser() {
        return this.bookingUser;
    }

    public void setBookingUser(BookingUser bookingUser) {
        this.bookingUser = bookingUser;
    }

    public BookingGuest getBookingGuest() {
        return this.bookingGuest;
    }

    public void setBookingGuest(BookingGuest bookingGuest) {
        this.bookingGuest = bookingGuest;
    }

    public Booking bookingId(Integer bookingId) {
        setBookingId(bookingId);
        return this;
    }

    public Booking isActive(Integer isActive) {
        setIsActive(isActive);
        return this;
    }

    public Booking confirmationCode(String confirmationCode) {
        setConfirmationCode(confirmationCode);
        return this;
    }

    public Booking flightBookings(List<FlightBooking> flightBookings) {
        setFlightBookings(flightBookings);
        return this;
    }

    public Booking passengers(List<Passenger> passengers) {
        setPassengers(passengers);
        return this;
    }

    public Booking bookingPayment(BookingPayment bookingPayment) {
        setBookingPayment(bookingPayment);
        return this;
    }

    public Booking bookingAgent(BookingAgent bookingAgent) {
        setBookingAgent(bookingAgent);
        return this;
    }

    public Booking bookingUser(BookingUser bookingUser) {
        setBookingUser(bookingUser);
        return this;
    }

    public Booking bookingGuest(BookingGuest bookingGuest) {
        setBookingGuest(bookingGuest);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Booking)) {
            return false;
        }
        Booking booking = (Booking) o;
        return Objects.equals(bookingId, booking.bookingId) && Objects.equals(isActive, booking.isActive) && Objects.equals(confirmationCode, booking.confirmationCode) && Objects.equals(flightBookings, booking.flightBookings) && Objects.equals(passengers, booking.passengers) && Objects.equals(bookingPayment, booking.bookingPayment) && Objects.equals(bookingAgent, booking.bookingAgent) && Objects.equals(bookingUser, booking.bookingUser) && Objects.equals(bookingGuest, booking.bookingGuest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, isActive, confirmationCode, flightBookings, passengers, bookingPayment, bookingAgent, bookingUser, bookingGuest);
    }

    @Override
    public String toString() {
        return "{" +
            " bookingId='" + getBookingId() + "'" +
            ", isActive='" + getIsActive() + "'" +
            ", confirmationCode='" + getConfirmationCode() + "'" +
            ", flightBookings='" + getFlightBookings() + "'" +
            ", passengers='" + getPassengers() + "'" +
            ", bookingPayment='" + getBookingPayment() + "'" +
            ", bookingAgent='" + getBookingAgent() + "'" +
            ", bookingUser='" + getBookingUser() + "'" +
            ", bookingGuest='" + getBookingGuest() + "'" +
            "}";
    }

 


    



    

}
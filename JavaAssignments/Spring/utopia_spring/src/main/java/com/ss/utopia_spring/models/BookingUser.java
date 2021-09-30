package com.ss.utopia_spring.models;

import java.util.Objects;

public class BookingUser {
    
    private Booking bookingId;
    private User userId;

    public BookingUser() {
    }

    public BookingUser(Booking bookingId, User userId) {
        this.bookingId = bookingId;
        this.userId = userId;
    }

    public Booking getBookingId() {
        return this.bookingId;
    }

    public void setBookingId(Booking bookingId) {
        this.bookingId = bookingId;
    }

    public User getUserId() {
        return this.userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public BookingUser bookingId(Booking bookingId) {
        setBookingId(bookingId);
        return this;
    }

    public BookingUser userId(User userId) {
        setUserId(userId);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof BookingUser)) {
            return false;
        }
        BookingUser bookingUser = (BookingUser) o;
        return Objects.equals(bookingId, bookingUser.bookingId) && Objects.equals(userId, bookingUser.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, userId);
    }

    @Override
    public String toString() {
        return "{" +
            " bookingId='" + getBookingId() + "'" +
            ", userId='" + getUserId() + "'" +
            "}";
    }

 


    



    

}
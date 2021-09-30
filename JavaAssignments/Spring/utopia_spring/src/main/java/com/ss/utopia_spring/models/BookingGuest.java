package com.ss.utopia_spring.models;

import java.util.Objects;

public class BookingGuest {

    private Booking bookingId;
    private String contactEmail;
    private String contactPhone;

    public BookingGuest() {
    }

    public BookingGuest(Booking bookingId, String contactEmail, String contactPhone) {
        this.bookingId = bookingId;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
    }

    public Booking getBookingId() {
        return this.bookingId;
    }

    public void setBookingId(Booking bookingId) {
        this.bookingId = bookingId;
    }

    public String getContactEmail() {
        return this.contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactPhone() {
        return this.contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public BookingGuest bookingId(Booking bookingId) {
        setBookingId(bookingId);
        return this;
    }

    public BookingGuest contactEmail(String contactEmail) {
        setContactEmail(contactEmail);
        return this;
    }

    public BookingGuest contactPhone(String contactPhone) {
        setContactPhone(contactPhone);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof BookingGuest)) {
            return false;
        }
        BookingGuest bookingGuest = (BookingGuest) o;
        return Objects.equals(bookingId, bookingGuest.bookingId) && Objects.equals(contactEmail, bookingGuest.contactEmail) && Objects.equals(contactPhone, bookingGuest.contactPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, contactEmail, contactPhone);
    }

    @Override
    public String toString() {
        return "{" +
            " bookingId='" + getBookingId() + "'" +
            ", contactEmail='" + getContactEmail() + "'" +
            ", contactPhone='" + getContactPhone() + "'" +
            "}";
    }


}
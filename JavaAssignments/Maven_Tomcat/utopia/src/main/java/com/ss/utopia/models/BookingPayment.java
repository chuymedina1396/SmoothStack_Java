package com.ss.utopia.models;

import java.util.Objects;

public class BookingPayment {

    private Booking bookingId;
    private String stripeId;
    private Integer refunded;


    public BookingPayment() {
    }

    public BookingPayment(Booking bookingId, String stripeId, Integer refunded) {
        this.bookingId = bookingId;
        this.stripeId = stripeId;
        this.refunded = refunded;
    }

    public Booking getBookingId() {
        return this.bookingId;
    }

    public void setBookingId(Booking bookingId) {
        this.bookingId = bookingId;
    }

    public String getStripeId() {
        return this.stripeId;
    }

    public void setStripeId(String stripeId) {
        this.stripeId = stripeId;
    }

    public Integer getRefunded() {
        return this.refunded;
    }

    public void setRefunded(Integer refunded) {
        this.refunded = refunded;
    }

    public BookingPayment bookingId(Booking bookingId) {
        setBookingId(bookingId);
        return this;
    }

    public BookingPayment stripeId(String stripeId) {
        setStripeId(stripeId);
        return this;
    }

    public BookingPayment refunded(Integer refunded) {
        setRefunded(refunded);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof BookingPayment)) {
            return false;
        }
        BookingPayment bookingPayment = (BookingPayment) o;
        return Objects.equals(bookingId, bookingPayment.bookingId) && Objects.equals(stripeId, bookingPayment.stripeId) && Objects.equals(refunded, bookingPayment.refunded);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, stripeId, refunded);
    }

    @Override
    public String toString() {
        return "{" +
            " bookingId='" + getBookingId() + "'" +
            ", stripeId='" + getStripeId() + "'" +
            ", refunded='" + getRefunded() + "'" +
            "}";
    }


    


}
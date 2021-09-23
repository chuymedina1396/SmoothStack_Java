package com.ss.utopia.models;

import java.util.Objects;

public class BookingAgent {

    private Booking bookingId;
    private User agentId;

    public BookingAgent() {
    }

    public BookingAgent(Booking bookingId, User agentId) {
        this.bookingId = bookingId;
        this.agentId = agentId;
    }

    public Booking getBookingId() {
        return this.bookingId;
    }

    public void setBookingId(Booking bookingId) {
        this.bookingId = bookingId;
    }

    public User getAgentId() {
        return this.agentId;
    }

    public void setAgentId(User agentId) {
        this.agentId = agentId;
    }

    public BookingAgent bookingId(Booking bookingId) {
        setBookingId(bookingId);
        return this;
    }

    public BookingAgent agentId(User agentId) {
        setAgentId(agentId);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof BookingAgent)) {
            return false;
        }
        BookingAgent bookingAgent = (BookingAgent) o;
        return Objects.equals(bookingId, bookingAgent.bookingId) && Objects.equals(agentId, bookingAgent.agentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, agentId);
    }

    @Override
    public String toString() {
        return "{" +
            " bookingId='" + getBookingId() + "'" +
            ", agentId='" + getAgentId() + "'" +
            "}";
    }

}
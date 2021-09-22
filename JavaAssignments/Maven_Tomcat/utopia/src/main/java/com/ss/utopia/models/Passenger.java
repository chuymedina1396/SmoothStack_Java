package com.ss.utopia.models;

import java.util.Objects;

public class Passenger {
    private Integer passengerId;
    private Booking bookingId;
    private String given_name;
    public String family_name;
    public String dob;
    public String gender;
    public String address;


    public Passenger() {
    }

    public Passenger(Integer passengerId, Booking bookingId, String given_name, String family_name, String dob, String gender, String address) {
        this.passengerId = passengerId;
        this.bookingId = bookingId;
        this.given_name = given_name;
        this.family_name = family_name;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
    }

    public Integer getPassengerId() {
        return this.passengerId;
    }

    public void setPassengerId(Integer passengerId) {
        this.passengerId = passengerId;
    }

    public Booking getBookingId() {
        return this.bookingId;
    }

    public void setBookingId(Booking bookingId) {
        this.bookingId = bookingId;
    }

    public String getGiven_name() {
        return this.given_name;
    }

    public void setGiven_name(String given_name) {
        this.given_name = given_name;
    }

    public String getFamily_name() {
        return this.family_name;
    }

    public void setFamily_name(String family_name) {
        this.family_name = family_name;
    }

    public String getDob() {
        return this.dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Passenger passengerId(Integer passengerId) {
        setPassengerId(passengerId);
        return this;
    }

    public Passenger bookingId(Booking bookingId) {
        setBookingId(bookingId);
        return this;
    }

    public Passenger given_name(String given_name) {
        setGiven_name(given_name);
        return this;
    }

    public Passenger family_name(String family_name) {
        setFamily_name(family_name);
        return this;
    }

    public Passenger dob(String dob) {
        setDob(dob);
        return this;
    }

    public Passenger gender(String gender) {
        setGender(gender);
        return this;
    }

    public Passenger address(String address) {
        setAddress(address);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Passenger)) {
            return false;
        }
        Passenger passenger = (Passenger) o;
        return Objects.equals(passengerId, passenger.passengerId) && Objects.equals(bookingId, passenger.bookingId) && Objects.equals(given_name, passenger.given_name) && Objects.equals(family_name, passenger.family_name) && Objects.equals(dob, passenger.dob) && Objects.equals(gender, passenger.gender) && Objects.equals(address, passenger.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passengerId, bookingId, given_name, family_name, dob, gender, address);
    }

    @Override
    public String toString() {
        return "{" +
            " passengerId='" + getPassengerId() + "'" +
            ", bookingId='" + getBookingId() + "'" +
            ", given_name='" + getGiven_name() + "'" +
            ", family_name='" + getFamily_name() + "'" +
            ", dob='" + getDob() + "'" +
            ", gender='" + getGender() + "'" +
            ", address='" + getAddress() + "'" +
            "}";
    }




}
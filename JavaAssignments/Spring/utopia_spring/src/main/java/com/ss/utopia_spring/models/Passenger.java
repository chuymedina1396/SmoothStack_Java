package com.ss.utopia_spring.models;
import java.util.Objects;

public class Passenger {
    private Integer passengerId;
    private Booking bookingId;
    private String givenName;
    public String familyName;
    public String dob;
    public String gender;
    public String address;


    public Passenger() {
    }

    public Passenger(Integer passengerId, Booking bookingId, String givenName, String familyName, String dob, String gender, String address) {
        this.passengerId = passengerId;
        this.bookingId = bookingId;
        this.givenName = givenName;
        this.familyName = familyName;
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

    public String getGivenName() {
        return this.givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return this.familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
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

    public Passenger givenName(String givenName) {
        setGivenName(givenName);
        return this;
    }

    public Passenger familyName(String familyName) {
        setFamilyName(familyName);
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
        return Objects.equals(passengerId, passenger.passengerId) && Objects.equals(bookingId, passenger.bookingId) && Objects.equals(givenName, passenger.givenName) && Objects.equals(familyName, passenger.familyName) && Objects.equals(dob, passenger.dob) && Objects.equals(gender, passenger.gender) && Objects.equals(address, passenger.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passengerId, bookingId, givenName, familyName, dob, gender, address);
    }

    @Override
    public String toString() {
        return "{" +
            " passengerId='" + getPassengerId() + "'" +
            ", bookingId='" + getBookingId() + "'" +
            ", givenName='" + getGivenName() + "'" +
            ", familyName='" + getFamilyName() + "'" +
            ", dob='" + getDob() + "'" +
            ", gender='" + getGender() + "'" +
            ", address='" + getAddress() + "'" +
            "}";
    }




}
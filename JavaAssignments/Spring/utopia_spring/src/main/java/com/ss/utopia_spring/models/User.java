package com.ss.utopia_spring.models;
import java.util.List;
import java.util.Objects;

public class User {
    
    private Integer userId;
    private UserRole userRoleId;
    private String givenName;
    private String familyName;
    private String username;
    private String email;
    private String password;
    private String phone;

    List<BookingAgent> bookingAgents;

    List<BookingUser> bookingUsers;


    public User() {
    }

    public User(Integer userId, UserRole userRoleId, String givenName, String familyName, String username, String email, String password, String phone, List<BookingAgent> bookingAgents, List<BookingUser> bookingUsers) {
        this.userId = userId;
        this.userRoleId = userRoleId;
        this.givenName = givenName;
        this.familyName = familyName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.bookingAgents = bookingAgents;
        this.bookingUsers = bookingUsers;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public UserRole getUserRoleId() {
        return this.userRoleId;
    }

    public void setUserRoleId(UserRole userRoleId) {
        this.userRoleId = userRoleId;
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

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<BookingAgent> getBookingAgents() {
        return this.bookingAgents;
    }

    public void setBookingAgents(List<BookingAgent> bookingAgents) {
        this.bookingAgents = bookingAgents;
    }

    public List<BookingUser> getBookingUsers() {
        return this.bookingUsers;
    }

    public void setBookingUsers(List<BookingUser> bookingUsers) {
        this.bookingUsers = bookingUsers;
    }

    public User userId(Integer userId) {
        setUserId(userId);
        return this;
    }

    public User userRoleId(UserRole userRoleId) {
        setUserRoleId(userRoleId);
        return this;
    }

    public User givenName(String givenName) {
        setGivenName(givenName);
        return this;
    }

    public User familyName(String familyName) {
        setFamilyName(familyName);
        return this;
    }

    public User username(String username) {
        setUsername(username);
        return this;
    }

    public User email(String email) {
        setEmail(email);
        return this;
    }

    public User password(String password) {
        setPassword(password);
        return this;
    }

    public User phone(String phone) {
        setPhone(phone);
        return this;
    }

    public User bookingAgents(List<BookingAgent> bookingAgents) {
        setBookingAgents(bookingAgents);
        return this;
    }

    public User bookingUsers(List<BookingUser> bookingUsers) {
        setBookingUsers(bookingUsers);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(userId, user.userId) && Objects.equals(userRoleId, user.userRoleId) && Objects.equals(givenName, user.givenName) && Objects.equals(familyName, user.familyName) && Objects.equals(username, user.username) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(phone, user.phone) && Objects.equals(bookingAgents, user.bookingAgents) && Objects.equals(bookingUsers, user.bookingUsers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userRoleId, givenName, familyName, username, email, password, phone, bookingAgents, bookingUsers);
    }

    @Override
    public String toString() {
        return "{" +
            " userId='" + getUserId() + "'" +
            ", userRoleId='" + getUserRoleId() + "'" +
            ", givenName='" + getGivenName() + "'" +
            ", familyName='" + getFamilyName() + "'" +
            ", username='" + getUsername() + "'" +
            ", email='" + getEmail() + "'" +
            ", password='" + getPassword() + "'" +
            ", phone='" + getPhone() + "'" +
            ", bookingAgents='" + getBookingAgents() + "'" +
            ", bookingUsers='" + getBookingUsers() + "'" +
            "}";
    }
    




}
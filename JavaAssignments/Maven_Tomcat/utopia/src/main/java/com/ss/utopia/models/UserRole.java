package com.ss.utopia.models;
import java.util.List;
import java.util.Objects;


public class UserRole {

    private Integer userRoleId;
    private String name;

    List<User> users;


    public UserRole() {
    }

    public UserRole(Integer userRoleId, String name, List<User> users) {
        this.userRoleId = userRoleId;
        this.name = name;
        this.users = users;
    }

    public Integer getUserRoleId() {
        return this.userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return this.users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public UserRole userRoleId(Integer userRoleId) {
        setUserRoleId(userRoleId);
        return this;
    }

    public UserRole name(String name) {
        setName(name);
        return this;
    }

    public UserRole users(List<User> users) {
        setUsers(users);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UserRole)) {
            return false;
        }
        UserRole userRole = (UserRole) o;
        return Objects.equals(userRoleId, userRole.userRoleId) && Objects.equals(name, userRole.name) && Objects.equals(users, userRole.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userRoleId, name, users);
    }

    @Override
    public String toString() {
        return "{" +
            " userRoleId='" + getUserRoleId() + "'" +
            ", name='" + getName() + "'" +
            ", users='" + getUsers() + "'" +
            "}";
    }


}
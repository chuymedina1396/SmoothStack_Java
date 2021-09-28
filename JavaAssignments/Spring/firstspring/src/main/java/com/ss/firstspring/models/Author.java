package com.ss.firstspring.models;

import java.util.Objects;

public class Author {
    
    String name;
    int authorId;
    public Author() {
    }

    public Author(String name, int authorId) {
        this.name = name;
        this.authorId = authorId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAuthorId() {
        return this.authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public Author name(String name) {
        setName(name);
        return this;
    }

    public Author authorId(int authorId) {
        setAuthorId(authorId);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Author)) {
            return false;
        }
        Author author = (Author) o;
        return Objects.equals(name, author.name) && authorId == author.authorId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, authorId);
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", authorId='" + getAuthorId() + "'" +
            "}";
    }

}

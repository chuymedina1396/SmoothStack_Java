package com.ss.library.models;
import java.util.List;

public class Genre {

    //Attributes
    private Integer genre_id;
    private String genre_name;

    //Relationships

    private List<BookGenres> bookGenres;

    //Getter and Setters for attributes
    public Integer getGenre_id() {
        return genre_id;
    }
    public void setGenre_id(Integer genre_id) {
        this.genre_id = genre_id;
    }
    public String getGenre_name() {
        return genre_name;
    }
    public void setGenre_name(String genre_name) {
        this.genre_name = genre_name;
    }

    //Getter and setter for relationships
    public List<BookGenres> getBookGenres() {
        return bookGenres;
    }
    public void setBookGenres(List<BookGenres> bookGenres) {
        this.bookGenres = bookGenres;
    }


}

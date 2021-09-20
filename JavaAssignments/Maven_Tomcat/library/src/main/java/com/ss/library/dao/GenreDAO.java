package com.ss.library.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.library.models.Genre;

public class GenreDAO extends BaseDAO<Genre> {

    public GenreDAO(Connection conn){
        super(conn);
    }

    public void addGenre(Genre genre) throws ClassNotFoundException, SQLException {
        save("INSERT INTO tbl_genre SET genre_id, genre_name VALUES(?,?)", new Object[] {genre.getGenre_id(), genre.getGenre_name()});
    }
    //What kind of update can we do? What if the user want to update the address and the name? For later...
    public void updateGenre(Integer id, String name) throws ClassNotFoundException, SQLException {
        save("UPDATE tbl_genre SET genre_Name = ? WHERE genre_id = ? ", new Object[] {name, id});
    }
    public void deleteGenre(Integer authorId) throws ClassNotFoundException, SQLException {
        save("DELETE from tbl_genre WHERE genre_id = ? ", new Object[] {authorId});
    }

    //Get all library branches
    public List<Genre> readAllGenres() throws ClassNotFoundException, SQLException{
        return read("SELECT * FROM tbl_genre", new Object[] {});
    }

    // Get a library branch by an id
    public List<Genre> readGenreById(Integer input) throws ClassNotFoundException, SQLException{
        return read("SELECT * FROM tbl_genre where genre_id = ?", new Object [] {input});
    }

    // ALL GET DAOS WILL HAVE THIS METHOD
    public List<Genre> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {

        List<Genre> genres = new ArrayList<>();
	
		while(rs.next()) {
            Genre a = new Genre();
            a.setGenre_id(rs.getInt("genre_id"));
            a.setGenre_name(rs.getString("genre_Name"));
            genres.add(a);
		}
        return genres;
    }
  
}

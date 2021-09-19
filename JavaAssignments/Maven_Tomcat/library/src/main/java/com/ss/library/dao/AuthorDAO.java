package com.ss.library.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.library.models.Author;

public class AuthorDAO extends BaseDAO<Author> {

    public AuthorDAO(Connection conn){
        // super is also used in react to inherit from the parent class :)
        super(conn);
    }

    public void addAuthor(Author author) throws ClassNotFoundException, SQLException {
        save("INSERT INTO tbl_author VALUES(?,?)", new Object[] {author.getAuthorName(), author.getBookAuthors()});
    }
    //What kind of update can we do? What if the user want to update the address and the name? For later...
    public void updateAuthor(Integer id, String name) throws ClassNotFoundException, SQLException {
        save("UPDATE tbl_author SET authorName = ? WHERE authorId = ? ", new Object[] {name, id});
    }
    public void deleteAuthor(Author author) throws ClassNotFoundException, SQLException {
        save("DELETE from tbl_author WHERE authorId = ? ", new Object[] {author.getAuthorId()});
    }

    //READ MY BRANCHID
    //READ BY NAME ETC

    //Get all library branches
    public List<Author> readAllAuthors() throws ClassNotFoundException, SQLException{
        return read("SELECT * FROM tbl_author", new Object[] {});
    }

    // Get a library branch by an id
    public List<Author> readAuthorById(Integer input) throws ClassNotFoundException, SQLException{
        return read("SELECT * FROM tbl_author where authorId = ?", new Object [] {input});
    }

    // ALL GET DAOS WILL HAVE THIS METHOD
    public List<Author> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {


        List<Author> authors = new ArrayList<>();
	
		while(rs.next()) {
            Author a = new Author();
            a.setAuthorName(rs.getString("authorName"));
            // a.setBookAuthors(rs.getString("bookAuthors"));
            authors.add(a);
		}
        return authors;
    }
  
}

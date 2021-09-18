package com.ss.library.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.library.models.Book;

public class BookDAO extends BaseDAO<Book> {

    public BookDAO(Connection conn){
        // super is also used in react to inherit from the parent class :)
        super(conn);
    }

    public void addBook(Book book) throws ClassNotFoundException, SQLException {
        save("INSERT INTO tbl_book VALUES(?,?)", new Object[] {book.getTitle(), book.getBookAuthors()});
    }
    //What kind of update can we do? What if the user want to update the address and the name? For later...
    public void updateBook(Integer id, String name) throws ClassNotFoundException, SQLException {
        save("UPDATE tbl_book SET branchName = ? WHERE branchId = ? ", new Object[] {name, id});
    }
    public void deleteBook(Book book) throws ClassNotFoundException, SQLException {
        save("DELETE from tbl_book WHERE branchId = ? ", new Object[] {book.getBookId()});
    }

    //READ MY BRANCHID
    //READ BY NAME ETC

    //Get all library branches
    public List<Book> readAllBooks() throws ClassNotFoundException, SQLException{
        return read("SELECT * FROM tbl_book", new Object[] {});
    }

    // Get a library branch by an id
    public List<Book> readBookById(Integer input) throws ClassNotFoundException, SQLException{
        return read("SELECT * FROM tbl_book where branchId = ?", new Object [] {input});
    }

    // ALL GET DAOS WILL HAVE THIS METHOD
    public List<Book> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {


        List<Book> books = new ArrayList<>();
	
		while(rs.next()) {
            Book a = new Book();
            a.setBookId(rs.getInt("bookId"));
            a.setTitle(rs.getString("title"));
            books.add(a);
		}
        return books;
    }
  
}

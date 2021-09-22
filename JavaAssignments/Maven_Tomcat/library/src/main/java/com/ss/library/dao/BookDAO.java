package com.ss.library.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.library.models.Book;

public class BookDAO extends BaseDAO<Book> {

    public BookDAO(Connection conn){
        super(conn);
    }

    public void addBook(String bookName) throws ClassNotFoundException, SQLException {
        save("INSERT INTO tbl_book SET title VALUES(?)", new Object[] {bookName});
    }
    
    public void updateBook(Integer id, String name) throws ClassNotFoundException, SQLException {
        save("UPDATE tbl_book SET title = ? WHERE bookId = ? ", new Object[] {name, id});
    }

    public void deleteBook(Integer bookId) throws ClassNotFoundException, SQLException {
        save("DELETE from tbl_book WHERE bookId = ? ", new Object[] {bookId});
    }

    //Get all library branches
    public List<Book> readAllBooks() throws ClassNotFoundException, SQLException{
        return read("SELECT * FROM tbl_book ORDER BY bookId limit 10", new Object[] {});
    }

    // Get a library branch by an id
    public List <Book> readBookById(Integer book) throws ClassNotFoundException, SQLException{
        return read("SELECT * FROM tbl_book where bookId = ?", new Object [] {book});
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

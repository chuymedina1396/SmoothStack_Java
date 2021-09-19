package com.ss.library.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.library.models.Author;
import com.ss.library.models.Book;
import com.ss.library.models.BookAuthors;

public class BookAuthorsDAO extends BaseDAO<BookAuthors> {

    public BookAuthorsDAO(Connection conn){
        // super is also used in react to inherit from the parent class :)
        super(conn);
    }

    public void addBookAuthor(BookAuthors bookAuthor) throws ClassNotFoundException, SQLException {
        save("INSERT INTO tbl_book_authors VALUES(?,?)", new Object[] {bookAuthor.getBookId(), bookAuthor.getAuthorId()});
    }
    
    public void updateBookAuthor(Integer id, String name) throws ClassNotFoundException, SQLException {
        save("UPDATE tbl_book_authors SET authorId = ? WHERE bookId = ? ", new Object[] {id, name});
    }
    public void deleteBook(BookAuthors bookAuthor) throws ClassNotFoundException, SQLException {
        save("DELETE from tbl_book_authors WHERE branchId = ? ", new Object[] {bookAuthor.getBookId()});
    }

    //READ MY BRANCHID
    //READ BY NAME ETC

    //Get all library branches
    public List<BookAuthors> readAllBooksAuthors() throws ClassNotFoundException, SQLException{
        return read("SELECT * FROM tbl_book_authors", new Object[] {});
    }

    // Get a library branch by an id
    public List<BookAuthors> readBookAuthorById(Integer input) throws ClassNotFoundException, SQLException{
        return read("SELECT * FROM tbl_book_authors where bookId = ?", new Object [] {input});
    }

    // ALL GET DAOS WILL HAVE THIS METHOD
    public List<BookAuthors> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {


        List<BookAuthors> bookAuthors = new ArrayList<>();
	
		while(rs.next()) {
            BookAuthors a = new BookAuthors();
            Book b = new Book();
            Author c = new Author();
            a.setBookId(b);
            a.setAuthorId(c);
            bookAuthors.add(a);
		}
        return bookAuthors;
    }
  
}

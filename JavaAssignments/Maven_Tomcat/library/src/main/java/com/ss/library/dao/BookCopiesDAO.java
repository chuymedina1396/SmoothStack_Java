package com.ss.library.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.library.models.Author;
import com.ss.library.models.Book;
import com.ss.library.models.BookAuthors;
import com.ss.library.models.BookCopies;
import com.ss.library.models.LibraryBranch;

public class BookCopiesDAO extends BaseDAO<BookCopies> {

    public BookCopiesDAO(Connection conn){
        // super is also used in react to inherit from the parent class :)
        super(conn);
    }

    public void addBookCopies(BookCopies bookCopies) throws ClassNotFoundException, SQLException {
        save("INSERT INTO tbl_book_copies VALUES(?,?)", new Object[] {bookCopies.getBookId(), bookCopies.getBranchId()});
    }
    
    public void updateBookCopies(Integer id, String name) throws ClassNotFoundException, SQLException {
        save("UPDATE tbl_book_copies SET authorId = ? WHERE bookId = ? ", new Object[] {id, name});
    }
    public void deleteBookCopies(BookCopies bookCopies) throws ClassNotFoundException, SQLException {
        save("DELETE from tbl_book_copies WHERE branchId = ? ", new Object[] {bookCopies.getBranchId()});
    }

    //READ MY BRANCHID
    //READ BY NAME ETC

    //Get all library branches
    public List<BookCopies> readAllBooksAuthors() throws ClassNotFoundException, SQLException{
        return read("SELECT * FROM tbl_book_copies", new Object[] {});
    }

    // Get a library branch by an id
    public List<BookCopies> readBookCopyById(Integer input) throws ClassNotFoundException, SQLException{
        return read("SELECT * FROM tbl_book_copies where bookId = ?", new Object [] {input});
    }

    public List<BookCopies> readBookCopyByBranch(Integer branchId, Integer bookId) throws ClassNotFoundException, SQLException{
        return read("SELECT noOfCopies FROM tbl_book_copies where bookId = ? and branchId=?", new Object [] {bookId, branchId});
    }

    // ALL GET DAOS WILL HAVE THIS METHOD
    public List<BookCopies> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {

        List<BookCopies> bookCopies= new ArrayList<>();
	
		while(rs.next()) {
            BookCopies a = new BookCopies();
            Book b = new Book();
            LibraryBranch c = new LibraryBranch();
            a.setBookId(b);
            a.setBranchId(c);
            bookCopies.add(a);
		}
        return bookCopies;
    }
  
}

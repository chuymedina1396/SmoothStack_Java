package com.ss.library.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.library.models.Author;
import com.ss.library.models.Book;
import com.ss.library.models.BookLoans;
import com.ss.library.models.LibraryBranch;
import com.ss.library.models.Borrower;


public class BookLoansDAO extends BaseDAO<BookLoans> {

    public BookLoansDAO(Connection conn){
        // super is also used in react to inherit from the parent class :)
        super(conn);
    }

    public void addBookLoan(BookLoans bookLoan) throws ClassNotFoundException, SQLException {
        save("INSERT INTO tbl_book_loans VALUES(?,?)", new Object[] {bookLoan.getBookId(), bookLoan.getBranchId(), bookLoan.getCardNo(), bookLoan.getDateIn(), bookLoan.getDateOut(), bookLoan.getDueDate()});
    }
    
    public void updateBookLoan(Integer id, String name) throws ClassNotFoundException, SQLException {
        save("UPDATE tbl_book_loans SET authorId = ? WHERE bookId = ? ", new Object[] {id, name});
    }
    public void deleteBook(BookLoans bookLoan) throws ClassNotFoundException, SQLException {
        save("DELETE from tbl_book_loans WHERE branchId = ? ", new Object[] {bookLoan.getBookId()});
    }

    //READ MY BRANCHID
    //READ BY NAME ETC

    //Get all library branches
    public List<BookLoans> readAllBooksAuthors() throws ClassNotFoundException, SQLException{
        return read("SELECT * FROM tbl_book_loans", new Object[] {});
    }

    // Get a library branch by an id
    public List<BookLoans> readBookLoanById(Integer input) throws ClassNotFoundException, SQLException{
        return read("SELECT * FROM tbl_book_loans where bookId = ?", new Object [] {input});
    }

    // ALL GET DAOS WILL HAVE THIS METHOD
    public List<BookLoans> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {


        List<BookLoans> bookLoans = new ArrayList<>();
	
		while(rs.next()) {
            BookLoans a = new BookLoans();
            Book b = new Book();
            Borrower c = new Borrower();
            LibraryBranch d = new LibraryBranch();
            a.setBookId(b);
            a.setCardNo(c);
            a.setBranchId(d);
            bookLoans.add(a);
		}
        return bookLoans;
    }
  
}

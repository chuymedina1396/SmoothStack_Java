package com.ss.library.service;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;

import java.sql.Connection;
import java.sql.SQLException;

import com.ss.library.dao.BookCopiesDAO;
import com.ss.library.dao.BookDAO;
import com.ss.library.dao.BorrowerDAO;
import com.ss.library.dao.LibraryBranchDAO;

import com.ss.library.models.Borrower;
import com.ss.library.models.LibraryBranch;
import com.ss.library.models.Book;
import com.ss.library.models.BookCopies;


public class BorrowerService {
    
    ConnectionUtil util = new ConnectionUtil();

    final String ANSI_YELLOW = "\u001B[33m";
    final String ANSI_GREEN = "\u001B[32m";
    final String ANSI_RED = "\u001B[31m";
    final String ANSI_PURPLE = "\u001B[35m";
    final String ANSI_BLUE = "\u001B[34m";

    public void borrowerMenu() throws ClassNotFoundException, SQLException{
        System.out.println(ANSI_GREEN + "Welcome! Enter your card number");
        Scanner scan = new Scanner(System.in);
        Integer cardNo = scan.nextInt();
        readBorrowers(cardNo);
    }

    public void readBorrowers(Integer cardNo) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        List<Borrower> borrowers = new ArrayList<Borrower>();
        try {
            conn = util.getConnection();
            BorrowerDAO borrowerDAO = new BorrowerDAO(conn);

            borrowers = borrowerDAO.readBorrowerById(cardNo);

            if(borrowers.isEmpty()){
                System.out.println(ANSI_RED + "Wrong Borrower Card Number! Sorry :( Try again! :)");
                borrowerMenu();
            }

            // How do i filter the list that i get back for a cardNo that does not exist?????
            for (Borrower borrower : borrowers){  // Which you iterate
                System.out.println(ANSI_GREEN + "Welcome, " + ANSI_YELLOW + borrower.getName() + ANSI_GREEN + " :) !" + " What would you like to do?");
            }

            borrowerActions(cardNo);

        }
        catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            if(conn != null){
                conn.close();
            }
        }
    }

    public void borrowerActions(Integer cardNo) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        System.out.println("1) Check out a book");
        System.out.println("2) Return a book");
        System.out.println("3) Quit to Previous");
        Scanner scan = new Scanner(System.in);
        Integer input = scan.nextInt();
        if(input == 1){
            System.out.println("Check a book out logic");
            chooseBranchToCheckOut(cardNo);
        }
        if(input == 2){
            System.out.println("Return a book logic");
        }
        if(input == 3){
            borrowerMenu();
        }
    }

    public void chooseBranchToCheckOut(Integer cardNo) throws ClassNotFoundException, SQLException{
        System.out.println("Pick the Branch you want to check out from:");
        Connection conn = null;
        List<LibraryBranch> branches = new ArrayList<LibraryBranch>();

        try {
            conn = util.getConnection();
            LibraryBranchDAO libraryDAO = new LibraryBranchDAO(conn);

            branches = libraryDAO.readAllLibraryBranches();

            for (LibraryBranch branch : branches){  // Which you iterate 
                System.out.println(branch.getBranchId() + ") " + branch.getBranchName());
            }

            // How can we redirect the user back?
            System.out.println(ANSI_YELLOW + (branches.size() + 1) + ")" + ANSI_YELLOW + " Quit to previous menu");

            
            //Get the branch Id and send it over to our chooseBranchAction method for operations
            System.out.println("Enter ID of branch you want to check out from");
            Scanner scan = new Scanner(System.in);
            Integer input = scan.nextInt();
            if(input == branches.size() + 1){
                borrowerActions(cardNo);
            }
            chooseBookToCheckOut(cardNo, input);
            scan.close();

        }
        catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            conn.rollback();
        } 
        finally {
            if(conn != null){
                conn.close();
            }
        }

    }

    //BASED OFF OF THE BRANCH, ONLY DISPLAY THE BOOKS THAT HAVE AT LEAST ONE COPY
    public void chooseBookToCheckOut(Integer cardNo, Integer branchId) throws ClassNotFoundException, SQLException {

        System.out.println("Pick the Book you want to check out:");
        Connection conn = null;
        List<Book> books = new ArrayList<Book>();
        List<BookCopies> bookCopies = new ArrayList<BookCopies>();

        try {
            conn = util.getConnection();
            BookDAO bookDAO = new BookDAO(conn);
            BookCopiesDAO bookCopiesDAO = new BookCopiesDAO(conn);

            bookCopies = bookCopiesDAO.readBooksByBranch(branchId);

            // I am able to get the number of books the branch carries but the output is weird.
            for (BookCopies bookCopy : bookCopies){  // Which you iterate 
                System.out.println(ANSI_GREEN + bookCopy + ") " + ANSI_PURPLE);
            }
            
            //Send user to previous menu
            System.out.println(ANSI_YELLOW + (bookCopies.size() + 1) + ")" + ANSI_YELLOW + " Quit to previous menu");

            System.out.println("Enter the Book ID of the book you wish to checkout!");

            Scanner scan = new Scanner(System.in);
            Integer bookId = scan.nextInt();

            if(bookId == bookCopies.size() +1){
                chooseBranchToCheckOut(cardNo);
            }
            
            System.out.println("You wish to checkout book with Book Id: " + bookId);
            System.out.println("FROM: " + branchId);
            System.out.println("WITH CARD NUMBER: " + cardNo);

            bookCopies = bookCopiesDAO.readBookCopyByBranch(branchId, bookId);

            if (bookCopies.isEmpty()){
                System.out.println("No Copies");
            }

            for (BookCopies bookCopy : bookCopies){  // Which you iterate 
                System.out.println(ANSI_GREEN + bookCopy.getNoOfCopies() + ") " + ANSI_PURPLE);
            }

            scan.close();

        }
        catch(ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getLocalizedMessage());
            e.printStackTrace();
            conn.rollback();
        } 
        finally {
            if(conn != null){
                conn.close();
            }
        }
    }


}

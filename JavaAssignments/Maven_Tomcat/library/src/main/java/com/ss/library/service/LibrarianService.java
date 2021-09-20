package com.ss.library.service;

import java.sql.Connection;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

import com.ss.library.models.Book;
import com.ss.library.models.BookAuthors;
import com.ss.library.models.BookCopies;
import com.ss.library.models.LibraryBranch;
import com.ss.library.models.Author;

import com.ss.library.dao.AuthorDAO;
import com.ss.library.dao.BookAuthorsDAO;
import com.ss.library.dao.BookCopiesDAO;
import com.ss.library.dao.BookDAO;
import com.ss.library.dao.LibraryBranchDAO;

public class LibrarianService {

    ConnectionUtil util = new ConnectionUtil();
    
    // Colors in the class level scope
    final String ANSI_YELLOW = "\u001B[33m";
    final String ANSI_GREEN = "\u001B[32m";
    final String ANSI_RED = "\u001B[31m";
    final String ANSI_PURPLE = "\u001B[35m";
    final String ANSI_BLUE = "\u001B[34m";
    // First method.
    public void librarianMenu() throws ClassNotFoundException, SQLException{
        //The first thing the user see when they enter the librarianMenu.
        System.out.println(ANSI_YELLOW + "Welcome Librarian! Select your next option!");

        //Then the user get redirected to the enertBranch method where they chose the next option
        enterBranch();
    }
    // Second method
    public void enterBranch() throws ClassNotFoundException, SQLException{
        System.out.println(ANSI_GREEN + "1) Enter branch you manage");
        System.out.println(ANSI_GREEN + "2) Quit to previous");
        Scanner scan = new Scanner(System.in);
        Integer input = scan.nextInt();
        if(input == 1){
            System.out.println("Choose a Library Branch you manage by selecting the number/ID of the branch!");

            readLibraryBranches();
        }
        if(input == 2){
            App.mainMenu();
        }
        scan.close();
    }

    // First Transaction
    public void readLibraryBranches() throws ClassNotFoundException, SQLException {
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

            conn.commit();
            
            //Get the branch Id and send it over to our chooseBranchAction method for operations
            System.out.println("Enter ID of branch");
            Scanner scan = new Scanner(System.in);
            Integer input = scan.nextInt();
            if(input == (branches.size() + 1)){
                enterBranch();
            }
            chooseBranchAction(input);
            scan.close();

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

    public void chooseBranchAction(Integer input) throws ClassNotFoundException, SQLException {
        System.out.println("1) Update the details of the Library");
        System.out.println("2) Add copies of Book to the Branch");
        System.out.println("3) Quit to previous ");
        Scanner scan = new Scanner(System.in);
        Integer option = scan.nextInt();
        if(option == 1){
            updateLibraryBranch(input);
        }
        if(option == 2){
            // may need to use joins
            addCopiesToBranch(input);
        }
        if(option == 3){
            readLibraryBranches();
        }
        scan.close();
    }
    
    // Branch Options for the Selected Library Branch
    public void updateLibraryBranch(Integer id ) throws ClassNotFoundException, SQLException{
        Connection conn = null;
        List<LibraryBranch> branch = new ArrayList<LibraryBranch>();
        try {
            conn = util.getConnection();
            LibraryBranchDAO libraryDAO = new LibraryBranchDAO(conn);
            // This is where we get the branchId of the chosen library branch.
            branch = libraryDAO.readLibraryBranchById(id);

            // Get the String the branch Name from the variable above
            String chosenBranchName = branch.toString();

            //Format the String for better user experience
            String formattedChosenBranch = chosenBranchName.substring(1, chosenBranchName.length() - 1);

            System.out.println(ANSI_YELLOW + "You have chosen to update the Branch with Branch Id: " + id + " and Branch Name: " + formattedChosenBranch);

            System.out.println(ANSI_RED + "Enter 'q' at any prompt to cancel operation.");
            Scanner scan = new Scanner(System.in);
           
            System.out.println(ANSI_GREEN + "Please enter new branch name or enter N/A for no change:");

            String name = scan.nextLine(); 

            if (name.equalsIgnoreCase("q")){
                System.out.println(ANSI_RED + "Operation cancelled. Returning to earlier menu");
                System.out.println(ANSI_GREEN + "Previous operation was cancelled, try again" );
                readLibraryBranches();
            }

            System.out.println(ANSI_GREEN + "Please enter new branch address or enter N/A for no change:");

            String address = scan.nextLine();

            if(address.equalsIgnoreCase("q")){
                System.out.println(ANSI_RED + "Operation cancelled. Returning to earlier menu");
                System.out.println(ANSI_GREEN + "Previous operation was cancelled, try again" );
                readLibraryBranches();
            }
            
            libraryDAO.updateLibraryBranch(id, name, address);

            conn.commit();
            System.out.println("Library Updated Successfully");
            chooseBranchAction(id);
            scan.close();

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

    public void addCopiesToBranch(Integer branchId) throws ClassNotFoundException, SQLException {
        System.out.println("Pick the Book you want to add copies of, to your branch:");
        Connection conn = null;
        List<Book> books = new ArrayList<Book>();
        // List<Author> authors = new ArrayList<Author>();
        // List<BookAuthors> bookAuthors = new ArrayList<BookAuthors>();
        List<BookCopies> bookCopies = new ArrayList<BookCopies>();

        try {
            conn = util.getConnection();
            BookDAO bookDAO = new BookDAO(conn);
            BookAuthorsDAO bookAuthorsDAO = new BookAuthorsDAO(conn);
            AuthorDAO authorDAO = new AuthorDAO(conn);
            BookCopiesDAO bookCopiesDAO = new BookCopiesDAO(conn);

            books = bookDAO.readAllBooks();
            // authors = authorDAO.readAllAuthors();
            // bookAuthors = bookAuthorsDAO.readAllBooksAuthors();

            for (Book book : books){  // Which you iterate 
                System.out.println(ANSI_GREEN + book.getBookId() + ") " + ANSI_PURPLE + book.getTitle() + ANSI_YELLOW + " by " + ANSI_BLUE + book.getBookAuthors());
            }
            // How can we redirect the user back?
            System.out.println(ANSI_YELLOW + (books.size() + 1) + ")" + ANSI_YELLOW + " Quit to previous menu");

            System.out.println("Enter the Book Id to add a copy of that book to the branch.");

            Scanner scan = new Scanner(System.in);
            Integer bookId = scan.nextInt();

            bookCopies = bookCopiesDAO.readBookCopyByBranch(bookId, branchId);

            for (BookCopies copy : bookCopies){  // Which you iterate 
                System.out.println("Existing Number of copies:" + ANSI_GREEN + copy.getNoOfCopies());
            }

            if(bookId == books.size() + 1){
                readLibraryBranches();
            }

            System.out.println("How many copies of book with bookId: " + bookId + " would you like to add to library branch:" + branchId);
           
            Integer copies = scan.nextInt();

            System.out.println("Adding " + copies + " of book with bookId: " + bookId + "to branch with branch Id:" + branchId);

            bookCopiesDAO.addBookCopies(copies, bookId, branchId);

            System.out.println("Copies added to branch!");

            conn.commit();

            scan.close();


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
}

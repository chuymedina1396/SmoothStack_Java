package com.ss.library.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.ss.library.models.Book;
import com.ss.library.models.BookCopies;
import com.ss.library.models.BookLoans;
import com.ss.library.models.LibraryBranch;
import com.ss.library.dao.LibraryBranchDAO;

public class LibrarianService {

    ConnectionUtil util = new ConnectionUtil();
    
    final String ANSI_YELLOW = "\u001B[33m";
    
    public void librarianMenu() throws ClassNotFoundException, SQLException{

        System.out.println(ANSI_YELLOW + "Welcome Librarian! Select your next option!");

        enterBranch();
    }
    public void enterBranch() throws ClassNotFoundException, SQLException{
        final String ANSI_GREEN = "\u001B[32m";
        System.out.println(ANSI_GREEN + "1) Enter branch you manage");
        System.out.println(ANSI_GREEN + "2) Quite to previous");
        Scanner scan = new Scanner(System.in);
        Integer input = scan.nextInt();
        if(input == 1){
            // This is redundant. I want to use my DAO, but how???
            System.out.println("Choose a Library Branch you manage by selecting the a number/id of the branch!");
            readLibraryBranches();
        }
        if(input == 2){
            App.mainMenu();
        }
        scan.close();
    }

    // Transaction
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
            System.out.println(ANSI_YELLOW + (branches.size() + 1) + ")" + ANSI_YELLOW + " Quit to previous menu");
            conn.commit();
            // Take user to branchOption for their specified branch
            getBranchById();

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


    // Get the Library branch by ID method
    public void getBranchById() throws ClassNotFoundException, SQLException{
            Connection conn = null;
            List<LibraryBranch> branch = new ArrayList<LibraryBranch>();
            Scanner scan = new Scanner(System.in);
            Integer input = scan.nextInt();
            try {
                conn = util.getConnection();
                LibraryBranchDAO libraryDAO = new LibraryBranchDAO(conn);
                branch = libraryDAO.readLibraryBranchById(input);
                // How do I access the detail of that branch??
                String chosenBranch = branch.toString();
                System.out.println("You chose the branch with the name" + chosenBranch);

                conn.commit();
                // I'm already passing the number input to my branchOptions method
                branchOptions(input);
            }
            catch(ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                conn.rollback();
            } finally {
                if(conn != null){
                    conn.close();
                }
            }
            scan.close();
    }
    
    // Branch Options for the Selected Library Branch
    public void branchOptions(Integer id ) throws ClassNotFoundException, SQLException{
            Connection conn = null;
            List<LibraryBranch> branch = new ArrayList<LibraryBranch>();
            try {
                conn = util.getConnection();
                LibraryBranchDAO libraryDAO = new LibraryBranchDAO(conn);
                branch = libraryDAO.readLibraryBranchById(id);
                // How do I access the detail of that branch??
                String chosenBranch = branch.toString();
                System.out.println("You chose the branch with the name" + chosenBranch + ". Please choose an option");
                System.out.println("1) Update the details of the Library with the name: " + chosenBranch);
                System.out.println("2) Add copies of Book to the Branch with name: " + chosenBranch);
                System.out.println("3) Quit to previous " + chosenBranch);
                Scanner scan = new Scanner(System.in);
                Integer input = scan.nextInt();
                if(input == 1){
                    System.out.println("Invoking Update Library DAO method");
                }
                if(input == 2){
                    // We will need to contruct our BookCopies DAO and Book DAO I believe!
                    System.out.println("Invoking Add Copies of Book to Library DAO method");
                }
                if(input == 3){
                    readLibraryBranches();
                }
                scan.close();
                conn.commit();
            
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

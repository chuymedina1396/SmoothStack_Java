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
    
    public void getBranchById() throws ClassNotFoundException, SQLException{
            Connection conn = null;
            List<LibraryBranch> branch = new ArrayList<LibraryBranch>();
            Scanner scan = new Scanner(System.in);
            Integer input = scan.nextInt();
            try {
                conn = util.getConnection();
                LibraryBranchDAO libraryDAO = new LibraryBranchDAO(conn);
                branch = libraryDAO.readLibraryBranchById(input);
                // How do I acced the detail of that branch??
                System.out.println(branch);

                conn.commit();

                System.out.println("Then take to menu for updating the branch, adding copies to the branch");
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

    public void branchOptions(Integer id ){
        System.out.println(id);
    }

    // public String addLibraryBranch() throws ClassNotFoundException, SQLException {
    //     Connection conn = null;
    //     try{
    //         conn = util.getConnection();
    //         LibraryBranchDAO libraryDAO = new LibraryBranchDAO(conn);
    //         System.out.println(libraryDAO);

            
    //         // Not sure if these are nessesary for just adding a library branch to the database.
    //         // BookLoans DAO
    //         // BookCopies DAO

    //         conn.commit();
    //         return "Library Branch Added!";

    //     }catch(Exception e){
    //         e.printStackTrace();
    //         conn.rollback();
    //         return "Library Branch could not be added";
    //     }finally{
    //         if(conn!=null){
    //             conn.close();
    //         }
    //     }
    // }




}

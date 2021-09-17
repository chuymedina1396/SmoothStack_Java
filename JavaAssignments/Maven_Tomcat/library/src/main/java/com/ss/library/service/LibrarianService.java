package com.ss.library.service;
import java.sql.Connection;
import java.util.Scanner;

import java.sql.SQLException;

import com.ss.library.models.LibraryBranch;
import com.ss.library.dao.LibraryBranchDAO;

public class LibrarianService {

    ConnectionUtil util = new ConnectionUtil();
    
    public void librarianMenu() throws ClassNotFoundException, SQLException{
        final String ANSI_YELLOW = "\u001B[33m";
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
            readLibraryBranches();
        }
        if(input == 2){
            App.mainMenu();
        }
        scan.close();
    }

    public String addLibraryBranch() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        try{
            conn = util.getConnection();
            LibraryBranchDAO libraryDAO = new LibraryBranchDAO(conn);
            System.out.println(libraryDAO);

            
            // Not sure if these are nessesary for just adding a library branch to the database.
            // BookLoans DAO
            // BookCopies DAO

            conn.commit();
            return "Library Branch Added!";

        }catch(Exception e){
            e.printStackTrace();
            conn.rollback();
            return "Library Branch could not be added";
        }finally{
            if(conn!=null){
                conn.close();
            }
        }
    }

    // Transaction
    public String readLibraryBranches() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        try{
            conn = util.getConnection();
            System.out.println(conn);
            LibraryBranchDAO libraryDAO = new LibraryBranchDAO(conn);
            System.out.println(libraryDAO);

            
            conn.commit();
            return "Got all Library Branches";
        }
        catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            conn.rollback();
            return "Could not retrieve library branches";
        } finally {
            if(conn != null){
                conn.close();
            }
        }
    }

    public void branchOptions() throws ClassNotFoundException, SQLException{
            Scanner scan = new Scanner(System.in);
            Integer input = scan.nextInt();
            if(input == 1){
                System.out.println("1) Update Branch");
                System.out.println("2) Add Copies of Book to Branch");
                System.out.println("3) Quit to previous");
            }
            if(input == 5){
                enterBranch();
            }
            scan.close();
    }

}

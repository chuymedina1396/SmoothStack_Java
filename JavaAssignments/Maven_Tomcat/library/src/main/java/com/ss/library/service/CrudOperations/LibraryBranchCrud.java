package com.ss.library.service.CrudOperations;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Models
import com.ss.library.models.LibraryBranch;
import com.ss.library.service.ConnectionUtil;
// DAOs
import com.ss.library.dao.LibraryBranchDAO;

public class LibraryBranchCrud {

    public static ConnectionUtil util = new ConnectionUtil();

    static final String ANSI_YELLOW = "\u001B[33m";
    static final String ANSI_GREEN = "\u001B[32m";
    static final String ANSI_RED = "\u001B[31m";
    static final String ANSI_PURPLE = "\u001B[35m";
    static final String ANSI_BLUE = "\u001B[34m";

    public static void addLibraryBranch() throws ClassNotFoundException, SQLException{
        Connection conn = null;
        try {
            conn = util.getConnection();
            LibraryBranchDAO libraryDAO = new LibraryBranchDAO(conn);
            LibraryBranch libraryBranch = new LibraryBranch();

            Scanner scan = new Scanner(System.in);

            System.out.println("Enter a new library branch id");
            Integer libraryBranchId = scan.nextInt();

            System.out.println("Enter a new Library Branch Name");
            String libraryBranchName = scan.nextLine();

            System.out.println("Enter a new Library Branch Name");
            String libraryBranchAddress = scan.nextLine();
            
            // Why did this not work? smh
            libraryBranch.setBranchId(libraryBranchId);
            libraryBranch.setBranchName(libraryBranchName);
            libraryBranch.setBranchName(libraryBranchAddress);
            
            libraryDAO.addLibraryBranch(libraryBranch);
            scan.close();
            conn.commit();
            System.out.print("LibraryBranch added successfully");
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
    public static void updateLibraryBranch() throws ClassNotFoundException, SQLException{
        Connection conn = null;
        List<LibraryBranch> branches = new ArrayList<LibraryBranch>();

        try {
            conn = util.getConnection();
            LibraryBranchDAO libraryBranchDAO = new LibraryBranchDAO(conn);

            branches = libraryBranchDAO.readAllLibraryBranches();

            for (LibraryBranch branch : branches){  // Which you iterate 
                System.out.println(ANSI_GREEN + branch.getBranchId() + ") " + "Name: " + branch.getBranchName() + " Address: " + branch.getBranchAddress());
            }

            System.out.println("Enter the Library branch Id that you would like the update");

            Scanner scan = new Scanner(System.in);
            Integer libraryBranch = scan.nextInt();

            scan.nextLine();
            
            System.out.println("What would you like the new Library branch name to be?");
            String newName = scan.nextLine();

            System.out.println("What would you like the new Library Address to be?");
            String newAddress = scan.nextLine();

            libraryBranchDAO.updateLibraryBranch(libraryBranch, newName, newAddress);

            conn.commit();

            System.out.println("Library Branch Updated Successfully");
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
    public static void deleteLibraryBranch() throws ClassNotFoundException, SQLException{
        Connection conn = null;
        List<LibraryBranch> libraryBranches = new ArrayList<LibraryBranch>();

        try {
            conn = util.getConnection();
            LibraryBranchDAO libraryBranchDAO = new LibraryBranchDAO(conn);

            libraryBranches = libraryBranchDAO.readAllLibraryBranches();

            for (LibraryBranch libraryBranch : libraryBranches){  // Which you iterate 
                System.out.println(ANSI_GREEN + libraryBranch.getBranchId() + ") " + libraryBranch.getBranchName() + ") " + ANSI_PURPLE + libraryBranch.getBranchAddress());
            }

            System.out.println("Enter the LibraryBranch Id that you would like the" + ANSI_RED + "DELETE");

            Scanner scan = new Scanner(System.in);
            Integer libraryBranchId = scan.nextInt();

            libraryBranchDAO.deleteLibraryBranch(libraryBranchId);

            conn.commit();

            System.out.println(ANSI_RED + "LibraryBranch Deleted Successfully");
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
    public static void readLibraryBranch() throws ClassNotFoundException, SQLException{
        Connection conn = null;
        List<LibraryBranch> libraryBranches = new ArrayList<LibraryBranch>();

        try {
            conn = util.getConnection();
            LibraryBranchDAO libraryBranchDAO = new LibraryBranchDAO(conn);
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the LibraryBranch ID you would like to retrieve from the database");
            Integer libraryBranchId = scan.nextInt();

            libraryBranches = libraryBranchDAO.readLibraryBranchById(libraryBranchId);

            for(LibraryBranch branch: libraryBranches){
                System.out.println(branch.getBranchName());
            }

            conn.commit();

            System.out.println(ANSI_GREEN + "Read LibraryBranch Successfully");
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

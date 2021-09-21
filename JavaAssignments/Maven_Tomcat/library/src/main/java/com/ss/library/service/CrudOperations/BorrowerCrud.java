package com.ss.library.service.CrudOperations;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Models
import com.ss.library.models.Borrower;
import com.ss.library.service.AdminService;
import com.ss.library.service.ConnectionUtil;
import com.ss.library.dao.BorrowerDAO;
// DAOs
import com.ss.library.dao.BookDAO;

public class BorrowerCrud {

    public static ConnectionUtil util = new ConnectionUtil();

    static final String ANSI_YELLOW = "\u001B[33m";
    static final String ANSI_GREEN = "\u001B[32m";
    static final String ANSI_RED = "\u001B[31m";
    static final String ANSI_PURPLE = "\u001B[35m";
    static final String ANSI_BLUE = "\u001B[34m";

    public static void addBorrower() throws ClassNotFoundException, SQLException{
        Connection conn = null;
        try {
            conn = util.getConnection();
            BorrowerDAO BorrowerDAO = new BorrowerDAO(conn);
            Borrower borrower = new Borrower();

            Scanner scan = new Scanner(System.in);

            System.out.println("Enter a Borrower CardNo");
            Integer borrowerId = scan.nextInt();
            
            scan.nextLine();

            System.out.println("Enter Borrower Name");
            String borrowerName = scan.nextLine();

            System.out.println("Enter Borrower Address");
            String borrowerAddress = scan.nextLine();

            System.out.println("Enter Borrower Phone");
            String borrowerPhone = scan.nextLine();

            // Why did this not work? smh
            // Borrower.setBorrowerId(borrowerId);
            // borrower.setName(borrowerName);
            // BorrowerDAO.addBorrower(borrower);
            
            BorrowerDAO.addBorrower(borrowerId, borrowerName, borrowerAddress, borrowerPhone);
            conn.commit();
            scan.close();
            System.out.print("borrower added successfully");
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
    public static void updateBorrower() throws ClassNotFoundException, SQLException{
        Connection conn = null;
        List<Borrower> borrowers= new ArrayList<Borrower>();

        try {
            conn = util.getConnection();
            BorrowerDAO BorrowerDAO = new BorrowerDAO(conn);

            borrowers = BorrowerDAO.readAllBorrowers();

            for (Borrower borrower : borrowers){  // Which you iterate 
                System.out.println(ANSI_GREEN + borrower.getCardNo() + ") " + ANSI_PURPLE + borrower.getName() + ANSI_YELLOW + " by " + ANSI_BLUE + borrower.getAddress() + borrower.getPhone());
            }

            System.out.println("Enter the Borrower Card Number that you would like the update");

            Scanner scan = new Scanner(System.in);
            Integer borrowerId = scan.nextInt();

            scan.nextLine();
            
            System.out.println("What would you like the new Borrower name to be?");
            String newName = scan.nextLine();
            BorrowerDAO.updateBorrower(borrowerId, newName);

            conn.commit();

            System.out.println("Borrower Updated Successfully");
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
    public static void deleteBorrower() throws ClassNotFoundException, SQLException{
        Connection conn = null;
        List<Borrower> borrowers = new ArrayList<Borrower>();

        try {
            conn = util.getConnection();
            BorrowerDAO BorrowerDAO = new BorrowerDAO(conn);

            borrowers  = BorrowerDAO.readAllBorrowers();

            for (Borrower borrower : borrowers ){  // Which you iterate 
                System.out.println(ANSI_GREEN + borrower.getCardNo() + ") " + ANSI_PURPLE + borrower.getName() + borrower.getAddress() + borrower.getPhone());
            }

            System.out.println("Enter the Borrower Id that you would like the" + ANSI_RED + "DELETE");

            Scanner scan = new Scanner(System.in);
            Integer borrowerId = scan.nextInt();

            BorrowerDAO.deleteBorrower(borrowerId);

            conn.commit();

            System.out.println(ANSI_RED + "Borrower Deleted Successfully");
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
    public static void readBorrower() throws ClassNotFoundException, SQLException{
        Connection conn = null;
        List<Borrower> borrowers = new ArrayList<Borrower>();

        try {
            conn = util.getConnection();
            BorrowerDAO BorrowerDAO = new BorrowerDAO(conn);
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the Borrower ID you would like to retrieve from the database");
            Integer borrowerId = scan.nextInt();

            borrowers = BorrowerDAO.readBorrowerById(borrowerId);
            
            for(Borrower borrower: borrowers){
                System.out.println("CardNo: " + borrower.getCardNo() + " Name: " + borrower.getName() + " Address " + borrower.getAddress() + " Phone " + borrower.getPhone() );
            }

            System.out.println(ANSI_GREEN + "Read Borrower Successfully");
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

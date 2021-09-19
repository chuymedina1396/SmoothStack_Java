package com.ss.library.service;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

import java.sql.Connection;
import java.sql.SQLException;

import com.ss.library.dao.BorrowerDAO;
import com.ss.library.models.Borrower;

public class BorrowerService {
    ConnectionUtil util = new ConnectionUtil();
    final String ANSI_YELLOW = "\u001B[33m";
    final String ANSI_GREEN = "\u001B[32m";
    final String ANSI_RED = "\u001B[31m";
    final String ANSI_PURPLE = "\u001B[35m";
    final String ANSI_BLUE = "\u001B[34m";

    public void borrowerMenu() throws ClassNotFoundException, SQLException{
        System.out.println("Welcome! Enter your card number");
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

            borrowers = borrowerDAO.readAllBorrowers();

            // How do i filter the list that i get back for a cardNo that does not exist?????
            for (Borrower borrower : borrowers){  // Which you iterate
                System.out.println(borrower.getCardNo() + ") " + borrower.getName() + borrower.getAddress() + borrower.getPhone());
            }

            // How can we redirect the user back?
            System.out.println(ANSI_YELLOW + (borrowers.size() + 1) + ")" + ANSI_YELLOW + " Quit to previous menu");

            conn.commit();
            
            // //Get the branch Id and send it over to our chooseBranchAction method for operations
            // System.out.println("Enter ID of branch");
            // Scanner scan = new Scanner(System.in);
            // Integer input = scan.nextInt();
            // chooseBranchAction(input);
            // scan.close();

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

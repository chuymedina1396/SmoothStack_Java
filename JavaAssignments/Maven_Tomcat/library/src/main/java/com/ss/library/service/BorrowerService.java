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
    public void borrowerMenu() throws ClassNotFoundException, SQLException{
        System.out.println("Welcome! Enter your card number");
        Scanner scan = new Scanner(System.in);
        Integer cardNo = scan.nextInt();
        System.out.println(cardNo);

        findBorrowerInDb(cardNo);
    }
    public void findBorrowerInDb(Integer cardNo) throws ClassNotFoundException, SQLException{
        Connection conn = null;
        List<Borrower> borrower = new ArrayList<Borrower>();
        try {
            conn = util.getConnection();
            BorrowerDAO borrowerDAO = new BorrowerDAO(conn);
            borrower = borrowerDAO.readBorrowerById(cardNo);
            borrower = borrowerDAO.extractData(borrower);
            System.out.print(borrower);
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

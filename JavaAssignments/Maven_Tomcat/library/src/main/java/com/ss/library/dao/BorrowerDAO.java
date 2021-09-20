package com.ss.library.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.library.models.Borrower;

public class BorrowerDAO extends BaseDAO<Borrower> {

    public BorrowerDAO(Connection conn){
        super(conn);
    }

    public void addBorrower(Integer cardNo, String name, String address, String phone) throws ClassNotFoundException, SQLException {
        save("INSERT INTO tbl_borrower (VALUES(?,?,?,?))", new Object[] {cardNo, name, address, phone});
    }
    //What kind of update can we do? What if the user want to update the address and the name? For later...
    public void updateBorrower(Integer cardNo, String name) throws ClassNotFoundException, SQLException {
        save("UPDATE tbl_borrower SET name = ? WHERE cardNo = ? ", new Object[] {name, cardNo});
    }
    public void deleteBorrower(Integer borrower) throws ClassNotFoundException, SQLException {
        save("DELETE from tbl_borrower WHERE authorId = ? ", new Object[] {borrower});
    }

    // Get a library branch by an id
    public List<Borrower> readBorrowerById(Integer input) throws ClassNotFoundException, SQLException{
        return read("SELECT * FROM tbl_borrower where cardNo = ?", new Object [] {input});
    }
    //Get all library branches
    public List<Borrower> readAllBorrowers() throws ClassNotFoundException, SQLException{
        return read("SELECT * FROM tbl_borrower", new Object[] {});
    }

    // ALL GET DAOS WILL HAVE THIS METHOD
    public List<Borrower> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
        List<Borrower> borrowers = new ArrayList<>();
	
		while(rs.next()) {
            Borrower a = new Borrower();
            a.setCardNo(rs.getInt("cardNo"));
            a.setName(rs.getString("name"));
            a.setAddress(rs.getString("address"));
            a.setPhone(rs.getString("phone"));

            borrowers.add(a);
		}
        return borrowers;
    }
  
}

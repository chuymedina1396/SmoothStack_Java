package com.ss.library.dao;

// Bring in sql packages
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ss.library.models.LibraryBranch;

public class LibraryBranchDAO extends BaseDAO<LibraryBranch> {

    public LibraryBranchDAO(Connection conn){
        // super is also used in react to inherit from the parent class :)
        super(conn);
    }

    public void addLibraryBranch(LibraryBranch libraryBranch) throws ClassNotFoundException, SQLException {
        save("INSERT INTO tbl_library_branch VALUES(?,?)", new Object[] {libraryBranch.getBranchName(), libraryBranch.getBranchAddress() });
    }

    //What kind of update can we do? What if the user want to update the address and the name? For later...
    public void updateLibraryBranch(Integer id, String name, String address) throws ClassNotFoundException, SQLException {
        save("UPDATE tbl_library_branch SET branchName = ?, branchAddress = ? WHERE branchId = ? ", new Object[] {name, address, id});
    }
    public void deleteLibraryBranch(LibraryBranch libraryBranch) throws ClassNotFoundException, SQLException {
        save("DELETE from tbl_library_branch WHERE branchId = ? ", new Object[] {libraryBranch.getBranchId()});
    }

    //READ MY BRANCHID
    //READ BY NAME ETC

    //Get all library branches
    public List<LibraryBranch> readAllLibraryBranches() throws ClassNotFoundException, SQLException{
        return read("SELECT * FROM tbl_library_branch", new Object[] {});
    }

    // Get a library branch by an id
    public List<LibraryBranch> readLibraryBranchById(Integer input) throws ClassNotFoundException, SQLException{
        return read("SELECT * FROM tbl_library_branch where branchId = ?", new Object [] {input});
    }

    // ALL GET DAOS WILL HAVE THIS METHOD
    public List<LibraryBranch> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
        List<LibraryBranch> libraryBranches = new ArrayList<>();
	
		while(rs.next()) {
            LibraryBranch a = new LibraryBranch();
            a.setBranchId(rs.getInt("branchId"));
            a.setBranchName(rs.getString("branchName"));
            a.setBranchAddress(rs.getString("branchAddress"));
            libraryBranches.add(a);
		}
        return libraryBranches;
    }

}

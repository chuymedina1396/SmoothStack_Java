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
    public void updateLibraryBranch(LibraryBranch libraryBranch) throws ClassNotFoundException, SQLException {
        save("UPDATE tbl_library_branch SET branchName = ? WHERE branchId = ? ", new Object[] {libraryBranch.getBranchName(), libraryBranch.getBranchId()});
    }
    public void deleteLibraryBranch(LibraryBranch libraryBranch) throws ClassNotFoundException, SQLException {
        save("DELETE from tbl_library_branch WHERE branchId = ? ", new Object[] {libraryBranch.getBranchId()});
    }

    //READ MY BRANCHID
    //READ BY NAME ETC

    //Get all library branches
    public List<LibraryBranch> readAllLibraryBranches() throws ClassNotFoundException, SQLException{
        return read("SELECT * FROM tbl_library_branch");
    }

    // Get a library branch by an id
    public List<LibraryBranch> readLibraryBranchById() throws ClassNotFoundException, SQLException{
        return read("SELECT * FROM tbl_library_branch where branchId = ?");
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
			// System.out.println("Branch Id: "+rs.getInt("branchId"));
			// System.out.println("Branch Name:"+rs.getString("branchName"));
			// System.out.println("Branch Address:"+rs.getString("branchAddress"));
		}
        // For getting a specific branch number, but we're just reading all for now.
		// PreparedStatement pstmt = getConnection().prepareStatement("SELECT * FROM tbl_library_branch WHERE branchId = ?");
        // pstmt.setInt(1, libraryBranch.getBranchId());
        return libraryBranches;
    }




    
}

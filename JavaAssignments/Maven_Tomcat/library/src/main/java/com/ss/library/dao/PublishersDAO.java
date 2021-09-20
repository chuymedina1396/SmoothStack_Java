package com.ss.library.dao;

// Bring in sql packages
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ss.library.models.Publisher;

public class PublishersDAO extends BaseDAO<Publisher> {

    public PublishersDAO(Connection conn){
        // super is also used in react to inherit from the parent class :)
        super(conn);
    }

    public void addPublisher(Publisher publisher) throws ClassNotFoundException, SQLException {
        save("INSERT INTO tbl_publisher VALUES(?,?)", new Object[] {publisher.getPublisherId(), publisher.getPublisherName(), publisher.getPublisherAddress(), publisher.getPublisherPhone() });
    }

    //What kind of update can we do? What if the user want to update the address and the name? For later...
    public void updatePublisher(Integer id, String name, String address) throws ClassNotFoundException, SQLException {
        save("UPDATE tbl_publisher SET publisherName = ?, publisherAddress = ? WHERE publisherId = ? ", new Object[] {name, address, id});
    }
    public void deletePublisher(Integer publisherId) throws ClassNotFoundException, SQLException {
        save("DELETE from tbl_publisher WHERE publisherId = ? ", new Object[] {publisherId});
    }

    //READ MY BRANCHID
    //READ BY NAME ETC

    //Get all library branches
    public List<Publisher> readAllPublisher() throws ClassNotFoundException, SQLException{
        return read("SELECT * FROM tbl_publisher", new Object[] {});
    }

    // Get a library branch by an id
    public List<Publisher> readPublisherById(Integer input) throws ClassNotFoundException, SQLException{
        return read("SELECT * FROM tbl_publisher where publisherId = ?", new Object [] {input});
    }

    // ALL GET DAOS WILL HAVE THIS METHOD
    public List<Publisher> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
        List<Publisher> publisher = new ArrayList<>();
	
		while(rs.next()) {
            Publisher a = new Publisher();
            a.setPublisherId(rs.getInt("publisherID"));
            a.setPublisherName(rs.getString("publisherName"));
            a.setPublisherAddress(rs.getString("publisherAddress"));
            publisher.add(a);
		}
        return publisher;
    }

}

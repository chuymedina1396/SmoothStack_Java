package com.ss.library.service.CrudOperations;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Models
import com.ss.library.models.Publisher;
import com.ss.library.service.ConnectionUtil;
// DAOs
import com.ss.library.dao.PublishersDAO;

public class PublisherCrud {

    public static ConnectionUtil util = new ConnectionUtil();

    static final String ANSI_YELLOW = "\u001B[33m";
    static final String ANSI_GREEN = "\u001B[32m";
    static final String ANSI_RED = "\u001B[31m";
    static final String ANSI_PURPLE = "\u001B[35m";
    static final String ANSI_BLUE = "\u001B[34m";

    public static void addPublisher() throws ClassNotFoundException, SQLException{
        Connection conn = null;
        try {
            conn = util.getConnection();
            PublishersDAO publisherDAO = new PublishersDAO(conn);
            Publisher publisher = new Publisher();

            Scanner scan = new Scanner(System.in);

            System.out.println("Enter a new library publisher id");
            Integer publisherId = scan.nextInt();

            System.out.println("Enter a new Publisher Branch Name");
            String publisherName = scan.nextLine();

            System.out.println("Enter a new Publisher Branch Name");
            String publisherAddress = scan.nextLine();
            
            // Why did this not work? smh
            publisher.setPublisherId(publisherId);
            publisher.setPublisherName(publisherName);
            publisher.setPublisherAddress(publisherAddress);
            
            publisherDAO.addPublisher(publisher);
            scan.close();
            conn.commit();
            System.out.print("Publisher added successfully");
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
    public static void updatePublisher() throws ClassNotFoundException, SQLException{
        Connection conn = null;
        List<Publisher> publishers = new ArrayList<Publisher>();

        try {
            conn = util.getConnection();
            PublishersDAO publisherDAO = new PublishersDAO(conn);

            publishers = publisherDAO.readAllPublisher();

            for (Publisher publisher : publishers){  // Which you iterate 
                System.out.println(ANSI_GREEN + publisher.getPublisherId() + ") " + "Name: " + publisher.getPublisherName() + " Address: " + publisher.getPublisherAddress() + publisher.getPublisherPhone());
            }

            System.out.println("Enter the Publisher Id that you would like the update");

            Scanner scan = new Scanner(System.in);
            Integer publisher = scan.nextInt();

            scan.nextLine();
            
            System.out.println("What would you like the new publisher name to be?");
            String newName = scan.nextLine();

            System.out.println("What would you like the new Publisher Address to be?");
            String newAddress = scan.nextLine();

            publisherDAO.updatePublisher(publisher, newName, newAddress);

            conn.commit();

            System.out.println("Publisher Updated Successfully");
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
    public static void deletePublisher() throws ClassNotFoundException, SQLException{
        Connection conn = null;
        List<Publisher> publishers = new ArrayList<Publisher>();

        try {
            conn = util.getConnection();
            PublishersDAO publisherDAO = new PublishersDAO(conn);

            publishers = publisherDAO.readAllPublisher();

            for (Publisher publisher : publishers){  // Which you iterate 
                System.out.println(ANSI_GREEN + publisher.getPublisherId() + ") " + "Name: " + publisher.getPublisherName() + " Address: " + publisher.getPublisherAddress() + publisher.getPublisherPhone());
            }

            System.out.println("Enter the Publisher Id that you would like the" + ANSI_RED + "DELETE");

            Scanner scan = new Scanner(System.in);
            Integer publisherId = scan.nextInt();

            publisherDAO.deletePublisher(publisherId);

            conn.commit();

            System.out.println(ANSI_RED + "Publisher Deleted Successfully");
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
    public static void readPublisher() throws ClassNotFoundException, SQLException{
        Connection conn = null;
        List<Publisher> publishers = new ArrayList<Publisher>();

        try {
            conn = util.getConnection();
            PublishersDAO publisherDAO = new PublishersDAO(conn);
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the Publisher ID you would like to retrieve from the database");
            Integer publisherId = scan.nextInt();

            publishers = publisherDAO.readPublisherById(publisherId);

            for (Publisher publisher : publishers){  // Which you iterate 
                System.out.println(ANSI_GREEN + publisher.getPublisherId() + ") " + "Name: " + publisher.getPublisherName() + " Address: " + publisher.getPublisherAddress() + publisher.getPublisherPhone());
            }

            conn.commit();

            System.out.println(ANSI_GREEN + "Read Publisher Successfully");
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

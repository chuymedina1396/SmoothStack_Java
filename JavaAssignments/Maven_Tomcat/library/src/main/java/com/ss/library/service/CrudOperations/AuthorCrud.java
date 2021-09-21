package com.ss.library.service.CrudOperations;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Models
import com.ss.library.models.Author;
import com.ss.library.service.ConnectionUtil;
import com.ss.library.dao.AuthorDAO;
// DAOs
import com.ss.library.dao.BookDAO;

public class AuthorCrud {

    public static ConnectionUtil util = new ConnectionUtil();

    static final String ANSI_YELLOW = "\u001B[33m";
    static final String ANSI_GREEN = "\u001B[32m";
    static final String ANSI_RED = "\u001B[31m";
    static final String ANSI_PURPLE = "\u001B[35m";
    static final String ANSI_BLUE = "\u001B[34m";

    public static void addAuthor() throws ClassNotFoundException, SQLException{
        Connection conn = null;
        try {
            conn = util.getConnection();
            AuthorDAO authorDAO = new AuthorDAO(conn);
            Author author = new Author();

            Scanner scan = new Scanner(System.in);

            // System.out.println("Enter a Author ID");
            // Integer authorId = scan.nextInt();
            
            // scan.nextLine();

            System.out.println("Enter Author Name");
            String authorName = scan.nextLine();

            // Why did this not work? smh
            // author.setAuthorId(authorId);
            author.setAuthorName(authorName);
            
            authorDAO.addAuthor(author);
            conn.commit();
            scan.close();
            System.out.print("author added successfully");
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
    public static void updateAuthor() throws ClassNotFoundException, SQLException{
        Connection conn = null;
        List<Author> authors = new ArrayList<Author>();

        try {
            conn = util.getConnection();
            AuthorDAO authorDAO = new AuthorDAO(conn);

            authors = authorDAO.readAllAuthors();

            for (Author author : authors){  // Which you iterate 
                System.out.println(ANSI_GREEN + author.getAuthorId() + ") " + ANSI_PURPLE + author.getAuthorId() + ANSI_YELLOW + " by " + ANSI_BLUE + author.getAuthorName());
            }

            System.out.println("Enter the Author Id that you would like the update");

            Scanner scan = new Scanner(System.in);
            Integer authorId = scan.nextInt();

            scan.nextLine();
            
            System.out.println("What would you like the new Author name to be?");
            String newName = scan.nextLine();
            authorDAO.updateAuthor(authorId, newName);
            conn.commit();

            System.out.println("Author Updated Successfully");
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
    public static void deleteAuthor() throws ClassNotFoundException, SQLException{
        Connection conn = null;
        List<Author> authors = new ArrayList<Author>();

        try {
            conn = util.getConnection();
            AuthorDAO authorDAO = new AuthorDAO(conn);

            authors = authorDAO.readAllAuthors();

            for (Author author : authors){  // Which you iterate 
                System.out.println(ANSI_GREEN + author.getAuthorId() + ") " + ANSI_PURPLE + author.getAuthorName());
            }

            System.out.println("Enter the Author Id that you would like the" + ANSI_RED + "DELETE");

            Scanner scan = new Scanner(System.in);
            Integer authorId = scan.nextInt();

            authorDAO.deleteAuthor(authorId);

            conn.commit();

            System.out.println(ANSI_RED + "Author Deleted Successfully");
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
    public static void readAuthor() throws ClassNotFoundException, SQLException{
        Connection conn = null;
        List<Author> authors = new ArrayList<Author>();

        try {
            conn = util.getConnection();
            AuthorDAO authorDAO = new AuthorDAO(conn);
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the Author ID you would like to retrieve from the database");
            Integer authorId = scan.nextInt();

            authors = authorDAO.readAuthorById(authorId);
            
            for(Author author: authors){
                System.out.println(author.getAuthorName());
            }

            System.out.println(ANSI_GREEN + "Read Author Successfully");
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

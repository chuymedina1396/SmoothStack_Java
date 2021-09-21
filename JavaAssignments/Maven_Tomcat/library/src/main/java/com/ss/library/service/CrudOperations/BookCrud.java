package com.ss.library.service.CrudOperations;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Models
import com.ss.library.models.Book;
import com.ss.library.service.ConnectionUtil;
// DAOs
import com.ss.library.dao.BookDAO;

public class BookCrud {

    public static ConnectionUtil util = new ConnectionUtil();

    static final String ANSI_YELLOW = "\u001B[33m";
    static final String ANSI_GREEN = "\u001B[32m";
    static final String ANSI_RED = "\u001B[31m";
    static final String ANSI_PURPLE = "\u001B[35m";
    static final String ANSI_BLUE = "\u001B[34m";

    public static void addBook() throws ClassNotFoundException, SQLException{
        Connection conn = null;
        try {
            conn = util.getConnection();
            BookDAO bookDAO = new BookDAO(conn);
            // Book book = new Book();

            Scanner scan = new Scanner(System.in);

            // System.out.println("Enter a Book ID that is over 1000");
            // Integer bookId = scan.nextInt();
            
            // scan.nextLine();

            System.out.println("Enter Book Title");
            String bookTitle = scan.nextLine();

            // Why did this not work? smh
            // book.setBookId(bookId);
            // book.setTitle(bookTitle);
            
            bookDAO.addBook(bookTitle);
            conn.commit();
            scan.close();
            System.out.print("Book added successfully");
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
    public static void updateBook() throws ClassNotFoundException, SQLException{
        Connection conn = null;
        List<Book> books = new ArrayList<Book>();

        try {
            conn = util.getConnection();
            BookDAO bookDAO = new BookDAO(conn);

            books = bookDAO.readAllBooks();

            for (Book book : books){  // Which you iterate 
                System.out.println(ANSI_GREEN + book.getBookId() + ") " + ANSI_PURPLE + book.getTitle() + ANSI_YELLOW + " by " + ANSI_BLUE + book.getBookAuthors());
            }

            System.out.println("Enter the Book Id that you would like the update");

            Scanner scan = new Scanner(System.in);
            Integer bookId = scan.nextInt();

            scan.nextLine();
            
            System.out.println("What would you like the new title to be?");
            String newName = scan.nextLine();
            bookDAO.updateBook(bookId, newName);

            conn.commit();

            System.out.println("Book Updated Successfully");
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
    public static void deleteBook() throws ClassNotFoundException, SQLException{
        Connection conn = null;
        List<Book> books = new ArrayList<Book>();

        try {
            conn = util.getConnection();
            BookDAO bookDAO = new BookDAO(conn);

            books = bookDAO.readAllBooks();

            for (Book book : books){  // Which you iterate 
                System.out.println(ANSI_GREEN + book.getBookId() + ") " + ANSI_PURPLE + book.getTitle() + ANSI_YELLOW + " by " + ANSI_BLUE + book.getBookAuthors());
            }

            System.out.println("Enter the Book Id that you would like the" + ANSI_RED + "DELETE");

            Scanner scan = new Scanner(System.in);
            Integer bookId = scan.nextInt();

            bookDAO.deleteBook(bookId);

            conn.commit();

            System.out.println(ANSI_RED + "Book Delete Successfully");
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
    public static void readBook() throws ClassNotFoundException, SQLException{
        Connection conn = null;
        List<Book> books = new ArrayList<Book>();

        try {
            conn = util.getConnection();
            BookDAO bookDAO = new BookDAO(conn);
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the book id you would like to retrieve from the database");
            Integer bookId = scan.nextInt();

            books = bookDAO.readBookById(bookId);
            for(Book book: books){
                System.out.println(book);
            }

            System.out.println(ANSI_GREEN + "Read Book Successfully");
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

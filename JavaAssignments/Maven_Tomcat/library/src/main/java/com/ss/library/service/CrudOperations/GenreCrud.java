package com.ss.library.service.CrudOperations;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Models
import com.ss.library.models.Genre;
import com.ss.library.service.ConnectionUtil;
// DAOs
import com.ss.library.dao.GenreDAO;

public class GenreCrud {

    public static ConnectionUtil util = new ConnectionUtil();

    static final String ANSI_YELLOW = "\u001B[33m";
    static final String ANSI_GREEN = "\u001B[32m";
    static final String ANSI_RED = "\u001B[31m";
    static final String ANSI_PURPLE = "\u001B[35m";
    static final String ANSI_BLUE = "\u001B[34m";

    public static void addGenre() throws ClassNotFoundException, SQLException{
        Connection conn = null;
        try {
            conn = util.getConnection();
            GenreDAO genreDAO = new GenreDAO(conn);
            Genre genre = new Genre();

            Scanner scan = new Scanner(System.in);

            System.out.println("Enter a new Genre ID");
            Integer genreId = scan.nextInt();

            System.out.println("Enter a new Genre");
            String genreName = scan.nextLine();
            
            scan.nextLine();

            // Why did this not work? smh
            genre.setGenre_id(genreId);
            genre.setGenre_name(genreName);
            
            genreDAO.addGenre(genre);
            conn.commit();
            scan.close();
            System.out.print("Genre added successfully");
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
    public static void updateGenre() throws ClassNotFoundException, SQLException{
        Connection conn = null;
        List<Genre> generes = new ArrayList<Genre>();

        try {
            conn = util.getConnection();
            GenreDAO genreDAO = new GenreDAO(conn);

            generes = genreDAO.readAllGenres();

            for (Genre genre : generes){  // Which you iterate 
                System.out.println(ANSI_GREEN + genre.getGenre_id() + ") " + genre.getGenre_name());
            }

            System.out.println("Enter the Genre Id that you would like the update");

            Scanner scan = new Scanner(System.in);
            Integer genreId = scan.nextInt();

            scan.nextLine();
            
            System.out.println("What would you like the new Genre name to be?");
            String newName = scan.nextLine();

            genreDAO.updateGenre(genreId, newName);

            conn.commit();

            System.out.println("Genre Updated Successfully");
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
    public static void deleteGenre() throws ClassNotFoundException, SQLException{
        Connection conn = null;
        List<Genre> generes = new ArrayList<Genre>();

        try {
            conn = util.getConnection();
            GenreDAO genreDAO = new GenreDAO(conn);

            generes = genreDAO.readAllGenres();

            for (Genre genere : generes){  // Which you iterate 
                System.out.println(ANSI_GREEN + genere.getGenre_id() + ") " + ANSI_PURPLE + genere.getGenre_name());
            }

            System.out.println("Enter the Genre Id that you would like the" + ANSI_RED + "DELETE");

            Scanner scan = new Scanner(System.in);
            Integer genreId = scan.nextInt();

            genreDAO.deleteGenre(genreId);

            conn.commit();

            System.out.println(ANSI_RED + "Genre Deleted Successfully");
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
    public static void readGenre() throws ClassNotFoundException, SQLException{
        Connection conn = null;
        List<Genre> genres = new ArrayList<Genre>();

        try {
            conn = util.getConnection();
            GenreDAO genereDAO = new GenreDAO(conn);
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the Genre ID you would like to retrieve from the database");
            Integer genreId = scan.nextInt();

            genres = genereDAO.readGenreById(genreId);

            for(Genre genre: genres){
                System.out.println(genre.getGenre_name());
            }

            System.out.println(ANSI_GREEN + "Read Genre Successfully");
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

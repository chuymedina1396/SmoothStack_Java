package com.ss.library.service;

import java.sql.SQLException;
import java.util.Scanner;

// Crud Operations Methods
import com.ss.library.service.CrudOperations.AuthorCrud;
import com.ss.library.service.CrudOperations.BookCrud;
import com.ss.library.service.CrudOperations.GenreCrud;
import com.ss.library.service.CrudOperations.LibraryBranchCrud;
import com.ss.library.service.CrudOperations.PublisherCrud;
import com.ss.library.service.CrudOperations.BorrowerCrud;

public class AdminService {
    
    public void startMenu() throws ClassNotFoundException, SQLException{
        System.out.println("Welcome to the admin service!");
        System.out.println("1) Add/Update/Delete/Read Book and Author"); //Check
        System.out.println("2) Add/Update/Delete/Read Genres");
        System.out.println("3) Add/Update/Delete/Read Publishers");
        System.out.println("4) Add/Update/Delete/Read Library Branches");
        System.out.println("5) Add/Update/Delete/Read Borrowers");
        System.out.println("6) Over-ride Due Date for a Book Loan");
        System.out.println("7) Quit to Previous");

        Scanner scan = new Scanner(System.in);
        Integer option = scan.nextInt();

        if(option == 1){
            operationsBookAndAuthor();
        }
        if(option == 2){
            operationsGenres();
        }
        if(option == 3){
            publisherOperations();
        }
        if(option == 4){
            operationsLibraryBranches();
        }
        if(option == 5){
            operationsBorrower();
        }
        if(option == 6){
            overRideDueDate();
        }
        if(option == 7){
            App.mainMenu();
        }

    }

    private void operationsBookAndAuthor() throws ClassNotFoundException, SQLException {
        System.out.println("You choose an Action");
        System.out.println("1) Add/Update/Delete/Read Book");
        System.out.println("2) Add/Update/Delete/Read Author");
        Scanner scan = new Scanner(System.in);
        Integer option = scan.nextInt();
        if(option == 1){
            bookOperations();
        }
        if(option == 2){
            System.out.println("Author Operations");
            authorOperations();
        }
    }
    private void operationsGenres() throws ClassNotFoundException, SQLException {
        System.out.println("You choose an Action");
        System.out.println("1) Add Genre");
        System.out.println("2) Update Genre");
        System.out.println("3) Delete Genre");
        System.out.println("4) Read Genre");
        Scanner scan = new Scanner(System.in);
        Integer option = scan.nextInt();
        if(option == 1) {
            GenreCrud.addGenre();
        }
        if(option == 2) {
            GenreCrud.updateGenre();
        }
        if(option == 3) {
            GenreCrud.deleteGenre();
        }
        if(option == 4){
            GenreCrud.readGenre();
        }
    }
    private void bookOperations() throws ClassNotFoundException, SQLException {
        
        System.out.println("Choose an operation to perform on the Book Table");
        System.out.println("1) Add Book");
        System.out.println("2) Update Book");
        System.out.println("3) Delete Book");
        System.out.println("4) Read Book");

        Scanner scan = new Scanner(System.in);
        Integer option = scan.nextInt();
        if(option ==1){
            BookCrud.addBook();
        }
        if(option ==2){
            System.out.println("Update Book");
            BookCrud.updateBook();
        }
        if(option ==3){
            System.out.println("Delete Book");
            BookCrud.deleteBook();
        }
        if(option ==4){
            System.out.println("Read Book");
            BookCrud.readBook();
        }
        
    }
    private void authorOperations() throws ClassNotFoundException, SQLException {
        
        System.out.println("Choose an operation to perform on the Book Table");
        System.out.println("1) Add Author");
        System.out.println("2) Update Author");
        System.out.println("3) Delete Author");
        System.out.println("4) Read Author");

        Scanner scan = new Scanner(System.in);
        Integer option = scan.nextInt();
        if(option == 1){
            AuthorCrud.addAuthor();
        }
        if(option == 2){
            System.out.println("Update Author");
            AuthorCrud.updateAuthor();
        }
        if(option == 3){
            System.out.println("Delete Book");
            AuthorCrud.deleteAuthor();
        }
        if(option == 4){
            System.out.println("Read Book");
            AuthorCrud.readAuthor();
        }
    }
    private void publisherOperations() throws ClassNotFoundException, SQLException {
        System.out.println("You choose an Action");
        System.out.println("1) Add Publisher");
        System.out.println("2) Update Publisher");
        System.out.println("3) Delete Publisher");
        System.out.println("4) Read Publisher");
        Scanner scan = new Scanner(System.in);
        Integer option = scan.nextInt();
        if(option == 1) {
            PublisherCrud.addPublisher();
        }
        if(option == 2) {
            PublisherCrud.updatePublisher();;
        }
        if(option == 3) {
            PublisherCrud.deletePublisher();;
        }
        if(option == 4){
            PublisherCrud.readPublisher();
        }
    }
    private void operationsLibraryBranches() throws ClassNotFoundException, SQLException {
        System.out.println("Choose an operation to perform on the Book Table");
        System.out.println("1) Add Library");
        System.out.println("2) Update Library");
        System.out.println("3) Delete Library");
        System.out.println("4) Read Library");

        Scanner scan = new Scanner(System.in);
        Integer option = scan.nextInt();
        if(option == 1){
            LibraryBranchCrud.addLibraryBranch();
        }
        if(option == 2){
            System.out.println("Update Branch");
            LibraryBranchCrud.updateLibraryBranch();
        }
        if(option == 3){
            System.out.println("Delete Branch");
            LibraryBranchCrud.deleteLibraryBranch();
        }
        if(option == 4){
            System.out.println("Read Book");
            LibraryBranchCrud.readLibraryBranch();
        }
    }
    private void operationsBorrower() throws ClassNotFoundException, SQLException {
        System.out.println("Choose an operation to perform on the Borrower Table");
        System.out.println("1) Add Borrower");
        System.out.println("2) Update Borrower");
        System.out.println("3) Delete Borrower");
        System.out.println("4) Read Borrower");

        Scanner scan = new Scanner(System.in);
        Integer option = scan.nextInt();
        if(option == 1){
            System.out.println("Add Borrower");
            BorrowerCrud.addBorrower();
        }
        if(option == 2){
            System.out.println("Update Borrower");
            BorrowerCrud.updateBorrower();;
        }
        if(option == 3){
            System.out.println("Delete Borrower");
            BorrowerCrud.deleteBorrower();
        }
        if(option == 4){
            System.out.println("Read Borrower");
            BorrowerCrud.readBorrower();
        }
    }
    private void overRideDueDate(){
        System.out.println("Overriding Due Date");
    }
}


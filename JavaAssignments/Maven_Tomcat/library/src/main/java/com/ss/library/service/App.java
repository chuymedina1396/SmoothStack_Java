package com.ss.library.service;
import java.sql.SQLException;
import java.util.Scanner;
public class App {
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        mainMenu();
    }
    public static void mainMenu() throws ClassNotFoundException, SQLException  {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the SS Library Management System. Which category of a user are you");
        System.out.println("1) Librarian");
        System.out.println("2) Administrator");
        System.out.println("3) Borrower");
        Integer input = scan.nextInt();
        if(input == 1){
            LibrarianService librarian = new LibrarianService();
            librarian.librarianMenu();
        }
        if(input == 2){
            System.out.println("You have chosen Administrator and will now be directed to the Administrator Menu");
            AdminService adminMenu = new AdminService();
            adminMenu.startMenu();
        }
        if(input == 3){
            System.out.println("You have chosen Borrower and will now be directed to the Borrower Menu");
        }
        scan.close();
    }
}

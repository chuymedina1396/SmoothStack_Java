// NOTE: I like to code something in one of few locations because modularity off the bat does not work well with my ADHD brain :). Will definitely  begin to refactor code this week. 

package com.utopia;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Bring in sql packages
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class App {
    // Bring in our Connection utility
    public static ConnectionUtil connUtil = new ConnectionUtil();
    public static void main(String[] args) {
        //MAIN METHODS FOR MENU FUNCTIONALITY
        mainMenu();
        // printCode();

    }

    public static void mainMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Utopia Airlines Management System. Which category of a user are you?");
        System.out.println("1) Employee/Agent");
        System.out.println("2) Administrator");
        System.out.println("3) Traveler");
        Integer input = scan.nextInt();
        if(input == 1){
            System.out.println("You have chosen Employee and will now be directed to the Employee Menu");
            try{
                employeeMenu();
            }   
            catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        if(input == 2){
            System.out.println("You have chosen Administrator and will now be directed to the Administrator Menu");
            try{
                adminMenu();
            }   
            catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        if(input == 3){
            System.out.println("You have chosen Traveler and will now be directed to the Traveler Menu");
            travellerMenu();
        }
        scan.close();
    }

    public static void employeeMenu() throws ClassNotFoundException, SQLException{

        Connection conn = null;

        Scanner scan = new Scanner(System.in);
        System.out.println("1) Enter the flights you manage: ");
        System.out.println("2) Quit to previous menu: ");
        Integer input = scan.nextInt();
        if(input == 1){
            System.out.println("List of Flights from database. ");
            Statement stmt = null;
            String query = "select * from flight";
            try {
                conn = connUtil.getConnection();
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    String route_id = rs.getString("route_id");
                    String airplane_id = rs.getString("airplane_id");
                    
                    System.out.println("Flight Route ID:" + route_id + "Airplane:" + airplane_id);
                }
                conn.commit();
            }
            catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
			    conn.rollback();
            }
            finally {
                if (stmt != null) { 
                  stmt.close(); 
                }
                if(conn!=null) {
                    conn.close();
                }
            }
        }
        if(input == 2){
            mainMenu();
        }
        scan.close();
    }

    public static void adminMenu() throws ClassNotFoundException, SQLException {

        Connection conn = null;

        Scanner scan = new Scanner(System.in);
        System.out.println("1) Add/Update/Delete/Read Flights"); //Done
        System.out.println("2) Add/Update/Delete/Read Tickets and Passengers");
        System.out.println("3) Add/Update/Delete/Read Airports"); // Done
        System.out.println("4) Add/Update/Delete/Read Travelers");
        System.out.println("5) Add/Update/Delete/Read Employees");
        System.out.println("6) Over-ride Trip Cancellation for a ticket.");
        Integer input = scan.nextInt();

        //1) Add/Update/Delete/Read Flights
        if(input == 1){
            System.out.println("You chose to Add/Update/Delete/Read Flights");
            System.out.println("Choose your action:");
            System.out.println("1) Add Flight");
            System.out.println("2) Update Flight");
            System.out.println("3) Delete Flight");
            System.out.println("4) Reads All Flights");
            Integer adminAction = scan.nextInt();
            if(adminAction == 1){
                System.out.println("Add a new Flight to the Flight Table.");
                PreparedStatement pstmt = null;
                try {
                    conn = connUtil.getConnection();
                    pstmt = conn.prepareStatement("INSERT into flight VALUES (default, (SELECT id FROM route WHERE id = ?), (SELECT id FROM airplane WHERE id = ?), ?, ?, ?)");
                    // Take flight ID
                    System.out.println("Enter Flight Route ID:");
                    Scanner flight = new Scanner(System.in);
                    Integer routeId = flight.nextInt();

                    // Take airplane ID
                    System.out.println("Enter Airplane ID: ");
                    Integer airplaneID = flight.nextInt();

                    // Consuming next line to avoid error.
                    flight.nextLine(); 

                    // Take depature time of flight
                    System.out.println("Enter Departure Time: ");
                    String departure = flight.nextLine();

                    // Number of Reserved Seats
                    System.out.println("Enter Number of Reserved Seats: ");
                    Integer seatsReserved = flight.nextInt();

                    System.out.println("Enter Seat Price: ");
                    Float priceSeat = flight.nextFloat();

                    pstmt.setInt(1, routeId);
                    pstmt.setInt(2, airplaneID);
                    pstmt.setString(3, departure);
                    pstmt.setInt(4, seatsReserved);
                    pstmt.setFloat(5, priceSeat);
                        pstmt.addBatch();
                    pstmt.executeBatch();

                    conn.commit();
                    flight.close();
                }
                catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                    conn.rollback();
                }
                finally {
                    if (pstmt != null) { 
                        pstmt.close(); 
                    }
                    if(conn!=null) {
                        conn.close();
                    }
                }
            }
            if(adminAction == 2){
                System.out.println("Update a Flight in the Flight Table");
                PreparedStatement pstmt = null;
                try {
                    
                    conn = connUtil.getConnection();
                    pstmt = conn.prepareStatement("UPDATE flight SET seat_price = ? WHERE id = ?");
                    System.out.println("Type in the Flight ID you want to update: ");
                    // Take flight ID
                    System.out.println("Enter the Flight ID you want to update:");
                    Scanner flight = new Scanner(System.in);
                    Integer flightId = flight.nextInt();


                    System.out.println("Enter Updated Seat Price: ");
                    Float priceSeat = flight.nextFloat();

                    pstmt.setFloat(1, priceSeat);
                    pstmt.setInt(2, flightId);
                        pstmt.addBatch();
                    pstmt.executeBatch();

                    conn.commit();
                    flight.close();
                }
                catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                    conn.rollback();
                }
                finally {
                    if (pstmt != null) { 
                        pstmt.close(); 
                    }
                    if(conn!=null) {
                        conn.close();
                    }
                }
            }
            if(adminAction == 3){
                System.out.println("Delete a Flight from the Flight Table: ");
                PreparedStatement pstmt = null;
                try {
                    conn = connUtil.getConnection();
                    pstmt = conn.prepareStatement("delete from flight where id = ?");
                    System.out.println("Type in the Flight ID you want to update: ");
                    // Take flight ID
                    System.out.println("Enter the Flight ID you want to delete:");
                    Scanner deleteFlight = new Scanner(System.in);
                    Integer flightId = deleteFlight.nextInt();

                    pstmt.setInt(1, flightId);
                    pstmt.executeUpdate();

                    conn.commit();
                    deleteFlight.close();
                }
                catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                    conn.rollback();
                }
                finally {
                    if (pstmt != null) { 
                        pstmt.close(); 
                    }
                    if(conn!=null) {
                        conn.close();
                    }
                }
            }
            if(adminAction == 4){
                System.out.println("Reading All Flights from Flight Table.");
                PreparedStatement pstmt = null;
                try {
                    conn = connUtil.getConnection();
                    pstmt = conn.prepareStatement("SELECT * FROM flight");
                    ResultSet rs = pstmt.executeQuery();
                    while (rs.next()) {
                        String flightIDs = rs.getString("id");
                        String seatPrices = rs.getString("seat_price");
                        System.out.println(flightIDs);
                        System.out.println(seatPrices);
                    }
                    conn.commit();
                }
                catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                    conn.rollback();
                }
                finally {
                    if (pstmt != null) { 
                        pstmt.close(); 
                    }
                    if(conn!=null) {
                        conn.close();
                    }
                }
            }
            scan.close();
        }
        // 2) Add/Update/Delete/Read Tickets and Passengers
        if(input == 2){
            System.out.println("You chose to Add/Update/Delete/Read Tickets and Passengers");
            System.out.println("Choose your action:");
            System.out.println("1) Add Passenger");
            System.out.println("2) Update Passenger");
            System.out.println("3) Delete Passenger");
            System.out.println("4) Read All Passengers");
            Integer adminAction = scan.nextInt();

            if(adminAction == 1){
                System.out.println("Add a new Passenger to the Passenger Table.");
                PreparedStatement pstmt = null;
                try {
                    conn = connUtil.getConnection();
                    pstmt = conn.prepareStatement("insert into passenger VALUES (default, (select * from booking where id = ?), ?, ?, ?, ?, ?)");
                    Scanner passenegerScanner = new Scanner(System.in);
                    System.out.println("Enter Passenger Booking ID:");
                    Integer bookingId = passenegerScanner.nextInt();

                    passenegerScanner.nextLine(); 

                    System.out.println("Enter Passenger First Name (Also known as given name.):");
                    String firstName = passenegerScanner.nextLine();

                    System.out.println("Enter Passenger Last Name (Also known as family name.):");
                    String lastName = passenegerScanner.nextLine();

                    System.out.println("Enter Passenger Date of birth (Format should look like this 20210804):");
                    Integer birthDate = passenegerScanner.nextInt();

                    passenegerScanner.nextLine(); 

                    System.out.println("Enter Passenger Gender:");
                    String gender = passenegerScanner.nextLine();

                    System.out.println("Enter Passenger Address:");
                    String address = passenegerScanner.nextLine();

                    pstmt.setInt(1, bookingId);
                    pstmt.setString(2, firstName);
                    pstmt.setString(3, lastName);
                    pstmt.setInt(4, birthDate);
                    pstmt.setString(5, gender);
                    pstmt.setString(6, address);
                        pstmt.addBatch();
                    pstmt.executeBatch();

                    conn.commit();
                    passenegerScanner.close();
                }
                catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                    conn.rollback();
                }
                finally {
                    if (pstmt != null) { 
                        pstmt.close(); 
                    }
                    if(conn!=null) {
                        conn.close();
                    }
                }
            }
            if(adminAction == 2){
                System.out.println("Update a Passenger in the Passenger Table.");
                PreparedStatement pstmt = null;
                try {
                    conn = connUtil.getConnection();
                    pstmt = conn.prepareStatement("update passenger set booking_id = ? where id = ?");
                    Scanner passenegerScanner = new Scanner(System.in);

                    System.out.println("What Passenger would you like to update info on their booking ticket from:");
                    Integer passengerId = passenegerScanner.nextInt();

                    passenegerScanner.nextLine(); 

                    System.out.println("Change their Booking Ticket to a new one: ");
                    String bookingId = passenegerScanner.nextLine();


                    pstmt.setInt(2, passengerId);
                    pstmt.setString(1, bookingId);
                        pstmt.addBatch();
                    pstmt.executeBatch();

                    conn.commit();
                    passenegerScanner.close();
                }
                catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                    conn.rollback();
                }
                finally {
                    if (pstmt != null) { 
                        pstmt.close(); 
                    }
                    if(conn!=null) {
                        conn.close();
                    }
                }
            }
            if(adminAction == 3){
                System.out.println("Delete a Passenger in the Passenger Table.");
                PreparedStatement pstmt = null;
                try {
                    conn = connUtil.getConnection();
                    pstmt = conn.prepareStatement("delete from passenger where id = ?");
                    Scanner passenegerScanner = new Scanner(System.in);

                    System.out.println("Enter Id of Passenger would you like to delete from the Passenger table:");
                    Integer passengerId = passenegerScanner.nextInt();
                    pstmt.setInt(1, passengerId);
                    pstmt.executeUpdate();

                    conn.commit();
                    passenegerScanner.close();
                }
                catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                    conn.rollback();
                }
                finally {
                    if (pstmt != null) { 
                        pstmt.close(); 
                    }
                    if(conn!=null) {
                        conn.close();
                    }
                }
            }
            if(adminAction == 4){
                Statement stmt = null;
                String query = "select * from passenger";
                try {
                    conn = connUtil.getConnection();
                    stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(query);
                    while (rs.next()) {
                        String passengerId = rs.getString("id");
                        
                        System.out.println("Passenger ID:" + passengerId);
                    }
                    conn.commit();
                }
                catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                    conn.rollback();
                }
                finally {
                    if (stmt != null) { 
                        stmt.close(); 
                    }
                    if(conn!=null) {
                        conn.close();
                    }
                }
            }
        }
        // 3) Add/Update/Delete/Read Airports
        if(input == 3){
            System.out.println("You chose to Add/Update/Delete/Read Airports");
            System.out.println("Choose your action:");
            System.out.println("1) Add Airport");
            System.out.println("2) Update Airport");
            System.out.println("3) Delete Airport");
            System.out.println("4) Reads All Airports");
            Integer adminAction = scan.nextInt();

            if(adminAction == 1){
                System.out.println("Add a new Airport to the Airport Table.");
                PreparedStatement pstmt = null;
                try {
                    conn = connUtil.getConnection();
                    pstmt = conn.prepareStatement("insert into airport VALUES (?, ?)");
                    System.out.println("Enter Airport ID:");
                    Scanner addAirportScan = new Scanner(System.in);
                    String airportId = addAirportScan.nextLine();
                    System.out.println("Enter Airport City:");
                    String airportCity = addAirportScan.nextLine();
                    pstmt.setString(1, airportId);
                    pstmt.setString(2, airportCity);
                        pstmt.addBatch();
                    pstmt.executeBatch();

                    conn.commit();
                    addAirportScan.close();
                }
                catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                    conn.rollback();
                }
                finally {
                    if (pstmt != null) { 
                        pstmt.close(); 
                    }
                    if(conn!=null) {
                        conn.close();
                    }
                }
            }
            if(adminAction == 2){
                System.out.println("Update a new Airport in the Airport Table.");
                PreparedStatement pstmt = null;
                try {

                    conn = connUtil.getConnection();
                    pstmt = conn.prepareStatement("update airport set city = ? where iata_id = ?");
                    System.out.println("Type in the airport code you want to update: ");
                    Scanner updateAirportScan = new Scanner(System.in);
                    String airportCode = updateAirportScan.nextLine();
                    System.out.println("Update Airport City:");
                    String airportCity = updateAirportScan.nextLine();
                    pstmt.setString(2, airportCode);
                    pstmt.setString(1, airportCity);
                        pstmt.addBatch();
                    pstmt.executeBatch();
                    
                    conn.commit();
                    updateAirportScan.close();
                }
                catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                    conn.rollback();
                }
                finally {
                    if (pstmt != null) { 
                        pstmt.close(); 
                    }
                    if(conn!=null) {
                        conn.close();
                    }
                }
            }
            if(adminAction == 3){
                System.out.println("Delete an Airport in the Airport Table.");
                PreparedStatement pstmt = null;
                try {

                    conn = connUtil.getConnection();
                    pstmt = conn.prepareStatement("DELETE from airport WHERE iata_id = ?");
                    System.out.println("Type in the airport/airport code you want to delete from the Airport table: ");
                    Scanner deleteAirportScan = new Scanner(System.in);
                    String airportCode = deleteAirportScan.nextLine();
                    pstmt.setString(1, airportCode);
                        pstmt.addBatch();
                    pstmt.executeBatch();
                    
                    conn.commit();
                    deleteAirportScan.close();
                }
                catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                    conn.rollback();
                }
                finally {
                    if (pstmt != null) { 
                        pstmt.close(); 
                    }
                    if(conn!=null) {
                        conn.close();
                    }
                }
            }
            if(adminAction == 4){
                System.out.println("Reading All Airports from Airport Table.");
                PreparedStatement pstmt = null;
                try {
                    conn = connUtil.getConnection();
                    pstmt = conn.prepareStatement("SELECT * FROM airport");
                    ResultSet rs = pstmt.executeQuery();
                    while (rs.next()) {
                        String airportIDs = rs.getString("iata_id");
                        System.out.println(airportIDs);
                    }
                    conn.commit();
                }
                catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                    conn.rollback();
                }
                finally {
                    if (pstmt != null) { 
                        pstmt.close(); 
                    }
                    if(conn!=null) {
                        conn.close();
                    }
                }
            }
        }
        // 4) Add/Update/Delete/Read Travelers
        if(input == 4){
            System.out.println("You chose to Add/Update/Delete/Read Employees");
            System.out.println("Choose your action:");
            System.out.println("1) Add Employee");
            System.out.println("2) Update Employee");
            System.out.println("3) Delete Employee");
            System.out.println("4) Reads All Employees");
            Integer adminAction = scan.nextInt();
            if(adminAction == 1){
                System.out.println("Add a new Traveler to the User Table.");
                PreparedStatement pstmt = null;
                try {
                    conn = connUtil.getConnection();
                    pstmt = conn.prepareStatement("INSERT into user VALUES (default, (SELECT id FROM user_role WHERE id = ?), ?, ?, ?, ?, ?, ?)");
                    // Take Traveler
                    System.out.println("Enter User Role for Traveler. Please enter 3 for Traveler");
                    Scanner Traveler = new Scanner(System.in);
                    Integer userRole = Traveler.nextInt();

                    // Consuming next line to avoid error.
                    Traveler.nextLine(); 

                    // Employee First Name
                    System.out.println("Enter Traveler First Name ");
                    String firstName = Traveler.nextLine();

                    // Employee Last Name
                    System.out.println("Enter Traveler Family Name (Last Name) ");
                    String lastName = Traveler.nextLine();

                    // Employee Username
                    System.out.println("Enter Traveler Username ");
                    String employeeUsername = Traveler.nextLine();

                    // Employee Email
                    System.out.println("Enter Traveler Email ");
                    String employeeEmail = Traveler.nextLine();

                    // Employee Password
                    System.out.println("Enter Traveler Password ");
                    String employeePassword= Traveler.nextLine();

                    // Employee Phone
                    System.out.println("Enter Traveler Phone ");
                    String employeePhone = Traveler.nextLine();

                    pstmt.setInt(1, userRole);
                    pstmt.setString(2, firstName);
                    pstmt.setString(3, lastName);
                    pstmt.setString(4, employeeUsername);
                    pstmt.setString(5, employeeEmail);
                    pstmt.setString(6, employeePassword);
                    pstmt.setString(7, employeePhone);
                        pstmt.addBatch();
                    pstmt.executeBatch();

                    conn.commit();
                    Traveler.close();
                }
                catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                    conn.rollback();
                }
                finally {
                    if (pstmt != null) { 
                        pstmt.close(); 
                    }
                    if(conn!=null) {
                        conn.close();
                    }
                }
            }
            if(adminAction == 2){
                System.out.println("Update an Traveler in the User Table.");
                PreparedStatement pstmt = null;
                try {
                    conn = connUtil.getConnection();
                    pstmt = conn.prepareStatement("update user set password = ? where role_id = 3 and email = ?");
                    System.out.println("Enter in the email of the Traveler you wish to update: ");
                    Scanner updateTravelerScan = new Scanner(System.in);
                    String travelerEmail = updateTravelerScan.nextLine();
                    System.out.println("Change Traveler Password to:");
                    String travelerPassword = updateTravelerScan.nextLine();
                    pstmt.setString(1, travelerPassword);
                    pstmt.setString(2, travelerEmail);
                        pstmt.addBatch();
                    pstmt.executeBatch();
                    
                    conn.commit();
                    updateTravelerScan.close();
                }
                catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                    conn.rollback();
                }
                finally {
                    if (pstmt != null) { 
                        pstmt.close(); 
                    }
                    if(conn!=null) {
                        conn.close();
                    }
                } 
            }
            if(adminAction == 3){
                System.out.println("Delete a Traveler in the User Table.");
                PreparedStatement pstmt = null;
                try {

                    conn = connUtil.getConnection();
                    pstmt = conn.prepareStatement("DELETE from user WHERE role_id = 3 and email = ?");
                    System.out.println("Type email of Travelers you wish to be deleted: ");
                    Scanner deleteTraveler = new Scanner(System.in);
                    String travelerEmail = deleteTraveler.nextLine();
                    pstmt.setString(1, travelerEmail);
                        pstmt.addBatch();
                    pstmt.executeBatch();
                    
                    conn.commit();
                    deleteTraveler.close();
                }
                catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                    conn.rollback();
                }
                finally {
                    if (pstmt != null) { 
                        pstmt.close(); 
                    }
                    if(conn!=null) {
                        conn.close();
                    }
                }
            }
            if(adminAction == 4){
                System.out.println("Reading All Travelers from User Table.");
                PreparedStatement pstmt = null;
                try {
                    conn = connUtil.getConnection();
                    pstmt = conn.prepareStatement("SELECT * FROM user WHERE role_id=3");
                    ResultSet rs = pstmt.executeQuery();
                    while (rs.next()) {
                        String travelers = rs.getString("email");
                        System.out.println(travelers);
                    }
                    conn.commit();
                }
                catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                    conn.rollback();
                }
                finally {
                    if (pstmt != null) { 
                        pstmt.close(); 
                    }
                    if(conn!=null) {
                        conn.close();
                    }
                } 
            } 
        }
        //5) Add/Update/Delete/Read Employees
        if(input == 5){
            System.out.println("You chose to Add/Update/Delete/Read Employees");
            System.out.println("Choose your action:");
            System.out.println("1) Add Employee");
            System.out.println("2) Update Employee");
            System.out.println("3) Delete Employee");
            System.out.println("4) Reads All Employees");
            Integer adminAction = scan.nextInt();
            if(adminAction == 1){
                System.out.println("Add a new Employee to the User Table.");
                PreparedStatement pstmt = null;
                try {
                    conn = connUtil.getConnection();
                    pstmt = conn.prepareStatement("INSERT into user VALUES (default, (SELECT id FROM user_role WHERE id = ?), ?, ?, ?, ?, ?, ?)");
                    // Take Employee
                    System.out.println("Enter User Role for Employee. Please enter 1 for Employee");
                    Scanner employee = new Scanner(System.in);
                    Integer userRole = employee.nextInt();

                    // Consuming next line to avoid error.
                    employee.nextLine(); 

                    // Employee First Name
                    System.out.println("Enter Employee First Name ");
                    String firstName = employee.nextLine();

                    // Employee Last Name
                    System.out.println("Enter Employee Family Name (Last Name) ");
                    String lastName = employee.nextLine();

                    // Employee Username
                    System.out.println("Enter Employee Username ");
                    String employeeUsername = employee.nextLine();

                    // Employee Email
                    System.out.println("Enter Employee Email ");
                    String employeeEmail = employee.nextLine();

                    // Employee Password
                    System.out.println("Enter Employee Password ");
                    String employeePassword= employee.nextLine();

                    // Employee Phone
                    System.out.println("Enter Employee Phone ");
                    String employeePhone = employee.nextLine();

                    pstmt.setInt(1, userRole);
                    pstmt.setString(2, firstName);
                    pstmt.setString(3, lastName);
                    pstmt.setString(4, employeeUsername);
                    pstmt.setString(5, employeeEmail);
                    pstmt.setString(6, employeePassword);
                    pstmt.setString(7, employeePhone);
                        pstmt.addBatch();
                    pstmt.executeBatch();

                    conn.commit();
                    employee.close();
                }
                catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                    conn.rollback();
                }
                finally {
                    if (pstmt != null) { 
                        pstmt.close(); 
                    }
                    if(conn!=null) {
                        conn.close();
                    }
                }
            }
            if(adminAction == 2){
                System.out.println("Update an Employee in the User Table.");
                PreparedStatement pstmt = null;
                try {
                    conn = connUtil.getConnection();
                    pstmt = conn.prepareStatement("update user set password = ? where role_id = 1 and email = ?");
                    System.out.println("Enter in the email of the employee you wish to update: ");
                    Scanner updateEmployeeScan = new Scanner(System.in);
                    String employeeEmail = updateEmployeeScan.nextLine();
                    System.out.println("Change Employee Password to:");
                    String employeePassword = updateEmployeeScan.nextLine();
                    pstmt.setString(1, employeePassword);
                    pstmt.setString(2, employeeEmail);
                        pstmt.addBatch();
                    pstmt.executeBatch();
                    
                    conn.commit();
                    updateEmployeeScan.close();
                }
                catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                    conn.rollback();
                }
                finally {
                    if (pstmt != null) { 
                        pstmt.close(); 
                    }
                    if(conn!=null) {
                        conn.close();
                    }
                } 
            }
            if(adminAction == 3){
                System.out.println("Delete an Employee in the User Table.");
                PreparedStatement pstmt = null;
                try {

                    conn = connUtil.getConnection();
                    pstmt = conn.prepareStatement("DELETE from user WHERE role_id = 1 and email = ?");
                    System.out.println("Type email of employee you wish to be deleted: ");
                    Scanner deleteEmployee = new Scanner(System.in);
                    String employeeEmail = deleteEmployee.nextLine();
                    pstmt.setString(1, employeeEmail);
                        pstmt.addBatch();
                    pstmt.executeBatch();
                    
                    conn.commit();
                    deleteEmployee.close();
                }
                catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                    conn.rollback();
                }
                finally {
                    if (pstmt != null) { 
                        pstmt.close(); 
                    }
                    if(conn!=null) {
                        conn.close();
                    }
                }
            }
            if(adminAction == 4){
                System.out.println("Reading All Employees from User Table.");
                PreparedStatement pstmt = null;
                try {
                    conn = connUtil.getConnection();
                    pstmt = conn.prepareStatement("SELECT * FROM user WHERE role_id=1");
                    ResultSet rs = pstmt.executeQuery();
                    while (rs.next()) {
                        String employees = rs.getString("email");
                        System.out.println(employees);
                    }
                    conn.commit();
                }
                catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                    conn.rollback();
                }
                finally {
                    if (pstmt != null) { 
                        pstmt.close(); 
                    }
                    if(conn!=null) {
                        conn.close();
                    }
                } 
            }
        }
        scan.close();
    }

    public static void travellerMenu() {

        Connection conn = null;

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the your Membership Number:");
        Integer memberId = scan.nextInt();

        // PreparedStatement pstm = "select "


        scan.close();
    }

    // public static void printCode() {
	// 	String code = "";
	// 	Random random = new Random();
	// 	for (int i = 0; i < 20; i++) {
 
	// 		 int r = random.nextInt(10); // randomly give a number each time (0-9)
 
	// 		 code = code + r; //Put together the random numbers every time
 
	// 	}
	// 	System.out.println(code);
	// }
}




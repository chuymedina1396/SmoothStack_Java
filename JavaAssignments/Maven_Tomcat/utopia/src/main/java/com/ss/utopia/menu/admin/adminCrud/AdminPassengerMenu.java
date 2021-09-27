package com.ss.utopia.menu.admin.adminCrud;

import java.sql.Date;
import java.sql.SQLException;

//Utilities
import static com.ss.utopia.utilities.ScannerUtil.*;
import static com.ss.utopia.utilities.StringSeperatorUtil.newLine;
import java.util.List;

import com.ss.utopia.menu.admin.AdminMenu;
import com.ss.utopia.models.Passenger;
import com.ss.utopia.services.AdminService;
import com.ss.utopia.utilities.ColorUtil;

public class AdminPassengerMenu extends ColorUtil {

    public static void AdminPassengersStartMenu() throws ClassNotFoundException, SQLException {
        System.out.println( ANSI_GREEN + "Welcome Admin. What would you like to see:" + newLine()

        + "  1) Add Passenger" + newLine()
        + "  2) Update Passenger" + newLine()
        + "  3) Delete Passenger" + newLine()
        + "  4) Read Passenger" + newLine()
        + "  5) Quit to Previous Menu" + newLine()
    );

        Integer selection = getIntInput(); 

        if(selection == 1){
            AdminService adminService = new AdminService();
            System.out.println("Enter info to create a new passenger");
            System.out.println("Enter Booking Id for Passenger");
            Integer bookingId = getIntInput();
            System.out.println("Enter Given Name for Passenger");
            String givenName = getStringInput();
            System.out.println("Enter Family Name for Passenger");
            String familyName = getStringInput();
            System.out.println("Enter DOB for Passenger");
            String dob = getDateInput();
            System.out.println("Enter Gender for Passenger");
            String gender = getStringInput();
            System.out.println("Enter Address for Passenger");
            String address = getStringInput();
            adminService.addPassenger(bookingId, givenName, familyName, dob, gender, address);
            AdminPassengersStartMenu();

        }
        if(selection == 2){
            AdminService adminService = new AdminService();
            System.out.println("Enter Passenger Id to update Passenger");
            Integer passengerId = getIntInput();
            System.out.println("Update the Booking Id of that Passenger.");
            Integer bookingId  = getIntInput();
            adminService.updatePassenger(passengerId, bookingId);
            AdminPassengersStartMenu();
        }
        if(selection == 3){
            AdminService adminService = new AdminService();
            System.out.println("Enter Passenger Id to delete");
            Integer passengerId = getIntInput();
            adminService.deletePassenger(passengerId);
            AdminPassengersStartMenu();
        }
        if(selection == 4) {
            System.out.println("1) Get all Passengers");
            System.out.println("2) Get Passenger by Id");
            Integer optionId = getIntInput(); 
            AdminService adminService = new AdminService();
            if(optionId == 1){
                List<Passenger> passengers = adminService.getAllPassengers();
                for (Passenger passenger : passengers){  // Which you iterate 
                    System.out.println("Reading Passenger: " + newLine()
                        + ANSI_GREEN + passenger.getPassengerId() + " ) "
                        + ANSI_YELLOW + "Given Name: " + passenger.getGivenName() + " "
                        + "FamilyName: " + passenger.getFamilyName() + " "
                        + "Gender: " + passenger.getGender()
                        + "Address: " + passenger.getAddress() + newLine()
                        + "Booking Object: " + passenger.getBookingId()
                        
                    );
                }
                AdminPassengersStartMenu();
            }
            if(optionId == 2){
                System.out.println("Enter a Flight Id to read that entry.");
                Integer passengerId = getIntInput();
                List<Passenger> passengers = adminService.getPassengerById(passengerId);
                for (Passenger passenger : passengers){  // Which you iterate 
                    System.out.println("Reading Passenger: " + newLine()
                        + ANSI_GREEN + passenger.getPassengerId() + " ) "
                        + ANSI_YELLOW + "Given Name: " + passenger.getGivenName() + " "
                        + "FamilyName: " + passenger.getFamilyName() + " "
                        + "Gender: " + passenger.getGender()
                        + "Address: " + passenger.getAddress() + newLine()
                        + "Booking Object: " + passenger.getBookingId() 
                    );
                }
                AdminPassengersStartMenu();
            } 
        }
        if(selection == 5){
           AdminMenu.adminMenuOptions();
        }
    }
}

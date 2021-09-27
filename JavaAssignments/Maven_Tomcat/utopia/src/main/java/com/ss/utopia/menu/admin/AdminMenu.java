package com.ss.utopia.menu.admin;

import java.sql.SQLException;

import com.ss.utopia.menu.MainMenu;
import com.ss.utopia.menu.admin.adminCrud.AdminAirportMenu;
import com.ss.utopia.menu.admin.adminCrud.AdminFlightsMenu;
import com.ss.utopia.menu.admin.adminCrud.AdminPassengerMenu;
import com.ss.utopia.menu.admin.adminCrud.AdminBookingMenu;
import com.ss.utopia.menu.admin.adminCrud.AdminEmployeesMenu;

import static com.ss.utopia.utilities.ScannerUtil.getIntInput;
import static com.ss.utopia.utilities.StringSeperatorUtil.newLine;



public class AdminMenu {

    public static void adminMenuOptions() throws ClassNotFoundException, SQLException {
        System.out.println( "Welcome Admin. What would you like to see:" + newLine() 
            + newLine()
            + "  1) Add/Update/Delete/Read Flights" + newLine() // Check
            + "  2) Add/Update/Delete/Read Seats" + newLine()
            + "  3) Add/Update/Delete/Read Bookings" + newLine() // Now
            + "  4) Add/Update/Delete/Read Passengers" + newLine()
            + "  5) Add/Update/Delete/Read Airports" + newLine() // Check
            + "  6) Add/Update/Delete/Read Travelers" + newLine()
            + "  7) Add/Update/Delete/Read Employees" + newLine()
            + "  8) Override Trip Cancellation" + newLine()
            + "  9) Quit to previous menu" + newLine()
        );
        System.out.println("Enter you choice by number:");
        Integer selection = getIntInput();

        if(selection == 1){
            AdminFlightsMenu adminFlightMenu = new AdminFlightsMenu();
            adminFlightMenu.AdminFlightsStartMenu();
        }
        if(selection == 3){
            AdminBookingMenu adminBookingMenu = new AdminBookingMenu();
            adminBookingMenu.AdminBookingsStartMenu();
        }
        if(selection == 4){
            AdminPassengerMenu.AdminPassengersStartMenu();
        }
        if(selection == 5){
            AdminAirportMenu airportMenu = new AdminAirportMenu();
            airportMenu.AdminAirportsStartMenu();
        }
        if(selection == 7){
            AdminEmployeesMenu.EmployeesStartMenu();
        }
        if(selection == 9){
            MainMenu.getUserCategory();
        }
    }
    
}

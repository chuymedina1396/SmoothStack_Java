package com.ss.utopia.menu.admin;



import java.sql.SQLException;

import com.ss.utopia.menu.admin.adminCrud.AdminAirportMenu;
import com.ss.utopia.menu.admin.adminCrud.AdminFlightsMenu;

import static com.ss.utopia.utilities.ScannerUtil.getIntInput;
import static com.ss.utopia.utilities.StringSeperatorUtil.newLine;



public class AdminMenu {

    public void adminMenuOptions() throws ClassNotFoundException, SQLException {
        System.out.println( "Welcome Admin. What would you like to see:" + newLine() 
            + newLine()
            + "  1) Add/Update/Delete/Read Flights" + newLine()
            + "  2) Add/Update/Delete/Read Seats" + newLine()
            + "  3) Add/Update/Delete/Read Passengers" + newLine()
            + "  4) Add/Update/Delete/Read Airports" + newLine()
            + "  5) Add/Update/Delete/Read Travelers" + newLine()
            + "  6) Add/Update/Delete/Read Employees" + newLine()
            + "  7) Override Trip Cancellation" + newLine()
        );

            Integer selection = getIntInput();

            if(selection == 1){
                AdminFlightsMenu adminFlightMenu = new AdminFlightsMenu();
                adminFlightMenu.AdminFlightsStartMenu();
            }
            if(selection == 4){
                AdminAirportMenu airportMenu = new AdminAirportMenu();
                airportMenu.AdminAirportsStartMenu();
            }
    }
    
}

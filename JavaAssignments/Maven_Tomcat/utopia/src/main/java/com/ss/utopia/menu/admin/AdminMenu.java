package com.ss.utopia.menu.admin;

import static com.ss.utopia.utilities.StringSeperatorUtil.newLine;
import static com.ss.utopia.utilities.ScannerUtil.getIntInput;
import com.ss.utopia.menu.admin.flights.AdminFlightsMenu;


public class AdminMenu {
    public static void main(String[] args) {
        System.out.println("Admin Menu!");   
    }
    public void adminMenuOptions() {
        System.out.println( "Welcome Admin. What would you like to see:" + newLine()
                + newLine()
                + "  1) Flights" + newLine()
                + "  2) Seats" + newLine()
                + "  3) Passengers" + newLine()
                + "  4) Airports" + newLine()
                + "  5) Travelers" + newLine()
                + "  6) Employees" + newLine()
                + "  7) Override Trip Cancellation" + newLine());

                if(getIntInput() == 1){
                    new AdminFlightsMenu();
                }
    }
    
}

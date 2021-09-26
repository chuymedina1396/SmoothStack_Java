package com.ss.utopia.menu.admin.flights;

import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;

import com.ss.utopia.daos.FlightDAO;

import com.ss.utopia.models.Route;
import com.ss.utopia.services.AdminService;
import com.ss.utopia.models.Airplane;
import com.ss.utopia.models.Airport;
import com.ss.utopia.models.Flight;

// import com.ss.utopia.services.AdminService;

//Utilities
import static com.ss.utopia.utilities.ScannerUtil.*;
import static com.ss.utopia.utilities.StringSeperatorUtil.newLine;


import static com.ss.utopia.utilities.ScannerUtil.getDateInput;

public class AdminAirportsMenu {

    public static void AdminAirportsStartMenu() throws ClassNotFoundException, SQLException {
        System.out.println( "Welcome Admin. What would you like to see:" + newLine()

        + "  1) Add Airport" + newLine()
        + "  2) Update Airport" + newLine()
        + "  3) Delete Airport" + newLine()
        + "  4) Read Airport" + newLine()

    );

        Integer selection = getIntInput(); 

        if(selection == 1){
            System.out.println("Add airport");
        }
        if(selection == 2){
            AdminService adminService = new AdminService();
            System.out.println("Enter Airport Code to update Airport");
            String code = getStringInput();
            System.out.println("Update the City of that airport.");
            String city  = getStringInput();
            adminService.updateAirport(code, city);
            AdminAirportsStartMenu();
        }
        if(selection == 3){
            AdminService adminService = new AdminService();
            System.out.println("Enter Flight Id to delete");
            Integer flightId = getIntInput();
            adminService.deleteFlight(flightId);
            AdminAirportsStartMenu();
        }
        if(selection == 4) {
            System.out.println("1) Get all Airports");
            System.out.println("2) Get Airport by AirportCode");
            Integer optionId = getIntInput(); 
            AdminService adminService = new AdminService();
            if(optionId == 1){
                List<Airport> airports = adminService.getAllAirports();
                for (Airport airport : airports){  
                    System.out.println("Reading Airport: "+
                        airport.getAirportCode()+
                        airport.getCity()
                    );
                }
                AdminAirportsStartMenu();;
            }
            
        }
    }
}

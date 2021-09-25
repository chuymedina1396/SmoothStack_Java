package com.ss.utopia.menu.admin.flights;

import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;

import com.ss.utopia.daos.FlightDAO;

import com.ss.utopia.models.Route;
import com.ss.utopia.services.AdminService;
import com.ss.utopia.models.Airplane;
import com.ss.utopia.models.Flight;

// import com.ss.utopia.services.AdminService;


import static com.ss.utopia.utilities.ScannerUtil.getIntInput;
import static com.ss.utopia.utilities.StringSeperatorUtil.newLine;


// import static com.ss.utopia.utilities.ScannerUtil.getDateInput;;

public class AdminFlightsMenu {

    public static void AdminFlightsStartMenu() throws ClassNotFoundException, SQLException {
        System.out.println( "Welcome Admin. What would you like to see:" + newLine()
        + "  1) Add Flight" 
        + "  2) Update Flight" 
        + "  3) Delete Flight" 
        + "  4) Read Flights" 
    );

        Integer selection = getIntInput(); 

        if(selection == 1){

            Flight flight = new Flight();
            Route route = new Route();
            Airplane airplane = new Airplane();

            System.out.println("Enter Origin AirportCodes for Flight");
            Integer route_id = getIntInput();
            route.setRouteId(route_id);
            

            System.out.println("Enter Airplane ID for Flight");
            Integer airplane_id = getIntInput();
            airplane.setAirplaneId(airplane_id);

            
            // System.out.println("Enter Departure time for flight");
            // String departure_time = getDateInput();

            // System.out.println("Enter Number of reserved seats:");
            // Integer reserved_seats = getIntInput();
            // flight.setReservedSeats(reserved_seats);

            // System.out.println("Enter a Seat Price");
            // Float seat_price = getFloatInput();

            AdminService adminService = new AdminService();
            adminService.addFlight(route, airplane);

            // System.out.println("Add this data: " +route.getRouteId()+airplane.getAirplaneId()+ "to the addFlight service!");

        }
    }

}

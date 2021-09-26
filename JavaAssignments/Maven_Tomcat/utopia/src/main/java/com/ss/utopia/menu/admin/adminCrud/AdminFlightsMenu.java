package com.ss.utopia.menu.admin.adminCrud;

import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;

import com.ss.utopia.daos.FlightDAO;

import com.ss.utopia.models.Route;
import com.ss.utopia.services.AdminService;
import com.ss.utopia.models.Airplane;
import com.ss.utopia.models.Flight;

// import com.ss.utopia.services.AdminService;

//Utilities
import static com.ss.utopia.utilities.ScannerUtil.*;
import static com.ss.utopia.utilities.StringSeperatorUtil.newLine;


import static com.ss.utopia.utilities.ScannerUtil.getDateInput;;

public class AdminFlightsMenu {

    public void AdminFlightsStartMenu() throws ClassNotFoundException, SQLException {
        System.out.println( "Welcome Admin. What would you like to see:" + newLine()

        + "  1) Add Flight" + newLine()
        + "  2) Update Flight" + newLine()
        + "  3) Delete Flight" + newLine()
        + "  4) Read Flights" + newLine()
    );

        Integer selection = getIntInput(); 

        if(selection == 1){

            // Creating new Instances of all models involved in the creation of the a Flight.
            Flight flight = new Flight();
            Route route = new Route();
            Airplane airplane = new Airplane();

            System.out.println("Enter a Route ID for the flight");
            Integer route_id = getIntInput();
            route.setRouteId(route_id);
            route.getDestAirport();
            route.getOriginAirport();
            ;

            System.out.println("Enter Airplane ID for Flight");
            Integer airplane_id = getIntInput();
            airplane.setAirplaneId(airplane_id);
            airplane.getAirplaneTypeId();
            // flight.setAirplaneId(airplane_id);

            System.out.println("Enter Departure time for flight");
            String departure_time = getDateInput();
            flight.setDepartureTime(departure_time);

            System.out.println("Enter Number of reserved seats:");
            Integer reserved_seats = getIntInput();
            flight.setReservedSeats(reserved_seats);

            System.out.println("Enter a Seat Price");
            Float seat_price = getFloatInput();
            flight.setSeatPrice(seat_price);

            AdminService adminService = new AdminService();
            adminService.addFlight(route, airplane, flight);

            System.out.println("Add this data: " + route + " Route Data " +" ** Airplane Data **  "+ airplane+ " **FLIGHT DATA***" +flight+ " to the addFlight service!");

        }
        if(selection == 2){
            AdminService adminService = new AdminService();
            System.out.println("Enter Flight Id to update");
            Integer flightId = getIntInput();
            System.out.println("Update Seat Price (Enter Float)");
            Float seatPrice  = getFloatInput();
            adminService.updateFlight(seatPrice, flightId);
            AdminFlightsStartMenu();
        }
        if(selection == 3){
            AdminService adminService = new AdminService();
            System.out.println("Enter Flight Id to delete");
            Integer flightId = getIntInput();
            adminService.deleteFlight(flightId);
            AdminFlightsStartMenu();
        }
        if(selection == 4) {
            System.out.println("1) Get all flights");
            System.out.println("2) Get flight by id");
            Integer optionId = getIntInput(); 
            AdminService adminService = new AdminService();
            if(optionId == 1){
                List<Flight> flights = adminService.getAllFlights();
                for (Flight flight : flights){  // Which you iterate 
                    System.out.println("Reading flight: " 
                        + flight.getFlightId() 
                        + " from database" + newLine() 
                        + "Flight Id: " 
                        + flight.getFlightId()
                        + "Route data"
                        +flight.getRouteId()
                        + "Airplane data"
                        +flight.getAirplane()
                        + " | Departure Time: "
                        + flight.getDepartureTime()
                        + ") | Reserved Seats: "
                        + flight.getReservedSeats()
                        + " | Seat Price: "
                        + flight.getSeatPrice() + newLine()
                    );
                }
                AdminFlightsStartMenu();
            }
            if(optionId == 2){
                System.out.println("Enter a Flight Id to read that entry.");
                Integer flightId = getIntInput();
                List<Flight> flights = adminService.readFlightsById(flightId);
                for (Flight flight : flights){  // Which you iterate 
                    System.out.println("Reading flights from database" + newLine() 
                        + "Flight Id: " 
                        + flight.getFlightId()
                        + " | Departure Time: "
                        + flight.getDepartureTime()
                        + ") | Reserved Seats: "
                        + flight.getReservedSeats()
                        + " | Seat Price: "
                        + flight.getSeatPrice()  + newLine()
                    );
                }
                AdminFlightsStartMenu();
            }
        }
    }
}

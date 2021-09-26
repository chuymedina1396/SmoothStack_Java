package com.ss.utopia.menu.employee;

import static com.ss.utopia.utilities.ScannerUtil.getIntInput;
import static com.ss.utopia.utilities.ScannerUtil.getIntInput;;
import static com.ss.utopia.utilities.StringSeperatorUtil.newLine;
import java.util.List;
import java.sql.SQLException;

import com.ss.utopia.models.Flight;

import com.ss.utopia.services.EmployeeService;


public class EmployeeMenu {
    public static void employeeMenuOption() throws ClassNotFoundException, SQLException {
        System.out.println("1) Enter flights you manage");
        System.out.println("2) Quit to previous menu");
        Integer employeeOption = getIntInput();
        if(employeeOption == 1){
            EmployeeService employeeService = new EmployeeService();
            List<Flight> flights = employeeService.getAllFlights();
            for (Flight flight : flights){  // Which you iterate 
                System.out.println("Reading flight: " + flight.getFlightId() + " from database" + newLine() 
                    + "Flight Id: " 
                    + flight.getFlightId()
                    + " | Departure Time: "
                    + flight.getDepartureTime()
                    + ") | Reserved Seats: "
                    + flight.getReservedSeats()
                    + " | Seat Price: "
                    + flight.getSeatPrice() + newLine()
                );
            }
            System.out.println("Enter the ID for the flight you manage from the list above"); 
            Integer searchFlight = getIntInput();
            


        }

    }
}

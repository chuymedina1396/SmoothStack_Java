package com.ss.utopia.services;

// Packages
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;

//Utilities
import com.ss.utopia.utilities.ConnectionUtil;

//DAOS
import com.ss.utopia.daos.RouteDAO;
import com.ss.utopia.daos.AirportDAO;
import com.ss.utopia.daos.FlightDAO;
import com.ss.utopia.daos.AirplaneDAO;

//Models
import com.ss.utopia.models.Route;
import com.ss.utopia.models.Airplane;
import com.ss.utopia.models.Airport;
import com.ss.utopia.models.Flight;


public class EmployeeService {
    
    ConnectionUtil connUtil = new ConnectionUtil();

    // To add a flight, we need the route id, the airplane id, the departure_time, reserved_seats, and the seat_price
    // public String addFlight(Route route, Airplane airplane, Flight flight) throws ClassNotFoundException, SQLException {
    //     Connection conn = null;
    //     try{
    //         conn = connUtil.getConnection();
    //         RouteDAO rdao = new RouteDAO(conn);
    //         rdao.addRoute(route);
    //         AirplaneDAO adao = new AirplaneDAO(conn);
    //         adao.addAirplane(airplane);
    //         FlightDAO fdao = new FlightDAO(conn);
    //         fdao.addFlight(flight);
    //         conn.commit(); // commit to database
    //         return "Flight added successfully";
    //     }catch(Exception e){
    //         if(conn != null){
    //             conn.rollback();
    //         }
    //         return "Flight addition failed";
    //     }finally{
    //         if(conn!=null){
    //             conn.close();
    //         }
    //     }
    // }
}

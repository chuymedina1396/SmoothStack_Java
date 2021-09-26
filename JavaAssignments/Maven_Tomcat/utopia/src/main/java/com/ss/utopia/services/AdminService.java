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


public class AdminService {
    
    ConnectionUtil connUtil = new ConnectionUtil();

    //** ALL SERVICE METHODS FOR FLIGHT OPERATIONS ** /
    public String addFlight(Route route, Airplane airplane, Flight flight) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        try{
            conn = connUtil.getConnection();
            RouteDAO rdao = new RouteDAO(conn);
            rdao.addRoute(route);
            AirplaneDAO adao = new AirplaneDAO(conn);
            adao.addAirplane(airplane);
            FlightDAO fdao = new FlightDAO(conn);
            fdao.addFlight(flight);
            conn.commit(); // commit to database
            return "Flight added successfully";
        }catch(Exception e){
            if(conn != null){
                conn.rollback();
            }
            return "Flight addition failed";
        }finally{
            if(conn!=null){
                conn.close();
            }
        }
    }
    
    public void updateFlight(Float seatPrice, Integer flightId) throws ClassNotFoundException, SQLException{
        Connection conn = null;
        try {
            conn = connUtil.getConnection();
            FlightDAO fdao = new FlightDAO(conn);
            fdao.updateFlight(seatPrice, flightId);
            conn.commit();
            System.out.println("Flight Updated");
        } catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            if(conn != null){
                conn.close();
            }
        }
    }
    // GET ALL FLIGHTS METHOD 
    public List<Flight> getAllFlights() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        List<Flight> flights = new ArrayList<Flight>();
        try {
            conn = connUtil.getConnection();
            FlightDAO fdao = new FlightDAO(conn);
            flights = fdao.readFlights();
            return flights;
        } catch (SQLException ex) {
            return Collections.emptyList();
        }
    }
    // GET A FLIGHT BY ID
    public List<Flight> readFlightsById(Integer flightId) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        List<Flight> flights = new ArrayList<Flight>();
        try {
            conn = connUtil.getConnection();
            FlightDAO fdao = new FlightDAO(conn);
            flights = fdao.readFlightsById(flightId);
            return flights;
        } catch (SQLException ex) {
            return Collections.emptyList();
        }
    }
    
    public void deleteFlight(Integer flightId) throws ClassNotFoundException, SQLException{
        Connection conn = null;
        try {
            conn = connUtil.getConnection();
            FlightDAO fdao = new FlightDAO(conn);
            fdao.deleteFlight(flightId);
            conn.commit();
            System.out.println("Flight Deleted");
        } catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            if(conn != null){
                conn.close();
            }
        }
    }

    // ** ALL SERVICE METHODS FOR AIRPORT OPERATIONS ** /
    
    public List<Airport> getAllAirports() throws ClassNotFoundException, SQLException{
        Connection conn = null;
        List<Airport> airports = new ArrayList<Airport>();
        try {
            conn = connUtil.getConnection();
            AirportDAO adao = new AirportDAO(conn);
            airports = adao.readAirports();
            return airports;
        } catch (SQLException ex) {
            return Collections.emptyList();
        }
    }
    public List<Airport> readAirportsByAirportCode(String airportCode) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        List<Airport> airports = new ArrayList<Airport>();
        try {
            conn = connUtil.getConnection();
            AirportDAO adao = new AirportDAO(conn);
            airports = adao.readAirportsByAirportCode(airportCode);
            return airports;
        } catch (SQLException ex) {
            return Collections.emptyList();
        }
    }
    public void deleteAirport(String airportCode) throws ClassNotFoundException, SQLException{
        Connection conn = null;
        try {
            conn = connUtil.getConnection();
            AirportDAO adao = new AirportDAO(conn);
            adao.deleteAirport(airportCode);
            conn.commit();
            System.out.println("Flight Deleted");
        } catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            if(conn != null){
                conn.close();
            }
        }
    }
    
    public void updateAirport(String airportCode, String city) throws ClassNotFoundException, SQLException{
        Connection conn = null;
        try {
            conn = connUtil.getConnection();
            AirportDAO adao = new AirportDAO(conn);
            adao.updateAirport(airportCode, city);
            conn.commit();
            System.out.println("Flight Deleted");
        } catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            if(conn != null){
                conn.close();
            }
        }
    }
}

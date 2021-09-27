package com.ss.utopia.services;

// Packages
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Date;

//Utilities
import com.ss.utopia.utilities.ConnectionUtil;

//DAOS
import com.ss.utopia.daos.RouteDAO;
import com.ss.utopia.daos.AirportDAO;
import com.ss.utopia.daos.FlightDAO;
import com.ss.utopia.daos.AirplaneDAO;
import com.ss.utopia.daos.PassengerDAO;

//Models
import com.ss.utopia.models.Route;
import com.ss.utopia.models.Airplane;
import com.ss.utopia.models.Airport;
import com.ss.utopia.models.Flight;
import com.ss.utopia.models.Passenger;


public class AdminService {
    
    ConnectionUtil connUtil = new ConnectionUtil();

    //** SERVICE METHODS FOR FLIGHT OPERATIONS ** /

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

    // ** SERVICE METHODS FOR AIRPORT OPERATIONS ** /
    public void addAirport(String airportCode, String city )throws ClassNotFoundException, SQLException{
        Connection conn = null;
        try {
            conn = connUtil.getConnection();
            AirportDAO adao = new AirportDAO(conn);
            adao.addAirport(airportCode, city);
            conn.commit();
            System.out.println("Airport Added");
        } catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            if(conn != null){
                conn.close();
            }
        }
    }
    public void deleteAirport(String airportCode) throws ClassNotFoundException, SQLException{
        Connection conn = null;
        try {
            conn = connUtil.getConnection();
            AirportDAO adao = new AirportDAO(conn);
            adao.deleteAirport(airportCode);
            conn.commit();
            System.out.println("Airport Deleted");
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
    
    // ** SERVICE METHODS FOR BOOKING OPERATIONS ** /

    
    // ** SERVICE METHODS FOR PASSENGER OPERATIONS ** /
    public void addPassenger(Integer bookingId, String givenName, String familyName, String dob, String gender, String address) throws ClassNotFoundException, SQLException{
        Connection conn = null;
        try {
            conn = connUtil.getConnection();
            PassengerDAO pdao = new PassengerDAO(conn);
            pdao.addPassenger(bookingId, givenName, familyName, dob, gender, address);
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
    public void updatePassenger(Integer passengerId, Integer newBookingId) throws 
    ClassNotFoundException, SQLException{
        Connection conn = null;
        try {
            conn = connUtil.getConnection();
            PassengerDAO pdao = new PassengerDAO(conn);
            pdao.updatePassenger(passengerId, newBookingId);
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
    public List<Passenger> getAllPassengers() throws ClassNotFoundException, SQLException{
        Connection conn = null;
        List<Passenger> passengers = new ArrayList<Passenger>();
        try {
            conn = connUtil.getConnection();
            PassengerDAO pdao = new PassengerDAO(conn);
            passengers = pdao.readPassengers();
            return passengers;
        } catch (SQLException ex) {
            return Collections.emptyList();
        }
    }
    public List<Passenger> getPassengerById(Integer passengerId) throws ClassNotFoundException, SQLException{
        Connection conn = null;
        List<Passenger> passengers = new ArrayList<Passenger>();
        try {
            conn = connUtil.getConnection();
            PassengerDAO pdao = new PassengerDAO(conn);
            passengers = pdao.readPassengersById(passengerId);
            return passengers;
        } catch (SQLException ex) {
            return Collections.emptyList();
        }
    }
    public void deletePassenger(Integer passengerId) throws ClassNotFoundException, SQLException{
        Connection conn = null;
        try {
            conn = connUtil.getConnection();
            PassengerDAO pdao = new PassengerDAO(conn);
            pdao.deletePassenger(passengerId);
            conn.commit();
            System.out.println("Passenger Deleted");
        } catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            if(conn != null){
                conn.close();
            }
        }
    }
    
    // ** SERVICE METHODS FOR EMPLOYEES OPERATIONS ** /




}

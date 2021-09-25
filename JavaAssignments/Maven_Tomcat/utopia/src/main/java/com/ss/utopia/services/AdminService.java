package com.ss.utopia.services;

// Packages
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
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

    private final FlightDAO flightDAO;

    public AdminService(FlightDAO dao) {
        this.flightDAO = dao;
    }

    public String addFlight(Route route, Airplane airplane) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        try{
            conn = connUtil.getConnection();
            RouteDAO rdao = new RouteDAO(conn);
            rdao.addRoute(route);
            AirplaneDAO adao = new AirplaneDAO(conn);
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
    
    public List<Flight> getAllFlights() throws ClassNotFoundException, SQLException {
        try {
            return flightDAO.readFlights();
        } catch (SQLException ex) {
            return Collections.emptyList();
        }
    }
}

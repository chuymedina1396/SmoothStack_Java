package com.ss.utopia.services;

// Packages
import java.sql.SQLException;
import java.sql.Connection;

//Utilities
import com.ss.utopia.utilities.ConnectionUtil;

//DAOS
import com.ss.utopia.daos.RouteDAO;
import com.ss.utopia.daos.AirportDAO;

//Models
import com.ss.utopia.models.Route;
import com.ss.utopia.models.Airport;


public class AdminService {
    ConnectionUtil connUtil = new ConnectionUtil();

    public String addFlight(Route route, Airport airport) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        try{
            conn = connUtil.getConnection();
            RouteDAO rdao = new RouteDAO(conn);
            AirportDAO adao = new AirportDAO(conn);
            rdao.addRoute(route);
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
}

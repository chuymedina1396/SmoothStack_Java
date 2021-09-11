package com.utopia.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.utopia.dao.AirportDAO;
import com.utopia.domain.Airport;
import com.utopia.domain.Route;

public class AdminService {
    ConnectionUtil connUtil = new ConnectionUtil();

    // Transaction
    public void addAirportRoute(Airport airport, Route route){
        Connection conn = null;
        try{
            conn = connUtil.getConnection();

            // Once you have you connection with the database, you can begin adding airport routes to the databases.
            // airportDAO -> add IDA to airport table.
            // airportDAO -> add BWI to airport table.
            // routeDAO -> insert IAD-BWI.
            AirportDAO adao = new AirportDAO(conn);
            adao.addAirport(airport);
            RouteDAO rdao = new RouteDAO(conn);
            // rado.addRoute();
            //If there are no errors.
            conn.commit();
        }
        catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
            conn.rollback();
        } finally {
            if(conn != null){
                conn.close();
            }
        }
    }

}
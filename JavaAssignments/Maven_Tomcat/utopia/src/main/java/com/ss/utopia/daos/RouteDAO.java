package com.ss.library.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.models.Airport;
import com.ss.utopia.models.Route;

public class RouteDAO extends BaseDAO<Route> {

    public RouteDAO(Connection conn){
        // super is also used in react to inherit from the parent class :)
        super(conn);
    }

    public void addRoute(Route route) throws ClassNotFoundException, SQLException {
        save("INSERT INTO route (origin_id, destination_id)  VALUES(?,?)", new Object[] {route.getOriginAirport(), route.getDestAirport()});
    }
    //What kind of update can we do? What if the user want to update the address and the name? For later...
    public void updateRoute(Route route) throws ClassNotFoundException, SQLException {
        save("UPDATE route SET authorName = ? WHERE authorId = ? ", new Object[] {route.getOriginAirport(), id});
    }
    public void deleteRoute(Route route) throws ClassNotFoundException, SQLException {
        save("DELETE from route WHERE routeId = ? ", new Object[] {route.getRouteId()});
    }

    //READ MY BRANCHID
    //READ BY NAME ETC

    //Get all library branches
    public List<Route> readAllRoutes() throws ClassNotFoundException, SQLException{
        return read("SELECT * FROM route", null);
    }

    // Get a library branch by an id
    public List<Route> readRouteById(Integer input) throws ClassNotFoundException, SQLException{
        return read("SELECT * FROM route where authorId = ?", new Object [] {input});
    }

    // ALL GET DAOS WILL HAVE THIS METHOD
    public List<Route> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {


        List<Route> authors = new ArrayList<>();
	
		while(rs.next()) {
            Route route = new Route();
            Airport airport = new Airport();
            route.setDestAirport(airport.getAirportCode());
            // a.setBookRoutes(rs.getString("bookRoutes"));
            authors.add(a);
		}
        return authors;
    }
  
}

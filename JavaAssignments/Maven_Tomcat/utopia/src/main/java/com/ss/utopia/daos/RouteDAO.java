package com.ss.utopia.daos;

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
    
    public void updateRoute(Route route) throws ClassNotFoundException, SQLException {
        save("UPDATE route SET authorName = ? WHERE authorId = ? ", new Object[] {route.getOriginAirport(), route.getDestAirport(), route.getRouteId()});
    }
    public void deleteRoute(Route route) throws ClassNotFoundException, SQLException {
        save("DELETE from route WHERE routeId = ? ", new Object[] {route.getRouteId()});
    }

    //Get all library branches
    public List<Route> readAllRoutes() throws ClassNotFoundException, SQLException{
        return read("SELECT * FROM route", null);
    }

    // Get a library branch by an id
    public List<Route> readRouteById(Route route) throws ClassNotFoundException, SQLException{
        return read("SELECT * FROM route where routeId = ?", new Object [] {route.getRouteId()});
    }

    // ALL GET DAOS WILL HAVE THIS METHOD
    public List<Route> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {


        List<Route> routes = new ArrayList<>();
	
		while(rs.next()) {
            Route route = new Route();
            Airport airport = new Airport();
            route.setDestAirport(airport.getAirportCode());
            // a.setBookRoutes(rs.getString("bookRoutes"));
            routes.add(route);
		}
        return routes;
    }
  
}

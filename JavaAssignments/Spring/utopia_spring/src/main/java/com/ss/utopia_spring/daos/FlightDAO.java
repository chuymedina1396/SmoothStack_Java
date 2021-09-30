package com.ss.utopia_spring.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia_spring.models.Airplane;
import com.ss.utopia_spring.models.Flight;
import com.ss.utopia_spring.models.Route;

public class FlightDAO extends BaseDAO<Flight> {

	public FlightDAO(Connection conn) {
		super(conn);
	}

    
	public void addFlight(Flight flight) throws ClassNotFoundException, SQLException {
		save("INSERT INTO flight (route_id, airplane_id, departure_time, reserved_seats, seat_price ) VALUES (?, ?, ?, ?, ?)", new Object[] {
				flight.getRouteId(),
				flight.getAirplane(),
				flight.getDepartureTime(),
				flight.getReservedSeats(),
				flight.getSeatPrice()
			});
	}

	public void updateFlight(Float seatPrice, Integer flightId) throws ClassNotFoundException, SQLException {
		save("UPDATE flight SET seat_price = ? WHERE id = ?", new Object[] { 
			seatPrice,
			flightId
		});
	}

	public void deleteFlight(Integer flightId) throws ClassNotFoundException, SQLException {
		save("DELETE from flight where id = ?", new Object[] { 
			flightId
		});
	}

	public List<Flight> readFlights() throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM flight", new Object[] {});
	}
	
	public List<Flight> readFlightsById(Integer flightId) throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM flight WHERE id = ?", new Object[] { 
			flightId
		});
	}

	@Override
	public List<Flight> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Flight> flights = new ArrayList<>();
		while (rs.next()) {
			Flight flight = new Flight();
			Route route = new Route();
			route.setRouteId(rs.getInt("route_id"));
			Airplane airplane = new Airplane();
			flight.setFlightId(rs.getInt("id"));
			// flight.setRouteId(route.getRouteId());
			// flight.setAirplane(airplane);
			flight.setDepartureTime(rs.getString("departure_time"));
			flight.setReservedSeats(rs.getInt("reserved_seats"));
			flight.setSeatPrice(rs.getFloat("seat_price"));
			flight.setRouteId(route);
			flights.add(flight);
		}
		return flights;
	}
}
package com.ss.utopia.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.models.Airplane;
import com.ss.utopia.models.Flight;
import com.ss.utopia.models.Route;

public class FlightDAO extends BaseDAO<Flight> {

	public FlightDAO(Connection conn) {
		super(conn);
	}

    
	public void addFlight(Flight flight) throws ClassNotFoundException, SQLException {
		save("INSERT INTO flight (route_id, airplane_id, departure_time, reserved_seats, seat_price ) VALUES (?, ?, ?, ?, ?)", new Object[] {
				flight.getRouteId().getRouteId(),
				flight.getAirplane().getAirplaneId(),
				flight.getDepartureTime(),
				flight.getReservedSeats(),
				flight.getSeatPrice()
			});
	}

	public void updateFlight(Flight flight) throws ClassNotFoundException, SQLException {
		save("UPDATE flight set airplane_id = ? WHERE id = ?", new Object[] { 
			flight.getAirplane().getAirplaneId(),
			flight.getFlightId()
		});
	}

	public void deleteFlight(Flight flight) throws ClassNotFoundException, SQLException {
		save("DELETE from flight where id = ?", new Object[] { 
			flight.getFlightId() 
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
			route.getRouteId();
			Airplane airport = new Airplane();
			flight.setFlightId(rs.getInt("id"));
			// flight.setRouteId(route.getRouteId());
			// flight.getAirplane().setAirplaneId(rs.getInt(airport.getAirplaneId()));
			flight.setDepartureTime(rs.getString("departure_time"));
			flight.setReservedSeats(rs.getInt("reserved_seats"));
			flight.setSeatPrice(rs.getFloat("seat_price"));
			flights.add(flight);
		}
		return flights;
	}
}
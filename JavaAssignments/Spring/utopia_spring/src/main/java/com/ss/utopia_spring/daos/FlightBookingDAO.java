package com.ss.utopia_spring.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia_spring.models.FlightBooking;

public class FlightBookingDAO extends BaseDAO<FlightBooking> {

	public FlightBookingDAO(Connection conn) {
		super(conn);
	}

    
	public void addFlightBooking(FlightBooking flightBooking) throws ClassNotFoundException, SQLException {
		save("INSERT INTO flightBooking (flight_id, booking_id ) VALUES (?, ?)", 
		new Object[] {
				flightBooking.getFlghtId(),
				flightBooking.getBookingId()
		});
	}

	public void updateFlightBooking(FlightBooking flightBooking) throws ClassNotFoundException, SQLException {
		save("UPDATE flightBooking set flight_id = ?  where booking_id = ?", new Object[] { 
			flightBooking.getFlghtId(),
			flightBooking.getBookingId()
		});
	}

	public void deleteFlightBooking(FlightBooking flightBooking) throws ClassNotFoundException, SQLException {
		save("delete from flightBooking where flight_id = ?", new Object[] {
			flightBooking.getFlghtId()
		  });
	}

	public List<FlightBooking> readFlightBookings() throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM flightBooking", null);
	}
	
	public List<FlightBooking> readFlightBookingsById(String flightBookingFlightId) throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM flightBooking WHERE flight_id= ?", new Object[] { 
			
		 });
	}

	@Override
	public List<FlightBooking> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<FlightBooking> flightBookings = new ArrayList<>();
		while (rs.next()) {
			FlightBooking flightBooking = new FlightBooking();
			flightBooking.getBookingId().setBookingId(rs.getInt("booking_id"));
			flightBooking.getFlghtId().setFlightId(rs.getInt("flight_id"));
			flightBookings.add(flightBooking);
		}
		return flightBookings;
	}
}
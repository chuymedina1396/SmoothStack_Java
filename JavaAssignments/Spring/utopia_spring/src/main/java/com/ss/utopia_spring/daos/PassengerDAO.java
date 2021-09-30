package com.ss.utopia_spring.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia_spring.models.Booking;
import com.ss.utopia_spring.models.Passenger;

public class PassengerDAO extends BaseDAO<Passenger> {

	public PassengerDAO(Connection conn) {
		super(conn);
	}

	public void addPassenger(Integer bookingId, String givenName, String familyName, String dob, String gender, String address) throws ClassNotFoundException, SQLException {
		save("INSERT INTO passenger (booking_id, given_name, family_name, dob, gender, address ) VALUES (?, ?, ?, ?, ?, ?)", new Object[] {
			bookingId,
			givenName,
			familyName,
			dob,
			gender,
			address
			});
	}

	public void updatePassenger(Integer passengerId, Integer bookingId) throws ClassNotFoundException, SQLException {
		save("UPDATE passenger set booking_id = ? WHERE id = ?", new Object[] { 
			bookingId,
            passengerId
		});
	}

	public void deletePassenger(Integer passengerId) throws ClassNotFoundException, SQLException {
		save("DELETE from passenger where id = ?", new Object[] { 
			passengerId
		});
	}

	public List<Passenger> readPassengers() throws ClassNotFoundException, SQLException {
		return read("select * from passenger join booking on booking.id=passenger.booking_id;", new Object[] {});
	}
	
	public List<Passenger> readPassengersById(Integer passengerId) throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM passenger WHERE id = ?", new Object[] { 
			passengerId
		});
	}

	@Override
	public List<Passenger> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Passenger> passengers = new ArrayList<>();
		while (rs.next()) {
			Passenger passenger = new Passenger();
			passenger.setPassengerId(rs.getInt("id"));
            passenger.setGivenName(rs.getString("given_name"));
            passenger.setFamilyName(rs.getString("family_name"));
            passenger.setDob(rs.getString("dob"));
            passenger.setGender(rs.getString("gender"));
			passenger.setAddress(rs.getString("address"));
			passengers.add(passenger);
			
		}
		return passengers;
	}
}
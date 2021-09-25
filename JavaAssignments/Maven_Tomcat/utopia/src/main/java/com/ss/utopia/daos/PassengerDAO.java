package com.ss.utopia.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.models.Passenger;

public class PassengerDAO extends BaseDAO<Passenger> {

	public PassengerDAO(Connection conn) {
		super(conn);
	}

	public void addPassenger(Passenger passenger) throws ClassNotFoundException, SQLException {
		save("INSERT INTO passenger (booking_id, given_name, family_name, dob, gender, address ) VALUES (?, ?, ?, ?, ?, ?)", new Object[] {
            passenger.getBookingId().getBookingId(),
            passenger.getGivenName(),
            passenger.getFamilyName(),
            passenger.getDob(),
            passenger.getGender(),
            passenger.getAddress()
			});
	}

	public void updatePassenger(Passenger passenger) throws ClassNotFoundException, SQLException {
		save("UPDATE passenger set address = ? WHERE id = ?", new Object[] { 
			passenger.getAddress(),
            passenger.getPassengerId()
		});
	}

	public void deletePassenger(Passenger passenger) throws ClassNotFoundException, SQLException {
		save("DELETE from passenger where id = ?", new Object[] { 
			passenger.getPassengerId()
		});
	}

	public List<Passenger> readPassengers() throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM passenger", null);
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
            passenger.getBookingId().setBookingId(rs.getInt("booking_id"));
            passenger.setGivenName(rs.getString("given_name"));
            passenger.setFamilyName(rs.getString("family_name"));
            passenger.setDob(rs.getString("dob"));
            passenger.setGender(rs.getString("gender"));
			passengers.add(passenger);
		}
		return passengers;
	}
}
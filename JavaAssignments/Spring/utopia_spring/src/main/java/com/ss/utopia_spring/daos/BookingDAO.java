package com.ss.utopia_spring.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia_spring.models.Booking;

public class BookingDAO extends BaseDAO<Booking> {

	public BookingDAO(Connection conn) {
		super(conn);
	}

	public void addBooking(Integer isActive, String confirmationCode) throws ClassNotFoundException, SQLException {
		save("INSERT INTO booking (is_active, confirmation_code) VALUES (?, ?)", new Object[] {
			isActive, confirmationCode });
	}

	public void updateBooking(Integer bookingId, Integer isActive) throws ClassNotFoundException, SQLException {
		save("UPDATE booking SET is_active = ? WHERE id = ?",
				new Object[] { isActive, bookingId }); 
	}

	public void deleteBooking(Integer bookingId) throws ClassNotFoundException, SQLException {
		save("DELETE from booking where id = ?", new Object[] { bookingId });
	}

	public List<Booking> readBookings() throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM booking limit 10", new Object[] {});
	}
	
	public List<Booking> readBookingsById(Integer bookingId) throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM booking WHERE id = ? ", 
						new Object[] { bookingId  });
	}

	@Override
	public List<Booking> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Booking> bookings = new ArrayList<>();
		while (rs.next()) {
			Booking booking = new Booking();
			booking.setBookingId(rs.getInt("id"));
			booking.setIsActive(rs.getInt("is_active"));
			booking.setConfirmationCode(rs.getString("confirmation_code"));
			bookings.add(booking);
		}
		return bookings;
	}
}
package com.ss.utopia_spring.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia_spring.models.BookingGuest;

public class BookingGuestDAO extends BaseDAO<BookingGuest> {

	public BookingGuestDAO(Connection conn) {
		super(conn);
	}

	public void addBooking(BookingGuest booking_guest) throws ClassNotFoundException, SQLException {
		save("INSERT INTO booking_guest (booking_id, contact_email, contact_phone) VALUES (?, ?,?)", new Object[] {
			booking_guest.getBookingId().getBookingId(), 
			booking_guest.getContactEmail(), 
			booking_guest.getContactPhone()
			});
	}

	public void updateBooking(BookingGuest booking_guest) throws ClassNotFoundException, SQLException {
		save("UPDATE booking_guest SET contact_email, contact_phone WHERE booking_id = ?",
			new Object[] {  
				booking_guest.getContactEmail(),
				booking_guest.getContactPhone(),
				booking_guest.getBookingId().getBookingId()
			}); 
	}

	public void deleteBooking(BookingGuest booking_guest) throws ClassNotFoundException, SQLException {
		save("DELETE from booking_guest where booking_id = ?", new Object[] { 
			booking_guest.getBookingId().getBookingId()

		});
	}

	public List<BookingGuest> readBookingGuests() throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM booking_guest", null);
	}
	
	public List<BookingGuest> readBookingGuestsById(String bookingGuestId) throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM booking_guest WHERE booking_id = ? ", new Object[] { 
			bookingGuestId  
		});
	}

	@Override
	public List<BookingGuest> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<BookingGuest> bookingGuests = new ArrayList<>();
		while (rs.next()) {
			BookingGuest booking_guest = new BookingGuest();
			booking_guest.getBookingId().setBookingId(rs.getInt("booking_id"));
			booking_guest.setContactEmail(rs.getString("contact_email"));
			booking_guest.setContactPhone(rs.getString("contact_phone"));

			bookingGuests.add(booking_guest);
		}
		return bookingGuests;
	}
}
package com.ss.utopia.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.models.BookingUser;

public class BookingUserDAO extends BaseDAO<BookingUser> {

	public BookingUserDAO(Connection conn) {
		super(conn);
	}

    
	public void addBookingUser(BookingUser booking_user) throws ClassNotFoundException, SQLException {
		save("INSERT INTO booking_user (booking_id, user_id) VALUES (?, ?)", 
		new Object[] {
			booking_user.getBookingId().getBookingId(),
			booking_user.getUserId().getUserId()
		});
	}

	public void updateBookingUser(BookingUser booking_user) throws ClassNotFoundException, SQLException {
		save("UPDATE booking_user set user_id  =  ? WHERE booking_id = ?",
				new Object[] {
					booking_user.getUserId(),
					booking_user.getBookingId()
				});
	}

	public void deleteBookingUser(BookingUser booking_user) throws ClassNotFoundException, SQLException {
		save("DELETE from booking_user where booking_id = ?", new Object[] { 
			booking_user.getBookingId()
		});
	}

	public List<BookingUser> readBookingUser() throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM booking_user", null);
	}
	
	public List<BookingUser> readBookingUserById(String bookingId) throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM booking_user WHERE booking_id = ?", 
						new Object[] { bookingId });
	}

	@Override
	public List<BookingUser> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<BookingUser> booking_users = new ArrayList<>();
		while (rs.next()) {
			BookingUser booking_user = new BookingUser();
			booking_user.getBookingId().setBookingId(rs.getInt("booking_id"));
			booking_user.getUserId().setUserId(rs.getInt("user_id"));

			booking_users.add(booking_user);
		}
		return booking_users;
	}
}
package com.ss.utopia_spring.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia_spring.models.BookingPayment;

public class BookingPaymentDAO extends BaseDAO<BookingPayment> {

	public BookingPaymentDAO(Connection conn) {
		super(conn);
	}

    
	public void addRoute(BookingPayment booking_payment) throws ClassNotFoundException, SQLException {
		save("INSERT INTO booking_payment (booking_id, stripe_id, refunded) VALUES (?, ?)", 
		new Object[] {
			booking_payment.getBookingId().getBookingId(),
			booking_payment.getStripeId(),
			booking_payment.getRefunded()
		});
	}

	public void updateRoute(BookingPayment booking_payment) throws ClassNotFoundException, SQLException {
		save("UPDATE booking_payment set refunded =  ? where stripe_id = ?",
				new Object[] {
					booking_payment.getRefunded(), 
					booking_payment.getStripeId() 
				});
	}

	public void deleteRoute(BookingPayment booking_payment) throws ClassNotFoundException, SQLException {
		save("DELETE from booking_payment where booking_id = ?", new Object[] { 
			booking_payment.getBookingId().getBookingId()
		});
	}

	public List<BookingPayment> readBookingPayments() throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM booking_payment", null);
	}
	
	public List<BookingPayment> readBookingPaymentsById(String bookingId) throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM booking_payment WHERE booking_id = ?", 
						new Object[] { bookingId });
	}

	@Override
	public List<BookingPayment> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<BookingPayment> bookingPayments = new ArrayList<>();
		while (rs.next()) {
			BookingPayment booking_payment = new BookingPayment();
			booking_payment.getBookingId().setBookingId(rs.getInt("booking_id"));
			booking_payment.setRefunded(rs.getInt("refunded"));
			booking_payment.setStripeId(rs.getString("stripe_id"));

			bookingPayments.add(booking_payment);
		}
		return bookingPayments;
	}
}
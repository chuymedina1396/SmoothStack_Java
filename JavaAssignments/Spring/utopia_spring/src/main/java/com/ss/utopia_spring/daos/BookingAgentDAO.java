package com.ss.utopia_spring.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia_spring.models.BookingAgent;

public class BookingAgentDAO extends BaseDAO<BookingAgent> {

	public BookingAgentDAO(Connection conn) {
		super(conn);
	}

	public void addBookingAgent(BookingAgent bookingAgent) throws ClassNotFoundException, SQLException {
		save("INSERT INTO booking_agent (booking_id, agent_id) VALUES (?, ?)", new Object[] { 
			bookingAgent.getBookingId().getBookingId(), bookingAgent.getAgentId().getUserId()
		});
	}

	public void updateBookingAgent(BookingAgent bookingAgent) throws ClassNotFoundException, SQLException {
		save("UPDATE booking_agent SET agent_id = ? WHERE booking_id = ?",
				new Object[] { bookingAgent.getAgentId().getUserId(), bookingAgent.getBookingId().getBookingId() });
	}

	public void deleteBookingAgent(BookingAgent bookingAgent) throws ClassNotFoundException, SQLException {
		save("DELETE from booking_agent where id = ?", new Object[] { bookingAgent.getAgentId().getUserId() });
	}

	public List<BookingAgent> readBookingAgents() throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM booking_agent", null);
	}
	
	public List<BookingAgent> readBookingAgentsById(String bookingAgent) throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM booking_agent WHERE agent_id = ?", 
						new Object[] { bookingAgent });
	}

	@Override
	public List<BookingAgent> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<BookingAgent> bookingAgents = new ArrayList<>();
		while (rs.next()) {
			BookingAgent bookingAgent = new BookingAgent();
			// Getting the Id, then setting the id to be that of the booking_id from the booking table
			bookingAgent.getBookingId().setBookingId(rs.getInt("booking_id"));
			bookingAgent.getAgentId().setUserId(rs.getInt("user_id"));
			bookingAgents.add(bookingAgent);
		}
		return bookingAgents;
	}
}
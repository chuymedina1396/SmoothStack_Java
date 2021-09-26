package com.ss.utopia.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.models.Airport;

public class AirportDAO extends BaseDAO<Airport> {

	public AirportDAO(Connection conn) {
		super(conn);
	}

	public void addAirport(Airport airport) throws ClassNotFoundException, SQLException {
		save("INSERT INTO airport (iata_id, city) VALUES (?, ?)", new Object[] {
				airport.getAirportCode(), 
				airport.getCity()
			});
	}

	public void updateAirport(String aiportCode, String city) throws ClassNotFoundException, SQLException {
		save("UPDATE airport set city = ? where iata_ids = ?", new Object[] { 
			city, 
			aiportCode 
		});
	}

	public void deleteAirport(String airportCode) throws ClassNotFoundException, SQLException {
		save("DELETE from airport where id = ?", new Object[] { airportCode });
	}

	public List<Airport> readAirports() throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM airport", new Object[] {});
	}
	
	public List<Airport> readAirportsByAirportCode(String airportCode) throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM airport WHERE iata_id = ?", 
						new Object[] { airportCode });
	}

	@Override
	public List<Airport> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Airport> airports = new ArrayList<>();
		while (rs.next()) {
			Airport airport = new Airport();
			airport.setAirportCode((rs.getString("iata_id")));
			airport.setCity(rs.getString("city"));
			airports.add(airport);
		}
		return airports;
	}
}
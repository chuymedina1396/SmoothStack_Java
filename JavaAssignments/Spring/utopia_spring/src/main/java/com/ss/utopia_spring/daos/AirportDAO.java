package com.ss.utopia_spring.daos;

import com.ss.utopia_spring.entities.Airport;

import org.springframework.stereotype.Component;


@Component
public class AirportDAO  {

	// public AirportDAO(Connection conn) {
	// 	super(conn);
	// }

	public Airport getAiportByCode(String airportCode){
        Airport airport = new Airport();
        airport.setAirportCode(airportCode);
        // airport.setCity("Airport City: " + authorId);
        return airport;
    }

    public Airport addAirport(Airport airport){
        Airport newAirport = new Airport();
        newAirport.setAirportCode(airport.getAirportCode());
        newAirport.setCity(airport.getCity());
        return newAirport;
    }

	// public void addAirport(Airport airport) throws ClassNotFoundException, SQLException {
	// 	save("INSERT INTO airport (iata_id, city) VALUES (?, ?)", new Object[] {
	// 			airport.getAirportCode(),
	// 			airport.getCity()
	// 		});
	// }

	// public List<Airport> readAirportsByAirportCode(String airportCode) throws ClassNotFoundException, SQLException {
	// 	return read("SELECT * FROM airport WHERE iata_id = ?", new Object[] { 
	// 		airportCode
	// 	});
	// }

	// @Override
	// public List<Airport> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
	// 	List<Airport> airports = new ArrayList<>();
	// 	while (rs.next()) {
	// 		Airport airport = new Airport();
	// 		airport.setAirportCode((rs.getString("iata_id")));
	// 		airport.setCity(rs.getString("city"));
	// 		airports.add(airport);
	// 	}
	// 	return airports;
	// }

	// public void updateAirport(String aiportCode, String city) throws ClassNotFoundException, SQLException {
	// 	save("UPDATE airport set city = ? where iata_id = ?", new Object[] { 
	// 		city, 
	// 		aiportCode 
	// 	});
	// }

	// public void deleteAirport(String airportCode) throws ClassNotFoundException, SQLException {
	// 	save("DELETE from airport where iata_id = ?", new Object[] { airportCode });
	// }

	// public List<Airport> readAirports() throws ClassNotFoundException, SQLException {
	// 	return read("SELECT * FROM airport", new Object[] {});
	// }
}
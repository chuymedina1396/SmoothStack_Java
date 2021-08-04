package com.utopia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import com.utopia.domain.Airport;

public class AirportDAO extends BaseDAO<Airport> {

    public AirportDAO(Connection conn){
        super(conn);
    }
    public void addAirport(Airport airport){
        save("INSERT into airport VALUES(?,?)", new Object[] { airport.getAirportCode(), airport.getCity() } );

    }
    public void updateAirport(Airport airport){
        save("UPDATE airport SET city = ? WHERE airportCode = ?", new Object[] {airport.getAirportCode(), airport.getCity() } );
    }
    public void deleteAirport(Airport airport){
        save("DELETE airport WHERE airportCode = ?", new Object[] { airport.getAirportCode()});
    }
    public List<Airport> readAllAirports() throws ClassNotFoundException, SQLException {
        return read("SELECT * FROM airport", null);
   
    }
    public List<Airport> readAirportsByCityName() throws ClassNotFoundException, SQLException {
        cityName = "%" + cityName + "%";
        return read("SELECT * FROM airport WHERE city like ?", new Object[] {cityName});
   
    }
    public List<Airport> extractData(ResultSet rs){
        List<Airport> airports = new ArrayList<>();
		while(rs.next()) {
            Airport a = new Airport();
            a.setAirportCode(rs.getString("iata_id"));
            a.setCity(rs.getString("city"));
            airports.add(a);

		}
        return airports;
    }
}
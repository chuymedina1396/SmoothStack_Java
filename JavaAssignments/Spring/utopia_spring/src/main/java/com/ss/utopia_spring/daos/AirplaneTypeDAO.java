package com.ss.utopia_spring.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia_spring.models.AirplaneType;

public class AirplaneTypeDAO extends BaseDAO<AirplaneType> {

	public AirplaneTypeDAO(Connection conn) {
		super(conn);
	}

	public void addAirplaneType(AirplaneType airplaneType) throws ClassNotFoundException, SQLException {
		save("INSERT INTO airplane_type (max_capacity) VALUES (?)", new Object[] {
				airplaneType.getMaxCapacity() });
	}

	public void updateAirplaneType(AirplaneType airplaneType) throws ClassNotFoundException, SQLException {
		save("UPDATE airplane_type set max_capacity = ? where id = ?",
				new Object[] { airplaneType.getMaxCapacity(), airplaneType.getAirplaneTypeId() });
	}

	public void deleteAirplaneType(AirplaneType airplaneType) throws ClassNotFoundException, SQLException {
		save("DELETE from airplane_type where id = ?", new Object[] { airplaneType.getAirplaneTypeId() });
	}

	public List<AirplaneType> readAirplaneTypes() throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM airplane_type", null);
	}
	
	public List<AirplaneType> readAirplaneTypesById(String airplaneTypeId) throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM airplane_type WHERE id = ?", 
						new Object[] { airplaneTypeId });
	}

	@Override
	public List<AirplaneType> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<AirplaneType> airplaneTypes = new ArrayList<>();
		while (rs.next()) {
			AirplaneType airplaneType = new AirplaneType();
			airplaneType.setAirplaneTypeId(rs.getInt("id"));
			airplaneType.setMaxCapacity(rs.getInt("max_capacity"));
			airplaneTypes.add(airplaneType);
		}
		return airplaneTypes;
	}
}
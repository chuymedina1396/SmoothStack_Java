package com.ss.utopia.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.models.Airplane;

public class AirplaneDAO extends BaseDAO<Airplane> {

	public AirplaneDAO(Connection conn) {
		super(conn);
	}

	public void addAirplane(Airplane airplane) throws ClassNotFoundException, SQLException {
		save("INSERT INTO airplane (type_id) VALUES (?)", new Object[] {
				airplane.getAirplaneTypeId() });
	}

	public void updateAirplane(Airplane airplane) throws ClassNotFoundException, SQLException {
		save("UPDATE airplane Set type_id = ? where id = ?",
				new Object[] {airplane.getAirplaneTypeId() });
	}

	public void deleteAirplane(Airplane airplane) throws ClassNotFoundException, SQLException {
		save("DELETE from airplane where id = ?", new Object[] { airplane.getAirplaneId() });
	}

	public List<Airplane> readAirplanes() throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM airplane", null);
	}
	
	public List<Airplane> readAirplanesById(String airplaneId) throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM airplane WHERE id = ?", 
						new Object[] { airplaneId });
	}

	@Override
	public List<Airplane> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Airplane> airplanes = new ArrayList<>();
		while (rs.next()) {
			Airplane airplane = new Airplane();
			airplane.setAirplaneId(rs.getInt("id"));
			airplane.getAirplaneTypeId().setAirplaneTypeId(rs.getInt("id"));
			airplanes.add(airplane);
		}
		return airplanes;
	}
}
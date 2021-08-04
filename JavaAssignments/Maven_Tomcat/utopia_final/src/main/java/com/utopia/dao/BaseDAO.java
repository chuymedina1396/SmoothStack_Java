package com.utopia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class BaseDAO<T> {

	public static Connection conn = null; // Passing a connection to all DAOs that inherit.

	public BaseDAO(Connection conn) {
		this.conn = conn; // forces anyone using the BaseDAO to have a connection object. 
	}

	public void save(String sql, Object[] vals) throws ClassNotFoundException, SQLException { // generic object added
		PreparedStatement pstmt = getConnection().prepareStatement(sql);
		int count =1; // things start at one in the database world.
		if(vals!=null){
			for(Object o: vals){
				pstmt.setObject(count, o);
				count++;
			}
		}
		pstmt.executeUpdate();
	}

	public List<T> read(String sql, Object[] vals) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = getConnection().prepareStatement(sql);
		int count =1; // things start at one in the database world.
		if(vals!=null){
			for(Object o: vals){
				pstmt.setObject(count, o);
				count++;
			}
		}
		ResultSet rs = pstmt.executeQuery();
		return extractData(rs);

	}
	abstract public List<T> extractData(ResultSet rs) throws ClassNotFoundException, SQLException;
}


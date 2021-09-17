package com.utopia.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    
    public  final String driver = "com.mysql.cj.jdbc.Driver";
	public  final String url = "jdbc:mysql://localhost:3306/utopia?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	public  final String user = "root";
	public  final String password = "root";

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		// Register Driver.
		Class.forName(driver);
		
		// Create a connection
		Connection conn = DriverManager.getConnection(url, user, password);
		// If a connection is in autocommit mode, then all its SQL statements are run and committed as individual transactions. Otherwise, its SQL statements are grouped into transactions that are ended by a call to either the commit method or the rollback method. By default, new connections are in autocommit mode.s
		conn.setAutoCommit(Boolean.FALSE); // soft commit 
        return conn;
    }
}
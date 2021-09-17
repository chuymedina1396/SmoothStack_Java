package com.ss.library.service;

// import java.io.FileInputStream;
// import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
// import java.util.Properties;

public class ConnectionUtil {

	public final String driver = "com.mysql.cj.jdbc.Driver";
    public final String url = "jdbc:mysql://localhost:3306/library?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public final String user = "root";
    public final String password = "root";

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url,user, password);
		conn.setAutoCommit(Boolean.FALSE);
		return conn;
	}

	// public static String getProperty(String propName) {
	// 	try (InputStream is = new FileInputStream("resources/db.properties")) {
	// 		Properties dbProp = new Properties();
	// 		dbProp.load(is);
	// 		return dbProp.getProperty(propName);
	// 	} catch (IOException e) {
	// 		e.printStackTrace();
	// 	}
	// 	return null;

	// }
}

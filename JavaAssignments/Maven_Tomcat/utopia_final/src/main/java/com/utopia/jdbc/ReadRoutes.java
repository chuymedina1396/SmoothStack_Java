package com.utopia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ReadRoutes {

	public static final String driver = "com.mysql.cj.jdbc.Driver";
	public static final String url = "jdbc:mysql://localhost:3306/utopia?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	public static final String user = "root";
	public static final String password = "root";

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Register Driver.
		Class.forName(driver);
		
		// Create a connection
		Connection conn = DriverManager.getConnection(url, user, password);
		
		//Statement
		Statement stmt = conn.createStatement();
		
		// Can define all sql queries for assignment and save them to variables to be invoked later on during menu selections????
		// PreparedStatement anotherPSTMT = conn.prepareStatement("select * from route "
		// 		+ "where origin_id= ? OR destination_id = ?");
		PreparedStatement pstmt = conn.prepareStatement("select * from route "
				+ "where origin_id= ? OR destination_id = ?");
		
		//Execute

		// Scanner scan = new Scanner(System.in);
		// System.out.println("Welcome to the Utopia Airlines Management System. Which category of a user are you");
		// // if admin -> admin console.
		// String originId = scan.nextLine()
		// pstmt.setString(1, originId);
		// pstmt.setString(2, originId);
		// scan.close();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Origin Id to search");
		String originId = scan.nextLine();
		pstmt.setString(1, originId);
		pstmt.setString(2, originId);
		scan.close();
		
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			System.out.println("Route ID: "+rs.getInt("id"));
			System.out.println("Origin ID:"+rs.getString("origin_id"));
			System.out.println("Dest ID:"+rs.getString("destination_id"));
		}

	}

}

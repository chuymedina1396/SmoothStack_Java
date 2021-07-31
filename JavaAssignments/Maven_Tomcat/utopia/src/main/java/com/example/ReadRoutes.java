package com.example;

import java.beans.Statement;
import java.sql.Connection;
import java.util.Scanner;

public class ReadRoutes {
    public static final String driver = "com.mysql.jdbc.Driver";
    public static final String url ="";
    public static final String username="";
    public static final String password = "";

    public static void main(String[] args) {
        Class.forName(driver);

        Connection conn = DriverManager.getConnection(url, user, password);

        //Statment Object
        // Statement for running queries
        Statement stmt = conn.createStatement();
        PreparedStatment pStmt = conn.prepareStatement("select * from route where origin_id= ?");


        Scanner scan = new Scanner(System.in);
        System.out.orintln("Enter Origin ID to search");
        String originId = scan.nextLine();
        // String sql ="'select * from route where origin_id='"+originId+"'";
        pStmt.setString(1,originId);

        // Dont need ResultSet can just execute.
        ResultSet rs = pStmt.executeQuery();
        while(rs.next()) {
            System.out.println("Route ID" + rs.getInt("id"));
            System.out.println("Origin ID" + rs.getString("origin_id"));
            System.out.println("Dest ID" + rs.getString("destination_id"));
        }

        // DO Admin first, most important



    }
}
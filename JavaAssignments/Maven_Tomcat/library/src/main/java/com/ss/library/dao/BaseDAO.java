package com.ss.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.List;

public abstract class BaseDAO<T> {

    protected Connection conn = null;

    // Constructor forces any class that inherts from the base to have a connection.
    public BaseDAO(Connection conn){
        this.conn = conn;
    }

    public void save(String sql, Object[] vals ) throws ClassNotFoundException, SQLException {
        PreparedStatement pstmt = conn.prepareStatement(sql);
        int count =1;
        for(Object o : vals){
            pstmt.setObject(count,o);
            count++;
        }
        pstmt.executeUpdate();
    }

    public Integer saveReturnPK(String sql, Object[] vals ) throws ClassNotFoundException, SQLException {
        PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        int count =1;
        for(Object o : vals){
            pstmt.setObject(count,o);
            count++;
        }
        pstmt.executeUpdate();
        ResultSet rs = pstmt.getGeneratedKeys(); // try this to get the generated primary keys if you need them. Most likely for joins.
        while(rs.next()){
            return rs.getInt(1); // try 0 if it throws an error
        }
        return null;
    }

    public List<T> read(String sql, Object[] vals ) throws ClassNotFoundException, SQLException{
        PreparedStatement pstmt = conn.prepareStatement(sql);
        int count = 1;
        for(Object o : vals){
            pstmt.setObject(count,o);
            count++;
        }
        ResultSet rs = pstmt.executeQuery();
        return extractData(rs);
    }

    abstract public List<T> extractData(ResultSet rs) throws ClassNotFoundException, SQLException;


}

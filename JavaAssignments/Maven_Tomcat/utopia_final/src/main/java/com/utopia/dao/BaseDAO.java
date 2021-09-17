package com.utopia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.sql.DriverManager;

// A Generic Version of the Box Class

//https://docs.oracle.com/javase/tutorial/java/generics/types.html documentation for generic classes
	// A generic class is defined with the following format:

	// class name<T1, T2, ..., Tn> { /* ... */ }
	// The type parameter section, delimited by angle brackets (<>), follows the class name. It specifies the type parameters (also called type variables) T1, T2, ..., and Tn.

	// To update the Box class to use generics, you create a generic type declaration by changing the code "public class Box" to "public class Box<T>". This introduces the type variable, T, that can be used anywhere inside the class.

	// With this change, the Box class becomes:

	// /**
	//  * Generic version of the Box class.
	//  * @param <T> the type of the value being boxed
	//  */
	// public class Box<T> {
	//     // T stands for "Type"
	//     private T t;

	//     public void set(T t) { this.t = t; }
	//     public T get() { return t; }
	// }
	// As you can see, all occurrences of Object are replaced by T. A type variable can be any non-primitive type you specify: any class type, any interface type, any array type, or even another type variable.

	// This same technique can be applied to create generic interfaces.

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


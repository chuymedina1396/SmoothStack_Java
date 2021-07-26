
// Assignment 6: Singleton
// Fix the below Singleton class:

// import java.math.BigDecimal;
// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.ResultSet;
// import java.sql.Statement;


// public static class SampleSingleton {

// 	private static Connection conn = null;
	
// 	private static SampleSingleton instance = null;
	
// 	public static SampleSingleton getInstance() {
// 		return instance;
// 	}
	
// }
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class WeekEndAssignmentSix {
    public static void main(String[] args){};
	private static Connection conn = null;
	
	private static volatile WeekEndAssignmentSix instance = null;
	
	public WeekEndAssignmentSix getInstance() {
        // implemented double check locking
        if(instance == null){
            synchronized(this){
                if(instance == null){
                    instance = new WeekEndAssignmentSix(); 
                }
            }
        }
        return instance;     
    }
}




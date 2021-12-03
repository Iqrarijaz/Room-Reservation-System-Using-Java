package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	 public class java {

	}

	final static String url = "jdbc:mysql:///reservation";
     final static String user = "root";
     final static String password = "root";
     // establish the connection
    
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		  Class.forName("com.mysql.cj.jdbc.Driver");

	      // variables
	     
		  Connection con = DriverManager.getConnection(url, user, password);
	      // display status message
	      if (con == null) {
	         System.out.println("JDBC connection is not established");
	         return con;
	      } else
	         System.out.println("");
		return con;
	}
}

package database;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class VacanccyInformation {

	static void getvacanncy(int buildingId) {
		String tableName = null;
		try {
			if (buildingId == 1) {
				tableName = "engineering";
			} else if (buildingId == 2) {
				tableName = "mainBuilding";
			} else if (buildingId == 3) {
				tableName = "library";
			} else if (buildingId == 4) {
				tableName = "business";
			} else if (buildingId == 5) {
				tableName = "architecture";
			} else {
				System.out.println("Invalid Input");
			}
			 Connection conn = DatabaseConnection.getConnection();
		     //Creating a Statement object
		     Statement stmt = conn.createStatement();
		     //Retrieving the data
		     ResultSet rs = stmt.executeQuery("select *from " +tableName+"");
		     while(rs.next()) {
		    	 
		    	  System.out.print( "Room Name : "+rs.getString("roomName").toString()+" , Room Id :"+ rs.getString("id")+" ,Reserve Status: "+rs.getString("reserve").toString());
		    	  
		        
		     }
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
  }

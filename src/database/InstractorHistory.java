package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InstractorHistory {
	static RoomReservationSystem roomReservationSystem =new RoomReservationSystem();
	public static void InstractorData() throws Exception
	{
		Connection con = DatabaseConnection.getConnection();
		// Creating a Statement object
		Statement stmt = con.createStatement();
		// Retrieving the data
		ResultSet rs = stmt.executeQuery("select *from instractor");
		System.out.print("Instractor History \n");
		while (rs.next()) {
			String instractorName=rs.getString("NAME").toString();
			String instractorEmail=rs.getString("Email").toString();
			String instractorAddress=rs.getString("ADDRESS").toString();
				System.out.print("Instractor Id   : " + rs.getInt("ID") + "\n");
				System.out.print("Instractor Name : " + rs.getString("NAME").toString() + "\n");
				System.out.print("Address         : " + rs.getString("ADDRESS").toString() + "\n");
				System.out.print("Email           : " + rs.getString("Email").toString() + "\n\n");
		
			} 
		roomReservationSystem.Menu();
	}
}

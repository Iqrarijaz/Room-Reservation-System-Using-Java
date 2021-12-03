package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RoomHistory {
	static RoomReservationSystem roomReservationSystem =new RoomReservationSystem();
	static void ReservedRoomHistory() throws Exception {
		// TODO Auto-generated method stub
		Connection con = DatabaseConnection.getConnection();
		// Creating a Statement object
		Statement stmt = con.createStatement();
		// Retrieving the data
		ResultSet rs = stmt.executeQuery("select * from engineering");
		while (rs.next()) {
			String reserveStatus = rs.getString("reserve");
			String value = "yes";

			boolean values = reserveStatus.equals(value);
			if (values == true) {
				PreparedStatement create = con.prepareStatement(
						"CREATE TABLE IF NOT EXISTS reservationHistory ( roomid integer,buildingId integer, roomName text NOT NULL,property text NOT NULL)");
				Statement s = con.createStatement();
				s.executeUpdate("INSERT INTO `reservationHistory`(roomid,buildingId,roomName,property) VALUE ('"
						+ rs.getString("id").toString() + "','" + rs.getString("buildingId").toString() + "','"
						+ rs.getString("roomName").toString() + "','" + rs.getString("property").toString() + "')");
				create.executeUpdate();
			} else {
				System.out.print("dont");
			}

		}
		
		
		
		 con = DatabaseConnection.getConnection();
		// Creating a Statement object
		 stmt = con.createStatement();
		// Retrieving the data
		 rs = stmt.executeQuery("select * from mainBuilding");
		while (rs.next()) {
			String reserveStatus = rs.getString("reserve");
			String value = "yes";

			boolean values = reserveStatus.equals(value);
			if (values == true) {
				PreparedStatement create = con.prepareStatement(
						"CREATE TABLE IF NOT EXISTS reservationHistory ( roomid integer,buildingId integer, roomName text NOT NULL,property text NOT NULL)");
				Statement s = con.createStatement();
				s.executeUpdate("INSERT INTO `reservationHistory`(roomid,buildingId,roomName,property) VALUE ('"
						+ rs.getString("id").toString() + "','" + rs.getString("buildingId").toString() + "','"
						+ rs.getString("roomName").toString() + "','" + rs.getString("property").toString() + "')");
				create.executeUpdate();
			} else {
				System.out.print("dont");
			}

		}
		
		
		
		
		 con = DatabaseConnection.getConnection();
			// Creating a Statement object
			 stmt = con.createStatement();
			// Retrieving the data
			 rs = stmt.executeQuery("select * from library");
			while (rs.next()) {
				String reserveStatus = rs.getString("reserve");
				String value = "yes";

				boolean values = reserveStatus.equals(value);
				if (values == true) {
					PreparedStatement create = con.prepareStatement(
							"CREATE TABLE IF NOT EXISTS reservationHistory ( roomid integer,buildingId integer, roomName text NOT NULL,property text NOT NULL)");
					Statement s = con.createStatement();
					s.executeUpdate("INSERT INTO `reservationHistory`(roomid,buildingId,roomName,property) VALUE ('"
							+ rs.getString("id").toString() + "','" + rs.getString("buildingId").toString() + "','"
							+ rs.getString("roomName").toString() + "','" + rs.getString("property").toString() + "')");
					create.executeUpdate();
				} else {
					System.out.print("dont");
				}

			}
			
			
			 con = DatabaseConnection.getConnection();
				// Creating a Statement object
				 stmt = con.createStatement();
				// Retrieving the data
				 rs = stmt.executeQuery("select * from business");
				while (rs.next()) {
					String reserveStatus = rs.getString("reserve");
					String value = "yes";

					boolean values = reserveStatus.equals(value);
					if (values == true) {
						PreparedStatement create = con.prepareStatement(
								"CREATE TABLE IF NOT EXISTS reservationHistory ( roomid integer,buildingId integer, roomName text NOT NULL,property text NOT NULL)");
						Statement s = con.createStatement();
						s.executeUpdate("INSERT INTO `reservationHistory`(roomid,buildingId,roomName,property) VALUE ('"
								+ rs.getString("id").toString() + "','" + rs.getString("buildingId").toString() + "','"
								+ rs.getString("roomName").toString() + "','" + rs.getString("property").toString() + "')");
						create.executeUpdate();
					} else {
						System.out.print("dont");
					}

				}
				
				 con = DatabaseConnection.getConnection();
					// Creating a Statement object
					 stmt = con.createStatement();
					// Retrieving the data
					 rs = stmt.executeQuery("select * from architecture");
					while (rs.next()) {
						String reserveStatus = rs.getString("reserve");
						String value = "yes";

						boolean values = reserveStatus.equals(value);
						if (values == true) {
							PreparedStatement create = con.prepareStatement(
									"CREATE TABLE IF NOT EXISTS reservationHistory ( roomid integer,buildingId integer, roomName text NOT NULL,property text NOT NULL)");
							Statement s = con.createStatement();
							s.executeUpdate("INSERT INTO `reservationHistory`(roomid,buildingId,roomName,property) VALUE ('"
									+ rs.getString("id").toString() + "','" + rs.getString("buildingId").toString() + "','"
									+ rs.getString("roomName").toString() + "','" + rs.getString("property").toString() + "')");
							create.executeUpdate();
						} else {
							System.out.print("dont");
						}

					}
		
					
					Connection conn = DatabaseConnection.getConnection();
					// Creating a Statement object
					 stmt = conn.createStatement();
					// Retrieving the data
					 rs = stmt.executeQuery("select * from reservationHistory ");
					 System.out.print(" Reservation History of a Room \n");
					while (rs.next()) {
					
							System.out.print("Room Id        : " + rs.getString("roomid").toString() + "\n");
							System.out.print("building Id    : " + rs.getString("buildingId").toString() + "\n");
							System.out.print("Room name      : " + rs.getString("roomName").toString() + "\n");
							System.out.print("Room Property  : " + rs.getString("property").toString() + "\n\n");
					
						} 
					roomReservationSystem.Menu();
	}
}

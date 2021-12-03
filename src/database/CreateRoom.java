package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class CreateRoom {
	static int ch;
	static String book_room;
	static // object of class
	RoomReservationSystem roomReservationSystem = new RoomReservationSystem();

	public static void CreateRoom() throws Exception {
		try {
			Connection con = DatabaseConnection.getConnection();
			Scanner scanner = new Scanner(System.in);
			System.out.println("1- Engineering\r\n" + "2- Main Building\r\n" + "3- Library\r\n" + "4- Business\r\n"
					+ "5- Architecture");
			{
				int builingId;
				System.out.print("Make your choice: ");
				ch = Integer.parseInt(scanner.nextLine());

				System.out.println("Room Name : ");
				String room_name = scanner.nextLine();

				System.out.println("Room Id : ");
				int room_id = Integer.parseInt(scanner.nextLine());

				System.out.println("Room Property : ");
				String room_property = scanner.nextLine();
				
				String decision="null";
			   
			    System.out.println("Want to reserve the room , 1: yes / 2: no ");
			    int reserveValue = scanner.nextInt();
			    if(reserveValue==1)
			    {
			    	decision="yes";
			    }
			    else if(reserveValue==2)
				    {
				    	decision="no";
				    }
			    else
			    {
			    	System.out.println("Invalid Input ");
			    }
				// reading user's choice
				switch (ch) {
				case 1: // to create room
					try {
						builingId = 1;
						PreparedStatement create = con.prepareStatement(
								"CREATE TABLE IF NOT EXISTS engineering ( id integer PRIMARY KEY,buildingId integer, roomName text NOT NULL,property text NOT NULL,reserve text NOT NULL )");
						Statement s = con.createStatement();
						s.executeUpdate("INSERT INTO `engineering`(id,buildingId,roomName,property,reserve) VALUE ('" + room_id+ "','" + builingId + "','" + room_name + "','" + room_property + "', '" + decision + "')");
						create.executeUpdate();
						// menu function call
						System.out.println("\n\n");
						roomReservationSystem.Menu();
					} catch (Exception e) {
						System.out.println(e);
					}

					break;

				case 2: // to create room
					try {
						builingId = 2;
						PreparedStatement create = con.prepareStatement(
								"CREATE TABLE IF NOT EXISTS mainBuilding ( id integer PRIMARY KEY,buildingId integer, roomName text NOT NULL,property text NOT NULL,reserve text NOT NULL )");
						Statement s = con.createStatement();
						s.executeUpdate("INSERT INTO `mainBuilding`(id,buildingId,roomName,property,reserve) VALUE ('" + room_id+ "','" + builingId + "','" + room_name + "','" + room_property + "', '" + decision + "')");
						create.executeUpdate();
						// menu function call
						
						roomReservationSystem.Menu();
					} catch (Exception e) {
						System.out.println(e);
					}
					break;

				case 3: // to create room
					try {
						builingId = 3;
						PreparedStatement create = con.prepareStatement(
								"CREATE TABLE IF NOT EXISTS library ( id integer PRIMARY KEY,buildingId integer, roomName text NOT NULL,property text NOT NULL,reserve text NOT NULL  )");
						Statement s = con.createStatement();
						s.executeUpdate("INSERT INTO `library`(id,buildingId,roomName,property,reserve) VALUE ('" + room_id
								+ "','" + builingId + "','" + room_name + "','" + room_property + "','" + decision + "')");
						create.executeUpdate();
						// menu function call
						roomReservationSystem.Menu();
						System.out.println("\n\n");
					} catch (Exception e) {
						System.out.println(e);
					}

					break;

				case 4: // to create room
					try {
						builingId = 4;
						PreparedStatement create = con.prepareStatement(
								"CREATE TABLE IF NOT EXISTS business ( id integer PRIMARY KEY,buildingId integer, roomName text NOT NULL,property text NOT NULL ,reserve text NOT NULL )");
						Statement s = con.createStatement();
						s.executeUpdate("INSERT INTO `business`(id,buildingId,roomName,property,reserve) VALUE ('" + room_id
								+ "','" + builingId + "','" + room_name + "','" + room_property + "', '" + decision + "')");
						create.executeUpdate();
						// menu function call
						System.out.println("\n\n");
						roomReservationSystem.Menu();
					} catch (Exception e) {
						System.out.println(e);
					}

					break;

				case 5: // to create room
					try {
						builingId = 5;
						PreparedStatement create = con.prepareStatement(
								"CREATE TABLE IF NOT EXISTS architecture  ( id integer PRIMARY KEY,buildingId integer, roomName text NOT NULL,property text NOT NULL,reserve text NOT NULL )");
						Statement s = con.createStatement();
						s.executeUpdate("INSERT INTO `architecture`(id,buildingId,roomName,property,reserve) VALUE ('" + room_id
								+ "','" + builingId + "','" + room_name + "','" + room_property + "','" + decision + "')");
						create.executeUpdate();
						// menu function call
						System.out.println("\n\n");
						roomReservationSystem.Menu();
					} catch (Exception e) {
						System.out.println(e);
					}
					break;

				default:
					System.out.println("Invalid choice! Please make a valid choice. \n\n");
				}
			}
			
		}
			
		 catch (Exception e) {
			System.out.println(e);
		}
		
	}
}

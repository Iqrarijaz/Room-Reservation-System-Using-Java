package database;

import java.util.Scanner;
import java.sql.*;

public class RoomReservationSystem {
	static int ch; // for storing user's choice
	public static String reserveBuilding;
	Scanner sc = new Scanner(System.in);
	static DatabaseConnection databaseConection = new DatabaseConnection();
	// obejct of class
	static CreateRoom createRoom = new CreateRoom();
	static RemoveRoom removeRoom = new RemoveRoom();
	static RoomHistory roomHistroy= new RoomHistory();
	static InstractorHistory instractorHistory=new InstractorHistory();
	static VacanccyInformation vacanccyinfo = new VacanccyInformation();

	public static void main(String[] args) throws Exception {
		// function for database connection
		// function for menu
		Menu();
	}

	public static void Menu() throws Exception {
		int ch; // for storing user's choice
		double ar; // for storing area
		int length, breadth, height, diagonal1, diagonal2;
		int side;
		int radius;
		Scanner sc = new Scanner(System.in); // creating object of Scanner class
		// displaying the menu
		System.out.println("1: Create Room");
		System.out.println("2: Remove Room");
		System.out.println("3: List all Rooms in a Building With Their Vacancy Information");
		System.out.println("4: Get Currently Occupied Rooms");
		System.out.println("5: Search For a Room");
		System.out.println("6: Get Reservation History of a Room");
		System.out.println("7: Get Reservation History of User");
		System.out.println("8: Reserve a Room");
		System.out.println("9: Leave a Room");

		{
			System.out.print("Make your choice: ");
			ch = sc.nextInt(); // reading user's choice
			switch (ch) {
			case 1: // to create room
				createRoom.CreateRoom();
				break;
			case 2:
				RemoveRoomFunctioncall();
				break;
			case 3:
				getVacanccyInformation();
				break;
			case 4:
				getOccupaiedRoom();
				break;
			case 5:
				SearchRoom();
				break;
			case 6:
				roomHistroy.ReservedRoomHistory();
				break;
			case 7:
				instractorHistory.InstractorData();
				break;
			case 8:
				ReserveRoom();
				break;
			case 9:
				LeaveRoom();
				break;
			default:
				System.out.println("Invalid choice! Please make a valid choice. \n\n");
			}
		}
	}

	


	static void getVacanccyInformation() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Building Id : ");
		int building_id = sc.nextInt();


		try {
			VacanccyInformation.getvacanncy(building_id);
			Menu();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void getOccupaiedRoom() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Building Id :");
		int buildingId = sc.nextInt();
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
			// Creating a Statement object
			Statement stmt = conn.createStatement();
			// Retrieving the data
			System.out.print("Booked Room in " + tableName + " building are \n");
			ResultSet rs = stmt.executeQuery("select *from " + tableName + "");
			while (rs.next()) {

				String checkRoom = rs.getString("reserve").toString();
				if (checkRoom != "no") {
					System.out.print("Room is Reserved");
					Menu();
				} else {

				}

				System.out.println("");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	static void RemoveRoomFunctioncall() throws Exception
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Building Id :");
		int buildingId = Integer.parseInt(sc.nextLine());
		System.out.print("Enter Room Id :");
		int roomid = Integer.parseInt(sc.nextLine());
		
		removeRoom.RemoveRoomfunction(roomid, buildingId);
	}
	static void SearchRoom() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Building Id :");
		int buildingId = Integer.parseInt(sc.nextLine());
		System.out.print("Enter Room Id to search  :");
		int roomId = Integer.parseInt(sc.nextLine());
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
			// Creating a Statement object
			Statement stmt = conn.createStatement();
			// Retrieving the data

			ResultSet rs = stmt.executeQuery("select * from " + tableName + " where id=" + roomId + "");
			while (rs.next()) {
				int id = Integer.parseInt(rs.getString("id"));
				if (buildingId == id) {
					System.out.print("Search Room is in " + tableName + " building \n");
					System.out.print("Room Id            : " + rs.getString("id").toString() + "\n");
					System.out.print("Room Name          : " + rs.getString("roomName").toString() + "\n");
					System.out.print("Reservation Status : " + rs.getString("reserve").toString() + "\n");
					System.out.println("");
					Menu();

				} else {
					System.out.print("Room not found ....");
					Menu();
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	static void ReserveRoom() {
		System.out.println("1- Engineering\r\n" + "2- Main Building\r\n" + "3- Library\r\n" + "4- Business\r\n"
				+ "5- Architecture");
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Building Id :");
		int buildingId = Integer.parseInt(sc.nextLine());
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
			reserveBuilding = tableName;
			Connection conn = DatabaseConnection.getConnection();
			// Creating a Statement object
			Statement stmt = conn.createStatement();
			// Retrieving the data
			ResultSet rs = stmt.executeQuery("select * from " + tableName);
			while (rs.next()) {
				String reserveStatus = rs.getString("reserve");
				String value = "yes";
				boolean values = reserveStatus.equals(value);
				if (values != true) {
					System.out.print("Available Rooms for booking in  " + tableName + " builing \n");
					System.out.print("Room Id            : " + rs.getString("id").toString() + "\n");
					System.out.print("Room Name          : " + rs.getString("roomName").toString() + "\n");
					System.out.print("Properties         : " + rs.getString("property").toString() + "\n");
					System.out.println("Want to register Room  1: yes / 2: no");

				} else {
					System.out.println("No Room Available for reservation ...");
					Menu();
				}
				boolean yn;
				int decision = (sc.nextInt());
				if (decision == 1) {
					BookRoom();
				} else if (decision == 2) {
					System.out.println("Room not registered ");
				}

			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	static void BookRoom() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Room Id to book  :");
		int roomId = Integer.parseInt(sc.nextLine());
		Connection conn = DatabaseConnection.getConnection();
		// Creating a Statement object
		Statement stmt = conn.createStatement();
		String query1 = "update " + reserveBuilding + " set reserve='yes' " + " where id=" + roomId;
		stmt.executeUpdate(query1);
		System.out.print("Your Reservation has been Made Successfully ");
		Menu();
	}

	static void LeaveRoom() throws SQLException, ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Building id  :");
		int buildingId = Integer.parseInt(sc.nextLine());
		String tableName = null;
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
		// Creating a Statement object
		Statement stmt = conn.createStatement();
		// Retrieving the data

		ResultSet rs = stmt.executeQuery("select * from " + tableName);
		while (rs.next()) {

			System.out.print("Room Id            : " + rs.getString("id").toString() + "\n");
			System.out.print("Room Name          : " + rs.getString("roomName").toString() + "\n");
			System.out.print("Properties         : " + rs.getString("property").toString() + "\n");

		}

		System.out.print("Enter Room Id you want to leave  :");
		int roomId = Integer.parseInt(sc.nextLine());
		try {
			conn = DatabaseConnection.getConnection();
			stmt = conn.createStatement();
			String query1 = "update " + tableName + " set reserve='no' " + " where id=" + roomId;
			stmt.executeUpdate(query1);
			System.out.println("You have left the Room");
			Menu();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}

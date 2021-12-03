package database;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class RemoveRoom {
	public static void RemoveRoomfunction(int tableId,int buildingId) throws Exception {
		String tableName = null;
		try {
			if (buildingId==1)
			{
				tableName="engineering";
			}
			else if (buildingId==2)
			{
				tableName="mainBuilding";
			}
			else if (buildingId==3)
			{
				tableName="library";
			}
			else if (buildingId==4)
			{
				tableName="business";
			}
			else if (buildingId==5)
			{
				tableName="architecture";
			}
			else {
				System.out.println("Invalid Input");
			}
			
			Connection con = DatabaseConnection.getConnection();
			PreparedStatement st = con.prepareStatement("DELETE FROM "+tableName+" WHERE id = " + tableId + ";");
	        st.executeUpdate();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	

}

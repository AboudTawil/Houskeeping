/**
 * 
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DBConnect;
import model.Room;

public class RoomsSQLiteDAO implements RoomsDAO{

	private Connection con = DBConnect.getInstance().getCon();
	
	@Override
	public List<Room> getAll() {

		List<Room> list = new ArrayList<>();
		try {
			
			Statement selectStatement = con.createStatement();  
			ResultSet rs=  selectStatement.executeQuery("SELECT * FROM rooms");
			while(rs.next()) {
				Room room = new Room();
				int index = rs.getInt("index");
				String roomId = rs.getString("roomId");
				int beds = rs.getInt("beds");
				int situation = rs.getInt("situation");
				int getLandery = rs.getInt("getLandery");
				int cleanRoom = rs.getInt("cleanRoom");
				int setLandery = rs.getInt("setLandery");
				int needTechnick = rs.getInt("needTechnick");
				String note = rs.getString("note");
				
				
			
				
				room.setId(index);
				room.setRoomId(roomId);
				room.setBeds(beds);
				room.setSituation(situation);
				room.setGetLandery(getLandery);
				room.setSetLandery(setLandery);
				room.setCleanRoom(cleanRoom);
				room.setNeedTechnick(needTechnick);
				room.setNote(note);
				
				list.add(room);
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}
		
	

	@Override
	public boolean update(Room room) {

				try {
					PreparedStatement updateStatement = con.prepareStatement("UPDATE rooms SET "
							+ "situation=? , "
							+ "getLandery = ?, "
							+ "cleanRoom = ?, "
							+"setLandery = ?, "
							+"needTechnick = ?   "
							+ "WHERE roomId like ? ");
					
					updateStatement.setInt(1,room.getSituation());
					updateStatement.setInt(2,room.getGetLandery());
					updateStatement.setInt(3,room.getCleanRoom());
					updateStatement.setInt(4,room.getSetLandery());
					updateStatement.setInt(5,room.getNeedTechnick());
					updateStatement.setString(6, room.getRoomId());
					
					updateStatement.executeUpdate();
					return updateStatement.getUpdateCount() == 1;
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		return false;
	}







}

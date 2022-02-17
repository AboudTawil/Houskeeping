/**
 * 
 */
package dao;

import java.util.List;

import model.Room;

public interface RoomsDAO {

	List<Room> getAll();
	
	boolean update(Room room);
}

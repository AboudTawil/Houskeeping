/**
 * 
 */
package MyLib;

import java.util.List;

import dao.RoomsSQLiteDAO;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import model.Room;

/**
 * @author Student
 *02.11.2021
 */
public class Mymethode {
	public static Paint getCircleColorBySituatuions(Room room) {
		Paint color =Color.BEIGE;
		int stuations =room.getSituation();
		switch (stuations) {
		case 0: color =Color.INDIANRED;
					break;
		case 5: color =Color.ROYALBLUE;
					break;
		case 10: color =Color.DARKOLIVEGREEN;
					break;
		}
		
		return color;
		
	}

	public static Room getRoomByRoomId(String roomId,List<Room> list) {

		for (Room r : list) {
			
			if(("c"+r.getRoomId()).equals(roomId))
			return r;
		}
		return null;
	}
	
	public static boolean  isTrueChkBox(int value) {
		if (value > 0 ) return true;
		return false;
		
	}
	
	public static int is25ValueSelectedchkBox(boolean b) {
		if(b == true)return 25;
		return 0;
	}
	
}

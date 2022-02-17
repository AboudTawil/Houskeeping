/**
 * 
 */
package model;

public class Room {
	private int index;
	private String roomId;
	private int beds ;
	private int situation;
	private int getLandery;
	private int cleanRoom;
	private int setLandery;
	private int needTechnick;
	private String note;
	
		
	public Room() {

	}
	
	// with index
	public Room(int index, String roomId, int beds, int situation, int getLandery, int cleanRoom, int setLandery,
			int needTechnick, String note) {
		super();
		this.index = index;
		this.roomId = roomId;
		this.beds = beds;
		this.situation = situation;
		this.getLandery = getLandery;
		this.cleanRoom = cleanRoom;
		this.setLandery = setLandery;
		this.needTechnick = needTechnick;
		this.note = note;
	}
	
	//with out index
	
	public Room(String roomId, int beds, int situation, int getLandery, int cleanRoom, int setLandery,
			int needTechnick, String note) {
		super();
		
		this.roomId = roomId;
		this.beds = beds;
		this.situation = situation;
		this.getLandery = getLandery;
		this.cleanRoom = cleanRoom;
		this.setLandery = setLandery;
		this.needTechnick = needTechnick;
		this.note = note;
	}
	public int getId() {
		return index;
	}
	public void setId(int index) {
		this.index = index;
	}
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public int getBeds() {
		return beds;
	}
	public void setBeds(int beds) {
		this.beds = beds;
	}
	public int getSituation() {
		return situation;
	}
	public void setSituation(int situation) {
		this.situation = situation;
	}
	public int getGetLandery() {
		return getLandery;
	}
	public void setGetLandery(int getLandery) {
		this.getLandery = getLandery;
	}
	public int getCleanRoom() {
		return cleanRoom;
	}
	public void setCleanRoom(int cleanRoom) {
		this.cleanRoom = cleanRoom;
	}
	public int getSetLandery() {
		return setLandery;
	}
	public void setSetLandery(int setLandery) {
		this.setLandery = setLandery;
	}
	public int getNeedTechnick() {
		return needTechnick;
	}
	public void setNeedTechnick(int needTechnick) {
		this.needTechnick = needTechnick;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "Room [id=" + index + ", roomId=" + roomId + ", beds=" + beds + ", situation=" + situation + ", getLandery="
				+ getLandery + ", cleanRoom=" + cleanRoom + ", setLandery=" + setLandery + ", needTechnick="
				+ needTechnick + ", note=" + note + "]";
	}
	
	
	

}

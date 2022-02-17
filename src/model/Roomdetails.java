/**
 * 
 */
package model;

/**
 * @author Student
 *04.11.2021
 */
public class Roomdetails {
		private String roomSitaution;
		private int oneBed;
		private int towBeds;
		private int threeBeds;
		private int fourBeds;
		private int sixBeds;
		private int total;
		
		
		
		
		public Roomdetails(String roomSitaution) {
			super();
			this.roomSitaution = roomSitaution;
		}
		public String getRoomSitaution() {
			return roomSitaution;
		}
		public void setRoomSitaution(String roomSitaution) {
			this.roomSitaution = roomSitaution;
		}
		public int getOneBed() {
			return oneBed;
		}
		public void setOneBed(int oneBed) {
			this.oneBed = oneBed;
		}
		public int getTowBeds() {
			return towBeds;
		}
		public void setTowBeds(int towBeds) {
			this.towBeds = towBeds;
		}
		public int getThreeBeds() {
			return threeBeds;
		}
		public void setThreeBeds(int threeBeds) {
			this.threeBeds = threeBeds;
		}
		public int getFourBeds() {
			return fourBeds;
		}
		public void setFourBeds(int fourBeds) {
			this.fourBeds = fourBeds;
		}
		public int getSixBeds() {
			return sixBeds;
		}
		public void setSixBeds(int sixBeds) {
			this.sixBeds = sixBeds;
		}
		public int getTotal() {
			return total;
		}
		public void setTotal(int total) {
			this.total = total;
		}
		
		
		
}

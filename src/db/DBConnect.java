package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBConnect {
	
	private static DBConnect instance = null;
	private Connection con;
	


	private  DBConnect() {
		
		try {
			
			// Class.forName("com.mysql.cj.jdbc.ConnectionImpl").newInstance();
			con = DriverManager.getConnection("jdbc:sqlite:./housekeeping.sqlite");
			
			System.out.println("DBConnect...Hotel Mangment.."+con);
		} catch (SQLException e) {
			
			System.err.println("keine DB-Connection!"+e);
			//e.printStackTrace();
			
		}
	}
	
	
	public static DBConnect getInstance() {
		
		if(instance== null) {
			
			instance = new  DBConnect();
		}
		
		return instance;
	}
	
	
	
	public Connection getCon() {
		return con;
	}
	

}

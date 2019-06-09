package main_game;

import java.sql.*;  
import java.util.*;

class datahand{  
	
	Connection conn;
	datahand(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}  
		try {
			conn=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/minigame","root","qwerty123");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}  
		
	}
	
public void insert(int score,String name){  
try{  
	
	System.out.println(score+name);


Calendar cal = Calendar.getInstance();
java.sql.Date date = new java.sql.Date(cal.getTime().getTime());

System.out.println(date);


String query = "Insert into score(name,high_score,date) values(?,?,?)";



PreparedStatement stmt = conn.prepareStatement(query);

stmt.setString(1, name);
stmt.setInt(2, score);
stmt.setDate(3, date);

System.out.println(query);

stmt.execute();
System.out.println("executed");
conn.close();  
}catch(Exception e){ System.out.println(e);}  
}  

public int return_high() {
	
	int _high = 0;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	String query = "select high_score from score where high_score = (select max(high_score) from score)";
	
	try {
		stmt = conn.prepareStatement(query);
	} catch (SQLException e) {

		e.printStackTrace();
	}
	try {
		rs =stmt.executeQuery();
	} catch (SQLException e) {

		e.printStackTrace();
	}
	
	try {
		while(rs.next()) {
			_high = (rs.getInt(1));
		}
	} catch (SQLException e) {

		e.printStackTrace();
	}
	
	return _high;
}

}  
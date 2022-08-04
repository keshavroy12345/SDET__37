package org.vtiger.Practices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import com.mysql.cj.jdbc.Driver;

public class JdbcConnectionTest {
	 	public static void main(String[] args) throws SQLException  {
	 		
	 		
			
	 		Driver driver = new Driver();
	 		Connection conn;
	 		
	 		DriverManager.registerDriver(driver);
	 		
	 		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tyss", "root",  "root");
	 		
	 		
	 		
	 		
	 		
	 		conn.createStatement().executeUpdate("insert into sdet36(empid, empName, phoneNumber, emailId, address) values('1004', 'keshav', '854403228', 'keshav.kumar@gmail.com', 'chennai');");
	 		System.out.println("data inserted");
	 		
	 		ResultSet result = conn.createStatement().executeQuery("select * from sdet36");
	 		
	 		while(result.next())
	 		{
	 			System.out.println(result.getInt(1)+" "+ result.getString(2)+" "+ result.getInt(3)+" "+ result.getString(4)+" "+result.getString(5));
	 		}
	 	}

}

package org.vtiger.Practices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class FetchTheJdbc {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
      // step-1 Registor / load the my Sql database
		
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		//step -2 get connection to database
		
	Connection	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tyss", "root", "root");
		
		//step -3 create sql connection
	   
	  Statement stat = con.createStatement();
	  String query = " select * from sdet36";
	  
	  //step-4 excute statment/query
	   
	 ResultSet result = stat.executeQuery(query);
	 
		 while(result.next()) {
		 System.out.println(result.getInt(1)+"/"+result.getString(2)+"/"+result.getInt(3)+"/"+result.getString(4)+"/"+result.getString(5)+"/");
		 
	 }
}
}
		
		
		




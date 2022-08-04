 package org.vtiger.Practices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class CreatePratice {

	public static void main(String[] args) throws SQLException {
		
		  // create the object for driver class which is given by db vendor
       Driver driver =new Driver();
       
       // Resistor the driver to jdbc
       DriverManager.registerDriver(driver);
       
       //Establish the connection
         Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/tyss","root","root");
         
         //create statement
         Statement statement=connection.createStatement();
         
         
       ResultSet result= statement.executeQuery("select* from sdet36;");
       
       //iterate the data
       while(result.next())
       {
    	   System.out.println(result.getString(1));
       }
        //validate the data
        int count=0;
        while(result.next()) {
        	if(result.getNString("empname").equals("vinod"))
        	{
        		System.out.println("data is present in db");
        		count++;
        		break;
        		
        		
        	}
        }
        connection.close();
	}

}

package com.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static Connection con=null;

	public static Connection getDBConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ram_db","root","root");
		
System.out.println("db connection here");
		return con; 
		
	}
	public Connection getJdbcConnection()
	{
		return con;
		
	}
	public static void closeConnection() throws SQLException
	{
		if(con!=null)
			con.close();
	}
	public static void init() {
		// TODO Auto-generated method stub
		
	}
}

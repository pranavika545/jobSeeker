package org.com.web.dao;

import java.sql.*;

public class DAO 
{
	private Connection conn;
	public DAO()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jobseeker", "root", "password");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return conn;
	}
	
}

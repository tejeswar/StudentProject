package com.dataaccesslayer.utility;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;

public class DBConnectionFactory {
	private static Connection con;
	private static Properties properties;
	private static String driver_name ;
	private static String db_name  ;
	private static String user_name  ;
	private static String password ;
	static
	{
		try {
			System.out.println("inside static block of DBConnectionFactory");
			properties = new Properties();
		    InputStream fileInputStream = DBConnectionFactory.class.getResourceAsStream("db.properties");
		     properties.load(fileInputStream);
			Class.forName(properties.getProperty("driverName"));
			System.out.println("end of static block of DBConnectionFactory");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
public static Connection getConnection(){
	
	try {
		System.out.println("inside  getConnection method of DBConnectionFactory");
		con=DriverManager.getConnection(properties.getProperty("dbName"), properties.getProperty("userName"), properties.getProperty("passWord"));
		System.out.println("connection is: "+con);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return con;
}
public static void close(){
	
	if(con!=null)
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}

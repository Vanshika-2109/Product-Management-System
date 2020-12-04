package com.yash.product_management.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class is used to provide utility for database connection
 * @author Vanshika Chaturvedi
 *
 */
public class JDBCUtil {
	 public static Connection getConnection()
	    {
	        Connection conn = null;
	        try{

	            Class.forName("com.mysql.jdbc.Driver");
	            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/productdb","root","root");

	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	        return conn;
	    }

	    //close connection
	    public static void closeConnection(Connection conn)
	    {
	        try{
	            conn.close();
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	    }


}

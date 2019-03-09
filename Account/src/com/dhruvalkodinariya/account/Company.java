package com.dhruvalkodinariya.account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;


public class Company {
	// JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "";
	   
	public static void main(String[] args) {
		createCompanyDB();
	}
	
	public static void createCompanyDB(){
		Connection c = null;
		Statement st = null;
		PreparedStatement pstmt = null;
		try {
			 c = DB.getConnection("");
			 st = c.createStatement();
			String dbname = CommonUtils.getUUID(20);
			String sql = "CREATE DATABASE "+dbname;
			st.executeUpdate(sql);
			c = DB.getConnection(dbname);
		    st = c.createStatement();
		    sql = "CREATE TABLE Contacts (" + 
		    		"cont_id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY," + 
		    		"cust_name VARCHAR(255)," + 
		    		"name_in_invoice VARCHAR(255)," + 
		    		"company VARCHAR(255)," + 
		    		"cont_type VARCHAR(255)," + 
		    		"cont_due_days VARCHAR(255)," +
		    		"mobile_no VARCHAR(255)," + 
		    		"email VARCHAR(255)," + 
		    		"gst_no VARCHAR(255)," +
		    		"pan_no VARCHAR(255)," +
		    		"bill_addr_1 VARCHAR(255)," +
		    		"bill_addr_2 VARCHAR(255)," +
		    		"bill_addr_3 VARCHAR(255)," +
		    		"bill_pincode VARCHAR(255)," +
		    		"bill_city VARCHAR(255)," +
		    		"bill_state VARCHAR(255)," +
		    		"bill_country VARCHAR(255)," +
		    		"ship_addr_1 VARCHAR(255)," +
		    		"ship_addr_2 VARCHAR(255)," +
		    		"ship_addr_3 VARCHAR(255)," +
		    		"ship_pincode VARCHAR(255)," +
		    		"ship_city VARCHAR(255)," +
		    		"ship_state VARCHAR(255)," +
		    		"ship_country VARCHAR(255)," +
		    		"currency VARCHAR(255)," +
		    		"current_balance VARCHAR(255)," + 
		    		"cont_is VARCHAR(255)," + 
		    		"note VARCHAR(255)" + 
		    		")";
		    st.executeUpdate(sql);
//		    c = DB.getConnection("ACCOUNT");
//		    pstmt = (PreparedStatement) c.prepareStatement("INSERT INTO Companies VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
//		    pstmt.setString(1,dbname);
//		    pstmt.setString(2,"Company name");
//		    pstmt.setString(3,"Contact name");
//		    pstmt.setString(4,"admin");
//		    pstmt.setString(5,"admin");
//		    pstmt.setString(6,"admin@gmail.com");
//		    pstmt.setString(7,"7894561320");
//		    pstmt.setString(8,"gstno");
//		    pstmt.setString(9,"panno");
//		    pstmt.setString(10,"currency");
//		    pstmt.setString(11,"addr-1");
//		    pstmt.setString(12,"addr-2");
//		    pstmt.setString(13,"city");
//		    pstmt.setString(14,"state");
//		    pstmt.setString(15,"country");
//		    pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		      //finally block used to close resources
		      try{
		         if(st!=null)
		            st.close();
		      }catch(SQLException se2){
		      }// nothing we can do
		      try{
		         if(c!=null)
		            c.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }
	}
	public static Connection selectCompanyDB(String dbname) throws SQLException{
		Connection c = DriverManager.getConnection(DB_URL+dbname,USER,PASS);;
		return c;
	}
}

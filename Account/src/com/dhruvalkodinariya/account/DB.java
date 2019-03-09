package com.dhruvalkodinariya.account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//import com.mysql.jdbc.*;

public class DB {
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost:3306/";
	   static final String USER = "root";
	   static final String PASS = "";
	   
	public static void main(String[] args){
		
	}
	public static Connection getConnection(String dbname) throws ClassNotFoundException, SQLException {
		Class.forName(JDBC_DRIVER);
		Connection c = null;
		if(dbname!="") {
			 c = DriverManager.getConnection(DB_URL+dbname,USER,PASS);
		}
		else {
			 c = DriverManager.getConnection(DB_URL,USER,PASS);
		}
		
		return c;
	}
	
}
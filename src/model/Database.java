package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement ps;
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	
	// TODO: Replace with a username
	static final String DB_URL = "jdbc:mysql://localhost/EMP";
	static final String USER = "root";
	static final String PASS = null;
	
	public Database () {
	}
	
	public void connect () {
		try {
			//Register the JDBC driver
			Class.forName("com.mysql.jdbc.Driver");			
		} catch (ClassNotFoundException e) {
			System.err.println(e);
			System.exit (-1);
		}
		try {
			 //Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void close () {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

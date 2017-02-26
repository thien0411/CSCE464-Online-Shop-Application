package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Database {
	private Connection conn;
	private PreparedStatement ps;
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

//	 TODO: Replace with a cse username and password
//	static final String DB_URL = "jdbc:mysql://cse.unl.edu:3306/CSE_USERNAME"
	static final String DB_URL = "jdbc:mysql://localhost:3306/CSCE464OnlineShoppingDB";
	
	static final String USER = "root";
	static final String PASS = "pass";
	
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
			if (ps != null && !ps.isClosed()) {
				ps.close();
			}
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addUser (Users user) {
		String insert = "INSERT INTO Users (Username, Password) VALUES (?, ?)";

		try {
		    ps = conn.prepareStatement(insert);
		    ps.setString(1, user.getUserName());
		    ps.setString(2, user.getPassword());
		    ps.executeUpdate();
		} catch (SQLException e) {
	      e.printStackTrace();
	    }
	}


	public boolean userExists (String username) {
		boolean result = false;
		String query = "SELECT Username FROM Users where Username = ?";
		ResultSet rs;

		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			rs = ps.executeQuery();

			while (rs.next()) {
				result = true;
			}

			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public String userPassword (String username) {
		String password = null;
		String query = "SELECT Password FROM Users where Username = ?";
		ResultSet rs;
		
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				password = rs.getString("Password");
			}
			
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return password;
	}

	public void getProducts(List<Product> productList, String productQuery) {
		String query = "SELECT p.*, pc.*, u.Username FROM Products p "
				+ "JOIN ProductCategories pc ON p.ProductCategoryIndex = pc.Id "
				+ "JOIN Users u ON p.SellerId = u.Id "
				+ "WHERE ProductName LIKE ?";
		ResultSet rs;
		Product p;
		String name;
		String category;
		String sellerName;
		Double price;
		String thumbnail;

		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, "%" + productQuery + "%");
			rs = ps.executeQuery();
			
			while (rs.next()) {
				name = rs.getString("ProductName");
				category = rs.getString("ProductCategory");
				sellerName = rs.getString("Username");
				price = rs.getDouble("Price");
				thumbnail = rs.getString("Thumbnail");
				p = new Product(name, category, sellerName, price, thumbnail);
				productList.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

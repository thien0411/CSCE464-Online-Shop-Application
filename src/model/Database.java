package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import util.ShippingRefNoGenerator;

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
		String query = "SELECT p.*, pc.ProductCategory, u.Username FROM Products p "
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
				thumbnail = rs.getString("ProductThumbnail");
				p = new Product(name, category, sellerName, price, thumbnail);
				p.setId(rs.getInt("Id"));
				productList.add(p);
			}

			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Product getProductById(int productId) {
		String query = "SELECT p.*, u.Username FROM Products p "
				+ "JOIN ProductCategories pc ON p.ProductCategoryIndex = pc.Id "
				+ "JOIN Users u ON p.SellerId = u.Id "
				+ "WHERE p.Id = ?";
		Product p = null;
		ResultSet rs;		

		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, productId);
			rs = ps.executeQuery();

			rs.next();
			String name = rs.getString("ProductName");
			String sellerName = rs.getString("Username");
			Double price = rs.getDouble("Price");
			Integer estDeliveryDays = rs.getInt("EstimatedDeliveryDays");
			String photoLinks = rs.getString("ProductPhotosLinks");
			List<String> photos = new LinkedList<String>();

			if (photoLinks != null && photoLinks.length() != 0) {
				String[] links = photoLinks.split(",");
				for (int i = 0; i < links.length; i++) {
					photos.add(links[i]);
				}
			}

			String description = rs.getString("ProductDescription");
			Integer availableQuantity = rs.getInt("AvailableQuantity");
			String thumbnail = rs.getString("ProductThumbnail");

			p = new Product(name, sellerName, price, estDeliveryDays, photos, description);
			p.setAvailableQuantity(availableQuantity);
			p.setThumbnail(thumbnail);
			p.setId(productId);
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return p;
	}

	public List<Review> getReviewsByProductId (int productId) {
		List<Review> reviews = new LinkedList<Review>();
		String query = "SELECT cr.*, u.Username FROM CustomerReviews cr "
				+ "JOIN Users u on cr.CustomerId = u.Id "
				+ "where cr.ProductId = ?";
		ResultSet rs;

		Review review = null;
		Users customer = null;
		String date = null;
		Integer rating = null;
		String feedback = null;

		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, productId);
			rs = ps.executeQuery();

			while(rs.next()) {
				customer = new Users(rs.getString("Username"));
				date = rs.getString("ReviewDate");
				rating = rs.getInt("Rating");
				feedback = rs.getString("Review");

				review = new Review(customer, date, rating, feedback);
				reviews.add(review);
			}

			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reviews;
	}

	public List<QuestionAnswer> getQAByProductId (int productId) {
		List<QuestionAnswer> qaList = new LinkedList<QuestionAnswer>();
		String query = "SELECT pqa.*, u.Username FROM ProductQA pqa "
				+ "JOIN Users u on pqa.CustomerId = u.Id "
				+ "WHERE pqa.ProductId = ?";
		ResultSet rs;

		QuestionAnswer qa = null;
		Users customer = null;
		String question = null;
		String answer = null;

		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, productId);
			rs = ps.executeQuery();

			while (rs.next()) {
				customer = new Users(rs.getString("Username"));
				question = rs.getString("Question");
				answer = rs.getString("Answer");

				qa = new QuestionAnswer(customer, question, answer);
				qaList.add(qa);
			}

			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return qaList;
	}

	public int getUserIdByUsername (String userName){
		String query = "SELECT Id from Users where Username = ?";
		int id = 0 ;
		ResultSet rs;
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, userName);
			rs = ps.executeQuery();

			while (rs.next()) {
				id = rs.getInt("Id");
			}

			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	public Orders getOrderById (int orderId) {
		String query = "SELECT * FROM Orders WHERE Id = ?";

		Orders o = null;
		ResultSet rs;
		
		List<Product> productList = new LinkedList<Product>();

		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, orderId);
			rs = ps.executeQuery();
			Double orderTotal = 0.0;
			String orderDate = null;
			String shippingAddress = null;
			
			if (rs.next()) {
				orderTotal = rs.getDouble("TotalCost");
				orderDate = rs.getString("OrderDate");
				shippingAddress = rs.getString("ShippingAddress");
				
				productList = this.getOrderItems(orderId);
			}



			o = new Orders(orderTotal, orderId, orderDate , productList, shippingAddress);


			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return o;
	}
	
	private List<Product> getOrderItems (int orderId) {
		String query = "SELECT oi.Quantity, oi.ShippingStatus, u.Username, p.*"
				+ "FROM OrderItems oi "
				+ "JOIN Products p on oi.ProductId = p.Id "
				+ "JOIN Users u on u.Id = p.SellerId "
				+ "WHERE OrderId = ?";

		boolean isShipped = false;
		
		ResultSet rs;
		List<Product> productList = new LinkedList<Product>();
		
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, orderId);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Integer productId = rs.getInt("Id");
				String productName = rs.getString("ProductName");
				Integer quantity = rs.getInt("Quantity");
				Double price = rs.getDouble("Price");
				String sellerName = rs.getString("Username");
				Integer shippingStatus = rs.getInt("ShippingStatus");
				if (shippingStatus.equals(1)) isShipped = true;
				
				Product p = new Product();
				p.setId(productId);
				p.setName(productName);
				p.setQuantityRequested(quantity);
				p.setPrice(price);
				p.setSellerName(sellerName);
				p.setIsShipped(isShipped);
				
				productList.add(p);
			}

			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return productList;
	}

	public void getOrderHistory(List<Orders> orderList, int userId) {
		String query = "SELECT o.Id, o.TotalCost, o.OrderDate FROM Orders as o Where CustomerID = ?";
		ResultSet rs;
		Orders o;
		Double orderTotal;
		Integer orderNumber;
		String orderDate;

		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, userId);
			rs = ps.executeQuery();

			while (rs.next()) {
				orderTotal = rs.getDouble("TotalCost");
				orderNumber = rs.getInt("Id");
				orderDate = rs.getString("OrderDate");

				o = new Orders(orderTotal, orderNumber, orderDate);
				orderList.add(o);
			}

			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deteleOrderByOrderId(int OrderId){
		String query = "Delete from OderItems where OrderId = ?;"
				+ " Delete from OderItems where Id = ?";

		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, OrderId);
			ps.setInt(2, OrderId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 

	public void addOrder(Orders order){
		String query = "INSERT INTO Orders "
				+ "(CustomerID, TotalCost, OrderDate, ShippingAddress, BillingAddress, CreditCardNumber) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";

		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, order.getCustomerId());
			ps.setDouble(2, order.getOrderTotal());
			ps.setString(3, order.getOrderDate());
			ps.setString(4, order.getShippingAddress());
			ps.setString(5, order.getBillingAddress());
			ps.setString(6, order.getCreditCardNumber());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Integer getOrderId (Integer customerId, Double totalCost) {
		String query = "SELECT Id FROM Orders WHERE CustomerId = ? AND TotalCost = ?";
		Integer orderId = 0;
		ResultSet rs;

		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, customerId);
			ps.setDouble(2, totalCost);
			rs = ps.executeQuery();

			while (rs.next()) {
				orderId = rs.getInt("id");
			}

			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return orderId;
	}

	public void addOrderItems (Integer orderId, List<Product> shoppingCart) {
		String insert = "INSERT INTO OrderItems "
				+ "(OrderId, SellerId, ProductId, ProductPrice, Quantity, ShippingStatus, ShippingRefNo, Status) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			for (Product p : shoppingCart) {
				Integer sellerId = this.getUserIdByUsername(p.getSellerName());

				ps = conn.prepareStatement(insert);
				ps.setInt(1, orderId);
				ps.setInt(2, sellerId);
				ps.setInt(3, p.getId());
				ps.setDouble(4, p.getPrice());
				ps.setInt(5, p.getQuantityRequested());
				ps.setInt(6, 1);
				ps.setInt(7, ShippingRefNoGenerator.generateRandom());
				ps.setInt(8, 1);

				ps.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

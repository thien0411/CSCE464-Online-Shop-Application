package model;

import java.util.LinkedList;
import java.util.List;

public class Orders {
	private Integer orderId;
	private Double orderTotal;
	private Integer orderNumber;
	private String orderDate;
	private List<Product> products;
	private String shippingAddress;

	public Orders(Double orderTotal, Integer orderNumber, String orderDate) {
		super();
		this.orderTotal = orderTotal;
		this.orderNumber = orderNumber;
		this.orderDate = orderDate;
	}
	
	public Orders(Double orderTotal, Integer orderNumber, String orderDate, List<Product> products,
			String shippingAddress) {
		super();
		this.orderTotal = orderTotal;
		this.orderNumber = orderNumber;
		this.orderDate = orderDate;
		this.products = products;
		this.shippingAddress = shippingAddress;
	}

	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public Double getOrderTotal() {
		return orderTotal;
	}
	public void setOrderTotal(Double orderTotal) {
		this.orderTotal = orderTotal;
	}
	public Integer getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public static List<Orders> getOrderList(String userName){
		List<Orders> orderList = new LinkedList<Orders>();
		Database db = new Database();
		db.connect();
		int userId = db.getUserIdByUsername(userName);
		db.getOrderHistory(orderList, userId); //Todo: add this function to the Database.java file
		db.close();
		return orderList;
	}
	
	public static Orders getOrder(int OrderId) {
		Orders p = null;

		Database db = new Database();
		db.connect();

		p = db.getOrderById(OrderId);

		db.close();
		return p;
	}

	

}

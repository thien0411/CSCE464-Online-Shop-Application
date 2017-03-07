package model;

import java.util.LinkedList;
import java.util.List;

public class Orders {
	private Integer orderId;
	private Integer CustomerId;
	private Double orderTotal;
	private Integer orderNumber;
	private String orderDate;
	private List<Product> products;
	private String shippingAddress;
	private String billingAddress;
	private String creditCardNumber;

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
	public Integer getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(Integer customerId) {
		CustomerId = customerId;
	}
	public String getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}
	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
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
		Orders o = null;

		Database db = new Database();
		db.connect();

		o = db.getOrderById(OrderId);

		db.close();
		return o;
	}
	public void addOrder(Orders order) {
		Database db = new Database();
		db.connect();
		db.addOrder(order);

		db.close();
	
	}
	public void deteleOrderByOrderId(int orderId) {
		Database db = new Database();
		db.connect();
		db.deteleOrderByOrderId(orderId);
		db.close();
	}

	

	

	

}

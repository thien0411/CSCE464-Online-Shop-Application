package model;

import java.util.LinkedList;
import java.util.List;

public class Orders {
	private Integer orderId;
	private Integer CustomerId;
	private Double orderTotal;
	private String orderDate;
	private List<Product> products;
	private String shippingAddress;
	private String billingAddress;
	private String creditCardNumber;

	public Orders () {
	}
	
	public Orders(Double orderTotal, Integer orderId, String orderDate) {
		this.orderTotal = orderTotal;
		this.orderId = orderId;
		this.orderDate = orderDate;
	}
	
	public Orders(Double orderTotal, Integer orderId, String orderDate, List<Product> products,
			String shippingAddress) {
		this.orderTotal = orderTotal;
		this.orderId = orderId;
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
		db.getOrderHistory(orderList, userId);
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
	public static void addOrder(Orders order) {
		Database db = new Database();
		db.connect();
		db.addOrder(order);
		db.close();
	}
	
	public void dbAddOrder() {
		Orders.addOrder(this);
		this.dbGetOrderId();
		this.dbAddOrderItems();
	}
	
	public static void deteleItem(int itemId) {
		Database db = new Database();
		db.connect();
		System.out.println("gooooo herrrreeee");
		db.deteleItemByItemId(itemId);
		db.close();
	}

	private void dbGetOrderId () {
		Integer id = 0;
		Database db = new Database();
		db.connect();
		id = db.getOrderId(this.CustomerId, this.orderTotal);
		db.close();
		this.orderId = id;
	}

	private void dbAddOrderItems () {
		Database db = new Database();
		db.connect();
		db.addOrderItems(this.orderId, this.products);
		db.close();
	}

	

}

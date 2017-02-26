package model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class Orders {
		private Double orderTotal;
		private Integer orderNumber;
		private String orderDate;
		private List<Product> products;
		private String shippingAddress;

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
		 
		
		
		
		
}

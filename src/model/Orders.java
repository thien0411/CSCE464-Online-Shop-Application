package model;

import javax.servlet.http.HttpServletRequest;

public class Orders {
		private Double total;
		private Integer orderNumber;
		private String orderDatel;
		
		
		
		public Orders(Double total, Integer orderNumber, String orderDatel) {
			super();
			this.total = total;
			this.orderNumber = orderNumber;
			this.orderDatel = orderDatel;
		}
		public Double getTotal() {
			return total;
		}
		public void setTotal(Double total) {
			this.total = total;
		}
		public Integer getOrderNumber() {
			return orderNumber;
		}
		public void setOrderNumber(Integer orderNumber) {
			this.orderNumber = orderNumber;
		}
		public String getOrderDatel() {
			return orderDatel;
		}
		public void setOrderDatel(String orderDatel) {
			this.orderDatel = orderDatel;
		}
		
}

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Orders;
import model.Product;
import model.Users;

/**
 * Servlet implementation class PlaceOrder
 */
public class PlaceOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PlaceOrder() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		@SuppressWarnings("unused")
		String firstName = request.getParameter("firstName");
		@SuppressWarnings("unused")
		String lastName = request.getParameter("lastName");
		String cardNumber = request.getParameter("cardNumber");
		String billingAddress = request.getParameter("billingAddress");
		String shippingAddress = request.getParameter("shippingAddress");
		
		Double total = 0.0;
		HttpSession session = request.getSession();
		Users user = (Users)session.getAttribute("user");
		
		@SuppressWarnings("unchecked")
		List<Product> shoppingCart = (LinkedList<Product>)session.getAttribute("shoppingCart");

		for (Product p : shoppingCart) {
			total += p.getPrice() * p.getQuantityRequested();
		}
		
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String orderDate = formatter.format(date);
		
		/* Create order based on shopping cart */
		Orders order = new Orders();
		order.setCreditCardNumber(cardNumber);
		order.setProducts(shoppingCart);
		order.setOrderDate(orderDate);
		order.setOrderTotal(total);
		order.setCustomerId(user.getId());
		order.setBillingAddress(billingAddress);
		order.setShippingAddress(shippingAddress);
		order.dbAddOrder();

		/* Clear shopping cart */
		shoppingCart = new LinkedList<Product>();
		session.setAttribute("shoppingCart", shoppingCart);
		
		PrintWriter out = response.getWriter();
		out.println(1);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

package controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Product;
import model.Transactions;

/**
 * Servlet implementation class CustomerTransactionConfirmation
 */
public class CustomerTransactionConfirmation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerTransactionConfirmation() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String cardType = request.getParameter("cardType");
		String cardNumber = request.getParameter("cardNumber");
		String securityCode = request.getParameter("securityCode");
		String expireMonth = request.getParameter("expireMonth");
		String billingAddress = request.getParameter("billingAddress");
		String shippingAddress = request.getParameter("shippingAddress");

		Transactions t = new Transactions();

		t.setFirstName(firstName);
		t.setLastName(lastName);
		t.setCardType(cardType);
		t.setCardNumber(cardNumber);
		t.setSecurityCode(securityCode);
		t.setExpireMonth(expireMonth);
		t.setBillingAddress(billingAddress);
		t.setShippingAddress(shippingAddress);

		Double total = 0.0;
		HttpSession session = request.getSession();

		@SuppressWarnings("unchecked")
		List<Product> shoppingCart = (LinkedList<Product>)session.getAttribute("shoppingCart");

		for (Product p : shoppingCart) {
			total += p.getPrice() * p.getQuantityRequested();
		}
		
		if (t.validData() && t.sufficientFunds()) {
			/* Create order based on shopping cart */
			// Something with Orders model

			/* Clear shopping cart */
			shoppingCart.clear();
		}

		request.setAttribute("transaction", t);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/CustomerTransactionConfirmation.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

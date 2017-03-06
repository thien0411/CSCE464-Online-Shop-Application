package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		Integer cardNumber = null;
		Integer securityCode = null;
		String expireMonth = request.getParameter("expireMonth");
		String billingAddress = request.getParameter("billingAddress");
		String shippingAddress = request.getParameter("shippingAddress");

//		String status = null;

		Transactions t = new Transactions();

//		boolean errorExists = false;

		try {
			cardNumber = Integer.parseInt(request.getParameter("cardNumber"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
			cardNumber = 0;
		}

		try {
			securityCode = Integer.parseInt(request.getParameter("securityCode"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
			securityCode = 0;
		}

		t.setFirstName(firstName);
		t.setLastName(lastName);
		t.setCardType(cardType);
		t.setCardNumber(cardNumber);
		t.setSecurityCode(securityCode);
		t.setExpireMonth(expireMonth);
		t.setBillingAddress(billingAddress);
		t.setShippingAddress(shippingAddress);

		HttpSession session = request.getSession();
		session.setAttribute("transaction", t);

		response.sendRedirect("CustomerTransactionConfirmation.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

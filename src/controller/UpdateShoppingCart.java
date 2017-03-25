package controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Product;

/**
 * Servlet implementation class UpdateShoppingCart
 */
public class UpdateShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateShoppingCart() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		Integer productId = Integer.parseInt(request.getParameter("productId"));
		String quantityString = request.getParameter("quantity");
		Integer quantity = 0;

		Double total = 0.00;

		Product p = null;

		if (action.equals("add") && quantityString != null && !quantityString.trim().equals("")) {
			quantity = Integer.parseInt(quantityString);
		}

		HttpSession session = request.getSession();

		@SuppressWarnings("unchecked")
		List<Product> shoppingCart = (LinkedList<Product>)session.getAttribute("shoppingCart");

		if (shoppingCart == null) {
			shoppingCart = new LinkedList<Product>();
			session.setAttribute("shoppingCart", shoppingCart);
		}

		if (action.equals("add")) {
			/* Check if item is already in cart,
			 * if so, add the amount to the request */
			boolean found = false;

			for (Product check : shoppingCart) {
				if (check.getId().equals(productId)) {
					found = true;
					check.requestAmountChange(quantity);
					break;
				}
			}

			/* Add a product, if quantity is available */
			if (!found) {
				p = Product.getProduct(productId);
				p.setQuantityRequested(quantity);
				if (p.validQuantity()) shoppingCart.add(p);
			}

		} else if (action.equals("delete")) {
			/* Find and remove the item */
			for (int i = 0; i < shoppingCart.size(); i++) {
				if (shoppingCart.get(i).getId().equals(productId)) {
					shoppingCart.remove(i);
					break;
				}
			}
		}

		/* Calculate total and place in session */
		DecimalFormat df = new DecimalFormat(".##");

		for (Product item : shoppingCart) {
			total += item.getPrice() * (double)item.getQuantityRequested();
		}

		session.setAttribute("formattedCartTotal", df.format(total));
		response.sendRedirect("View&CheckoutShoppingCart.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Review;
import model.Users;
import util.InputFormatting;

/**
 * Servlet implementation class CustomerReviews
 */
public class CustomerReviews extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerReviews() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer productId = Integer.parseInt(request.getParameter("productId"));
		String customerReview = InputFormatting.safeFilter(request.getParameter("review"));
		Integer rating = Integer.parseInt(request.getParameter("rating"));

		HttpSession session = request.getSession();
		Users customer = (Users)session.getAttribute("user");
		
		PrintWriter out = response.getWriter();
		
		/*Send the review to the database*/
		if (Review.addReview(customer, productId, customerReview, rating)) {
			/* Success */
			out.print("1");
		} else {
			/* Error */
			out.print("0");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.QuestionAnswer;
import model.Users;
import util.InputFormatting;

/**
 * Servlet implementation class CustomerQA
 */
public class CustomerQA extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerQA() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer productId = Integer.parseInt(request.getParameter("productId"));
		String customerQuestion = InputFormatting.safeFilter(request.getParameter("question"));

		HttpSession session = request.getSession();
		Users customer = (Users)session.getAttribute("user");

		PrintWriter out = response.getWriter();

		/* Send question to the database */
		if (QuestionAnswer.addQuestion(productId, customer, customerQuestion)) {
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

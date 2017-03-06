package controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Orders;
import model.Product;

/**
 * Servlet implementation class CancelOrderTransaction
 */
public class CancelOrderTransaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelOrderTransaction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String action = request.getParameter("action");
//		Integer orderId = Integer.parseInt(request.getParameter("orderId"));
//		HttpSession session = request.getSession();
		
//		@SuppressWarnings("unchecked")
//		List<Orders> OrderList = (LinkedList<Orders>)session.getAttribute("OrderList");
//		
//		if (action.equals("Cancel")) {
//			/* Find and remove the item */
//			for (int i = 0; i < OrderList.size(); i++) {
//				if (OrderList.get(i).getOrderId().equals(orderId)) {
//					OrderList.remove(i);
//					break;
//				}
//			}
//		}
//		session.setAttribute("OrderCancel", OrderList);

		response.sendRedirect("CancellationConfirmation.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package controller;

import java.io.IOException; 

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		 
		System.out.println("In cancel confirm: orderIem Id = " + itemId + "    OrderId: " + orderId);
		
		Product orderItem  = Product.getOrderItemForCancellation(itemId, orderId);
		
		//System.out.println("Product Id = " + orderItem.getId() + "    OrderId: " + orderId);
		//Orders order = Orders.getOrder(orderId);
		Orders.deteleItem(itemId, orderId);
	
		
		request.setAttribute("orderItem", orderItem);
		request.setAttribute("orderId", orderId);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("CancellationConfirmation.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

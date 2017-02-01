package controller;
 
import java.io.FileInputStream; 
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Users;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		/* The users.properties file is stored in the "WEB-INF" folder.
		   To access this file, you will need its absolute path. */
		
		/*
		 * Note: the content of the properties file may not be visible
		 */
		 
		/* Following two statements are used to obtain the absolute path 
		   of the users.properies file from its relative path. */
		
		
		ServletContext sc = this.getServletContext();
		String propFilePath = sc.getRealPath("/WEB-INF/users.properties");
		
		
		/*
		Properties p = new Properties();
		
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(propFilePath);
			
			p.load(fis);
				
			// Check whether the username exists or not
			if(!p.containsKey(userName)) {			
				// Link-redirection
				response.sendRedirect("Register.jsp");
			} else { // Check whether the password matches or not
				String pword = p.getProperty(userName);  
				if(!pword.equals(password)) {
					response.sendRedirect("Register.jsp"); // Link-redirection
				} else {
					response.sendRedirect("LoginSuccess.jsp"); // Link-redirection
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(fis != null) {
				fis.close();
			}
		}
		/*
		
		/*
		 * Instead using servlet methods (above) for user login,
		 * instantiate a Users object and 
		 * use appropriate method for user login from the Users class.
		 */
		
		Users userLogin = new Users(userName, password);
		
		userLogin.validateUser(userLogin, propFilePath, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

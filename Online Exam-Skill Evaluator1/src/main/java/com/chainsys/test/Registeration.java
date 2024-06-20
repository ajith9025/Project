package com.chainsys.test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.chainsys.dao.UserDeatils;
import com.chainsys.model.Register;



/**
 * Servlet implementation class Registeration
 */
@WebServlet("/Registeration")
public class Registeration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Register register = new Register();
	UserDeatils deatils = new UserDeatils();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Registeration() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String contactno = request.getParameter("contact_no");
        
		register.setUsername(username);
		register.setPassword(password);
		register.setEmail(email);
		register.setContactno(contactno);
		try {
			deatils.insert(register);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		request.setAttribute("register", register);
		ArrayList<Register> list = null;
		try {

			list = deatils.getAllRegister();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		request.setAttribute("list", list);

		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
		
		
	/*	   if (registerUser(username, email, password, contactno)) {
	            // Redirect to login page with success message
	            response.sendRedirect("login.jsp?message=Registration successful. Please log in.");
	        } else {
	            // Redirect back to registration with error message
	            response.sendRedirect("signup.jsp?error=Registration failed. Try again.");
	        }
	    }
	    
	    private boolean registerUser(String username, String email, String password, String contactno) {
	        // Implement your user registration logic here
	        return true; // Assume registration is always successful for this example
	    }*/

	}
}


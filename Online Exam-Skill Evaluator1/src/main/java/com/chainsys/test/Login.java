package com.chainsys.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		HttpSession session=request.getSession();
		session.setAttribute("email", email);
		if(email.endsWith("@online.com")) {
			response.sendRedirect("adminlogin.jsp");
		}
		else
		{
			response.sendRedirect("index.html");
		
	    }
		 /*if (isValidUser(email, password)) {
	            // Set user session and redirect to homepage
	            request.getSession().setAttribute("user", email);
	            response.sendRedirect("index.jsp");
	        } else {
	            // Redirect back to login with error message
	            response.sendRedirect("login.jsp?error=Invalid credentials");
	        }
	    }
	    
	    private boolean isValidUser(String email, String password) {
	        // Implement your user validation logic here
	        return "user@example.com".equals(email) && "password".equals(password);
	    }*/
	}
}



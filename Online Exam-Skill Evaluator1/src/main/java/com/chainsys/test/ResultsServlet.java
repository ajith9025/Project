package com.chainsys.test;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.chainsys.dao.ResultsDetails;
import com.chainsys.model.Results;

/**
 * Servlet implementation class ResultsServlet
 */
@WebServlet("/ResultsServlet")
public class ResultsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Results results = new Results();
	ResultsDetails rd = new ResultsDetails();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ResultsServlet() {
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
		int Id = Integer.parseInt(request.getParameter("Id"));
		int userId = Integer.parseInt(request.getParameter("userId"));
		int examId=Integer.parseInt(request.getParameter("examId"));
		int markObtained=Integer.parseInt(request.getParameter("markObtained"));
		results.setId(Id);
		results.setUserId(userId);
		results.setExamId(examId);
		results.setMarkObtained(markObtained);
		try {
			rd.insert(results);
			request.setAttribute("results", results);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
	}
}

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
import com.chainsys.dao.ResultsDetails;

import com.chainsys.model.Results;

/**
 * Servlet implementation class ResultsServlet
 */
@WebServlet("/ResultsServlet")
public class ResultsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/* private static final int marksObtained = 0; */
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
		int resultId = Integer.parseInt(request.getParameter("resultId"));
		int userId = Integer.parseInt(request.getParameter("userId"));
		int examId=Integer.parseInt(request.getParameter("examId"));
		int marksObtained=Integer.parseInt(request.getParameter("marksObtained"));
        results.setResultId(resultId);
		results.setUserId(userId);
		results.setExamId(examId);
		results.setMarksObtained(marksObtained);
		try {
			rd.insert(results);
		
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		request.setAttribute("results", results);
		ArrayList<Results> list=null;
		  try {
				
				 list=rd.getAllResult();

			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		 
	      request.setAttribute("list",list);
			
		  RequestDispatcher dispatcher = request.getRequestDispatcher("ViewResults.jsp");
		  dispatcher.forward(request, response);
		
	}
}

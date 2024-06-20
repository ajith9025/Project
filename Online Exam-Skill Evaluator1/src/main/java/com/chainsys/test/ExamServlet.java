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

import com.chainsys.dao.ExamDetails;
import com.chainsys.model.Exam;


/**
 * Servlet implementation class ExamServlet
 */
@WebServlet("/ExamServlet")
public class ExamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Exam exam=new Exam();
	ExamDetails details= new ExamDetails();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExamServlet() {
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
		int examId=Integer.parseInt(request.getParameter("examId"));
		String examName = request.getParameter("examName");
		String examDatestr = request.getParameter("examDate");
		int duration = Integer.parseInt(request.getParameter("duration"));
		int totalMarks = Integer.parseInt(request.getParameter("totalMarks"));
		exam.setExamId(examId);
		exam.setExamName(examName);
		exam.setExamDate(examDatestr);
		exam.setDuration(duration);
		exam.setTotalMarks(totalMarks);
		 try {
				details.insert(exam);
				
					 
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			}
			  request.setAttribute("exam",exam);
			  ArrayList<Exam> list=null;
			  try {
					
					 list=details.getAllExam();

				} catch (SQLException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			 
		      request.setAttribute("list",list);
				
			  RequestDispatcher dispatcher = request.getRequestDispatcher("ViewDetails.jsp");
			  dispatcher.forward(request, response);
	}
}

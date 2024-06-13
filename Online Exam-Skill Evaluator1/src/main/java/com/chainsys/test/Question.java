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

import com.chainsys.dao.QuestionDetails;
import com.chainsys.model.AddQuestion;


/**
 * Servlet implementation class Question
 */
@WebServlet("/Question")
public class Question extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AddQuestion question= new AddQuestion();
	QuestionDetails details=new QuestionDetails();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Question() {
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
		int examId = Integer.parseInt(request.getParameter("examId"));
		String examName=request.getParameter("examName");
   	    String questionText=request.getParameter("questionText");
   	    String option1=request.getParameter("option1");
   	    String option2=request.getParameter("option2");
   	    String option3=request.getParameter("option3");
   	    String option4=request.getParameter("option4");
   	    String correctAnswer=request.getParameter("correctAnswer");
   	    question.setExamId(examId);
   	    question.setExamName(examName);
   	    question.setQuestionText(questionText);
   	    question.setOption1(option1);
   	    question.setOption2(option2);
   	    question.setOption3(option3);
   	    question.setOption4(option4);
   	    question.setCorrectAnswer(correctAnswer);
   	    
   	 try {
			details.insert(question);
				 
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		  request.setAttribute("question",question);
		  ArrayList<AddQuestion> list=null;
		  try {
				
				 list=details.getAllQuestion();

			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		 
	      request.setAttribute("list",list);
			
		  RequestDispatcher dispatcher = request.getRequestDispatcher("ViewQuestion.jsp");
		  dispatcher.forward(request, response);
		
	}
}

package com.chainsys.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.dao.ExamDetails;
import com.chainsys.dao.QuestionDetails;
import com.chainsys.model.AddQuestion;

/**
 * Servlet implementation class UpdateQuestionServlet
 */
@WebServlet("/UpdateQuestionServlet")
public class UpdateQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateQuestionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		int examId = Integer.parseInt(request.getParameter("examId"));
		String examName=request.getParameter("examName");
   	    String questionText=request.getParameter("questionText");
   	    String option1=request.getParameter("option1");
   	    String option2=request.getParameter("option2");
   	    String option3=request.getParameter("option3");
   	    String option4=request.getParameter("option4");
   	    String correctAnswer=request.getParameter("correctAnswer");
   	    AddQuestion question=new AddQuestion();
   	    question.setExamId(examId);
   	    question.setExamName(examName);
   	    question.setQuestionText(questionText);
   	    question.setOption1(option1);
   	    question.setOption2(option2);
   	    question.setOption3(option3);
   	    question.setOption4(option4);
   	    question.setCorrectAnswer(correctAnswer);
   	    
   	  try {
          QuestionDetails.update(question);
          response.sendRedirect("success.jsp");
      } catch (Exception e) {
          e.printStackTrace();
          response.sendRedirect("error.jsp");
      }
	}

}

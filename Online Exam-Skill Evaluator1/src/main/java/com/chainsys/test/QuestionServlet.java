package com.chainsys.test;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.dao.UserDeatils;
import com.chainsys.model.AddQuestion;
import com.chainsys.model.Register;
import com.chainsys.util.DBConnection;

@WebServlet("/QuestionServlet")
public class QuestionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
	

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 int examId = Integer.parseInt(request.getParameter("examId"));
    	 String questionText=request.getParameter("questionText");
    	 String option1=request.getParameter("option1");
    	 String option2=request.getParameter("option2");
    	 String option3=request.getParameter("option3");
    	 String option4=request.getParameter("option4");
    	 String correctAnswer=request.getParameter("correctAnswer");
    	
        DBConnection dbconnection=new DBConnection();

        try (Connection connection = dbconnection.getConnection()) {
            String query = " insert into questions (exam_id, question_text, option1, option2, option3, option4, correct_answer) values (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement prepare = connection.prepareStatement(query)) {
            	prepare.setInt(1, examId);
                prepare.setString(2, questionText);
                prepare.setString(3, option1);
                prepare.setString(4, option2);
                prepare.setString(5, option3);
                prepare.setString(6, option4);
                prepare.setString(7, correctAnswer);
                int rows = prepare.executeUpdate();
                if (rows > 0) {
                    response.getWriter().println("Question inserted successfully!");
                } else {
                    response.getWriter().println("Failed to insert Queston.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
    
}
		
        
        
        
        
        
        
        
        
    


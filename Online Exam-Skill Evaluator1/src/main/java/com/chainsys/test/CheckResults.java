package com.chainsys.test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.dao.Training;

@WebServlet("/CheckResults")
public class CheckResults extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckResults() {
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

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
        Enumeration<String> parameterNames = request.getParameterNames();
        Map<String, String> answersMap = new HashMap<>();

        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            System.out.println(paramName);
            if (paramName.startsWith("answer")) {
                String examId = paramName.substring("answer".length());
                String[] paramValues = request.getParameterValues(paramName);
                if (paramValues != null && paramValues.length > 0) {
                    answersMap.put(examId, paramValues[0]);
                                      }
                
            }
        }

        
            Training checkanswer=new  Training();
            Map<String, String> correctAnswersMap = null;
            try {
                correctAnswersMap = checkanswer. getCorrectAnswersFromDatabase();
            } catch (ClassNotFoundException | SQLException e) {
                // TODO Auto-generated catch block
                 e.printStackTrace();
            }

            // Validate answers
            int correctCount = 0;
            int totalCount = answersMap.size(); // Total number of questions attempted
            for (Map.Entry<String, String> entry : answersMap.entrySet()) {
                String examId = entry.getKey();
                String userAnswer = entry.getValue();
                String correctAnswer = correctAnswersMap.get(examId);
                if (correctAnswer != null && correctAnswer.equals(userAnswer)) {
                    correctCount++;
                }
            }

            // Calculate percentage
            double percentage = (correctCount * 100.0) / totalCount;

            // Set result attributes to be forwarded to the result JSP page
            request.setAttribute("totalCount", totalCount);
            request.setAttribute("correctCount", correctCount);
            request.setAttribute("percentage", percentage);
            System.out.println(totalCount);
            System.out.println(correctCount);
            System.out.println(percentage);

            // Forward the request to the result JSP page
            RequestDispatcher dispatcher = request.getRequestDispatcher("results3.jsp");
            dispatcher.forward(request, response);
        }

        }

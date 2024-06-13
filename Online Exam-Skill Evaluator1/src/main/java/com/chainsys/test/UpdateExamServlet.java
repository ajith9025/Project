package com.chainsys.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.model.Exam;
import com.chainsys.dao.ExamDetails;

@WebServlet("/UpdateExamServlet")
public class UpdateExamServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int examId = Integer.parseInt(request.getParameter("examId"));
        String examName = request.getParameter("examName");
        String examDate = request.getParameter("examDate");
        int duration = Integer.parseInt(request.getParameter("duration"));
        int totalMarks = Integer.parseInt(request.getParameter("totalMarks"));

        Exam exam = new Exam();
        exam.setExamId(examId);
        exam.setExamName(examName);
        exam.setExamDate(examDate);
        exam.setDuration(duration);
        exam.setTotalMarks(totalMarks);

        try {
            ExamDetails.update(exam);
            response.sendRedirect("success.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}

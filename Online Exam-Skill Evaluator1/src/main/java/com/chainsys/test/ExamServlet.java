package com.chainsys.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.model.Exam;
import com.chainsys.util.DBConnection;

@WebServlet("/ExamServlet")
public class ExamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String examName = request.getParameter("examName");
		String examDate = request.getParameter("examDate");
		int duration = Integer.parseInt(request.getParameter("duration"));
		int totalMarks = Integer.parseInt(request.getParameter("totalMarks"));

		DBConnection dbconnection = new DBConnection();

		try (Connection conn = dbconnection.getConnection()) {
			String query = "insert into exams (exam_name, exam_date, duration, total_marks) values (?, ?, ?, ?)";
			try (PreparedStatement prepare = conn.prepareStatement(query)) {
				prepare.setString(1, examName);
				prepare.setString(2, examDate);
				prepare.setInt(3, duration);
				prepare.setInt(4, totalMarks);

				int rows = prepare.executeUpdate();
				if (rows > 0) {
					response.getWriter().println("Exam inserted successfully!");
				} else {
					response.getWriter().println("Failed to insert exam.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println("Error: " + e.getMessage());
		}

		List<Exam> exams = new ArrayList<>();
		try (Connection connection = dbconnection.getConnection()) {
			String query = "select * from exams";
			try (PreparedStatement prepare = connection.prepareStatement(query)) {
				ResultSet rs = prepare.executeQuery();
				while (rs.next()) {
					Exam exam = new Exam();
					exam.setExamId(rs.getInt("exam_id"));
					exam.setExamName(rs.getString("exam_name"));
					exam.setExamDate(rs.getDate("exam_date"));
					exam.setDuration(rs.getInt("duration"));
					exam.setTotalMarks(rs.getInt("total_marks"));
					exams.add(exam);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("exams", exams);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ViewExam.jsp");
		dispatcher.forward(request, response);
	}
}

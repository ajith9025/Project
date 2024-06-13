package com.chainsys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.chainsys.model.Exam;
import com.chainsys.util.DBConnection;

public class ExamDetails{

	public static void insert(Exam exam) throws ClassNotFoundException, SQLException {
		DBConnection dbconnection = new DBConnection();
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			Connection connection = dbconnection.getConnection();
			String query = "insert into exams (exam_id,exam_name, exam_date, duration, total_marks) values (?,?, ?, ?, ?)";
			PreparedStatement prepare = connection.prepareStatement(query);
			prepare.setInt(1, exam.getExamId());
			prepare.setString(2, exam.getExamName());
			prepare.setString(3, exam.getExamDate());
			prepare.setInt(4, exam.getDuration());
			prepare.setInt(5, exam.getTotalMarks());
			int execute = prepare.executeUpdate();
			System.out.println(execute);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public  ArrayList<Exam> getAllExam() throws SQLException, ClassNotFoundException {
		DBConnection dbconnection = new DBConnection();
		ArrayList<Exam> list = new ArrayList<>();
		try {
			Connection connection = dbconnection.getConnection();
			String query = "select * from exams";
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				int examId = rs.getInt("exam_id");
				String examName = rs.getString("exam_name");
				String examDate= rs.getString("exam_date");
				int duration = rs.getInt("duration");
				int totalMarks = rs.getInt("total_marks");
				Exam exam = new Exam();
				exam.setExamId(examId);
				exam.setExamName(examName);
				exam.setExamDate(examDate);
				exam.setDuration(duration);
				exam.setTotalMarks(totalMarks);
				list.add(exam);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public static void update(Exam exam) throws ClassNotFoundException, SQLException {
	    DBConnection dbconnection = new DBConnection();
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    try {
	        Connection connection = dbconnection.getConnection();
	        String query = "update exams set exam_name = ?, exam_date = ?, duration = ?, total_marks = ? where exam_id = ?";
	        PreparedStatement prepare = connection.prepareStatement(query);
	        prepare.setString(1, exam.getExamName());
	        prepare.setString(2, exam.getExamDate());
	        prepare.setInt(3, exam.getDuration());
	        prepare.setInt(4, exam.getTotalMarks());
	        prepare.setInt(5, exam.getExamId()); 
	        prepare.executeUpdate();
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public static void delete(int examId) throws ClassNotFoundException, SQLException {
	    DBConnection dbconnection = new DBConnection();
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    try {
	        Connection connection = dbconnection.getConnection();
	        String query = "delete from exams where exam_id = ?";
	        PreparedStatement prepare = connection.prepareStatement(query);
	        prepare.setInt(1, examId);
	        prepare.executeUpdate();
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }
	}


}

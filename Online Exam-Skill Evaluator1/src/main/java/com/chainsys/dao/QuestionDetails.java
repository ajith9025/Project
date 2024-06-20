package com.chainsys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.chainsys.model.AddQuestion;
import com.chainsys.util.DBConnection;

public class QuestionDetails {

	public static void insert(AddQuestion question) throws ClassNotFoundException, SQLException {
		DBConnection dbconnection = new DBConnection();
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			Connection connection = dbconnection.getConnection();
			String query = " insert into questions (exam_id,exam_name, question_text, option1, option2, option3, option4, correct_answer) values (?,?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement prepare = connection.prepareStatement(query);
			prepare.setInt(1, question.getExamId());
			prepare.setString(2, question.getExamName());
			prepare.setString(3, question.getQuestionText());
			prepare.setString(4, question.getOption1());
			prepare.setString(5, question.getOption2());
			prepare.setString(6, question.getOption3());
			prepare.setString(7, question.getOption4());
			prepare.setString(8, question.getCorrectAnswer());
			int execute = prepare.executeUpdate();
			System.out.println(execute);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<AddQuestion> getAllQuestion() throws SQLException, ClassNotFoundException {
		DBConnection dbconnection = new DBConnection();
		ArrayList<AddQuestion> list = new ArrayList<AddQuestion>();
		try {
			Connection connection = dbconnection.getConnection();
			String query = "select * from questions";
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				int examId = rs.getInt("exam_id");
				String examName = rs.getString("exam_name");
				String questionText = rs.getString("question_text");
				String option1 = rs.getString("option1");
				String option2 = rs.getString("option2");
				String option3 = rs.getString("option3");
				String option4 = rs.getString("option4");
				String correctAnswer = rs.getString("correct_answer");
				AddQuestion question = new AddQuestion();
			    question.setExamId(examId);
			    question.setExamName(examName);
			    question.setQuestionText(questionText);
			    question.setOption1(option1);
			    question.setOption2(option2);
			    question.setOption3(option3);
			    question.setOption4(option4);
			    question.setCorrectAnswer(correctAnswer);
				list.add(question);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void update(AddQuestion question) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		 DBConnection dbconnection = new DBConnection();
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    try {
		        Connection connection = dbconnection.getConnection();
		        String query = "update questions set exam_name= ?, question_text= ?, option1 = ?, option2 = ? , option3 = ? , option4 = ? , correct_answer = ? where exam_id = ?";
		        PreparedStatement prepare = connection.prepareStatement(query);
		        prepare.setString(1, question.getExamName());
		        prepare.setString(2, question.getQuestionText());
		        prepare.setString(3, question.getOption1());
		        prepare.setString(4, question.getOption2());
		        prepare.setString(5, question.getOption3());
		        prepare.setString(6, question.getOption4());
		        prepare.setString(7, question.getCorrectAnswer());
		        prepare.setInt(8,question.getExamId());
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
	        String query = "delete from questions where exam_id = ?";
	        PreparedStatement prepare = connection.prepareStatement(query);
	        prepare.setInt(1, examId);
	        prepare.executeUpdate();
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }
	}
		
	}
	

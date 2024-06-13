package com.chainsys.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.chainsys.model.AddQuestion;
import com.chainsys.util.DBConnection;

public class QuestionView {
	


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

}

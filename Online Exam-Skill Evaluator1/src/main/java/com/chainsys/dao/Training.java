package com.chainsys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.chainsys.util.DBConnection;

public class Training {
	public Map<String, String> getCorrectAnswersFromDatabase() throws ClassNotFoundException, SQLException {
		// Replace this with your logic to fetch correct answers from the database
		// Example:
		// Map<String, String> correctAnswersMap =
		// yourDatabaseService.getCorrectAnswers();
		// return correctAnswersMap;
		Map<String, String> answersMap = new HashMap<>();
      
		Connection con = DBConnection.getConnection();
		String query = "select exam_id,correct_answer from questions";
		PreparedStatement p = con.prepareStatement(query);
		ResultSet re = p.executeQuery();
		while (re.next()) {
			String examId = re.getString("exam_id");
			String option = re.getString("correct_answer");
			answersMap.put(examId, option);
		}
		return answersMap;
		
	}
}

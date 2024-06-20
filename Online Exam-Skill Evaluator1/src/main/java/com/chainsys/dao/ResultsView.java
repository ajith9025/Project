package com.chainsys.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.chainsys.model.Results;
import com.chainsys.util.DBConnection;

public class ResultsView {
	
	public  ArrayList<Results> getAllResult() throws SQLException, ClassNotFoundException {
		DBConnection dbconnection = new DBConnection();
		ArrayList<Results> list = new ArrayList<>();
		try {
			Connection connection = dbconnection.getConnection();
			String query = "select * from results";
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				int resultId=rs.getInt("result_id");
				int userId=rs.getInt("user_id");
				int examId=rs.getInt("exam_id");
				int marksObtained=rs.getInt("marks_obtained");
				Results results=new Results();
				results.setResultId(resultId);
				results.setUserId(userId);
				results.setExamId(examId);
				results.setMarksObtained(marksObtained);
				list.add(results);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}

package com.chainsys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.chainsys.model.Results;
import com.chainsys.util.DBConnection;

public class ResultsDetails {
      

	public static void insert(Results results) throws ClassNotFoundException, SQLException {
		DBConnection dbconnection = new DBConnection();
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			Connection connection = dbconnection.getConnection();
			String query="insert into results(result_id,user_id,exam_id,marks_obtained) values(?,?,?,?)";
			PreparedStatement prepare = connection.prepareStatement(query);
			prepare.setInt(1,results.getResultId());
			prepare.setInt(2,results.getUserId());
			prepare.setInt(3,results.getExamId());
			prepare.setInt(4,results.getMarksObtained());
			int execute = prepare.executeUpdate();
			System.out.println(execute);
			}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
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

package com.chainsys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.chainsys.model.Results;
import com.chainsys.util.DBConnection;

public class ResultsDetails {
      

	public static void insert(Results results) throws ClassNotFoundException, SQLException {
		DBConnection dbconnection = new DBConnection();
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			Connection connection = dbconnection.getConnection();
			String query="insert into results(id,user_id,exam_id,mark_obtained) values(?,?,?,?)";
			PreparedStatement prepare = connection.prepareStatement(query);
			prepare.setInt(1,results.getId());
			prepare.setInt(2,results.getUserId());
			prepare.setInt(3,results.getExamId());
			prepare.setInt(4,results.getMarkObtained());
			int execute = prepare.executeUpdate();
			System.out.println(execute);
			}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}

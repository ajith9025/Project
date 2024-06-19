package com.chainsys.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		String url = "jdbc:mysql://localhost:3306/my_project_day13";
		String userName = "root";
		String password = "ajith123";
		String query = "select * from users";
		Connection connection = DriverManager.getConnection(url, userName, password);
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		System.out.println(connection);

	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_project_day13", "root", "ajith123");
		return connection;
	}
}

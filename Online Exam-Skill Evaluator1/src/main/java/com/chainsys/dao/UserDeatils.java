package com.chainsys.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.chainsys.model.AddQuestion;
import com.chainsys.model.Register;
import com.chainsys.util.DBConnection;


public class UserDeatils implements  User{
	
	public static void insert(Register register) throws ClassNotFoundException,SQLException{
		DBConnection dbconnection=new DBConnection();
		Class.forName("com.mysql.cj.jdbc.Driver");
		try 
	   {
		Connection connection = dbconnection.getConnection();
		String query = "insert into users(username,password,email,contact_no)values(?,?,?,?)";
		PreparedStatement prepare = connection.prepareStatement(query);
		prepare.setString(1, register.getUsername());
		prepare.setString(2, register.getPassword());
		prepare.setString(3, register.getEmail());
		prepare.setString(4, register.getContactno());
		int execute = prepare.executeUpdate();
		System.out.println(execute);
	   }
       catch (ClassNotFoundException | SQLException e)
		{
		   e.printStackTrace();
	    }
	}
	public ArrayList<Register> getAllRegister()throws SQLException, ClassNotFoundException {
		DBConnection dbconnection=new DBConnection();
		ArrayList<Register> list= new ArrayList<Register>();
	try {
			Connection connection = dbconnection.getConnection();
			String query = "select username,password,email,contact_no from users";
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
			  
				String username = rs.getString("username");
				String password = rs.getString("password");
				String email = rs.getString("email");
				String contact_no = rs.getString("contact_no");
			
				Register register = new Register();
				
			    register.setUsername(username);
				register.setPassword(password);
				register.setEmail(email);
				register.setContactno(contact_no);
	
				list.add(register);
			}
	}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void login(Register register) throws ClassNotFoundException, SQLException {
	    DBConnection dbconnection = new DBConnection();
	    Class.forName("com.mysql.cj.jdbc.Driver");
	   
	    try {
	        Connection connection = dbconnection.getConnection();
	        String query = "SELECT * FROM users WHERE password = ? AND email = ?";
	        PreparedStatement prepare = connection.prepareStatement(query);
	        prepare.setString(1, register.getPassword());
	        prepare.setString(2, register.getEmail()); 
	        ResultSet result = prepare.executeQuery(); 
	        if (result.next()) {
	            System.out.println("Login successful!");
	         
	        } else {
	            System.out.println("Invalid email or password!"); 
	        }
	        result.close();
	        prepare.close();
	        connection.close();
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }
	}
}





	
		
		
	
		
	





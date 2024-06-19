package com.chainsys.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.chainsys.model.AddQuestion;
import com.chainsys.model.Exam;
import com.chainsys.model.Register;
import com.chainsys.util.DBConnection;


public class UserDeatils implements  User{
	
	public static void insert(Register register) throws ClassNotFoundException,SQLException{
		DBConnection dbconnection=new DBConnection();
		Class.forName("com.mysql.cj.jdbc.Driver");
		try 
	   {
		Connection connection = dbconnection.getConnection();
		String query = "insert into users(user_id,username,password,email,contact_no)values(?,?,?,?,?)";
		PreparedStatement prepare = connection.prepareStatement(query);
		prepare.setInt(1,register.getUserId());
		prepare.setString(2, register.getUsername());
		prepare.setString(3, register.getPassword());
		prepare.setString(4, register.getEmail());
		prepare.setString(5, register.getContactno());
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
			String query = "select user_id,username,password,email,contact_no from users";
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
			    int userId=rs.getInt("user_id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String email = rs.getString("email");
				String contact_no = rs.getString("contact_no");
			
				Register register = new Register();
		        register.setUserId(userId);
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
	public static void update(Register register) throws ClassNotFoundException, SQLException {
		  DBConnection dbconnection = new DBConnection();
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    
		    try {
		        Connection connection = dbconnection.getConnection();
		        String query = "UPDATE users SET username = ?, password = ?, contact_no = ? , email = ? where user_id=?";
		        PreparedStatement prepare = connection.prepareStatement(query);
		        prepare.setString(1, register.getUsername());
		        prepare.setString(2, register.getPassword());
		        prepare.setString(3, register.getContactno());
		        prepare.setString(4, register.getEmail());
		        prepare.setInt(5,register.getUserId());
		        
		   
		        
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public static void delete(int userId) throws ClassNotFoundException, SQLException {
	    DBConnection dbconnection = new DBConnection();
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    try {
	        Connection connection = dbconnection.getConnection();
	        String query = "delete from users where user_id = ?";
	        PreparedStatement prepare = connection.prepareStatement(query);
	        prepare.setInt(1, userId);
	        prepare.executeUpdate();
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }
	}
}





	
		
		
	
		
	





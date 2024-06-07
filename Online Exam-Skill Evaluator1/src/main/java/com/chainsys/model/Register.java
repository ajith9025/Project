package com.chainsys.model;

public class Register {
	int id;
	String username;
	String password;
	String email;
    String contactno;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	
	public Register(int id, String username, String password, String email, String contactno) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.contactno = contactno;
	}
	public Register() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Register [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", contactno=" + contactno + "]";
	}

	

}

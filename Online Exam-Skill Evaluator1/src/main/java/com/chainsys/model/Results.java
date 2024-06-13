package com.chainsys.model;

public class Results {
    int id;
	int userId;
	int examId;
	int markObtained;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getExamId() {
		return examId;
	}
	public void setExamId(int examId) {
		this.examId = examId;
	}
	public int getMarkObtained() {
		return markObtained;
	}
	public void setMarkObtained(int markObtained) {
		this.markObtained = markObtained;
	}
	
	
	public Results(int id, int userId, int examId, int markObtained) {
		super();
		this.id = id;
		this.userId = userId;
		this.examId = examId;
		this.markObtained = markObtained;
	}
	public Results() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Results [id=" + id + ", userId=" + userId + ", examId=" + examId + ", markObtained=" + markObtained
				+ "]";
	}
}

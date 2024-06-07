package com.chainsys.model;

public class Skills {

	int id;
	int skillName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSkillName() {
		return skillName;
	}
	public void setSkillName(int skillName) {
		this.skillName = skillName;
	}
	public Skills(int id, int skillName) {
		super();
		this.id = id;
		this.skillName = skillName;
	}
	
	@Override
	public String toString() {
		return "Skills [id=" + id + ", skillName=" + skillName + "]";
	}
	
	
}

package com.studentMS.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class StudentName {

	@Column(nullable=false)
	private String fname;
	private String mname;
	@Column(nullable=false)
	private String lname;
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	@Override
	public String toString() {
		return "StudentName [fname=" + fname + ", mname=" + mname + ", lname=" + lname + "]";
	}
	
}

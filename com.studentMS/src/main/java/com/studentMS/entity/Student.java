package com.studentMS.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student_table")
public class Student {
	
	@Id
	private Long id;
	
	@Embedded
	private StudentName name;
	
	@Column(unique=true, length=10)
	private String ph;
	private Integer age;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public StudentName getName() {
		return name;
	}

	public void setName(StudentName name) {
		this.name = name;
	}

	public String getPh() {
		return ph;
	}

	public void setPh(String ph) {
		this.ph = ph;
	}

	public Integer getAge() {
		return age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", ph=" + ph + ", age=" + age + "]";
	}

}

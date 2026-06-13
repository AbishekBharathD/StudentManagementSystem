package com.studentMS.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Department {
	
	@Id
	private Integer id;
	private String deptName;
	
	@OneToMany(mappedBy="dept", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Staff> staffs = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public List<Staff> getStaffs() {
		return staffs;
	}

	public void setStaffs(List<Staff> staffs) {
		this.staffs = staffs;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", deptName=" + deptName + ", staffs=" + staffs + "]";
	}

}

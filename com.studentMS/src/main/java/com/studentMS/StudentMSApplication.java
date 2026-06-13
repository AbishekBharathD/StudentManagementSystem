package com.studentMS;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.studentMS.entity.Address;
import com.studentMS.entity.Course;
import com.studentMS.entity.Department;
import com.studentMS.entity.Staff;
import com.studentMS.entity.Student;

public class StudentMSApplication {

	public static void main(String[] args) {
		
		Department dept = new Department();
		dept.setId(104);
		dept.setDeptName("CSE");
		
		Staff s1 = new Staff();
		s1.setId(1);
		s1.setName("Ram");
		s1.setDept(dept);
		
		Staff s2 = new Staff();
		s2.setId(2);
		s2.setName("Dhanush");
		s2.setDept(dept);
		
		dept.getStaffs().add(s1);
		dept.getStaffs().add(s2);
		
		Configuration config = new Configuration().configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(dept);
		
		Department dept1 = session.get(Department.class, 104);
		
		tx.commit();
		
		System.out.println(dept1);
		
		
		session.close();
		
	}
	
}

package com.studentMS;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.studentMS.entity.Address;
import com.studentMS.entity.Department;
import com.studentMS.entity.Student;

public class StudentMSApplication {

	public static void main(String[] args) {
		
		Student john = new Student();
		john.setId(1);
		john.setName("John S");
		john.setPhone("9080560518");
		john.setEmail("abishek22092004@gmail.com");
		
		Student james = new Student();
		james.setId(2);
		james.setName("James S");
		james.setPhone("9080560777");
		james.setEmail("abi2209s@gmail.com");
		
		Department dept = new Department();
		dept.setId(104);
		dept.setDeptName("CSE");
		
		john.setDept(dept);
		james.setDept(dept);
		
		dept.getStudents().add(john);
		dept.getStudents().add(james);
		
		Configuration config = new Configuration().configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction tx = session.beginTransaction();
		session.persist(dept);
		session.persist(john);
		session.persist(james);
		Department d1 = session.get(Department.class, 104);
		tx.commit();
		
		System.out.println(d1);
		
		session.close();
		
	}
	
}

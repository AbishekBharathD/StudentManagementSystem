package com.studentMS;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.studentMS.entity.Student;
import com.studentMS.entity.StudentName;

public class StudentMSApplication {

	public static void main(String[] args) {
		
		StudentName sn = new StudentName();
		sn.setFname("James");
		sn.setMname(null);
		sn.setLname("P");
		
		Student james = new Student();
		james.setId(102L);
		james.setName(sn);
		james.setPh("9123557277");
		james.setAge(22);
		
		Student stu1 = null;
		
		Configuration config = new Configuration().configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction tx = session.beginTransaction();
		session.persist(james);
		stu1 = session.get(Student.class, 102);
		tx.commit();
		
		System.out.println(stu1);
		
		session.close();
		
	}
	
}

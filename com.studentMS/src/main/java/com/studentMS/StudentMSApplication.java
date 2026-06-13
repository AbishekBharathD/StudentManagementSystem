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
		
//		Student s = new Student();
//		s.setId(1);
//		s.setName("John");
		
		Configuration config = new Configuration().configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session1 = sessionFactory.openSession();
		Transaction tx1 = session1.beginTransaction();
		
//		session1.save(s);
		
		//First-Level Caching
		
		Student s1 = session1.get(Student.class, 1);
		Student s2 = session1.get(Student.class, 1);
		
		tx1.commit();
		
		session1.close();
		
		//Second-Level Caching
		
		Session session2 = sessionFactory.openSession();
		Transaction tx2 = session2.beginTransaction();
		
		Student s3 = session2.get(Student.class, 1);
		
		tx2.commit();
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
		session2.close();
		
	}
	
}

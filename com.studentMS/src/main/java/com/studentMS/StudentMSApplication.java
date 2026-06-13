package com.studentMS;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.studentMS.entity.Address;
import com.studentMS.entity.Course;
import com.studentMS.entity.Department;
import com.studentMS.entity.Student;

public class StudentMSApplication {

	public static void main(String[] args) {
		
		Student john = new Student();
		john.setId(1);
		john.setName("John S");
		
		
		Student james = new Student();
		james.setId(2);
		james.setName("James S");
		
		Course c1 = new Course();
		c1.setId(10001);
		c1.setCourseName("Java");
		c1.setAuthor("Abish");
		c1.setDuration(13);
		
		Course c2 = new Course();
		c2.setId(10002);
		c2.setCourseName("Python");
		c2.setAuthor("Abish");
		c2.setDuration(10);
		
		c1.getStudents().add(james);
		c1.getStudents().add(john);
		
		c2.getStudents().add(james);
		c2.getStudents().add(john);
		
		john.getCourses().add(c1);
		james.getCourses().add(c1);
		john.getCourses().add(c2);
		james.getCourses().add(c2);
		
		
		
		Configuration config = new Configuration().configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.persist(c1);
		session.persist(c2);
		session.persist(james);
		session.persist(john);
		
		tx.commit();
		
		
		session.close();
		
	}
	
}

package com.studentMS;


import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.studentMS.entity.Address;
import com.studentMS.entity.Course;
import com.studentMS.entity.Department;
import com.studentMS.entity.Staff;
import com.studentMS.entity.Student;

import jakarta.persistence.Query;

public class StudentMSApplication {

	public static void main(String[] args) {
		
		Configuration config = new Configuration().configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session1 = sessionFactory.openSession();
		Transaction tx1 = session1.beginTransaction();
		
//		Random r = new Random();
//		for(int i=1; i<=50; i++) {
//			Student s = new Student();
//			s.setId(i);
//			s.setName("Name "+i);
//			s.setMark(r.nextInt(100));
//			session1.persist(s);
//		}
		
		//Query q = session1.createQuery("from Student where mark>70");
		
//		List<Student> students = q.getResultList();
//		
//		for(Student student : students) {
//			System.out.println(student);
//		}


//		Query q = session1.createQuery("from Student where id=7");
//		Student s = (Student)q.getSingleResult();
//		System.out.println(s);
		
//		Query q = session1.createQuery("select id, name, mark from Student where mark > 60");
//		List<Object[]> students = q.getResultList();
//		for(Object[] student : students) {
//			System.out.println(student[0]+" : "+student[1]+" : "+student[2]);
//		}
		
//		int m = 70;
//		Query q = session1.createQuery("select sum(mark) from Student where mark > :m");
//		q.setParameter("m", m);
//		Long total_mark = (Long) q.getSingleResult();
//		System.out.println("Total : "+total_mark);
		
		
		/*
		 *  Native SQL Query Using Hibernate 
		 */
		
//		Query q = session1.createNativeQuery("select * from student where mark > 60", Student.class);
//		List<Student> students = q.getResultList();
//		for(Student s : students) {
//			System.out.println(s);
//		}
		
		Query q = session1.createNativeQuery("select id, name from student where mark > 60");
		List<Object[]> students = q.getResultList();
		for(Object[] obj : students) {
			System.out.println(((Number)obj[0]).longValue()+" "+(String)obj[1]);
		}
		
		tx1.commit();
		
		session1.close();
		
		
	}
	
}

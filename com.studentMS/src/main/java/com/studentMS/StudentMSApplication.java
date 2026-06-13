package com.studentMS;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.studentMS.entity.Address;
import com.studentMS.entity.Student;

public class StudentMSApplication {

	public static void main(String[] args) {
		
		Address address = new Address();
		address.setAddressId(101);
		address.setCountry("India");
		address.setState("Tamil Nadu");
		address.setCity("Chennai");
		address.setHouseAddress("274 Kumaran Nagar Vellacherry");
		address.setPincode(600221);
		
		Student john = new Student();
		john.setId(1);
		john.setName("John S");
		john.setPhone("9080560518");
		john.setEmail("abishek22092004@gmail.com");
		john.setAddress(address);
		
		Configuration config = new Configuration().configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction tx = session.beginTransaction();
		session.persist(address);
		session.persist(john);
		tx.commit();
		
		session.close();
		
	}
	
}

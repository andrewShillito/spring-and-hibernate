package com.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		// create a hibernate session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			// use the session object to save Java object
			
			// create student object
			Student student = new Student("First", "Last", "first.last@email.com");
			Student student2 = new Student("First2", "Last2", "first2.last@email.com");
			Student student3 = new Student("First3", "Last3", "first3.last@email.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save student object
			session.save(student);
			session.save(student2);
			session.save(student3);
			
			// commit transaction
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
	}

}

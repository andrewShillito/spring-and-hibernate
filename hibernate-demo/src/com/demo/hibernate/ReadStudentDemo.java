package com.demo.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		// create a hibernate session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			// use the session object to save a Student object
			Student student = new Student("Read", "Demo", "read.demo@email.com");
			session.beginTransaction();
			session.save(student);
			session.getTransaction().commit();
			
			// log the resulting mysql auto-incremented id
			System.out.println("Student mysql generated id: [" + student.getId() + "]");
			
			// now read that object by primary key from the db
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			Student retrievedStudent = session.get(Student.class, student.getId());
			
			System.out.println("Retrieved student: " + retrievedStudent);
			System.out.println("Memory location equality to local object: " + String.valueOf(retrievedStudent == student));
			System.out.println("Value equality to local object: " + String.valueOf(student.equals(retrievedStudent)));
			
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Retrieved student: " + retrievedStudent);
			System.out.println("Memory location equality to local object: " + String.valueOf(retrievedStudent == student));
			System.out.println("Value equality to local object: " + String.valueOf(student.equals(retrievedStudent)));
			
			session.getTransaction().commit();
		} finally {
			factory.close();
		}

	}

}

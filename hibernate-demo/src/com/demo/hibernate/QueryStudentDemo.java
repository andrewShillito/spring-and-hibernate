package com.demo.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		// create a hibernate session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			
			// start a transaction
			session.beginTransaction();
			
			// query for list of students
			List<Student> students = session.createQuery("from Student").getResultList();
			
			// display resulting students
			if (students.size() > 0) {
				
				for (Student student : students) {
					System.out.println(student);
				}
				
			} else {
				System.out.println("No students found in db");
			}
			
			// commit transaction
			session.getTransaction().commit();
			
			// 
			
		} finally {
			factory.close();
		}

	}

}

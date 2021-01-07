package com.demo.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		// create a hibernate session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			String query = "from Student s where s.lastName='Demo' AND s.email='read.demo@gmail.com'";
			
			// start a transaction
			session.beginTransaction();
			
			List<Student> students = queryStudents(session, query);
			
			displayStudents(students, query);
			for (Student student : students) {
				student.setEmail("read.demo" + student.getId() + "@gmail.com");
			}

			// commit transaction
			session.getTransaction().commit();
			
			// check the result
			session = factory.getCurrentSession();
			session.beginTransaction();
			displayStudents(queryStudents(session, query), query);
			query = "from Student s where s.email LIKE 'read.demo%'";
			displayStudents(queryStudents(session, query), query);
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			query = "Update Student s set s.lastName='UpdateDemo' WHERE s.email LIKE 'read.demo%'";
			session.createQuery(query).executeUpdate();
			query = "from Student s where s.email LIKE 'read.demo%'";
			displayStudents(queryStudents(session, query), query);
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}

	}

	public static List<Student> queryStudents(Session session, String query) {
		return session.createQuery(query).getResultList();
	}
	
	public static void displayStudents(List<Student> students, String query) {
		System.out.println("----");
		if (students.size() > 0) {
			System.out.println("Query results for: [" + query + "]");
			for (Student student : students) {
				System.out.println(student);
			}
		} else {
			System.out.println("No students found for query [" + query + "]");
		}
	}
	
}

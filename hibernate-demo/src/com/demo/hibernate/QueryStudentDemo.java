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
			
			String query = "from Student";
			
			// query for list of students
			displayStudents(queryStudents(session, query), query);
			
			System.out.println("----");
			
			// display resulting students
			displayStudents(queryStudents(session, query), query);
			
			System.out.println("----");
			
			query = "from Student s where s.lastName='Last2'";
			displayStudents(queryStudents(session, query), query);
			
			System.out.println("----");
			
			query = "from Student s where s.lastName='Last2'";
			displayStudents(queryStudents(session, query), query);
			
			System.out.println("----");
			query = "from Student s where s.firstName='Read' AND s.email LIKE '%demo%'";
			displayStudents(queryStudents(session, query), query);

			// commit transaction
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}

	}
	
	public static List<Student> queryStudents(Session session, String query) {
		return session.createQuery(query).getResultList();
	}

	public static void displayStudents(List<Student> students, String query) {
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

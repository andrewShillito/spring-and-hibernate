package main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import coach.Coach;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		// load spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope_applicationContext.xml");
		
		// retrieve bean from the spring container
		Coach coach = context.getBean("coach", Coach.class);
		Coach otherCoach = context.getBean("coach", Coach.class);
		
		boolean result = coach == otherCoach;
		
		// call methods on the bean
		System.out.println("\nPointing to the same object: " + result);
		System.out.println("\nMemory location for coach: " + coach);
		System.out.println("\nMemory location for otherCoach: " + otherCoach + "\n");
		
		// close the context
		context.close();

	}

}

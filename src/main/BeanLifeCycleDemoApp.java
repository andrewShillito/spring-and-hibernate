package main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import coach.Coach;

public class BeanLifeCycleDemoApp {

	public static void main(String[] args) {
		// load spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifecycle_applicationContext.xml");
		
		// retrieve bean from the spring container
		Coach coach = context.getBean("coach", Coach.class);

		// call methods on the bean
		System.out.println(coach.getDailyWorkout());
		
		// close the context
		context.close();

	}

}

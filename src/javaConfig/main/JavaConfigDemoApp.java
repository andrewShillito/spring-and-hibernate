package javaConfig.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import coach.Coach;
import javaConfig.config.JavaConfig;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		// read from java source code configuration
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		
		// retrieve beans from the container
		Coach coach = context.getBean("trackCoach", Coach.class);
		
		// use the beans retrieved
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
		
		// close the application context
		context.close();

	}

}

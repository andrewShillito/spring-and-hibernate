package javaConfig.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javaConfig.coach.TrackCoach;
import javaConfig.config.JavaConfig;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		// read from java source code configuration
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		
		// retrieve beans from the container
		TrackCoach coach = context.getBean("trackCoach", TrackCoach.class);
		
		// use the beans retrieved
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
		System.out.println(coach.getMessage());
		System.out.println(coach.getEmail());
		System.out.println(coach.getTeam());
		
		// close the application context
		context.close();

	}

}

package annotation.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import annotation.coach.AnnotationCoach;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		// load spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("annotation_applicationContext.xml");
		
		// retrieve bean from the spring container
		AnnotationCoach coach = context.getBean("tennisCoach", AnnotationCoach.class);
		AnnotationCoach swimCoach = context.getBean("swimCoach", AnnotationCoach.class);
		AnnotationCoach hockeyCoach = context.getBean("hockeyCoach", AnnotationCoach.class);

		// call methods on the bean
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
		
		System.out.println(swimCoach.getDailyWorkout());
		System.out.println(swimCoach.getDailyFortune());
		
		System.out.println(hockeyCoach.getDailyWorkout());
		System.out.println(hockeyCoach.getDailyFortune());
		
		// close the context
		context.close();

	}
}

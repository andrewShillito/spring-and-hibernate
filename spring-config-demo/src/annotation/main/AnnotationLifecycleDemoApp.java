package annotation.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import annotation.coach.AnnotationCoach;

public class AnnotationLifecycleDemoApp {

	public static void main(String[] args) {
		// load spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("annotation_applicationContext.xml");
		
		// retrieve bean from the spring container
		AnnotationCoach coach = context.getBean("tennisCoach", AnnotationCoach.class);

		// call methods on the bean
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
		System.out.println(coach.getOtherMessage());
		
		// close the context
		context.close();
	}

}

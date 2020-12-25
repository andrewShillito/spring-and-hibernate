package annotation.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import annotation.coach.AnnotationCoach;

public class AnnotationBeanScopeDemoApp {

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
		System.out.println(coach.getOtherMessage());
		
		System.out.println(swimCoach.getDailyWorkout());
		System.out.println(swimCoach.getDailyFortune());
		System.out.println(swimCoach.getOtherMessage());
		
		System.out.println(hockeyCoach.getDailyWorkout());
		System.out.println(hockeyCoach.getDailyFortune());
		System.out.println(hockeyCoach.getOtherMessage());
		
		AnnotationCoach otherCoach = context.getBean("tennisCoach", AnnotationCoach.class);
		AnnotationCoach otherSwimCoach = context.getBean("swimCoach", AnnotationCoach.class);
		AnnotationCoach otherHockeyCoach = context.getBean("hockeyCoach", AnnotationCoach.class);
		
		System.out.println("Tennis coach memory locations: " + coach + " " + otherCoach);
		System.out.println("Swim coach memory locations: " + swimCoach + " " + otherSwimCoach);
		System.out.println("Hockey coach memory locations: " + hockeyCoach + " " + otherHockeyCoach);
		
		// close the context
		context.close();

	}

}

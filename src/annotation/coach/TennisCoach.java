package annotation.coach;

import org.springframework.stereotype.Component;

@Component("tennisCoach") // note that this is the default spring bean id but stated explicitly - we don't need to do this
public class TennisCoach implements AnnotationCoach {

	@Override
	public String getDailyWorkout() {
		return "Practice backhand volley";
	}

}

package annotation.coach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import annotation.fortune.AnnotationFortuneService;

@Component
public class HockeyCoach implements AnnotationCoach {

	@Autowired
	private AnnotationFortuneService fortuneService;
	// no need for setter method, spring will use reflection to set this field
	
	@Override
	public String getDailyWorkout() {
		return "Practice slapshot";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}

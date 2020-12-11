package annotation.coach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import annotation.fortune.AnnotationFortuneService;

@Component
public class TennisCoach implements AnnotationCoach {

	private AnnotationFortuneService fortuneService;
	
	@Autowired
	public TennisCoach(AnnotationFortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
